package com.example.footballleague.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.footballleague.BaseApplication;
import com.example.footballleague.R;
import com.example.footballleague.adapter.PlayerAdapter;
import com.example.footballleague.databinding.ActivityDetailsTeamBinding;
import com.example.footballleague.model.detailsteam.SquadItem;
import com.example.footballleague.viewmodel.FootballLeagueViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DetailsTeamActivity extends AppCompatActivity {
    ActivityDetailsTeamBinding activtyDeatilsTeamBinding;
    @Inject
    ViewModelProvider.Factory viewModelProvider;
    FootballLeagueViewModel footballLeagueViewModel;
    LinearLayoutManager mLayoutManager;
    int id = 0;
    String token = "12faf50c4edc47d2bdc76add010fc0c1";
    List<SquadItem> detailsTeamsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_team);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);

        footballLeagueViewModel = new ViewModelProvider(this, viewModelProvider).get(FootballLeagueViewModel.class);
        detailsTeamsList = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(this);

        activtyDeatilsTeamBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_team);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        footballLeagueViewModel.getDetailsTeamsResponce(token, id, activtyDeatilsTeamBinding.getRoot()).observe(this, detailsTeams -> {

            activtyDeatilsTeamBinding.setDetailsteams(detailsTeams);
            detailsTeamsList.addAll(detailsTeams.getSquad());
            PlayerAdapter playerAdapter = new PlayerAdapter(detailsTeamsList, getApplicationContext());
            activtyDeatilsTeamBinding.recyclerviewPlayer.setLayoutManager(mLayoutManager);
            activtyDeatilsTeamBinding.recyclerviewPlayer.setAdapter(playerAdapter);
            activtyDeatilsTeamBinding.progressBar.hide();


        });
    }
}
