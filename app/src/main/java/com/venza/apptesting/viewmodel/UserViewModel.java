package com.venza.apptesting.viewmodel;

import com.venza.apptesting.model.UserModel;
import com.venza.apptesting.network.RetrofitInstance;
import com.venza.apptesting.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private LiveData<List<UserModel>> users;

    public UserViewModel() {
        userRepository = new UserRepository();
        users = userRepository.getUser();
    }

    public LiveData<List<UserModel>> getUsers() {
        return users;
    }
}
