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
import java.util.HashMap;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.DataHolder> {
    ArrayList<String> categoryNames;
    HashMap<String,Double> categoriesInfo;

    public CategoryAdapter(ArrayList<String> cateName, HashMap<String, Double> cateInfo) {
        this.categoryNames = cateName;
        this.categoriesInfo = cateInfo;
    }

    @NonNull
    @Override
    public CategoryAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_two_column,parent,false);
        return new CategoryAdapter.DataHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.DataHolder holder, int position) {
        holder.category.setText(categoryNames.get(position));
        holder.price.setText(categoriesInfo.get(categoryNames.get(position)) + "");
    }

    @Override
    public int getItemCount() {
        return categoryNames.size();
    }

    class DataHolder extends RecyclerView.ViewHolder {
        TextView category;
        TextView price;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.RecyclerViewCategoryName);
            price = itemView.findViewById(R.id.RecyclerViewCategoryPrice);
        }
    }
}
