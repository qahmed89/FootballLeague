package com.example.footballleague.remote;


import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.teams.Teams;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface FootballLeagueServices {

    @GET("competitions/{id}/teams")
    Observable<Teams> getTeams(@Header("X-Auth-Token") String token,
                               @Path(value = "id", encoded = true) int id);

    @GET("teams/{id}")
    Observable<DetailsTeams> getDetailsTeams(@Header("X-Auth-Token") String token,
                                             @Path(value = "id", encoded = true) int id);
}
