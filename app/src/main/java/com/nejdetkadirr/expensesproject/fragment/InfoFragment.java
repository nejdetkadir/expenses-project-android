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
import com.nejdetkadirr.expensesproject.recyclerview.HomeAdapter;

public class InfoFragment extends Fragment {
    CategoryAdapter categoryAdapter;
    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info,container,false);

        RecyclerView recyclerView = rootView.findViewById(R.id.CategoryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        categoryAdapter = new CategoryAdapter(MainActivity.categoriesName,MainActivity.categoriesInfo);
        recyclerView.setAdapter(categoryAdapter);
        return rootView;
    }
}
