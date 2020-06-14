package com.nejdetkadirr.expensesproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nejdetkadirr.expensesproject.MainActivity;
import com.nejdetkadirr.expensesproject.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class DetailFragment extends Fragment {
    ArrayList<String> details = new ArrayList<>();
    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail,container,false);
        details.add("Toplam harcama tutarı " + MainActivity.totalPrice);
        details.add(MainActivity.isWeekend + " daha fazla harcama yapılmış.");
        String maxCatPrice = "";
        String minCatPrice = "";
        int order = 0;
        Map<String, Double> maxCat = sortByValue(MainActivity.categoriesInfo);
        for (Map.Entry<String, Double> cat : maxCat.entrySet()) {
            if (order == 0) {
                minCatPrice = cat.getKey();
            }
            order++;
            maxCatPrice = cat.getKey();
        }
        details.add("En az harcama " + minCatPrice + " kategorisine ait.");
        details.add("En fazla harcama " + maxCatPrice + " kategorisine ait.");
        String minMonthPrice = "";
        String maxMonthPrice = "";
        order = 0;
        Map<String, Double> minMonth = sortByValue(MainActivity.monthsInfo);
        for (Map.Entry<String, Double> month : minMonth.entrySet()) {
            if (order == 0) {
                minMonthPrice = month.getKey();
            }
            order++;
            maxMonthPrice = month.getKey();
        }
        details.add("En az harcama " + minMonthPrice + " ayına ait.");
        details.add("En fazla harcama " + maxMonthPrice + " ayına ait.");
        ListView listView = rootView.findViewById(R.id.ListViewDetail);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,details);
        listView.setAdapter(arrayAdapter);
        return rootView;
    }
    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm) {
        // Create a list from elements of HashMap
        LinkedList<Map.Entry<String, Double> > list =
                new LinkedList<Map.Entry<String, Double> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
