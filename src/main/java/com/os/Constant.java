package com.os;

public class Constant {
	
	public static final int API_VERSION = 1;
	
	public static final int PAGE_SIZE = 20;

	public static class SessionKey{
		public static final String ACCOUNT 		= "acc";
		public static final String VCODE 		= "v-code";
	}
	
	public static class ApplyStatus{
		public static final int APPLIED = 1;
		public static final int RUNNING = 2;
		public static final int APPLY_COMPLETE = 3;
		public static final int ABOLISH = 4;
		public static final int COMPLETE = 5;
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
}
