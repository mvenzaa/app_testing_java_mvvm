package com.venza.apptesting.network;

import com.venza.apptesting.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/posts")
    Call<List<UserModel>> getData();
}
