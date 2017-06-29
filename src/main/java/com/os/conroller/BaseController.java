package com.os.conroller;

import javax.servlet.http.HttpSession;

import com.os.Constant.SessionKey;
import com.os.auth.domain.Auth;
import com.os.exception.NoSignInException;

public class BaseController {
	
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
}