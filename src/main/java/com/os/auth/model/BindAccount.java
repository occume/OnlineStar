package com.os.auth.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BindAccount {
	
	public Account getAccount(){
		Account acc = new Account();
		acc.setAvatarImageName(avatarImageName);
		acc.setCityId(cityId);
		acc.setProvinceId(provinceId);
		acc.setName(name);
		acc.setGenderId(genderId);
		return acc;
	}
	
	public Auth getAuth(){
		Auth auth = new Auth();
		auth.setPhone(phone);
		auth.setPassword(password);
		auth.setType(type);
		if(type == 2){
			auth.setOpenKeyWx(openKey);
		}
		if(type == 3){
			auth.setOpenKeyWeibo(openKey);
		}
		if(type == 4){
			auth.setOpenKeyQq(openKey);
		}
		return auth;
	}
	
	@NotNull
	@Size(min=1, max=20)
	private String name;
	
	@Column(name = "province_id")
	@JsonProperty("province_id")
	private int provinceId;
	
	@JsonProperty("province_name")
	private String provinceName;
	
	@JsonProperty("city_id")
	private int cityId;
	
	@JsonProperty("city_name")
	private String cityName;
	
	@JsonProperty("gender_id")
	private int genderId;
	
	@JsonProperty("avatar_image_name")
	private String avatarImageName;
	
	@JsonProperty("group_id")
	private int groupId;
	
	private int type;
	
	@NotNull
	@Pattern(regexp = "^1\\d{10}", message = "Invalid phone number")
	private String phone;
	
	@NotNull
	@Size(min=6, max=20)
	private String password;
	
	@JsonProperty("open_key")
	private String openKey;
	
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
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOpenKey() {
		return openKey;
	}

	public void setOpenKey(String openKey) {
		this.openKey = openKey;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
