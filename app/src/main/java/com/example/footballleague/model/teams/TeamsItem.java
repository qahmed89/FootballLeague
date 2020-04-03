package com.example.footballleague.model.teams;

import androidx.annotation.Nullable;

import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.google.gson.annotations.SerializedName;

public class TeamsItem{
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

	@SerializedName("phone")
	private String phone;
	@Nullable

	@SerializedName("name")
	private String name;
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

 private DetailsTeams detailsTeams;

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

	public void setFounded(@Nullable int founded) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(	@Nullable
									 String phone) {
		this.phone = phone;
	}

	@Nullable
	public String getName() {
		return name;
	}

	public void setName(@Nullable String name) {
		this.name = name;
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

	@Nullable
	public DetailsTeams getDetailsTeams() {
		return detailsTeams;
	}

	public void setDetailsTeams(@Nullable DetailsTeams detailsTeams) {
		this.detailsTeams = detailsTeams;
	}

	@Override
 	public String toString(){
		return 
			"TeamsItem{" + 
			"area = '" + area + '\'' + 
			",venue = '" + venue + '\'' + 
			",website = '" + website + '\'' + 
			",address = '" + address + '\'' + 
			",crestUrl = '" + crestUrl + '\'' + 
			",tla = '" + tla + '\'' + 
			",founded = '" + founded + '\'' + 
			",lastUpdated = '" + lastUpdated + '\'' + 
			",clubColors = '" + clubColors + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",shortName = '" + shortName + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}