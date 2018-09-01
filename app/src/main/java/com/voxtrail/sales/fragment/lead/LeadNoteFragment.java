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
import com.voxtrail.sales.fragmentcontroller.FragmentController;
import com.voxtrail.sales.pojo.ResponseListPOJO;
import com.voxtrail.sales.pojo.lead.LeadNotePOJO;
import com.voxtrail.sales.webservice.ResponseListCallback;
import com.voxtrail.sales.webservice.WebServiceBaseResponseList;
import com.voxtrail.sales.webservice.WebServicesUrls;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LeadNoteFragment extends FragmentController {

    @BindView(R.id.rv_timeline)
    RecyclerView rv_timeline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_lead_notes, container, false);
        setUpView(getActivity(), this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachAdapter();
        getAllLeads();
    }

    public static LeadNoteFragment newInstance() {
        Bundle args = new Bundle();
        LeadNoteFragment fragment = new LeadNoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void getAllLeads() {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("lead_id", "1"));

        new WebServiceBaseResponseList<LeadNotePOJO>(nameValuePairs, getActivity(), new ResponseListCallback<LeadNotePOJO>() {

            @Override
            public void onGetMsg(ResponseListPOJO<LeadNotePOJO> responseListPOJO) {
                try {
                    if (responseListPOJO.isSuccess()) {
                        deviceStrings.clear();
                        deviceStrings.addAll(responseListPOJO.getResultList());
                        leadAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, LeadNotePOJO.class, "get_notes", true).execute(WebServicesUrls.GET_NOTES);
    }


    LeadNoteAdapter leadAdapter;
    List<LeadNotePOJO> deviceStrings = new ArrayList<>();

    public void attachAdapter() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_timeline.setHasFixedSize(true);
        rv_timeline.setLayoutManager(linearLayoutManager);
        leadAdapter = new LeadNoteAdapter(getActivity(), null, deviceStrings);
        rv_timeline.setAdapter(leadAdapter);
        rv_timeline.setNestedScrollingEnabled(false);
        rv_timeline.setItemAnimator(new DefaultItemAnimator());
    }


}
