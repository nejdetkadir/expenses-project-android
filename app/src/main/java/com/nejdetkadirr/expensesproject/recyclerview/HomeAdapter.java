package com.nejdetkadirr.expensesproject.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nejdetkadirr.expensesproject.R;
import com.nejdetkadirr.expensesproject.service.ExpensesModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.DataHolder> {
    ArrayList<ExpensesModel> expensesModelArrayList;

    public HomeAdapter(ArrayList<ExpensesModel> models) {
        this.expensesModelArrayList = models;
    }

    @NonNull
    @Override
    public HomeAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_home_recycler,parent,false);
        return new HomeAdapter.DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.DataHolder holder, int position) {
        holder.id.setText(expensesModelArrayList.get(position).id);
        holder.date.setText(expensesModelArrayList.get(position).date);
        holder.category.setText(expensesModelArrayList.get(position).category);
        holder.price.setText(expensesModelArrayList.get(position).price);
    }

    @Override
    public int getItemCount() {
        return expensesModelArrayList.size();
    }

    class DataHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView date;
        TextView category;
        TextView price;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.RecyclerViewID);
            date = itemView.findViewById(R.id.RecyclerViewDate);
            category = itemView.findViewById(R.id.RecyclerViewCategory);
            price = itemView.findViewById(R.id.RecyclerViewPrice);
        }
    }

}
