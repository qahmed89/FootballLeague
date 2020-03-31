package com.example.footballleague.model.sss;

import com.example.footballleague.model.detailsteam.SquadItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NamePlayer
{

    @SerializedName("squad")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
