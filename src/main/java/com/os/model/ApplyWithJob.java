package com.os.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplyWithJob {

	private long id;
	
	@JsonProperty("status_id")
	private int statusId;
	
	private String title;
	private float price;
	
	@JsonProperty("start_time")
	private Date startTime;
	
	@JsonProperty("end_time")
	private Date endTime;
	
	@JsonProperty("type_name")
	private String typeName;
	
	@JsonProperty("city_name")
	private String cityName;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

}
