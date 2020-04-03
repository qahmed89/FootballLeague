package com.example.footballleague.model.detailsteam;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
 //With this annotation we are going to hide compiler warnings

public class DetailsTeams  {
@Nullable
	@SerializedName("area")
	private Area area;
	@Nullable

	@SerializedName("venue")
	private String venue;
	@Nullable

	@SerializedName("website")
	private String website;
	@Nullable

	@SerializedName("address")
	private String address;
	@Nullable

	@SerializedName("crestUrl")
	private String crestUrl;
	@Nullable

	@SerializedName("tla")
	private String tla;
	@Nullable

	@SerializedName("founded")
	private int founded;
	@Nullable

	@SerializedName("lastUpdated")
	private String lastUpdated;
	@Nullable

	@SerializedName("clubColors")
	private String clubColors;
	@Nullable

	@SerializedName("squad")
	private List<SquadItem> squad;
	@Nullable

	@SerializedName("phone")
	private String phone;
	@Nullable

	@SerializedName("name")
	private String name;
	@Nullable

	@SerializedName("activeCompetitions")
	private List<ActiveCompetitionsItem> activeCompetitions;
	@Nullable

	@SerializedName("id")
	private int id;
	@Nullable

	@SerializedName("shortName")
	private String shortName;
	@Nullable

	@SerializedName("email")
	private String email;

	@Nullable
	public Area getArea() {
		return area;
	}

	public void setArea(@Nullable Area area) {
		this.area = area;
	}

	@Nullable
	public String getVenue() {
		return venue;
	}

	public void setVenue(@Nullable String venue) {
		this.venue = venue;
	}

	@Nullable
	public String getWebsite() {
		return website;
	}

	public void setWebsite(@Nullable String website) {
		this.website = website;
	}

	@Nullable
	public String getAddress() {
		return address;
	}

	public void setAddress(@Nullable String address) {
		this.address = address;
	}

	@Nullable
	public String getCrestUrl() {
		return crestUrl;
	}

	public void setCrestUrl(@Nullable String crestUrl) {
		this.crestUrl = crestUrl;
	}

	@Nullable
	public String getTla() {
		return tla;
	}

	public void setTla(@Nullable String tla) {
		this.tla = tla;
	}

	public int getFounded() {
		return founded;
	}

	public void setFounded(int founded) {
		this.founded = founded;
	}

	@Nullable
	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(@Nullable String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Nullable
	public String getClubColors() {
		return clubColors;
	}

	public void setClubColors(@Nullable String clubColors) {
		this.clubColors = clubColors;
	}

	@Nullable
	public List<SquadItem> getSquad() {
		return squad;
	}

	public void setSquad(@Nullable List<SquadItem> squad) {
		this.squad = squad;
	}

	@Nullable
	public String getPhone() {
		return phone;
	}

	public void setPhone(@Nullable String phone) {
		this.phone = phone;
	}

	@Nullable
	public String getName() {
		return name;
	}

	public void setName(@Nullable String name) {
		this.name = name;
	}

	@Nullable
	public List<ActiveCompetitionsItem> getActiveCompetitions() {
		return activeCompetitions;
	}

	public void setActiveCompetitions(@Nullable List<ActiveCompetitionsItem> activeCompetitions) {
		this.activeCompetitions = activeCompetitions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Nullable
	public String getShortName() {
		return shortName;
	}

	public void setShortName(@Nullable String shortName) {
		this.shortName = shortName;
	}

	@Nullable
	public String getEmail() {
		return email;
	}

	public void setEmail(@Nullable String email) {
		this.email = email;
	}

	@Override
 	public String toString(){
		return 
			"DetailsTeams{" + 
			"area = '" + area + '\'' + 
			",venue = '" + venue + '\'' + 
			",website = '" + website + '\'' + 
			",address = '" + address + '\'' + 
			",crestUrl = '" + crestUrl + '\'' + 
			",tla = '" + tla + '\'' + 
			",founded = '" + founded + '\'' + 
			",lastUpdated = '" + lastUpdated + '\'' + 
			",clubColors = '" + clubColors + '\'' + 
			",squad = '" + squad + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",activeCompetitions = '" + activeCompetitions + '\'' + 
			",id = '" + id + '\'' + 
			",shortName = '" + shortName + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}