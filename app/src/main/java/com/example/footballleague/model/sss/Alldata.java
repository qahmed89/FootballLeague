package com.example.footballleague.model.sss;

import com.example.footballleague.model.teams.Area;
import com.example.footballleague.model.teams.TeamsItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Alldata {

    @SerializedName("teams")
    private List<Teamsdetail> teams;

    public List<Teamsdetail> getTeams() {
        return teams;
    }

    public void setTeams(List<Teamsdetail> teams) {
        this.teams = teams;
    }
}
