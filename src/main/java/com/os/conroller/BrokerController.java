package com.os.conroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.os.Constant;
import com.os.auth.model.Account;
import com.os.auth.model.Auth;
import com.os.auth.service.AccountService;
import com.os.model.Apply;
import com.os.model.ApplyWithOnlineStar;
import com.os.model.Broker;
import com.os.model.BrokerOnlineStar;
import com.os.model.Job;
import com.os.model.Merchant;
import com.os.model.OnlineStar;
import com.os.model.Result;
import com.os.service.ApplyService;
import com.os.service.BrokerService;
import com.os.service.JobService;
import com.os.service.MerchantService;
import com.os.service.OnlineStarService;

@Controller
@RequestMapping("/broker/v1")
public class BrokerController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(BrokerController.class);
	
	@Autowired
	private AccountService accService;
	@Autowired
	private OnlineStarService osService;
	@Autowired
	private BrokerService brokerService;
	@Autowired
	private JobService jobService;
	@Autowired
	private ApplyService applyService;
	
	private Broker getProfile(Auth auth) {
		return brokerService.getByAuthId(auth.getId());
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	@ResponseBody
    public Object profile(HttpSession session){
		Auth auth = checkAndGetAuth(session);
		Broker broker = brokerService.getByAuthId(auth.getId());
    	return Result.ok(broker);
	}
	
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpSession session, @Valid @RequestBody Broker broker){
		checkAndGetAuth(session);
		brokerService.update(broker);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/os/add", method = RequestMethod.POST)
	@ResponseBody
    public Object onlineStarAdd(HttpSession session, @RequestBody BrokerOnlineStar bos){
		Auth auth = checkAndGetAuth(session);
		Broker broker = getProfile(auth);
		if(broker == null) return Result.fail("Group Broker is not selected");
		
		Account acc = bos.account();
		accService.save(acc);
		
		OnlineStar os = bos.onlineStar();
		os.setAuthId(0l);
		os.setAccountId(acc.getId());
		osService.save(os);

		brokerService.addOnlineStar(broker.getId(), os.getId());
		
    	return Result.OK;
	}
	
	@RequestMapping(value = "/os/list", method = RequestMethod.POST)
	@ResponseBody
    public Object onlineStarList(HttpSession session, @RequestBody Map<String, Object> map){
		Auth auth = checkAndGetAuth(session);
		Broker broker = getProfile(auth);
		if(broker == null) return Result.fail("Group Broker is not selected");
		
		int page = getParamInt("page", map);
		
    	return Result.ok(brokerService.onlineStarList(broker.getId()));
	}
}