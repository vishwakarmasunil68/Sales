package com.voxtrail.sales.fragment.lead.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.voxtrail.sales.R;
import com.voxtrail.sales.Util.Constants;
import com.voxtrail.sales.Util.ToastClass;
import com.voxtrail.sales.fragmentcontroller.FragmentController;
import com.voxtrail.sales.webservice.WebServiceBase;
import com.voxtrail.sales.webservice.WebServicesCallBack;
import com.voxtrail.sales.webservice.WebServicesUrls;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;

public class AddNoteFragment extends FragmentController {

    @BindView(R.id.et_description)
    EditText et_description;
    @BindView(R.id.iv_check)
    ImageView iv_check;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_add_note, container, false);
        setUpView(getActivity(),this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iv_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_description.getText().toString().length()>0){
                    insertNote();
                }else{
                    ToastClass.showShortToast(getActivity().getApplicationContext(),"Please Enter some text");
                }
            }
        });

    }

    public void insertNote(){
        ArrayList<NameValuePair> nameValuePairs=new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("leadid","1"));
        nameValuePairs.add(new BasicNameValuePair("comment",et_description.getText().toString()));
        nameValuePairs.add(new BasicNameValuePair("commentby_id", Constants.userPOJO.getSno()));
        nameValuePairs.add(new BasicNameValuePair("commentby", Constants.userPOJO.getName()));
        nameValuePairs.add(new BasicNameValuePair("commentby_email", Constants.userPOJO.getPersonalemail()));

        new WebServiceBase(nameValuePairs, getActivity(), new WebServicesCallBack() {
            @Override
            public void onGetMsg(String apicall, String response) {
                try{
                    JSONObject jsonObject=new JSONObject(response);
                    if(jsonObject.optString("status").equals("1")){
                        ToastClass.showShortToast(getActivity().getApplicationContext(),"Note Added");
                        onBackPressed();
                    }else{
                        ToastClass.showShortToast(getActivity().getApplicationContext(),jsonObject.optString("message"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"INSERT_NOTE",true).execute(WebServicesUrls.INSERT_NOTE);
    }

    public static AddNoteFragment newInstance() {
        Bundle args = new Bundle();
        AddNoteFragment fragment = new AddNoteFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
