package com.os.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRecommendOnlineStar {

	@JsonProperty("auth_id")
	private long authId;
	
	private String name;
	
	@JsonProperty("avatar_image_name")
	private String avatarImageName;
	
	@JsonProperty("gender_id")
	private int genderId;
	
	@JsonProperty("happen_time")
	private Date happenTime = new Date();
	
	public long getAuthId() {
		return authId;
	}
	public void setAuthId(long authId) {
		this.authId = authId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatarImageName() {
		return avatarImageName;
	}
	public void setAvatarImageName(String avatarImageName) {
		this.avatarImageName = avatarImageName;
	}
	public int getGenderId() {
		return genderId;
	}
	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}
	public Date getHappenTime() {
		return happenTime;
	}
	public void setHappenTime(Date happenTime) {
		this.happenTime = happenTime;
	}
	
}
