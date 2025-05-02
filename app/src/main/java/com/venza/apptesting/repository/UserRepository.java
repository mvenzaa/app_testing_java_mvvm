package com.venza.apptesting.repository;

import com.venza.apptesting.model.UserModel;
import com.venza.apptesting.network.ApiInterface;
import com.venza.apptesting.network.RetrofitInstance;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private ApiInterface apiInterface;

    public UserRepository() {
        apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
    }

    public LiveData<List<UserModel>> getUser() {
        MutableLiveData<List<UserModel>> data = new MutableLiveData<>();

        apiInterface.getData().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });

        return data;
    }
}
