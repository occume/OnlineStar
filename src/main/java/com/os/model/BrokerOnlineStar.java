package com.os.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.os.auth.model.Account;

public class BrokerOnlineStar {
	
	public Account account(){
		Account acc = new Account();
		acc.setAvatarImageName(avatarImageName);
		acc.setCityId(cityId);
		acc.setProvinceId(provinceId);
		acc.setGenderId(genderId);
		acc.setName(name);
		return acc;
	}
	
	public OnlineStar onlineStar(){
		OnlineStar os = new OnlineStar();
		os.setHeight(height);
		os.setWeight(weight);
		os.setBreast(breast);
		os.setBrandSpokePrice(brandSpokePrice);
		os.setExpierence(expierence);
		os.setFansCount(fansCount);
		os.setGiftToMoney(giftToMoney);
		os.setHipline(hipline);
		os.setOfflineLivePrice(offlineLivePrice);
		os.setOnlineLivePrice(onlineLivePrice);
		os.setPlatform(platform);
		os.setPlatformName(platformName);
		os.setWaistline(waistline);
		return os;
	}
	
	@NotNull
	@Size(min=1, max=20)
	private String name;
	
	@Column(name = "province_id")
	@JsonProperty("province_id")
	private int provinceId;
	
	@JsonProperty("city_id")
	private int cityId;
	
	@JsonProperty("gender_id")
	private int genderId;
	
	@JsonProperty("avatar_image_name")
	private String avatarImageName;
	
	@JsonProperty("group_id")
	private String groupId;

    private Float onlineLivePrice;

    private Float offlineLivePrice;

    private Float brandSpokePrice;

    private String platform;

    private String platformName;

    private Integer fansCount;

    private Float giftToMoney;

    private Float height;

    private Float weight;

    private Float breast;

    private Float waistline;

    private Float hipline;

    private String expierence;
    
    private Long accountId;

    public Float getOnlineLivePrice() {
        return onlineLivePrice;
    }

    public void setOnlineLivePrice(Float onlineLivePrice) {
        this.onlineLivePrice = onlineLivePrice;
    }

    public Float getOfflineLivePrice() {
        return offlineLivePrice;
    }

    public void setOfflineLivePrice(Float offlineLivePrice) {
        this.offlineLivePrice = offlineLivePrice;
    }

    public Float getBrandSpokePrice() {
        return brandSpokePrice;
    }

    public void setBrandSpokePrice(Float brandSpokePrice) {
        this.brandSpokePrice = brandSpokePrice;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Float getGiftToMoney() {
        return giftToMoney;
    }

    public void setGiftToMoney(Float giftToMoney) {
        this.giftToMoney = giftToMoney;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getBreast() {
        return breast;
    }

    public void setBreast(Float breast) {
        this.breast = breast;
    }

    public Float getWaistline() {
        return waistline;
    }

    public void setWaistline(Float waistline) {
        this.waistline = waistline;
    }

    public Float getHipline() {
        return hipline;
    }

    public void setHipline(Float hipline) {
        this.hipline = hipline;
    }

    public String getExpierence() {
        return expierence;
    }

    public void setExpierence(String expierence) {
        this.expierence = expierence == null ? null : expierence.trim();
    }

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
}