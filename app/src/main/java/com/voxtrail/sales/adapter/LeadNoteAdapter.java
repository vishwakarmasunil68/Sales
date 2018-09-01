package com.voxtrail.sales.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.voxtrail.sales.R;
import com.voxtrail.sales.pojo.lead.LeadNotePOJO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 03-11-2017.
 */

public class LeadNoteAdapter extends RecyclerView.Adapter<LeadNoteAdapter.ViewHolder> {
    private List<LeadNotePOJO> items;
    Activity activity;
    Fragment fragment;

    public LeadNoteAdapter(Activity activity, Fragment fragment, List<LeadNotePOJO> items) {
        this.items = items;
        this.activity = activity;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_lead_note, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tv_note.setText(items.get(position).getComment());
        holder.tv_by.setText("By "+items.get(position).getCommentby());
        holder.tv_dt.setText(items.get(position).getCommentdatetime());

        holder.itemView.setTag(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_note)
        TextView tv_note;
        @BindView(R.id.tv_by)
        TextView tv_by;
        @BindView(R.id.tv_dt)
        TextView tv_dt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
