package com.nejdetkadirr.expensesproject.service;

import com.google.gson.annotations.SerializedName;

public class ExpensesModel {

    @SerializedName("id")
    public String id;

    @SerializedName("date")
    public String date;

    @SerializedName("category")
    public String category;

    @SerializedName("price")
    public String price;

}
