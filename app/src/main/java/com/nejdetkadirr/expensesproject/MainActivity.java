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
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    CompositeDisposable compositeDisposable;
    ArrayList<ExpensesModel> expensesModelArrayList;
    private String baseURL = "https://api.nejdetkadirbektas.com/";
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.ViewPager);
        TabLayout tabLayout = findViewById(R.id.Tablayout);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

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
        for (ExpensesModel e: expensesModelArrayList) {
            System.out.println(e.category);
        }
    }

}