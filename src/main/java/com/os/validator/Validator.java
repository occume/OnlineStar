package com.os.validator;

import javax.servlet.http.HttpServletRequest;

import com.os.model.Mission;
import com.os.model.OnlineStar;

public class Validator {

	public static OnlineStar validateOnlineStar(HttpServletRequest request){
		String name = getParam(request, "name");
		String qq = getParam(request, "qq");
		String mobile = getParam(request, "mobile");
		String platform = getParam(request, "platform");
		
		return new OnlineStar(name, mobile, qq, platform);
	}
	
	public static Mission validateMission(HttpServletRequest request){
		String name = getParam(request, "name");
		String qq = getParam(request, "qq");
		String mobile = getParam(request, "mobile");
		String platform = getParam(request, "platform");
		
		return new Mission(name, mobile, qq, platform);
	}
	
	private static String getParam(HttpServletRequest request, String name){
		return request.getParameter(name);
	}
}
