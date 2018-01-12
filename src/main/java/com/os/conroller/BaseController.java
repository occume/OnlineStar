package com.os.conroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.os.Constant.HeaderName;
import com.os.Context;
import com.os.ParameterProcessor;
import com.os.auth.model.Account;
import com.os.exception.NoSignInException;

public class BaseController extends ParameterProcessor{
	
	protected static final String JSON = "application/json;charset=UTF-8";
	protected static final String TEXT = "application/json;charset=UTF-8";
	
	private static Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	protected <T> T attr(HttpSession session, String name){
		return (T) session.getAttribute(name);
	}
	
	protected Account checkAndGetAuth(HttpServletRequest request){
		String token = request.getHeader(HeaderName.TOKEN);
		if(Strings.isNullOrEmpty(token)){
			throw new NoSignInException("No token is found");
		}
		Account account = attr(request.getSession(), token);
		if(account == null){
			account = Context.getByToken(token);
			LOG.info("No token is found in db");
		}
		if(account == null){
			throw new NoSignInException("Not sign in");
		}
		return account;
	}
}