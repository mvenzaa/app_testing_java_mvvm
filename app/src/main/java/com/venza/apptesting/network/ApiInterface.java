package com.venza.apptesting.network;

import com.venza.apptesting.model.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/posts")
    Call<UserModel> getData();
}
