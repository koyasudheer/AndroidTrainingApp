package com.sudheer.androidtrainingapp;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.tx_country.setText(country_names[position]);
        holder.tx_capital.setText(country_capitals[position]);
        holder.ch_box.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        StringBuffer result=new StringBuffer();
//                        for(int i=0;i<country_names.length;i++){
//                            if(((CheckBox)v).isChecked()){
//                                result.append("Country:").append(country_names[position]);
                       // Toast.makeText(v.getContext(), result.toString(), Toast.LENGTH_LONG).show();
//                            }
//                        }
//                        if(((CheckBox)v).isChecked()) {
//
//                            Toast.makeText(v.getContext(),"Country:"+country_names[position]+"capital:"+country_capitals[position],Toast.LENGTH_LONG).show();
//                        }
                        if(((CheckBox)v).isChecked()) {
                            AlertDialog.Builder a_builder = new AlertDialog.Builder(v.getContext());
                            a_builder.setMessage("Country: " + country_names[position] + "\n" + "Capital:" + country_capitals[position])
                                    .setCancelable(true);
                            AlertDialog alert = a_builder.create();
                            alert.setTitle("You Selected");
                            alert.show();
                        }
                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return country_names.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tx_country, tx_capital;
        CheckBox ch_box;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tx_country = (TextView) itemView.findViewById(R.id.tx_country);
            tx_capital = (TextView) itemView.findViewById(R.id.tx_capital);
            ch_box=(CheckBox)itemView.findViewById(R.id.ch_box);

        }
    }
}