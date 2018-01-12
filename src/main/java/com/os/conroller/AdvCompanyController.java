package com.os.conroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.os.auth.model.Account;
import com.os.model.Job;
import com.os.model.Result;
import com.os.service.ApplyService;
import com.os.service.JobService;
import com.os.service.MerchantService;
import com.os.service.OnlineStarService;

@Controller
@RequestMapping("/intellect/v1")
public class AdvCompanyController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(AdvCompanyController.class);
	
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private JobService jobService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private OnlineStarService osService;
	
	@RequestMapping(value = "/os/recommond/list", method = RequestMethod.GET)
	@ResponseBody
    public Object jobCreateOsList(HttpServletRequest request){
		Account account = checkAndGetAuth(request);

    	return Result.ok(osService.getRecommendList(0, 2));
	}
	
	@RequestMapping(value = "/job/recommond/list", method = RequestMethod.GET)
	@ResponseBody
    public Object jobList(HttpServletRequest request){
		Account account = checkAndGetAuth(request);
		
		Map<String, Object> conditionMap = Maps.newHashMap();
		conditionMap.put("city_id", 1);
		List<Job> data = jobService.jobList(conditionMap);
    	return Result.ok(data);
	}
}