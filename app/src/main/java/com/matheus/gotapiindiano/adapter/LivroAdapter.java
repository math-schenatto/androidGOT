package com.matheus.gotapiindiano.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.matheus.gotapiindiano.R;
import com.matheus.gotapiindiano.model.Livro;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.LivroViewHolder> {
    private List<Livro> dataList;
    private Context context;
    private static ClickListener clickListener;

    public LivroAdapter(Context context, List<Livro> dataList){
        this.context = context;
        this.dataList = dataList;
    }
    public static class LivroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public final View mview;
        private ImageView coverImage;
        TextView txtTitle;
        TextView txtIsbn;
        TextView txtReleased;
        TextView txtAuthors;

        LivroViewHolder(View itemView){
            super(itemView);
            mview = itemView;
            mview.setOnClickListener(this);
            mview.setOnLongClickListener(this);
            txtTitle = mview.findViewById(R.id.title);
            txtIsbn = mview.findViewById(R.id.isbn);
            txtReleased = mview.findViewById(R.id.released);
            txtAuthors = mview.findViewById(R.id.autor);

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
    public LivroViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new LivroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LivroViewHolder holder, int position){
        holder.txtTitle.setText(dataList.get(position).getName());
        holder.txtIsbn.setText(dataList.get(position).getIsbn());
        holder.txtReleased.setText(dataList.get(position).getReleased());
        holder.txtAuthors.setText(dataList.get(position).getCountry());

        //Picasso.Builder builder = new Picasso.Builder(context);
        //builder.downloader(new OkHttp3Downloader(context));
        //builder.build().load(dataList.get(position).getT)
    }

    @Override
    public int getItemCount(){
        return dataList.size();
    }


    public void setOnItemClickListener(ClickListener clickListener) {
        LivroAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
}
