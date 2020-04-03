package com.example.footballleague.repository;


import androidx.annotation.Nullable;

import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.teams.Teams;
import com.example.footballleague.remote.FootballLeagueServices;

import javax.inject.Inject;

import io.reactivex.Observable;

public class FootballLeagueRepository {
    private FootballLeagueServices footballLeagueServices;

    @Inject
    public FootballLeagueRepository(FootballLeagueServices footballLeagueServices) {
        this.footballLeagueServices = footballLeagueServices;
    }

    @Nullable

    public Observable<Teams> Teams(String token, int id) {
        return footballLeagueServices.getTeams(token, id);
    }

    @Nullable
    public Observable<DetailsTeams> DetailsTeams(String token, int id) {
        return footballLeagueServices.getDetailsTeams(token, id);
    }


}
