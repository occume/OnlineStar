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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import com.os.Constant;
import com.os.Constant.HeaderName;
import com.os.Constant.Hint;
import com.os.Constant.SessionKey;
import com.os.SendMan;
import com.os.auth.model.Account;
import com.os.auth.model.Auth;
import com.os.auth.model.BindAccount;
import com.os.auth.service.AccountService;
import com.os.auth.service.AuthService;
import com.os.exception.NoSignInException;
import com.os.model.Result;

@Controller
@RequestMapping("/passport/v" + Constant.API_VERSION)
public class AuthController{
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthService authService;
	@Autowired
	private AccountService accService;
	
	@RequestMapping(value = "/v-code", method = RequestMethod.POST)
	@ResponseBody
    public Result vcode(HttpSession session, @RequestBody Map<String, String> map){
		int code = genVcode();
		session.setAttribute(SessionKey.VCODE, code);
		String phone = map.get("phone");
		SendMan.sms(phone, code);
    	return Result.OK;
    }
	
	private int genVcode() {
		int start = 100000;
		int end = 999999;
		return start + new Random().nextInt((end - start) + 1);
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
    public Result regitster(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody Auth auth){
		Result r;
		if(authService.exist(auth.getPhone())){
			r = Result.fail("你的手机号码已经注册过啦");
		}else{
			
//			checkVcode(request.getSession(), auth.getVcode());
			
			authService.save(auth);
			Account acc = new Account();
			acc.setAuthId(auth.getId());
			accService.save(acc);
			
//			Account acc1 = accService.getByAuthId(auth.getId());
//			session.setAttribute("acc", acc1);
			
			setToken(request, response, auth);
			r = Result.OK;
		}
    	return r;
    }
	
	private void checkVcode(HttpSession session, int vcode){
		if(session.getAttribute(SessionKey.VCODE) == null){
			throw new NoSignInException("请输入验证码哦");
		}
		else{
			int vcodeS = (int) session.getAttribute(SessionKey.VCODE);
			if(vcodeS != vcode){
				throw new NoSignInException("验证码不正确哦");
			}
		}
	}
	
	@RequestMapping(value = "/password/reset", method = RequestMethod.POST)
	@ResponseBody
    public Result resetPassword(HttpSession session, @Valid @RequestBody Auth auth){
		Result r;
		if(authService.exist(auth.getPhone())){
			checkVcode(session, auth.getVcode());
			authService.resetPassword(auth);
			r = Result.OK;
		}else{
			r = Result.fail(Hint.NOT_EXIST_PHONE);
		}
    	return r;
    }
	
	@RequestMapping(value = "/info1", method = RequestMethod.POST)
	@ResponseBody
    public Object info(@RequestBody Map<String, String> map){
		String phone = map.get("phone");
		Auth auth = authService.getAuth(phone);
    	return Result.ok(auth);
    }
	
	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
	@ResponseBody
    public Result signIn(HttpServletRequest request, HttpServletResponse response, @RequestBody BindAccount bindAccount){
		
		int errCode = 0;
		String errMessage = "";
		Result result;
		Auth authParam = bindAccount.getAuth();
		Auth auth = checkBind(authParam);
		
		if(authParam.getType() == 2){
			errMessage = (Hint.NOT_BINDED_WEIXIN);
			errCode = 12;
		}
		else if(authParam.getType() == 3){
			errMessage = (Hint.NOT_BINDED_WEIBO);
			errCode = 13;
		}
		else if(authParam.getType() == 4){
			errMessage = (Hint.NOT_BINDED_QQ);
			errCode = 14;
		}
		else{
			auth = authService.getAuth(authParam.getPhone(), authParam.getPassword());
			if(auth == null){
				errMessage = Hint.NOT_EXIST_PHONE;
				errCode = 12;
			}
		}
		
		if(auth != null){
			LOG.info("Sign-in success: {}", auth);
			result = setToken(request, response, auth);
		}
		else{
			result = Result.fail(errCode, errMessage);
		}
    	return result;
    }
	
	private Result setToken(HttpServletRequest request, HttpServletResponse response, Auth auth){
		String token = Hashing.md5().hashBytes(("HRZ2017" + auth.getId()).getBytes()).toString();
		auth.setToken(token);
		authService.resetToken(auth);
		response.setHeader(HeaderName.TOKEN, token);
		Account acc = accService.getByAuthId(auth.getId());
		request.getSession().setAttribute(token, acc);
		return Result.ok(acc);
	}
	
	private Auth checkBind(Auth authParam){
		Auth auth = null;
		if(authParam.getType() == 2){
			auth = authService.getByOpenKeyWx(authParam.getOpenKeyWx());
		}
		else if(authParam.getType() == 3){
			auth = authService.getByOpenKeyWeibo(authParam.getOpenKeyWeibo());
		}
		else if(authParam.getType() == 4){
			auth = authService.getByOpenKeyQQ(authParam.getOpenKeyQq());
		}
		return auth;
	}
	
	@RequestMapping(value = "/open-key/bind/check", method = RequestMethod.POST)
	@ResponseBody
    public Object bindOpenKeyCheck(HttpServletRequest request, HttpServletResponse response, @RequestBody BindAccount bindAccount){
		Auth auth = authService.getAuth(bindAccount.getPhone());
		Result result = Result.OK;
		if(auth == null){
			result = Result.fail(Hint.NOT_EXIST_PHONE);
		}
		return result;
	}
	
	@RequestMapping(value = "/open-key/bind", method = RequestMethod.POST)
	@ResponseBody
    public Object bindOpenKey(HttpServletRequest request, HttpServletResponse response, @RequestBody BindAccount bindAccount){
		
		int type = bindAccount.getType();
		Result ret = Result.OK;
		int bindResult = 0;
		
		if(Strings.isNullOrEmpty(bindAccount.getOpenKey())){
			return Result.fail(Hint.EMPTY_OPEN_KEY);
		}
		
		if(Strings.isNullOrEmpty(bindAccount.getPhone())){
			return Result.fail(Hint.NOT_EXIST_PHONE);
		}
		Auth authParam = bindAccount.getAuth();
		
		Auth auth = checkBind(authParam);
		if(auth != null){
			return Result.fail(Hint.BINDED_OPEN_KEY);
		}
		
		auth = authService.getAuth(authParam.getPhone());
		
		if(auth == null){
			authService.save(authParam);
			Account acc = new Account();
			acc.setAuthId(authParam.getId());
			accService.save(acc);
		}
		else{
			auth = authService.getAuth(authParam.getPhone(), authParam.getPassword());
			if(auth == null){
				return Result.fail(Hint.PASSWORD_NOT_CORRECT);
			}
			if(type == 2){
				bindResult = authService.bindOpenKeyWx(authParam);
			}
			else if(type == 3){
				bindResult = authService.bindOpenKeyWeibo(authParam);
			}
			else if(type == 4){
				bindResult = authService.bindOpenKeyQQ(authParam);
			}
			else{
				ret = Result.fail(Hint.INVALID_OPEN_KEY_TYPE);
			}
			
			if(bindResult == 0){
				ret = Result.fail(Hint.NOT_EXIST_PHONE);
			}
			else{
				Account acc = bindAccount.getAccount();
				Auth auth1 = authService.getAuth(authParam.getPhone());
				acc.setAuthId(auth1.getId());
				accService.update(acc);
			}
		}
		
		if(ret == Result.OK){
			ret = signIn(request, response, bindAccount);
		}
    	return ret;
	}
	
	@RequestMapping(value = "/account/update", method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpServletRequest request, @Valid @ModelAttribute Account acc){
//		authService.save(acc);
    	return Result.OK;
	}
}