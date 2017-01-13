package org.d3.wx.vo;
/**
 * 微信文章类
 * @author d_jin
 *
 */
public class ArticleItem {

	private String owner;
	private String title;
	private String description;
	private String picurl;
	private String url;
	
	public ArticleItem(){}
	
	public ArticleItem(String title, String description, String picurl,
			String url, String owner) {
		this.title = title;
		this.description = description;
		this.picurl = picurl;
		this.url = url;
		this.owner = owner;
	}
	
	public ArticleItem(String description, String picurl,String url) {
		this.description = description;
		this.picurl = picurl;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
