package com.os.auth.conroller;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AuthenticatorController {
	
	@InitBinder
	public void initBinder(){
		System.out.println("Init binder");
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Object dataBindingErrorHandle(BindingResult result){
		return result.getFieldErrors();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadSqlGrammarException.class)
	@ResponseBody
	public Object errorBadSqlHandle(BadSqlGrammarException e){
		System.out.println(e);
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object errorHandle(Exception e){
		System.out.println(e);
		return e.getMessage();
	}
}