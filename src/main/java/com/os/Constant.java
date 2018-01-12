package com.os;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.os.mapper.IdNamePair;

public class Constant {
	
	public static final int API_VERSION = 1;
	
	public static final int PAGE_SIZE = 20;

	public static class SessionKey{
		public static final String ACCOUNT 		= "acc";
		public static final String VCODE 		= "v-code";
	}
	
	public static class HeaderName{
		public static final String TOKEN 		= "token";
	}
	
	public static class ApplyStatus{
		public static final int APPLIED = 1;
		public static final int RUNNING = 2;
		public static final int APPLY_COMPLETE = 3;
		public static final int ABOLISH = 4;
		public static final int COMPLETE = 5;
		public static final int NO_PASS = 6;
	}
	
	public static class ApplyType{
		public static final int APPLY = 1;
		public static final int INVITE = 2;
	}
	
	public static class GroupType{
		public static final int ONLINE_STAR = 1;
		public static final int MERCHANT = 2;
		public static final int BROKER_COMPANY = 3;
		public static final int ADV_COMPANY = 4;
	}
	
	public static class ImageType{
		public static final int AVATAR = 1;
		public static final int ONLINE_LIVE = 2;
		public static final int OFFLINE_LIVE = 3;
		public static final int ADV_COMPANY = 4;
	}
	
	public static List<IdNamePair> JOB_SEARCH_DATE_CONDITION_LIST = Lists.newArrayList();
	public static List<IdNamePair> JOB_SEARCH_COMMISSION_CONDITION_LIST = Lists.newArrayList();
	public static List<IdNamePair> JOB_SEARCH_GENDER_CONDITION_LIST = Lists.newArrayList();
	
	static{
		
		JOB_SEARCH_DATE_CONDITION_LIST.add(new IdNamePair(1, "一周内"));
		JOB_SEARCH_DATE_CONDITION_LIST.add(new IdNamePair(2, "一月内"));
		JOB_SEARCH_DATE_CONDITION_LIST.add(new IdNamePair(3, "半年内"));
		JOB_SEARCH_DATE_CONDITION_LIST.add(new IdNamePair(4, "不限"));
		
		JOB_SEARCH_COMMISSION_CONDITION_LIST.add(new IdNamePair(1, "0~5千"));
		JOB_SEARCH_COMMISSION_CONDITION_LIST.add(new IdNamePair(2, "5千~5万"));
		JOB_SEARCH_COMMISSION_CONDITION_LIST.add(new IdNamePair(3, "5万以上"));
		JOB_SEARCH_COMMISSION_CONDITION_LIST.add(new IdNamePair(4, "不限"));
		
		JOB_SEARCH_GENDER_CONDITION_LIST.add(new IdNamePair(1, "男"));
		JOB_SEARCH_GENDER_CONDITION_LIST.add(new IdNamePair(2, "女"));
		JOB_SEARCH_GENDER_CONDITION_LIST.add(new IdNamePair(3, "不限"));
	}
	
	public static class Hint{
		public static String PASSWORD_NOT_CORRECT = "密码不正确";
		public static String NOT_EXIST_PHONE = "这个手机号码不存在";
		public static String INVALID_OPEN_KEY_TYPE = "";
		public static String BINDED_OPEN_KEY = "已经被绑定";
		public static String EMPTY_OPEN_KEY = "OpenId不能为空";
		public static String NOT_BINDED_WEIBO = "未绑定微博号";
		public static String NOT_BINDED_WEIXIN = "未绑定微信号";
		public static String NOT_BINDED_QQ = "未绑定QQ";
	}
}
