package com.os.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Job {
    private Long id;

    @JsonProperty("merchant_id")
    private Long merchantId;

    private String title;

    private String content;

    @JsonProperty("job_type_id")
    private Integer jobTypeId;

    private Integer cityId;
    @JsonProperty("start_time")
    private Date startTime;
    
    @JsonProperty("end_time")
    private Date endTime;

    private String address;

    @JsonProperty("expect_count")
    private Integer expectCount;

    private Float price;

    @JsonProperty("gender_id")
    private Integer genderId;

    private String phone;

    @JsonProperty("status_id")
    private Integer statusId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(Integer jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getExpectCount() {
        return expectCount;
    }

    public void setExpectCount(Integer expectCount) {
        this.expectCount = expectCount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}