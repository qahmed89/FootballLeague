package com.example.footballleague.model.detailsteam;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Area{
	@Nullable

	@SerializedName("name")
	private String name;
	@Nullable

	@SerializedName("id")
	private int id;

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

	@Override
 	public String toString(){
		return 
			"Area{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}