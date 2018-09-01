package com.voxtrail.sales.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.voxtrail.sales.R;
import com.voxtrail.sales.Util.Constants;
import com.voxtrail.sales.Util.Pref;
import com.voxtrail.sales.Util.StringUtils;
import com.voxtrail.sales.pojo.user.UserPOJO;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Pref.GetBooleanPref(getApplicationContext(), StringUtils.IS_LOGIN,false)){
                    String user_details=Pref.GetStringPref(getApplicationContext(),StringUtils.USER_DETAILS,"");
                    Constants.userPOJO=new Gson().fromJson(user_details, UserPOJO.class);
                    if(Constants.userPOJO.getUsersrole().equals("3")){
                        startActivity(new Intent(SplashActivity.this, ImortExcelActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    }

                }else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finishAffinity();
            }
        },2000);

    }
}
