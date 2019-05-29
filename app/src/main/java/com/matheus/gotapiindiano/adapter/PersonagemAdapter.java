package com.matheus.gotapiindiano.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.matheus.gotapiindiano.R;
import com.matheus.gotapiindiano.model.Personagem;

import java.util.List;

public class PersonagemAdapter extends RecyclerView.Adapter<PersonagemAdapter.PersonagemViewHolder> {
    private List<Personagem> dataList;
    private Context context;
    private static PersonagemAdapter.ClickListener clickListener;

    public PersonagemAdapter(Context context, List<Personagem> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public static class PersonagemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public final View mview;
        private ImageView coverImage;
        TextView txtName;
        TextView txtCulture;
        TextView txtBorn;
        TextView txtGender;

        PersonagemViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
            mview.setOnClickListener(this);
            mview.setOnLongClickListener(this);
            txtName = mview.findViewById(R.id.name);
            txtCulture = mview.findViewById(R.id.culture);
            txtBorn = mview.findViewById(R.id.born);
            txtGender = mview.findViewById(R.id.gender);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }

    @Override
    public PersonagemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row_person, parent, false);
        return new PersonagemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PersonagemViewHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getName());
        holder.txtCulture.setText(dataList.get(position).getCulture());
        holder.txtBorn.setText(dataList.get(position).getBorn());
        holder.txtGender.setText(dataList.get(position).getGender());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnItemClickListener(PersonagemAdapter.ClickListener clickListener) {
        PersonagemAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);

        void onItemLongClick(int position, View v);
    }
}
