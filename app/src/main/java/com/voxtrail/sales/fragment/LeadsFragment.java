package com.voxtrail.sales.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voxtrail.sales.R;
import com.voxtrail.sales.adapter.LeadAdapter;
import com.voxtrail.sales.fragmentcontroller.FragmentController;
import com.voxtrail.sales.pojo.ResponseListPOJO;
import com.voxtrail.sales.pojo.lead.LeadPOJO;
import com.voxtrail.sales.webservice.ResponseListCallback;
import com.voxtrail.sales.webservice.WebServiceBaseResponseList;
import com.voxtrail.sales.webservice.WebServicesUrls;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LeadsFragment extends FragmentController {

    @BindView(R.id.rv_leads)
    RecyclerView rv_leads;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_leads, container, false);
        setUpView(getActivity(),this,view);
        return view;
    }

    public static LeadsFragment newInstance() {
        Bundle args = new Bundle();
        LeadsFragment fragment = new LeadsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachAdapter();

        getAllLeads();
    }

    public void getAllLeads(){
        ArrayList<NameValuePair> nameValuePairs=new ArrayList<>();
        new WebServiceBaseResponseList<LeadPOJO>(nameValuePairs, getActivity(), new ResponseListCallback<LeadPOJO>(){
            @Override
            public void onGetMsg(ResponseListPOJO<LeadPOJO> responseListPOJO) {
                try{
                    if(responseListPOJO.isSuccess()){
                        deviceStrings.clear();
                        deviceStrings.addAll(responseListPOJO.getResultList());
                        leadAdapter.notifyDataSetChanged();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },LeadPOJO.class,"GET_LEADS",true).execute(WebServicesUrls.GET_LEADS);
    }

    LeadAdapter leadAdapter;
    List<LeadPOJO> deviceStrings= new ArrayList<>();

    public void attachAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_leads.setHasFixedSize(true);
        rv_leads.setLayoutManager(linearLayoutManager);
        leadAdapter = new LeadAdapter(getActivity(),null,deviceStrings);
        rv_leads.setAdapter(leadAdapter);
        rv_leads.setNestedScrollingEnabled(false);
        rv_leads.setItemAnimator(new DefaultItemAnimator());
    }

}
