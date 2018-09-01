package com.voxtrail.sales.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.voxtrail.sales.R;
import com.voxtrail.sales.pojo.CallLogsPOJO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 03-11-2017.
 */

public class CallLogsAdapter extends RecyclerView.Adapter<CallLogsAdapter.ViewHolder>{
    private List<CallLogsPOJO> items;
    Activity activity;
    Fragment fragment;

    public CallLogsAdapter(Activity activity, Fragment fragment, List<CallLogsPOJO> items) {
        this.items = items;
        this.activity = activity;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_call_log, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tv_contact_number.setText(items.get(position).getNumber());
        holder.tv_type.setText(items.get(position).getType());
        holder.tv_time.setText(items.get(position).getDate_time());


        holder.itemView.setTag(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_contact_number)
        TextView tv_contact_number;
        @BindView(R.id.tv_type)
        TextView tv_type;
        @BindView(R.id.tv_time)
        TextView tv_time;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
