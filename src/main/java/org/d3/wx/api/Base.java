package org.d3.wx.api;

import org.d3.http.Http;
import org.json.JSONException;
import org.json.JSONObject;

import com.os.util.EncryptUtil;
import com.os.util.TimeUtil;

public class Base {
	
	private static volatile String ACCESS_TOKEN;
	private static volatile String JSAPI_TOKEN;
	
	private static String TOKEN = "mycity";
	private static long lastChangeAccessTokenTime;
	private static long lastChangeJsapiTokenTime;
	
	public static String getToken(){
		return TOKEN;
	}

	public static void changeAccessToken(){
		String api = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx1b7a5432dfba7d65&secret=4299b0c1b43a19fe7152f5e30c7d2e99";
		String content = Http.get(api);
		try {
			JSONObject jobj = new JSONObject(content);
			ACCESS_TOKEN = jobj.getString("access_token");
			lastChangeAccessTokenTime = TimeUtil.now();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public static String getAccessToken(){
		if(ACCESS_TOKEN == null || isOutOfDate(lastChangeAccessTokenTime)){
			changeAccessToken();
		}
		return ACCESS_TOKEN;
	}
	
	public static void changeJsapiToken(){
		String api = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ getAccessToken() +"&type=jsapi";
		String content = Http.get(api);
		try {
			JSONObject jobj = new JSONObject(content);
			JSAPI_TOKEN = jobj.getString("ticket");
			lastChangeJsapiTokenTime = TimeUtil.now();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public static String getJsapiToken(){
		if(JSAPI_TOKEN == null || isOutOfDate(lastChangeJsapiTokenTime)){
			changeJsapiToken();
		}
		return JSAPI_TOKEN;
	}
	
	public static String getSignature(String noncestr, String timestamp, String url){
		StringBuffer sb = new StringBuffer();
		sb.append("jsapi_ticket=")
		  .append(getJsapiToken())
		  .append("&noncestr=")
		  .append(noncestr)
		  .append("&timestamp=")
		  .append(timestamp)
		  .append("&url=")
		  .append(url);
		String signature = EncryptUtil.sha(sb.toString());
		return signature;
	}
	
	private static boolean isOutOfDate(long time){
		return (TimeUtil.now() - time) / 1000 >= 7200;
	}
	/*
	 *	{
		   "access_token":"ACCESS_TOKEN",
		   "expires_in":7200,
		   "refresh_token":"REFRESH_TOKEN",
		   "openid":"OPENID",
		   "scope":"SCOPE",
		   "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
		}
	 */
	/**
	 * 网页获取用户信息 Auth2 认证
	 * @param code
	 * @return
	 */
	public static String auth2(String code){
		String api = "https://api.weixin.qq.com/sns/oauth2/access_token?"
				+ "appid=wx1b7a5432dfba7d65&secret=4299b0c1b43a19fe7152f5e30c7d2e99&code="+ code +"&grant_type=authorization_code";
		String content = Http.get(api);
		String openId = null;
		try {
			JSONObject jobj = new JSONObject(content);
			openId = jobj.getString("openid");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return openId;
	}
	
	/**
	 * 网页获取用户信息 Auth2 认证
	 * @param code
	 * @return
	 */
	public static String qrcodeTicket(){
		String api = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + getAccessToken();
		JSONObject jobj = new JSONObject();
		//{"action_name": "QR_LIMIT_SCENE", 
//		"action_info": {
//			"scene": {
//			"scene_id": 123
//			}
//		}
//		}
		try {
			jobj.put("action_name", "QR_LIMIT_SCENE");
			JSONObject actionInfo = new JSONObject();
			JSONObject scene = new JSONObject();
			scene.put("scene_id", "1000");
			actionInfo.put("scene", scene);
			jobj.put("action_info", actionInfo);
		} catch (JSONException e) {
//			LOG.error("{}", e.getMessage());
		}
		String content = Http.post(api, jobj.toString());
		String ticket = null;
		try {
			jobj = new JSONObject(content);
			ticket = jobj.getString("ticket");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return ticket;
	}
	
	public static String ipList(){
		return "";
	}
}
