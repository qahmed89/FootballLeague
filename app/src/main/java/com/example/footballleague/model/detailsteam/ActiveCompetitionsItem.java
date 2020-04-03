package com.example.footballleague.model.detailsteam;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;


public class ActiveCompetitionsItem{
	@Nullable

	@SerializedName("area")
	private Area area;
	@Nullable

	@SerializedName("lastUpdated")
	private String lastUpdated;
	@Nullable

	@SerializedName("code")
	private String code;
	@Nullable

	@SerializedName("name")
	private String name;
	@Nullable

	@SerializedName("id")
	private int id;
	@Nullable

	@SerializedName("plan")
	private String plan;

	@Nullable
	public Area getArea() {
		return area;
	}

	public void setArea(@Nullable Area area) {
		this.area = area;
	}

	@Nullable
	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(@Nullable String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Nullable
	public String getCode() {
		return code;
	}

	public void setCode(@Nullable String code) {
		this.code = code;
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
	public String getPlan() {
		return plan;
	}

	public void setPlan(@Nullable String plan) {
		this.plan = plan;
	}

	@Override
 	public String toString(){
		return 
			"ActiveCompetitionsItem{" + 
			"area = '" + area + '\'' + 
			",lastUpdated = '" + lastUpdated + '\'' + 
			",code = '" + code + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",plan = '" + plan + '\'' + 
			"}";
		}
}