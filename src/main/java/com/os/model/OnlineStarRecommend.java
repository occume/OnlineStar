package com.os.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OnlineStarRecommend {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "os_id")
	@JsonProperty("os_id")
	private long osId;
	
	private String name;
	
	@Column(name = "avatar_image_name")
	@JsonProperty("avatar_image_name")
	private String avatarImageName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOsId() {
		return osId;
	}

	public void setOsId(long osId) {
		this.osId = osId;
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

	@Override
	public String toString() {
		return "OnlineStarRecommend [id=" + id + ", osId=" + osId + ", name="
				+ name + ", imageName=" + avatarImageName + "]";
	}
	
}
