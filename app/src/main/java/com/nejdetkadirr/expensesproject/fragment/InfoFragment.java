package com.nejdetkadirr.expensesproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nejdetkadirr.expensesproject.MainActivity;
import com.nejdetkadirr.expensesproject.R;
import com.nejdetkadirr.expensesproject.recyclerview.CategoryAdapter;
import com.nejdetkadirr.expensesproject.recyclerview.DayAdapter;
import com.nejdetkadirr.expensesproject.recyclerview.HomeAdapter;
import com.nejdetkadirr.expensesproject.recyclerview.MonthAdapter;

public class InfoFragment extends Fragment {
    CategoryAdapter categoryAdapter;
    MonthAdapter monthAdapter;
    DayAdapter dayAdapter;
    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info,container,false);

        RecyclerView recyclerViewCate = rootView.findViewById(R.id.CategoryRecyclerView);
        recyclerViewCate.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        categoryAdapter = new CategoryAdapter(MainActivity.categoriesName,MainActivity.categoriesInfo);
        recyclerViewCate.setAdapter(categoryAdapter);

        RecyclerView recyclerViewMonth = rootView.findViewById(R.id.MonthRecyclerView);
        recyclerViewMonth.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        monthAdapter = new MonthAdapter(MainActivity.monthsName,MainActivity.monthsInfo);
        recyclerViewMonth.setAdapter(monthAdapter);

        RecyclerView recyclerViewDay = rootView.findViewById(R.id.DayRecyclerView);
        recyclerViewDay.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        dayAdapter = new DayAdapter(MainActivity.daysName,MainActivity.daysInfo);
        recyclerViewDay.setAdapter(dayAdapter);

        return rootView;
    }
}
