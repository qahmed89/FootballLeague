package com.example.footballleague.model.sss;

import com.example.footballleague.model.detailsteam.SquadItem;
import com.example.footballleague.model.teams.Area;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teamsdetail {

    @SerializedName("area")
    private Area area;

    @SerializedName("venue")
    private String venue;

    @SerializedName("website")
    private String website;


    @SerializedName("clubColors")
    private String clubColors;



    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("squad")
    private List<NamePlayer> squad;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getClubColors() {
        return clubColors;
    }

    public void setClubColors(String clubColors) {
        this.clubColors = clubColors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<NamePlayer> getSquad() {
        return squad;
    }

    public void setSquad(List<NamePlayer> squad) {
        this.squad = squad;
    }
}
