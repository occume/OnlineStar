package com.os.auth.conroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.os.auth.domain.Account;
import com.os.auth.domain.Auth;
import com.os.auth.service.AccountService;
import com.os.auth.service.AuthService;
import com.os.db.domain.OnlineStar;
import com.os.db.domain.Result;
import com.os.exception.NoSignInException;
import com.os.validator.Validator;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	private static final String JSON = "application/json;charset=UTF-8";
	private static final String TEXT = "application/json;charset=UTF-8";
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AuthService authService;
	@Autowired
	private AccountService accService;
	
	@RequestMapping(value = "/reg", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Result regitster(@Valid @RequestBody Auth auth){
		Result r;
		if(authService.exist(auth.getPhone())){
			r = Result.fail("Exist phone");
		}else{
			authService.save(auth);
			r = Result.OK;
		}
    	return r;
    }
	
	@RequestMapping(value = "/info", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object info(HttpSession session, @RequestBody Phone p){
		checkAuth(session);
    	return Result.OK;
    }
	
	@RequestMapping(value = "/update", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpServletRequest request, @Valid @RequestBody Account acc){
//		authService.save(acc);
		System.out.println(acc);
		accService.save(acc);
    	return Result.OK;
	}
	
	private void checkAuth(HttpSession session){
		Auth auth = (Auth)session.getAttribute("acc");
		if(auth == null){
			throw new NoSignInException("Not sign in");
		}
	}
}