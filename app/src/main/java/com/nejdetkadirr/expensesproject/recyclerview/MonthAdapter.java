package com.nejdetkadirr.expensesproject.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nejdetkadirr.expensesproject.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.DataHolder> {
    ArrayList<String> monthNames;
    HashMap<String,Double> monthInfo;

    public MonthAdapter(ArrayList<String> monthNames, HashMap<String, Double> monthInfo) {
        this.monthNames = monthNames;
        this.monthInfo = monthInfo;
    }

    @NonNull
    @Override
    public MonthAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_two_column,parent,false);
        return new MonthAdapter.DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthAdapter.DataHolder holder, int position) {
        holder.month.setText(monthNames.get(position));
        holder.price.setText(monthInfo.get(monthNames.get(position)) + "");
    }

    @Override
    public int getItemCount() {
        return monthNames.size();
    }

    class DataHolder extends RecyclerView.ViewHolder {
        TextView month;
        TextView price;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.RecyclerViewTitleName);
            price = itemView.findViewById(R.id.RecyclerViewTitlePrice);
        }
    }
}
