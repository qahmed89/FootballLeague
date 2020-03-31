package com.example.footballleague.repository;


import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.teams.Teams;
import com.example.footballleague.remote.FootballLeagueServices;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class FootballLeagueRepository {
    private FootballLeagueServices footballLeagueServices;

    @Inject
    public FootballLeagueRepository(FootballLeagueServices footballLeagueServices) {
        this.footballLeagueServices = footballLeagueServices;
    }

    public Flowable<Teams> Teams(String token, int id) {
        return footballLeagueServices.getTeams(token, id);
    }
    public Flowable<DetailsTeams> DetailsTeams(String token, int id) {
        return footballLeagueServices.getDetailsTeams(token, id);
    }






}
