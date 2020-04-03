package com.example.footballleague.model.teams;

import androidx.annotation.Nullable;

import java.util.List;

import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.google.gson.annotations.SerializedName;

public class Teams{
	@Nullable

	@SerializedName("teams")
	private List<TeamsItem> teams;
	@Nullable

	@SerializedName("count")
	private int count;
	@Nullable

	@SerializedName("season")
	private Season season;
	@Nullable

	@SerializedName("competition")
	private Competition competition;
@Nullable
	@SerializedName("filters")
	private Filters filters;
	@Nullable

 private List<DetailsTeams> detailsTeams;

	@Nullable
	public List<DetailsTeams> getDetailsTeams() {
		return detailsTeams;
	}

	public void setDetailsTeams(@Nullable List<DetailsTeams> detailsTeams) {
		this.detailsTeams = detailsTeams;
	}

	@Nullable
	public List<TeamsItem> getTeams() {
		return teams;
	}

	public void setTeams(@Nullable List<TeamsItem> teams) {
		this.teams = teams;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Nullable
	public Season getSeason() {
		return season;
	}

	public void setSeason(@Nullable Season season) {
		this.season = season;
	}

	@Nullable
	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(@Nullable Competition competition) {
		this.competition = competition;
	}

	@Nullable
	public Filters getFilters() {
		return filters;
	}

	public void setFilters(@Nullable Filters filters) {
		this.filters = filters;
	}

	@Override
 	public String toString(){
		return 
			"Teams{" + 
			"teams = '" + teams + '\'' + 
			",count = '" + count + '\'' + 
			",season = '" + season + '\'' + 
			",competition = '" + competition + '\'' + 
			",filters = '" + filters + '\'' + 
			"}";
		}
}