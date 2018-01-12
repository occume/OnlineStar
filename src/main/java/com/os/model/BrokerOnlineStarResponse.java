package com.os.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrokerOnlineStarResponse {
	
	@JsonProperty("os_id")
	private long osId;
	
	private String name;
	
	@JsonProperty("province_name")
	private String provinceName;
	
	@JsonProperty("city_name")
	private String cityName;
	
	@JsonProperty("gender_id")
	private int genderId;
	
	@JsonProperty("avatar_image_name")
	private String avatarImageName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getAvatarImageName() {
		return avatarImageName;
	}

	public void setAvatarImageName(String avatarImageName) {
		this.avatarImageName = avatarImageName;
	}

	public long getOsId() {
		return osId;
	}

	public void setOsId(long osId) {
		this.osId = osId;
	}
	
}