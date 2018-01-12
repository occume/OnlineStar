package com.os.conroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.loader.WebappClassLoader;
import org.d3.wx.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.os.Constant;
import com.os.Constant.ApplyStatus;
import com.os.Message1;
import com.os.SendMan;
import com.os.auth.model.Account;
import com.os.auth.model.Auth;
import com.os.model.Apply;
import com.os.model.ApplyWithJob;
import com.os.model.Job;
import com.os.model.OnlineStar;
import com.os.model.Result;
import com.os.service.ApplyService;
import com.os.service.JobService;
import com.os.service.OnlineStarService;

@Controller
@RequestMapping("/job/v1")
public class JobController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	private JobService jobService;
	@Autowired
	private ApplyService applyService;
	
	@RequestMapping(value = "/post", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object createJob(HttpServletRequest request, @Valid @RequestBody Job job){
		checkAndGetAuth(request);
//		jobService.insert(job);
		System.out.println(job.getImageList());
    	return Result.OK;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
    public Object jobList(HttpServletRequest request, @RequestBody Map<String, Object> map){
		//checkAndGetAuth(request);
		System.out.println(map);
		List<Job> data = jobService.jobList(map);
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
    public Object jobDetail(HttpServletRequest request, @RequestBody Map<String, Object> map){
		//checkAndGetAuth(request);
		System.out.println(map);
		long id = (long) map.get("id");
		Job data = jobService.getById(id);
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	@ResponseBody
    public Object applyJob(HttpServletRequest request, @RequestBody Map<String, Long> map){
		Account account = checkAndGetAuth(request);
		
		Result result;
		long jobId = map.get("job_id");
		Apply apply = Apply.newApply(jobId, account.getAuthId(), Constant.ApplyType.APPLY);
		if(applyService.exist(apply)){
			result = Result.fail("Already applied");
		}
		else{
			applyService.create(apply);
			Message1 message = new Message1(account.getRegistionid(), "[Hongrz] this is alert", 
					"[Hongrz] this is title", 1, account.getAuthId(), "[Hongrz] this is a link");
			SendMan.send(message);
			result = Result.OK;
		}
		
    	return result;
	}
	
	@RequestMapping(value = "/apply/list", method = RequestMethod.POST)
	@ResponseBody
    public Object applyList(HttpServletRequest request, @RequestBody Map<String, Object> map){
		Account account = checkAndGetAuth(request);
//		OnlineStar os = getProfile(auth);
		int page = getParamInt("page", map);
		int statusId = getParamInt("status_id", map);
		int startRow = page * Constant.PAGE_SIZE;
		List<ApplyWithJob> applyList = 
				applyService.getWithJob(startRow, account.getAuthId(), statusId, 0);
    	return Result.ok(applyList);
	}
	
	@RequestMapping(value = "/apply/abolish", method = RequestMethod.POST)
	@ResponseBody
    public Object applyAbolish(HttpServletRequest request, @RequestBody Map<String, Long> map){
		Account account = checkAndGetAuth(request);
//		OnlineStar os = getProfile(auth);
		long applyId = map.get("apply_id");
		Apply apply = applyService.getById(applyId);
		if(apply == null || apply.getAuthId() != account.getAuthId()){
			return Result.fail("Permission denied");
		}
		applyService.handleApply(applyId, ApplyStatus.ABOLISH);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/apply/complete", method = RequestMethod.POST)
	@ResponseBody
    public Object applyComplete(HttpServletRequest request, @RequestBody Map<String, Long> map){
		Account account = checkAndGetAuth(request);
		
		long applyId = map.get("apply_id");
		Apply apply = applyService.getById(applyId);
		if(apply == null || apply.getAuthId() != account.getAuthId()){
			return Result.fail("Permission denied");
		}
		applyService.handleApply(applyId, ApplyStatus.COMPLETE);
    	return Result.OK;
	}
}