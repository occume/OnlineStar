package com.os.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Broker {
    private Long id;

    @JsonProperty("auth_id")
    private Long authId;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("company_qualification")
    private String companyQualification;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyQualification() {
        return companyQualification;
    }

    public void setCompanyQualification(String companyQualification) {
        this.companyQualification = companyQualification == null ? null : companyQualification.trim();
    }
}