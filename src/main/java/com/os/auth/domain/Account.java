package com.os.auth.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
	
	@Id
	@GeneratedValue
	private long id;
	
	private long authId;
	
	@NotNull
	//@Size(min=1, max=20)
	private String name;
	
	@Column(name = "province_id")
	@JsonProperty("province_id")
	private int provinceId;
	
	@JsonProperty("city_id")
	private int cityId;
	private byte gender;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public byte getGender() {
		return gender;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	
	public long getAuthId() {
		return authId;
	}
	public void setAuthId(long authId) {
		this.authId = authId;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", provinceId="
				+ provinceId + ", cityId=" + cityId + ", gender=" + gender
				+ "]";
	}
	
}
