package com.os.auth.conroller;

import java.util.Map;
import java.util.Random;

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

import com.os.Constant;
import com.os.Constant.SessionKey;
import com.os.auth.model.Account;
import com.os.auth.model.Auth;
import com.os.auth.service.AuthService;
import com.os.model.OnlineStar;
import com.os.model.Result;
import com.os.validator.Validator;

@Controller
@RequestMapping("/passport/v" + Constant.API_VERSION)
public class AuthController {
	
	private static final String JSON = "application/json;charset=UTF-8";
	private static final String TEXT = "application/json;charset=UTF-8";
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/v-code", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Result vcode(HttpSession session, @RequestBody Map<String, Integer> map){
		int code = genVcode();
		session.setAttribute(SessionKey.VCODE, code);
    	return Result.OK;
    }
	
	private int genVcode() {
		int start = 100000;
		int end = 999999;
		return start + new Random().nextInt((end - start) + 1);
	}
	
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
	
	@RequestMapping(value = "/password/reset", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Result resetPassword(HttpSession session, @Valid @RequestBody Auth auth){
		Result r;
		if(authService.exist(auth.getPhone())){
			if(session.getAttribute(SessionKey.VCODE) == null){
				r = Result.fail("Please get v-code first");
			}
			else{
				int vcode = (int) session.getAttribute(SessionKey.VCODE);
				if(vcode == auth.getVcode()){
					authService.resetPassword(auth);
					r = Result.OK;
				}
				else{
					r = Result.fail("V-code is incorrect");
				}
			}
			
		}else{
			r = Result.fail("Not exist phone");
		}
    	return r;
    }
	
	@RequestMapping(value = "/info1", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object info(@RequestBody Map<String, String> map){
		String phone = map.get("phone");
		System.out.println("phone: " + phone);
		System.out.println(authService.exist(phone));
		Auth auth = authService.getAuth(phone);
    	return Result.ok(auth);
    }
	
	@RequestMapping(value = "/sign-in", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object auth(HttpSession session, @Valid @RequestBody Auth auth){
		Result result;
		Auth auth1 = authService.getAuth(auth.getPhone(), auth.getPassword());
		if(auth1 == null){
			result = Result.fail("Not exist phone");
		}
		else{
			result = Result.ok(auth1);
			LOG.info("Sign-in: {}", auth1);
			session.setAttribute("acc", auth1);
		}
    	return result;
    }
	
	@RequestMapping(value = "/account/update", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpServletRequest request, @Valid @ModelAttribute Account acc){
//		authService.save(acc);
    	return Result.OK;
	}
}