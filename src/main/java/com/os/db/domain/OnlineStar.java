package com.os.db.domain;

public class OnlineStar {

	private long 		id;
	private String 		name;
	private String 		mobile;
	private String		qq;
	private String 		platform;
	private int			fansCount;
	
	public OnlineStar(){}
	
	public OnlineStar(String name, String mobile, String qq, String platform) {
		this.name = name;
		this.mobile = mobile;
		this.qq = qq;
		this.platform = platform;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platForm) {
		this.platform = platForm;
	}
	public int getFansCount() {
		return fansCount;
	}
	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}
	
}
