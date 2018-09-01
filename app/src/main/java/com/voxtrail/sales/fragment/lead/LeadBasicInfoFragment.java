package com.voxtrail.sales.fragment.lead;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.voxtrail.sales.R;
import com.voxtrail.sales.fragmentcontroller.FragmentController;
import com.voxtrail.sales.pojo.LeadBasicPOJO;
import com.voxtrail.sales.pojo.ResponsePOJO;
import com.voxtrail.sales.webservice.ResponseCallBack;
import com.voxtrail.sales.webservice.WebServiceBaseResponse;
import com.voxtrail.sales.webservice.WebServicesUrls;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

import butterknife.BindView;

public class LeadBasicInfoFragment extends FragmentController {

    @BindView(R.id.et_owner)
    EditText et_owner;
    @BindView(R.id.et_account_name)
    EditText et_account_name;
    @BindView(R.id.et_department)
    EditText et_department;
    @BindView(R.id.et_status)
    EditText et_status;
    @BindView(R.id.et_address)
    EditText et_address;
    @BindView(R.id.et_facebook)
    EditText et_facebook;
    @BindView(R.id.et_twitter)
    EditText et_twitter;
    @BindView(R.id.et_linked_in)
    EditText et_linked_in;
    @BindView(R.id.et_city)
    EditText et_city;
    @BindView(R.id.et_state)
    EditText et_state;
    @BindView(R.id.et_country)
    EditText et_country;
    @BindView(R.id.et_pin_code)
    EditText et_pin_code;
    @BindView(R.id.et_website)
    EditText et_website;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_lead_basic_info, container, false);
        setUpView(getActivity(),this,view);
        return view;
    }

    public static LeadBasicInfoFragment newInstance() {
        Bundle args = new Bundle();
        LeadBasicInfoFragment fragment = new LeadBasicInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public void showData(LeadBasicPOJO leadBasicPOJO){
        et_owner.setText(leadBasicPOJO.getOwner());
        et_account_name.setText(leadBasicPOJO.getFirstname() + " " + leadBasicPOJO.getLastname());
        et_department.setText(leadBasicPOJO.getDepartment());
        et_status.setText(leadBasicPOJO.getStagename());
        et_address.setText(leadBasicPOJO.getCompaddress());
        et_facebook.setText(leadBasicPOJO.getFacebook());
        et_twitter.setText(leadBasicPOJO.getTwitter());
        et_linked_in.setText(leadBasicPOJO.getLinkedin());
        et_city.setText(leadBasicPOJO.getCompcity());
        et_state.setText(leadBasicPOJO.getCompstate());
        et_country.setText(leadBasicPOJO.getCompcountry());
        et_pin_code.setText(leadBasicPOJO.getCompzipcode());
        et_website.setText(leadBasicPOJO.getCompwebsite());
    }


}
