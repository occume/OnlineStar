package com.os.auth.conroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.os.exception.NoSignInException;
import com.os.model.Result;

@ControllerAdvice
public class AuthenticatorController {
	
	@InitBinder
	public void initBinder(){
		
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)  
	@ResponseBody  
	public Result handleMethodArgumentNotValidException(  
	        MethodArgumentNotValidException ex) {  
	    BindingResult bindingResult = ex.getBindingResult();  
	    String errorMesssage = "Invalid Request:";  
	  
	    for (FieldError fieldError : bindingResult.getFieldErrors()) {  
	        errorMesssage += fieldError.getDefaultMessage() + ", ";  
	    }  
	      
	    System.out.println(bindingResult.getFieldError().getDefaultMessage());  
	    Result response = new Result();  
	    response.setErrCode(-11);  
	    response.setErrMessage(errorMesssage);  
	    return response;  
	}
	
	// JSON convert exception  
		@ExceptionHandler(HttpMessageNotReadableException.class)  
		@ResponseBody  
		public Result handleHttpMessageNotReadableException(  
		        HttpMessageNotReadableException ex) {
			ex.printStackTrace();
			Result response = new Result();  
		    response.setErrCode(-22);  
		    response.setErrMessage("json convert failure!");  
		    return response;  
		}  
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Object dataBindingErrorHandle(BindingResult result){
		System.out.println("dataBindingErrorHandle　" +result);
		return result.getFieldErrors();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadSqlGrammarException.class)
	@ResponseBody
	public Object errorBadSqlHandle(BadSqlGrammarException e){
		System.out.println("-- errorBadSqlHandle");
		System.out.println(e.getMessage());
		Result response = new Result();  
	    response.setErrCode(-22);  
	    response.setErrMessage("Oh, programmer is ran!");  
	    return response;  
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object errorHandle(Exception e){
		System.out.println("-- errorHandle");
		//e.printStackTrace();
		if(e instanceof NoSignInException){
			return Result.fail(e.getMessage());
		}
		e.printStackTrace();
		return Result.fail("Oh, programmer is ran!");
	}
}