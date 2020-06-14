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
import com.nejdetkadirr.expensesproject.recyclerview.HomeAdapter;

public class HomeFragment extends Fragment {
    HomeAdapter homeAdapter;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container,false);
        RecyclerView recyclerView = rootView.findViewById(R.id.HomeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        homeAdapter = new HomeAdapter(MainActivity.expensesModelArrayList);
        recyclerView.setAdapter(homeAdapter);
        return rootView;
    }
}
