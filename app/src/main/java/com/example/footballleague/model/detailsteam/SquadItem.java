package com.example.footballleague.model.detailsteam;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class SquadItem{
@Nullable
	@SerializedName("role")
	private String role;
	@Nullable

	@SerializedName("nationality")
	private String nationality;
	@Nullable

	@SerializedName("countryOfBirth")
	private String countryOfBirth;
	@Nullable

	@SerializedName("shirtNumber")
	private int shirtNumber;
	@Nullable

	@SerializedName("name")
	private String name;
	@Nullable

	@SerializedName("dateOfBirth")
	private String dateOfBirth;
	@Nullable

	@SerializedName("id")
	private int id;
	@Nullable

	@SerializedName("position")
	private String position;

	@Nullable
	public String getRole() {
		return role;
	}

	public void setRole(@Nullable String role) {
		this.role = role;
	}

	@Nullable
	public String getNationality() {
		return nationality;
	}

	public void setNationality(@Nullable String nationality) {
		this.nationality = nationality;
	}

	@Nullable
	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(@Nullable String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public int getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(int shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	@Nullable
	public String getName() {
		return name;
	}

	public void setName(@Nullable String name) {
		this.name = name;
	}

	@Nullable
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(@Nullable String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Nullable
	public String getPosition() {
		return position;
	}

	public void setPosition(@Nullable String position) {
		this.position = position;
	}

	@Override
 	public String toString(){
		return 
			name;
		}
}