package org.d3.wx.vo;

import java.util.Date;

/**
 * 视频类
 * @author d_jin
 *
 */
public class Vedio implements Comparable<Vedio>{
	
	private String owner;
	private String title;
	private String picurl;
	private String url;
	private String uploadDate;
	private String duration;
	private Date   upDate;
	private boolean today;
	
	public Vedio(String title, String picurl, String url,
			String uploadDate, String duration) {
		this.title = title;
		this.picurl = picurl;
		this.url = url;
		this.uploadDate = uploadDate;
		this.duration = duration;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	public boolean isToday() {
		return today;
	}

	public void setToday(boolean today) {
		this.today = today;
	}

	@Override
	public int compareTo(Vedio o) {
		return o.getUpDate().compareTo(this.getUpDate());
	}
	
}
