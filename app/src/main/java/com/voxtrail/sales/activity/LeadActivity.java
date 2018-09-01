package com.voxtrail.sales.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;
import com.voxtrail.sales.R;
import com.voxtrail.sales.Util.ToastClass;
import com.voxtrail.sales.adapter.ViewPagerWithTitleAdapter;
import com.voxtrail.sales.fragment.LeadsFragment;
import com.voxtrail.sales.fragment.lead.LeadActivityFragment;
import com.voxtrail.sales.fragment.lead.LeadAppointmentFragment;
import com.voxtrail.sales.fragment.lead.LeadBasicInfoFragment;
import com.voxtrail.sales.fragment.lead.LeadCallBackFragment;
import com.voxtrail.sales.fragment.lead.LeadNoteFragment;
import com.voxtrail.sales.fragment.lead.LeadTaskFragment;
import com.voxtrail.sales.fragment.lead.add.AddAppointmentFragment;
import com.voxtrail.sales.fragment.lead.add.AddDealFragment;
import com.voxtrail.sales.fragment.lead.add.AddNoteFragment;
import com.voxtrail.sales.fragment.lead.add.AddTaskFragment;
import com.voxtrail.sales.fragmentcontroller.ActivityManager;
import com.voxtrail.sales.pojo.LeadBasicPOJO;
import com.voxtrail.sales.pojo.ResponsePOJO;
import com.voxtrail.sales.view.CustomViewPager;
import com.voxtrail.sales.webservice.ResponseCallBack;
import com.voxtrail.sales.webservice.WebServiceBaseResponse;
import com.voxtrail.sales.webservice.WebServicesUrls;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeadActivity extends ActivityManager {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    CustomViewPager viewPager;

    @BindView(R.id.menu_add_deal)
    FloatingActionButton menu_add_deal;
    @BindView(R.id.menu_add_note)
    FloatingActionButton menu_add_note;
    @BindView(R.id.menu_add_task)
    FloatingActionButton menu_add_task;
    @BindView(R.id.menu_add_appointment)
    FloatingActionButton menu_add_appointment;
    @BindView(R.id.menu_add_call)
    FloatingActionButton menu_add_call;

    @BindView(R.id.tv_owner_name)
    TextView tv_owner_name;
    @BindView(R.id.tv_department)
    TextView tv_department;
    @BindView(R.id.ll_email)
    LinearLayout ll_email;
    @BindView(R.id.ll_phone)
    LinearLayout ll_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        ButterKnife.bind(this);

        setUpPager();

        menu_add_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddDealFragment());
            }
        });
        menu_add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddNoteFragment());
            }
        });
        menu_add_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddTaskFragment());
            }
        });
        menu_add_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddAppointmentFragment());
            }
        });
        menu_add_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddDealFragment());
            }
        });


    }


    LeadBasicInfoFragment leadBasicInfoFragment;

    public void setUpPager() {
        ViewPagerWithTitleAdapter adapter = new ViewPagerWithTitleAdapter(getSupportFragmentManager());
        adapter.addFrag(leadBasicInfoFragment = new LeadBasicInfoFragment(), "BASIC INFO");
        adapter.addFrag(new LeadActivityFragment(), "ACTIVITIES");
        adapter.addFrag(new LeadsFragment(), "DEALS");
        adapter.addFrag(new LeadNoteFragment(), "NOTES");
        adapter.addFrag(new LeadTaskFragment(), "TASKS");
        adapter.addFrag(new LeadAppointmentFragment(), "APPOINTMENTS");
        adapter.addFrag(new LeadCallBackFragment(), "CALL LOGS");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());

        tabs.setupWithViewPager(viewPager);

        getLeadBasicInfo();
    }

    public void getLeadBasicInfo() {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("sno", "1"));

        new WebServiceBaseResponse<LeadBasicPOJO>(nameValuePairs, this, new ResponseCallBack<LeadBasicPOJO>() {
            @Override
            public void onGetMsg(final ResponsePOJO<LeadBasicPOJO> responsePOJO) {
                try {
                    if (responsePOJO.isSuccess()) {
                        if (leadBasicInfoFragment != null) {
                            leadBasicInfoFragment.showData(responsePOJO.getResult());
                            tv_owner_name.setText(responsePOJO.getResult().getOwner());
                            tv_department.setText(responsePOJO.getResult().getDepartment());

                            ll_email.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    sendEmail(responsePOJO.getResult().getEmail());
                                }
                            });

                            ll_phone.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    callPhone(responsePOJO.getResult().getMobile());
                                }
                            });

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, LeadBasicPOJO.class, "get_lead_basic", true).execute(WebServicesUrls.GET_LEAD_INFO);
    }

    public void sendEmail(String email){
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{email});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Deal");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");


        emailIntent.setType("message/rfc822");

        try {
            startActivity(Intent.createChooser(emailIntent,
                    "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            ToastClass.showShortToast(getApplicationContext(), "No Email App Found");
        }
    }

    public void callPhone(final String phone_number){

        Permissions.check(LeadActivity.this, Manifest.permission.CALL_PHONE, null,
                new PermissionHandler() {
                    @Override
                    public void onGranted() {
                        //do your task.
                        try {
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + phone_number));
                            if (ActivityCompat.checkSelfPermission(LeadActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    ActivityCompat#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for ActivityCompat#requestPermissions for more details.
                                return;
                            }
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
