package com.os.conroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.os.auth.model.Auth;
import com.os.model.Job;
import com.os.model.OnlineStar;
import com.os.model.Result;
import com.os.service.JobService;
import com.os.service.OnlineStarService;

@Controller
@RequestMapping("/job/v1")
public class JobController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value = "/post", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object createJob(HttpSession session, @Valid @RequestBody Job job){
		checkAndGetAuth(session);
		jobService.insert(job);
    	return Result.OK;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
    public Object jobList(HttpSession session, @RequestBody Map<String, Object> map){
		//checkAndGetAuth(session);
		System.out.println(map);
		List<Job> data = jobService.jobList(map);
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
    public Object jobDetail(HttpSession session, @RequestBody Map<String, Object> map){
		//checkAndGetAuth(session);
		System.out.println(map);
		long id = (long) map.get("id");
		Job data = jobService.getById(id);
    	return Result.ok(data);
	}
}