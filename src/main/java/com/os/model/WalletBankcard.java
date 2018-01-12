package com.os.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WalletBankcard {
    private Integer id;

    private Long authId;

    @JsonProperty("card_type_id")
    private Integer cardTypeId;

    @JsonProperty("card_owner")
    private String cardOwner;

    private Integer defaultId;

    @JsonProperty("card_number")
    private String cardNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public Integer getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner == null ? null : cardOwner.trim();
    }

    public Integer getDefaultId() {
        return defaultId;
    }

    public void setDefaultId(Integer defaultId) {
        this.defaultId = defaultId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }
}