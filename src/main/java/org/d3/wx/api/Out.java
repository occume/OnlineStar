package org.d3.wx.api;

import java.util.List;

import org.d3.http.Http;
import org.d3.wx.vo.ArticleItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Out{
	
	private static Logger LOG = LoggerFactory.getLogger(Out.class);
	private static final String CS_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
	
	public static void sendCSTextMsg(String msg){

		JSONObject jobj = new JSONObject();
		try {
			jobj.put("touser", "oGDxut6UIp27um1Z7eDOeImRzcYg");
			jobj.put("msgtype", "text");
			jobj.put("text",new JSONObject().put("content", msg));
		} catch (JSONException e) {
			LOG.error("{}", e.getMessage());
		}
		
		doSend(jobj.toString());
	}
	
	public static void sendCSNewsMsg(List<String> targets, List<ArticleItem> items){

		if(targets.size() == 0){
			LOG.info("No follows: {}");
			return;
		}
		
		for(String to: targets){
			JSONObject jobj = new JSONObject();
			try {
				jobj.put("touser", to);
				jobj.put("msgtype", "news");
				JSONArray articles = new JSONArray(items);
				jobj.put("news",new JSONObject().put("articles", articles));
			} catch (JSONException e) {
				LOG.error("{}", e.getMessage());
			}
			
			doSend(jobj.toString());
		}
	}
	
	private static void doSend(String jsonMsg){
		String result = Http.post(CS_MSG_URL + Base.getAccessToken(), jsonMsg);
		if(!result.contains("\"errcode\":0")){
			LOG.error("{}", result);
		}
	}
}
