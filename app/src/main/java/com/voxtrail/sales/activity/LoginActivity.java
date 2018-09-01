package com.voxtrail.sales.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.voxtrail.sales.R;
import com.voxtrail.sales.Util.Constants;
import com.voxtrail.sales.Util.Pref;
import com.voxtrail.sales.Util.StringUtils;
import com.voxtrail.sales.Util.ToastClass;
import com.voxtrail.sales.pojo.ResponseListPOJO;
import com.voxtrail.sales.pojo.UserRolePOJO;
import com.voxtrail.sales.pojo.user.UserPOJO;
import com.voxtrail.sales.webservice.ResponseListCallback;
import com.voxtrail.sales.webservice.WebServiceBase;
import com.voxtrail.sales.webservice.WebServiceBaseResponse;
import com.voxtrail.sales.webservice.WebServiceBaseResponseList;
import com.voxtrail.sales.webservice.WebServicesCallBack;
import com.voxtrail.sales.webservice.WebServicesUrls;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_user_name)
    EditText et_user_name;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.spinner_roles)
    Spinner spinner_roles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_user_name.getText().toString().length()>0
                        &&et_password.getText().toString().length()>0){
                    callLoginAPI();
                }else{
                    ToastClass.showShortToast(getApplicationContext(),"Please Enter Details Properly");
                }
            }
        });

        getAllRoles();

    }

    List<UserRolePOJO> userRolePOJOS=new ArrayList<>();

    public void getAllRoles(){
        ArrayList<NameValuePair> nameValuePairs=new ArrayList<>();
        new WebServiceBaseResponseList<>(nameValuePairs, this, new ResponseListCallback<UserRolePOJO>() {
            @Override
            public void onGetMsg(ResponseListPOJO<UserRolePOJO> responseListPOJO) {
                try{
                    if(responseListPOJO.isSuccess()){
                        List<String> stringList=new ArrayList<>();
                        for(UserRolePOJO userRolePOJO:responseListPOJO.getResultList()){
                            stringList.add(userRolePOJO.getRole());
                        }
                        setSpinnerItem(stringList);
                        userRolePOJOS.clear();
                        userRolePOJOS.addAll(responseListPOJO.getResultList());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },UserRolePOJO.class,"get_user_roles",true).execute(WebServicesUrls.GET_USER_ROLES);
    }

    public void setSpinnerItem(List<String> items){
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        items);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner_roles.setAdapter(spinnerArrayAdapter);
    }


    public void callLoginAPI(){
        ArrayList<NameValuePair> nameValuePairs=new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("username",et_user_name.getText().toString()));
        nameValuePairs.add(new BasicNameValuePair("password",et_password.getText().toString()));
        nameValuePairs.add(new BasicNameValuePair("role",userRolePOJOS.get(spinner_roles.getSelectedItemPosition()).getSno()));
//        nameValuePairs.add(new BasicNameValuePair("role","1"));
        new WebServiceBase(nameValuePairs, this, new WebServicesCallBack() {
            @Override
            public void onGetMsg(String apicall, String response) {
                try{
                    JSONObject jsonObject=new JSONObject(response);
                    if(jsonObject.optString("status").equals("1")){
                        JSONObject jsonObject1=jsonObject.optJSONObject("result");
                        Pref.SetBooleanPref(getApplicationContext(),StringUtils.IS_LOGIN,true);
                        Pref.SetStringPref(getApplicationContext(), StringUtils.USER_DETAILS,jsonObject1.toString());

                        UserPOJO userPOJO=new Gson().fromJson(jsonObject1.toString(),UserPOJO.class);
                        Constants.userPOJO=userPOJO;

                        if(userPOJO.getUsersrole().equals("3")){
                            startActivity(new Intent(LoginActivity.this,ImortExcelActivity.class));
                        }else{
                            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                        }

                        finish();

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"LOGIN_API_CALL",true).execute(WebServicesUrls.LOGIN_API);
    }

}
