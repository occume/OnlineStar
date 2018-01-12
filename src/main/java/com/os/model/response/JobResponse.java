package com.os.model.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.os.model.JobImage;

public class JobResponse {
	
	private Long id;

    @JsonProperty("auth_id")
    private Long authId;

    private String title;

    private String content;

    @JsonProperty("job_type_id")
    private Integer jobTypeId;
    
    @JsonProperty("job_type_name")
    private String jobTypeName;

    @JsonProperty("city_id")
    private Integer cityId;
    
    @JsonProperty("district_id")
    private Integer districtId;
    
    @JsonProperty("district_name")
    private Integer districtName;
    
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
    
	@JsonProperty("city_name")
    private String cityName;
	
	@JsonProperty("image_list")
	private List<JobImage> imageList;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		this.address = address;
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
		this.phone = phone;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getJobTypeName() {
		return jobTypeName;
	}

	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}

	public List<JobImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<JobImage> imageList) {
		this.imageList = imageList;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getDistrictName() {
		return districtName;
	}

	public void setDistrictName(Integer districtName) {
		this.districtName = districtName;
	}

}
