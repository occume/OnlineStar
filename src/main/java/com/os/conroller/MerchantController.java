package com.os.conroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.loader.WebappClassLoader;
import org.apache.tomcat.util.http.fileupload.UploadContext;
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
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;
import com.os.auth.model.Auth;
import com.os.model.Apply;
import com.os.model.ApplyWithOnlineStar;
import com.os.model.Job;
import com.os.model.Merchant;
import com.os.model.OnlineStar;
import com.os.model.Result;
import com.os.service.ApplyService;
import com.os.service.JobService;
import com.os.service.MerchantService;
import com.os.service.OnlineStarService;

@Controller
@RequestMapping("/merchant/v1")
public class MerchantController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(MerchantController.class);
	
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private JobService jobService;
	@Autowired
	private ApplyService applyService;

	private Merchant getProfile(Auth auth){
		return merchantService.getByAuthId(auth.getId());
	}
	
	@RequestMapping(value = "/job/post", method = RequestMethod.POST)
	@ResponseBody
    public Object createJob(HttpSession session, @Valid @RequestBody Job job){
		Auth auth = checkAndGetAuth(session);
		Merchant merchant = getProfile(auth);
		if(merchant == null) return Result.fail("Group is not selected");
		job.setMerchantId(merchant.getId());
		jobService.insert(job);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/job/list", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object jobList(HttpSession session, @RequestBody Map<String, Object> map){
		Auth auth = checkAndGetAuth(session);
		Merchant merchant = getProfile(auth);
		Result result;
		if(merchant != null){
			LOG.info("{}", map);
			List<Job> data = jobService.jobListOfMerchant(merchant.getId());
			result = Result.ok(data);
		}
		else{
			result = Result.fail("Group is not selected");
		}
    	return result;
	}
	
	@RequestMapping(value = "/job/apply/list", method = RequestMethod.POST)
	@ResponseBody
    public Object jobApplyList(HttpSession session, @RequestBody Map<String, Long> map){
		Auth auth = checkAndGetAuth(session);
		Merchant merchant = getProfile(auth);
		long jobId = map.get("job_id");
		List<ApplyWithOnlineStar> data = applyService.selectWithOnlineStar(jobId);
		
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/job/apply/pass", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object applyJob(HttpSession session, @RequestBody Map<String, Long> map){
		Auth auth = checkAndGetAuth(session);
		Merchant merchant = getProfile(auth);
		
		long applyId = map.get("apply_id");
		Apply apply = applyService.getById(applyId);
		if(apply == null || apply.getOsId() != os.getId()){
			return Result.fail("Permission denied");
		}
		applyService.handleApply(applyId, 2);
		
    	return result;
	}
}