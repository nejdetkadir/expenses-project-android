package com.nejdetkadirr.expensesproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nejdetkadirr.expensesproject.fragment.ViewPagerAdapter;
import com.nejdetkadirr.expensesproject.service.ExpensesAPI;
import com.nejdetkadirr.expensesproject.service.ExpensesModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    CompositeDisposable compositeDisposable;
    public static ArrayList<ExpensesModel> expensesModelArrayList;
    public static ArrayList<String> categoriesName = new ArrayList<>();
    public static HashMap<String,Double> categoriesInfo = new HashMap<>();
    public static ArrayList<String> monthsName = new ArrayList<>();
    public static HashMap<String,Double> monthsInfo = new HashMap<>();
    public static ArrayList<String> daysName = new ArrayList<>();
    public static HashMap<String,Double> daysInfo = new HashMap<>();
    private String baseURL = "https://api.nejdetkadirbektas.com/";
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        loadDataFromAPI();
    }

    private void loadDataFromAPI() {
        ExpensesAPI expensesAPI = retrofit.create(ExpensesAPI.class);
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(expensesAPI.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse));
    }

    private void handleResponse(List<ExpensesModel> expensesModelList) {
        expensesModelArrayList = new ArrayList<>(expensesModelList);
        for (int i = 1; i < expensesModelArrayList.size(); i++) {
            double price = Double.valueOf(expensesModelArrayList.get(i).price);
            if (categoriesInfo.get(expensesModelArrayList.get(i).category) != null) {
                categoriesInfo.put(expensesModelArrayList.get(i).category, categoriesInfo.get(expensesModelArrayList.get(i).category) + price);
            } else {
                categoriesInfo.put(expensesModelArrayList.get(i).category, Double.valueOf(expensesModelArrayList.get(i).price));
                categoriesName.add(expensesModelArrayList.get(i).category);
            }

            if (monthsInfo.get(expensesModelArrayList.get(i).getMonth()) != null) {
                monthsInfo.put(expensesModelArrayList.get(i).getMonth(), monthsInfo.get(expensesModelArrayList.get(i).getMonth()) + price);
            } else {
                monthsInfo.put(expensesModelArrayList.get(i).getMonth(), Double.valueOf(expensesModelArrayList.get(i).price));
                monthsName.add(expensesModelArrayList.get(i).getMonth());
            }

            if (daysInfo.get(expensesModelArrayList.get(i).getDay()) != null) {
                daysInfo.put(expensesModelArrayList.get(i).getDay(), daysInfo.get(expensesModelArrayList.get(i).getDay()) + price);
            } else {
                daysInfo.put(expensesModelArrayList.get(i).getDay(), Double.valueOf(expensesModelArrayList.get(i).price));
                daysName.add(expensesModelArrayList.get(i).getDay());
            }
        }
        ViewPager viewPager = findViewById(R.id.ViewPager);
        TabLayout tabLayout = findViewById(R.id.Tablayout);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}