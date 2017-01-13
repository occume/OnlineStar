package org.sendmsg.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import org.d3.http.Http;
import org.d3.wx.api.Base;
import org.d3.wx.vo.Message;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Maps;
import com.google.common.primitives.Longs;
import com.os.util.EncryptUtil;

public class SendMsg {
	
	public static void main(String...strings) throws UnsupportedEncodingException{
		sendMsg();
//		Long v = Longs.stringConverter().convert(null);
		
//		System.out.println(URLDecoder.decode("你好", "GBk"));
//		System.out.println(v);
	}
	private final static String token = "UleYPhau9hM0kbjzln9qLLb2T1t62YO_2QUkcpOeGQh9Xl_K4GAc9jxModwAqoE_xpIOf8O43H5mSC0_PWuQaepcLIPju41ApiV_BHscn9g";
	public static void sendMsg(){
		String api = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + Base.getAccessToken();
		Map<String, String> params = Maps.newHashMap();
		
		params.put("kf_account", "test1@test");
		params.put("nickname", "客服1");
		params.put("password", "pswmd51231231231");
		
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("touser", "oGDxut6UIp27um1Z7eDOeImRzcYg");
			jobj.put("msgtype", "text");
			jobj.put("text",new JSONObject().put("content", "Hello JD"));
//			jobj.put("password", EncryptUtil.md5("pswmd51231231231"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println(jobj.toString());
		
		String result = Http.post(api, jobj.toString());
		System.out.println(result);
	}
	
	public static void getAllKf(){
		String api = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=" + token;
		String result = Http.get(api);
		System.out.println(result);
	}
	
	public static void getToken(){
		String api = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx1b7a5432dfba7d65&secret=4299b0c1b43a19fe7152f5e30c7d2e99";
		String result = Http.get(api);
		System.out.println(result);
	}
}
