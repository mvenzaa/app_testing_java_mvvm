package com.venza.apptesting.viewmodel;

import com.venza.apptesting.model.UserModel;
import com.venza.apptesting.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {

    private final MutableLiveData<List<UserModel>> user = new MutableLiveData<>(new ArrayList<>());

    public MutableLiveData<List<UserModel>> getUser() {

        RetrofitInstance retrofitInstance = new RetrofitInstance();

        retrofitInstance.getApiInterface().getData().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    setUser(response.body());
                }
        }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }

        return user;
    }

    public void setUser(List<UserModel> user) {
        this.user.setValue(user);
    }

}
