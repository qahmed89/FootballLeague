package com.example.footballleague.view;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.footballleague.BaseApplication;
import com.example.footballleague.R;
import com.example.footballleague.viewmodel.FootballLeagueViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    ViewModelProvider.Factory viewModelProvider;
    FootballLeagueViewModel footballLeagueViewModel;
    String token = "12faf50c4edc47d2bdc76add010fc0c1";
    int id = 2021;
    NavController navController;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this, navController);
        footballLeagueViewModel = new ViewModelProvider(this, viewModelProvider).get(FootballLeagueViewModel.class);
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();

        return super.onSupportNavigateUp();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
