package com.voxtrail.sales.fragment.lead;

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
import com.voxtrail.sales.adapter.LeadNoteAdapter;
import com.voxtrail.sales.adapter.LeadTaskAdapter;
import com.voxtrail.sales.fragmentcontroller.FragmentController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LeadTaskFragment extends FragmentController {

    @BindView(R.id.rv_timeline)
    RecyclerView rv_timeline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_lead_notes, container, false);
        setUpView(getActivity(),this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachAdapter();
    }

    public static LeadTaskFragment newInstance() {
        Bundle args = new Bundle();
        LeadTaskFragment fragment = new LeadTaskFragment();
        fragment.setArguments(args);
        return fragment;
    }


    LeadTaskAdapter leadAdapter;
    List<String> deviceStrings= new ArrayList<>();

    public void attachAdapter() {

        for(int i=0;i<15;i++){
            deviceStrings.add("");
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_timeline.setHasFixedSize(true);
        rv_timeline.setLayoutManager(linearLayoutManager);
        leadAdapter = new LeadTaskAdapter(getActivity(),null,deviceStrings);
        rv_timeline.setAdapter(leadAdapter);
        rv_timeline.setNestedScrollingEnabled(false);
        rv_timeline.setItemAnimator(new DefaultItemAnimator());
    }


}
