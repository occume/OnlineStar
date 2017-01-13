package com.os.db.domain;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class Mission {
	
	public static void validate(HttpServletRequest request){
		String name = getParam(request, "name");
		String qq = getParam(request, "qq");
		String mobile = getParam(request, "mobile");
		String platform = getParam(request, "platform");
	}

	private long 		id;
	private long		merchantId;
	private int			type;
	private String		subject;
	private int			budget;
	private int			modelCount;
	private String		location;
	private String		desc;
	private Date		startTime;
	private Date		endTime;
	private Date		createTime;
	
	public Mission(){}
	
	public Mission(){}

	public Mission(long merchantId, int budget, String location) {
		this.merchantId = merchantId;
		this.budget = budget;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getModelCount() {
		return modelCount;
	}

	public void setModelCount(int modelCount) {
		this.modelCount = modelCount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
	
}
