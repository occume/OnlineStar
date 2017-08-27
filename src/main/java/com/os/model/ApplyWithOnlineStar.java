package com.os.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplyWithOnlineStar {

	private long id;
	private String name;
	
	@JsonProperty("gender_id")
	private int genderId;
	
	@JsonProperty("avatar_image_id")
	private int avatarImageId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public int getAvatarImageId() {
		return avatarImageId;
	}

	public void setAvatarImageId(int avatarImageId) {
		this.avatarImageId = avatarImageId;
	}

}
