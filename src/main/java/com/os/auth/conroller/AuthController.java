package com.os.auth.conroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.os.auth.domain.Account;
import com.os.auth.domain.Auth;
import com.os.auth.service.AuthService;
import com.os.db.domain.OnlineStar;
import com.os.db.domain.Result;
import com.os.validator.Validator;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private static final String JSON = "application/json;charset=UTF-8";
	private static final String TEXT = "application/json;charset=UTF-8";
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/reg", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object regitster(HttpServletRequest request, @Valid @ModelAttribute Auth auth){
		//authService.save(auth);
		System.out.println("register");
    	return Result.OK;
    }
	
	@RequestMapping(value = "/account/update", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpServletRequest request, @Valid @ModelAttribute Account acc){
		authService.save(acc);
    	return Result.OK;
  }
	
	

    public static void main(String...strings){
//    	121.36436,31.225824
//    	121.36470393469,31.225998529817
//    	double dis = Distance.getShortDistance(121.36436, 31.225824, 121.36470393469, 31.225998529817);
//    	System.out.println(dis);
    }
}