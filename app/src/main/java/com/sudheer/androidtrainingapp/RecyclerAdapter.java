package com.sudheer.androidtrainingapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sudheer on 5/4/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    public String[] country_names, country_capitals;

    public RecyclerAdapter(String[] country_names, String[] country_capitals) {
        this.country_names = country_names;
        this.country_capitals = country_capitals;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tx_country.setText(country_names[position]);
        holder.tx_capital.setText(country_capitals[position]);
    }

    @Override
    public int getItemCount() {
        return country_names.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tx_country, tx_capital;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tx_country = (TextView) itemView.findViewById(R.id.tx_country);
            tx_capital = (TextView) itemView.findViewById(R.id.tx_capital);
        }
    }
}