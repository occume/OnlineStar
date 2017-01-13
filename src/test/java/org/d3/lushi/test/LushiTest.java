package org.d3.lushi.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.d3.wx.vo.Card;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class LushiTest {

	public static void main(String[] args) throws JSONException, IOException {
		byte[] buf = Files.readAllBytes(Paths.get("D:/Workspaces2014/MyCity/src/main/resources/AllSets.zhCN.json"));
		JSONObject jobj = new JSONObject(new String(buf));
//		System.out.println(jobj);
//		parse(jobj.get("Basic"), 1);
		parse(jobj, 1);
		for(Card card: cards)
		System.out.println(card);
	}
	
	private static List<Card> cards = Lists.newArrayList();

	public static void parseObject(JSONObject root, int level){
		
		try {
			String id = root.getString("id");
			if(!Strings.isNullOrEmpty(id))
				addCard(root);
			return;
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		String[] names = JSONObject.getNames(root);
		int lv = level + 1;
		for(String name: names){
			try {
				Object obj = root.get(name);
				parse(obj, name, lv);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private static void addCard(JSONObject jobj){
		String[] names = JSONObject.getNames(jobj);
		Card card = new Card();
		for(String name: names){
			try {
				Object value = jobj.get(name);
				Method method = getMethod(name);
				if(method != null){
					method.invoke(card, value);
				}
				else{
					System.out.println(name);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		cards.add(card);
	}
	
	private static Method[] methods = Card.class.getMethods();
	
	public static Method getMethod(String name){
		
		for(Method m: methods){
			String mname = m.getName().toLowerCase();
			if(mname.contains("set") && mname.contains(name.toLowerCase())){
				return m;
			}
		}
		return null;
	}
	
	private boolean isString(Object obj){
		return obj instanceof String;
	}
	
	private boolean isInteger(Object obj){
		return obj instanceof Integer;
	}
	
	private static String up1(String name){
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static void parseArray(JSONArray root, int level){
		
		int len = root.length();
		int lv = level + 1;
		
		for(int i = 0; i < len; i++){
			try {
				Object obj = root.get(i);
				parse(obj, "ARR", lv);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void parse(Object obj, String name, int level){
		
		print(level);
		
		if(obj instanceof JSONArray){
			parseArray((JSONArray) obj, level);
			System.out.println(name);
		}
		else if(obj instanceof JSONObject){
			parseObject((JSONObject) obj, level);
			System.out.println(name);
		}
		else{
			System.out.println(name + " : " + obj);
		}
	}
	
	public static void print(int count){
		char[] chars = new char[count];
		Arrays.fill(chars, '-');
		System.out.print(chars);
	}
	
	public static void parse(Object obj, int level){
		parse(obj, "", level);
	}
}
