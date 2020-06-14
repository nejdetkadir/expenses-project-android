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

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DataHolder> {
    ArrayList<String> dayNames;
    HashMap<String,Double> dayInfo;

    public DayAdapter(ArrayList<String> dayName, HashMap<String, Double> dayInfo) {
        this.dayNames = dayName;
        this.dayInfo = dayInfo;
    }

    @NonNull
    @Override
    public DayAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_two_column,parent,false);
        return new DayAdapter.DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayAdapter.DataHolder holder, int position) {
        holder.day.setText(dayNames.get(position));
        holder.price.setText(dayInfo.get(dayNames.get(position)) + "");
    }

    @Override
    public int getItemCount() {
        return dayNames.size();
    }

    class DataHolder extends RecyclerView.ViewHolder {
        TextView day;
        TextView price;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.RecyclerViewTitleName);
            price = itemView.findViewById(R.id.RecyclerViewTitlePrice);
        }
    }
}
