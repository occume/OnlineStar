package com.os;

import java.util.Map;

public class ParameterProcessor {
	
	protected String getParamString(String name, Map<String, Object> map){
		if(!map.containsKey(name)) return "";
		return String.valueOf(map.get(name));
	}
	
	protected int getParamInt(String name, Map<String, Object> map){
		if(!map.containsKey(name)) return 0;
		return (int) map.get(name);
	}
	
	protected long getParamLong(String name, Map<String, Object> map){
		if(!map.containsKey(name)) return 0l;
		return Long.valueOf(map.get(name).toString());
	}
	
	protected double getParamDouble(String name, Map<String, Object> map){
		if(!map.containsKey(name)) return 0d;
		return Double.valueOf(map.get(name).toString());
	}
	
	protected void pageSet(int page, Map<String, Object> map){
		map.put("startRow", page * Constant.PAGE_SIZE);
		map.put("pageSize", Constant.PAGE_SIZE);
	}
}
