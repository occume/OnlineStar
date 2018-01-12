package com.os.conroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.os.model.OnlineStarWork;
import com.os.model.Result;
import com.os.model.request.BrokerOnlineStarWork;
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
	
	private Broker getProfile(Account account) {
		return brokerService.getByAuthId(account.getAuthId());
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	@ResponseBody
    public Object profile(HttpServletRequest request){
		Account account = checkAndGetAuth(request);
		
		Broker broker = brokerService.getByAuthId(account.getAuthId());
    	return Result.ok(broker);
	}
	
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpServletRequest request, @Valid @RequestBody Broker broker){
		checkAndGetAuth(request);
		brokerService.update(broker);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/os/add", method = RequestMethod.POST)
	@ResponseBody
    public Object onlineStarAdd(HttpServletRequest request, @RequestBody BrokerOnlineStar bos){
		Account account = checkAndGetAuth(request);
		Broker broker = getProfile(account);
		if(broker == null) return Result.fail("Group Broker is not selected");
		
		Account acc = bos.account();
		accService.save(acc);
		
		OnlineStar os = bos.onlineStar();
		os.setAuthId(0l);
		os.setAccountId(acc.getId());
		os.setBrokerId(broker.getId());
		osService.save(os);

		brokerService.addOnlineStar(broker.getId(), os.getId());
		
    	return Result.OK;
	}
	
	@RequestMapping(value = "/os/list", method = RequestMethod.POST)
	@ResponseBody
    public Object onlineStarList(HttpServletRequest request, @RequestBody Map<String, Object> map){
		Account account = checkAndGetAuth(request);
		Broker broker = getProfile(account);
		if(broker == null) return Result.fail("Group Broker is not selected");
		
		int page = getParamInt("page", map);
		
    	return Result.ok(brokerService.onlineStarList(broker.getId()));
	}
	
	/**
	 * 上传作品
	 * @param request
	 * @param workList
	 * @return
	 */
	@RequestMapping(value = "/os/work/add", method = RequestMethod.POST)
	@ResponseBody
    public Object workAdd(HttpServletRequest request, @RequestBody BrokerOnlineStarWork bos){
		Account account = checkAndGetAuth(request);
		
//		System.out.println(auth.getId());
		long osId = bos.osId;
		List<OnlineStarWork> workList = bos.workList;
//		if(os == null) return Result.fail("Group is not selected");
		for(OnlineStarWork work: workList){
			work.setOsId(osId);
			osService.addWork(work);
		}
    	return Result.OK;
	}
}