package com.os.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.os.model.Apply;

public class MerchantResponse {

	private String name;
	
    private String phone;
    
	@JsonProperty("city_name")
    private String cityName;
	
	@JsonProperty("province_name")
    private String provinceName;
	
	@JsonProperty("avatar_image_name")
    private String avatarImageName;
	
	@JsonProperty("post_count")
	private int postCount;
	
	@JsonProperty("complete_count")
	private int completeCount;
	
	@JsonProperty("apply")
	private Apply apply;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getAvatarImageName() {
		return avatarImageName;
	}

	public void setAvatarImageName(String avatarImageName) {
		this.avatarImageName = avatarImageName;
	}

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

}
