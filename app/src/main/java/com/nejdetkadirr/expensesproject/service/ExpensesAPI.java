package com.nejdetkadirr.expensesproject.service;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ExpensesAPI {
    @GET("expenses/index.php")
    Observable<List<ExpensesModel>> getData();
}
