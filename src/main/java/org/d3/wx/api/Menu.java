package org.d3.wx.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.d3.http.Http;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.io.Files;


public class Menu {
	
	private static final String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";

	public static void create(){
		String api = MENU_CREATE + Base.getAccessToken();
		
//		JSONObject jobj = new JSONObject();
//		try {
//			JSONArray jarr = new JSONArray();
//			
//			JSONObject m1 = new JSONObject();
//			m1.put("type", "click");
//			m1.put("name", "今日歌曲");
//			m1.put("key", "V1001_TODAY_MUSIC");
//			jarr.put(m1);
//			
//			JSONObject m2 = new JSONObject();
//			m2.put("name", "菜单");
//			
//			jobj.put("button", jarr);
//			
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
		
//		System.out.println(jobj.toString());
		URL url = Menu.class.getResource("/_menu.json");
		System.out.println(url);
		File menuFile = new File(url.getPath());
		String menuString = "";
		try {
			menuString = Files.toString(menuFile, Charset.forName("UTF-8"));
//			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(menuFile), Charset.forName("UTF-8")));
//			String line = null;
//			for(;;){
//				line = reader.readLine();
//				if(line == null) break;
//				menuString += line;
//			}
			System.out.println(menuString);
			JSONObject jobj = new JSONObject(menuString);
			System.out.println(jobj);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		String result = Http.post(api, menuString);
		System.out.println(result);
	}
	
	public static void main(String...strings){
		create();
	}
}
