package org.d3.wx.api;

import java.util.Date;

import org.d3.http.Http;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.os.model.User;

public class UserManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserManager.class);

	public static User getUserInfo(String openId){
		String accessToken = Base.getAccessToken();
		String api = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+ accessToken +"&openid=" + openId +"&lang=zh_CN";
		String content = Http.get(api);
		User user = null;
		try {
			JSONObject jobj = new JSONObject(content);
			user = new User();
			user.setSubscribe(1);
			user.setOpenId(openId);
			user.setNickName(jobj.getString("nickname"));
			user.setSex(jobj.getInt("sex"));
			user.setLanguage(jobj.getString("language"));
			user.setCity(jobj.getString("city"));
			user.setProvince(jobj.getString("province"));
			user.setCountry(jobj.getString("country"));
			user.setHeadImgUrl(jobj.getString("headimgurl"));
			user.setSubscribeTime(new Date(jobj.getLong("subscribe_time") * 1000));
			user.setRemark(jobj.getString("remark"));
			user.setLastAccessTime(new Date());
		} catch (JSONException e) {
			LOG.error("parse user info error, openId: {}; message: {}", e.getMessage());
		}
		return user;
	}
	
	public static void main(String...strings){
		getUserInfo("oGDxut6UIp27um1Z7eDOeImRzcYg");
	}
}
