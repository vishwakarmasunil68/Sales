package com.voxtrail.sales.fragment.lead.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.voxtrail.sales.R;
import com.voxtrail.sales.Util.UtilityFunction;
import com.voxtrail.sales.fragmentcontroller.FragmentController;
import com.voxtrail.sales.pojo.ResponseListPOJO;
import com.voxtrail.sales.pojo.lead.LeadOutcomePOJO;
import com.voxtrail.sales.webservice.ResponseListCallback;
import com.voxtrail.sales.webservice.WebServiceBaseResponseList;
import com.voxtrail.sales.webservice.WebServicesUrls;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

public class AddAppointmentFragment extends FragmentController implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{

    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_description)
    EditText et_description;
    @BindView(R.id.et_from)
    EditText et_from;
    @BindView(R.id.et_from_time)
    EditText et_from_time;
    @BindView(R.id.et_to)
    EditText et_to;
    @BindView(R.id.et_to_time)
    EditText et_to_time;
    @BindView(R.id.et_where)
    EditText et_where;
    @BindView(R.id.et_related_to)
    EditText et_related_to;
    @BindView(R.id.rv_attendes)
    RecyclerView rv_attendes;
    @BindView(R.id.spinner_outcome)
    Spinner spinner_outcome;

    EditText dateEdittext,timeEdittext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_add_appointment, container, false);
        setUpView(getActivity(),this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getAllOutcomes();

        et_from.setText(UtilityFunction.getCurrentDate());
        et_to.setText(UtilityFunction.getCurrentDate());


        et_from_time.setText(UtilityFunction.getCurrentTime());
        et_to_time.setText(UtilityFunction.getCurrentTime());


        et_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateEdittext=et_from;
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        AddAppointmentFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(), "Select From Date");
            }
        });
        et_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateEdittext=et_to;
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        AddAppointmentFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(), "Select To Date");
            }
        });

        et_from_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeEdittext=et_from_time;
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        AddAppointmentFragment.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.show(getActivity().getFragmentManager(), "Select Time");
            }
        });

        et_to_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeEdittext=et_to_time;
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        AddAppointmentFragment.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.show(getActivity().getFragmentManager(), "Select Time");
            }
        });

    }
    List<LeadOutcomePOJO> leadOutcomePOJOS=new ArrayList<>();
    public void getAllOutcomes(){
        new WebServiceBaseResponseList<LeadOutcomePOJO>(new ArrayList<NameValuePair>(), getActivity(), new ResponseListCallback<LeadOutcomePOJO>() {
            @Override
            public void onGetMsg(ResponseListPOJO<LeadOutcomePOJO> responseListPOJO) {
                try{
                    if(responseListPOJO.isSuccess()){
                        List<String> stringList=new ArrayList<>();
                        for(LeadOutcomePOJO leadOutcomePOJO:responseListPOJO.getResultList()){
                            stringList.add(leadOutcomePOJO.getOutcome());
                        }
                        leadOutcomePOJOS.clear();
                        leadOutcomePOJOS.addAll(responseListPOJO.getResultList());

                        setOutcomeSpinnerAdapter(stringList);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },LeadOutcomePOJO.class,"GET_LEAD_OUTCOME",true).execute(WebServicesUrls.GET_ALL_OUTCOMES);
    }

    public void setOutcomeSpinnerAdapter(List<String> outcomes){
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_spinner_item,
                        outcomes); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner_outcome.setAdapter(spinnerArrayAdapter);
    }

    public static AddAppointmentFragment newInstance() {
        Bundle args = new Bundle();
        AddAppointmentFragment fragment = new AddAppointmentFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String month = "";
        String day = "";
        if ((monthOfYear + 1) < 10) {
            month = "0" + (monthOfYear + 1);
        } else {
            month = String.valueOf(monthOfYear + 1);
        }

        if (dayOfMonth < 10) {
            day = "0" + dayOfMonth;
        } else {
            day = String.valueOf(dayOfMonth);
        }

        String date = day + "-" + month + "-" + year;
        dateEdittext.setText(date);
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String secondString = second < 10 ? "0" + second : "" + second;
        String time = hourString + ":" + minuteString;
        timeEdittext.setText(time);
    }
}
