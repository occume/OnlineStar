package com.os.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AboutUs {
	
	public static final AboutUs about = new AboutUs("Hongrz", "666666", "We are Hongrz", "copy@2017", "Hongrz");
	
	private AboutUs(String wechat, String qq, String intro, String copyright,
			String companyName) {
		this.wechat = wechat;
		this.qq = qq;
		this.intro = intro;
		this.copyright = copyright;
		this.companyName = companyName;
	}

	public String wechat;
	public String qq;
	public String intro;
	public String copyright;
	
	@JsonProperty("conpany_name")
	public String companyName;
}
