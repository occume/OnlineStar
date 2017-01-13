package org.d3.wx;

public class Constant {

	public static class ParamKey{
    	public static final String ECHOSTR 		= "echostr";
    	public static final String SIGNATURE 	= "signature";
    	public static final String TIMESTAMP 	= "timestamp";
    	public static final String NONCE 		= "nonce";
	}
	
	public static class Sessionkey{
		public static final String OPEN_ID 		= "openId";
		public static final String NARRATERS 	= "narraters";
	}
	
	public static class MsgType{
		public static final String EVENT 	= "event";
		public static final String TEXT 	= "text";
	}
	
	public static class ErrorCode{
		public static final String SIGNATURE_ERROR = "401";
	}
}
