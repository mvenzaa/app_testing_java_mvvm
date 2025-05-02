package com.venza.apptesting;

import android.os.Bundle;

import com.venza.apptesting.view.UserAdapter;
import com.venza.apptesting.viewmodel.UserViewModel;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserViewModel userViewModel;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        SearchView searchView = findViewById(R.id.searchViewUsers);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.filter(newText);
                return true;
            }
        });

        userAdapter = new UserAdapter(userModel -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Detail User")
                    .setMessage("ID: "+ userModel.getId() + "\nTitle: " + userModel.getTitle())
                    .setPositiveButton("OK", null)
                    .show();
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUsers().observe(this, userModels -> {
            userAdapter.setData(userModels);
        });

    }
}