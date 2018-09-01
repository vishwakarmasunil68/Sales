package com.voxtrail.sales.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.voxtrail.sales.R;
import com.voxtrail.sales.activity.LeadActivity;
import com.voxtrail.sales.pojo.lead.LeadPOJO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 03-11-2017.
 */

public class LeadAdapter extends RecyclerView.Adapter<LeadAdapter.ViewHolder>{
    private List<LeadPOJO> items;
    Activity activity;
    Fragment fragment;

    public LeadAdapter(Activity activity, Fragment fragment, List<LeadPOJO> items) {
        this.items = items;
        this.activity = activity;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_lead_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.ll_lead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, LeadActivity.class));
            }
        });

        holder.tv_company_name.setText(items.get(position).getCompname());
        holder.tv_lead_email.setText(items.get(position).getEmail());
        holder.tv_place.setText(items.get(position).getCompaddress());
        holder.tv_revenue.setText("$ " +items.get(position).getComprevenue());

        holder.itemView.setTag(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ll_lead)
        LinearLayout ll_lead;
        @BindView(R.id.tv_company_name)
        TextView tv_company_name;
        @BindView(R.id.tv_lead_email)
        TextView tv_lead_email;
        @BindView(R.id.tv_place)
        TextView tv_place;
        @BindView(R.id.tv_revenue)
        TextView tv_revenue;
        @BindView(R.id.tv_date)
        TextView tv_date;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
