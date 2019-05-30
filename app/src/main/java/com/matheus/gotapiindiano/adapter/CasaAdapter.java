package com.matheus.gotapiindiano.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.matheus.gotapiindiano.R;
import com.matheus.gotapiindiano.model.Casa;

import java.util.ArrayList;
import java.util.List;

public class CasaAdapter extends RecyclerView.Adapter<CasaAdapter.CasaViewHolder> {
    private List<Casa> dataList;
    private Context context;
    private static CasaAdapter.ClickListener clickListener;

    public CasaAdapter(Context context, List<Casa> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    public static class CasaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public final View mview;
        TextView txtName;
        TextView txtRegion;
        TextView txtWords;
        TextView txtFounded;

        CasaViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
            mview.setOnClickListener(this);
            mview.setOnLongClickListener(this);
            txtName = mview.findViewById(R.id.houseName);
            txtRegion = mview.findViewById(R.id.region);
            txtWords = mview.findViewById(R.id.words);
            txtFounded = mview.findViewById(R.id.founded);
        }

        @Override
        public void onClick(View v) {
            try {
                clickListener.onItemClick(getAdapterPosition(), v);
            } catch (Exception e) {
                return;
            }
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }

    @Override
    public CasaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row_casa, parent, false);
        return new CasaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CasaViewHolder holder, final int position) {
        holder.txtName.setText(dataList.get(position).getName());
        holder.txtRegion.setText(dataList.get(position).getRegion());
        holder.txtWords.setText(dataList.get(position).getWords());
        holder.txtFounded.setText(dataList.get(position).getFounded());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setfilter(List<Casa> listcasa) {
        dataList = new ArrayList<>();
        dataList.addAll(listcasa);
        notifyDataSetChanged();

    }

    public void setOnItemClickListener(CasaAdapter.ClickListener clickListener) {
        CasaAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);

        void onItemLongClick(int position, View v);
    }
}
