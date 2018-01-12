package com.os.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OnlineStar {
	
    private Long id;

    private Long authId;

    @JsonProperty("online_live_price")
    private Float onlineLivePrice = 0.0f;

    @JsonProperty("offline_live_price")
    private Float offlineLivePrice = 0.0f;

    @JsonProperty("brand_spoke_price")
    private Float brandSpokePrice = 0.0f;

    private String platform;

    @JsonProperty("platform_name")
    private String platformName;

    @JsonProperty("fans_count")
    private Integer fansCount = 0;

    @JsonProperty("gift_to_money")
    private Float giftToMoney = 0.0f;
    
    @JsonProperty("play_amount")
    private Long playAmount = 0L;

    private Float height;

    private Float weight;

    private Float breast;

    private Float waistline;

    private Float hipline;

    private String expierence;
    
    @JsonProperty("broker_id")
    private Long brokerId;
    
    @JsonProperty("account_id")
    private Long accountId;
    
    @JsonProperty("label_list")
    private List<OnlineStarLabel> labelList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

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

	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public List<OnlineStarLabel> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<OnlineStarLabel> labelList) {
		this.labelList = labelList;
	}

	public Long getPlayAmount() {
		return playAmount;
	}

	public void setPlayAmount(Long playAmount) {
		this.playAmount = playAmount;
	}

	@Override
	public String toString() {
		return "OnlineStar [id=" + id + ", authId=" + authId
				+ ", onlineLivePrice=" + onlineLivePrice + ", platform="
				+ platform + ", platformName=" + platformName + ", fansCount="
				+ fansCount + ", labelList=" + labelList + "]";
	}
	
}