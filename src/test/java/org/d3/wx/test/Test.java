package org.d3.wx.test;

import java.util.UUID;

import org.d3.wx.api.Base;

import com.os.util.TimeUtil;

public class Test {

	public static void main(String[] args) {
		String jsapiToken = Base.getJsapiToken();
		System.out.println(jsapiToken);
		System.out.println(UUID.randomUUID().toString());
		
		generateSignature();
		
//		System.out.println(Integer.valueOf(null));
		
		System.out.println(System.getProperty("user.dir"));
	}

	public static void generateSignature(){
		String noncestr = UUID.randomUUID().toString();
		String timestamp = String.valueOf(TimeUtil.now());
		String url = "http://112.124.115.136/mycity/food";
		String signature = Base.getSignature(noncestr, timestamp, url);
		
		System.out.println(noncestr);
		System.out.println(timestamp);
		System.out.println(signature);
	}
}
