package com.voxtrail.sales.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voxtrail.sales.R;
import com.voxtrail.sales.adapter.LeadAdapter;
import com.voxtrail.sales.fragmentcontroller.FragmentController;
import com.voxtrail.sales.pojo.lead.LeadPOJO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DealsFragment extends FragmentController {

    @BindView(R.id.rv_leads)
    RecyclerView rv_leads;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_deals, container, false);
        setUpView(getActivity(),this,view);
        return view;
    }

    public static DealsFragment newInstance() {
        Bundle args = new Bundle();
        DealsFragment fragment = new DealsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachAdapter();
    }

    LeadAdapter leadAdapter;
    List<LeadPOJO> deviceStrings = new ArrayList<>();

    public void attachAdapter() {

        for (int i = 0; i < 5; i++) {
            deviceStrings.add(new LeadPOJO());
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_leads.setHasFixedSize(true);
        rv_leads.setLayoutManager(linearLayoutManager);
        leadAdapter = new LeadAdapter(getActivity(),null,deviceStrings);
        rv_leads.setAdapter(leadAdapter);
        rv_leads.setNestedScrollingEnabled(false);
        rv_leads.setItemAnimator(new DefaultItemAnimator());
    }

}
