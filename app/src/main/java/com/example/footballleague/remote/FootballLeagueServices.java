package com.example.footballleague.remote;


import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.teams.Teams;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface FootballLeagueServices {

@GET("competitions/{id}/teams")
Flowable<Teams> getTeams(@Header("X-Auth-Token") String token,
                           @Path(value = "id", encoded = true) int id);

    @GET("teams/{id}")
    Flowable<DetailsTeams> getDetailsTeams(@Header("X-Auth-Token") String token,
                                           @Path(value = "id", encoded = true) int id);
}
