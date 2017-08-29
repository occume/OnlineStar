package com.os.conroller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.os.Constant.SessionKey;
import com.os.auth.model.Auth;
import com.os.exception.NoSignInException;

public class BaseController {
	
	protected static final String JSON = "application/json;charset=UTF-8";
	protected static final String TEXT = "application/json;charset=UTF-8";
	
	protected void checkAuth(HttpSession session){
		Auth auth = (Auth)session.getAttribute(SessionKey.ACCOUNT);
		if(auth == null){
			throw new NoSignInException("Not sign in");
		}
	}
	
	protected <T> T attr(HttpSession session, String name){
		return (T) session.getAttribute(name);
	}
	
	protected Auth checkAndGetAuth(HttpSession session){
		Auth auth = attr(session, SessionKey.ACCOUNT);
		if(auth == null){
			throw new NoSignInException("Not sign in");
		}
		return auth;
	}
	
	protected int getParamInt(String name, Map<String, Object> map){
		if(!map.containsKey(name)) return 0;
		return (int) map.get(name);
	}
	
	protected long getParamLong(String name, Map<String, Object> map){
		if(!map.containsKey(name)) return 0l;
		return Long.valueOf(map.get(name).toString());
	}
}