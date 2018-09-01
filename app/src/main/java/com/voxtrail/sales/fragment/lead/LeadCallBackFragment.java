package com.voxtrail.sales.fragment.lead;

import android.Manifest;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;
import com.voxtrail.sales.R;
import com.voxtrail.sales.adapter.CallLogsAdapter;
import com.voxtrail.sales.adapter.LeadAppointmentAdapter;
import com.voxtrail.sales.fragmentcontroller.FragmentController;
import com.voxtrail.sales.pojo.CallLogsPOJO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

public class LeadCallBackFragment extends FragmentController {

    @BindView(R.id.rv_timeline)
    RecyclerView rv_timeline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_lead_activity, container, false);
        setUpView(getActivity(),this,view);
        return view;
    }

    public static LeadCallBackFragment newInstance() {
        Bundle args = new Bundle();
        LeadCallBackFragment fragment = new LeadCallBackFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        attachAdapter();

        Permissions.check(getActivity(), Manifest.permission.READ_CALL_LOG, null,
                new PermissionHandler() {
                    @Override
                    public void onGranted() {
                        //do your task.
                        getCallDetails();
                    }
                });
    }

    List<CallLogsPOJO> callLogsPOJOS=new ArrayList<>();
    private void getCallDetails() {

        StringBuffer sb = new StringBuffer();
        Cursor managedCursor = getActivity().managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        sb.append("Call Details :");
        int count = 0;
        while (managedCursor.moveToNext() && count <= 10) {
            String phNumber = managedCursor.getString(number);
            String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = managedCursor.getString(duration);
            String dir = null;
            int dircode = Integer.parseInt(callType);
            switch (dircode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    dir = "OUTGOING";
                    break;

                case CallLog.Calls.INCOMING_TYPE:
                    dir = "INCOMING";
                    break;

                case CallLog.Calls.MISSED_TYPE:
                    dir = "MISSED";
                    break;
            }
//            sb.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- " + dir + " \nCall Date:--- " + callDayTime + " \nCall duration in sec :--- " + callDuration);
//            sb.append("\n----------------------------------");

            CallLogsPOJO callLogsPOJO=new CallLogsPOJO();
            callLogsPOJO.setDuration(callDuration);
            callLogsPOJO.setType(dir);
            callLogsPOJO.setNumber(phNumber);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            callLogsPOJO.setDate_time(simpleDateFormat.format(callDayTime));


            callLogsPOJOS.add(callLogsPOJO);
            count++;
        }
        callLogsAdapter.notifyDataSetChanged();
        managedCursor.close();
//        call.setText(sb);
//        Log.d(TagUtils.getTag(), "calls:-" + sb);
    }


    CallLogsAdapter callLogsAdapter;

    public void attachAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_timeline.setHasFixedSize(true);
        rv_timeline.setLayoutManager(linearLayoutManager);
        callLogsAdapter = new CallLogsAdapter(getActivity(),null,callLogsPOJOS);
        rv_timeline.setAdapter(callLogsAdapter);
        rv_timeline.setNestedScrollingEnabled(false);
        rv_timeline.setItemAnimator(new DefaultItemAnimator());
    }

}
