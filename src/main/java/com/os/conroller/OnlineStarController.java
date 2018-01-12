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
import com.os.model.Apply;
import com.os.model.ApplyWithJob;
import com.os.model.JobWithMerchant;
import com.os.model.OnlineStar;
import com.os.model.OnlineStarWork;
import com.os.model.Result;
import com.os.model.response.JobResponse;
import com.os.model.response.MerchantResponse;
import com.os.service.ApplyService;
import com.os.service.CommonService;
import com.os.service.JobService;
import com.os.service.OnlineStarService;
import com.os.service.WalletService;

@Controller
@RequestMapping("/os/v1")
public class OnlineStarController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(OnlineStarController.class);
	
	@Autowired
	private OnlineStarService osService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private WalletService walletService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private JobService jobService;
	
	private OnlineStar getProfile(Account account){
		return osService.getByAuthId(account.getAuthId());
	}
	/**
	 * 个人中心更新
	 * @param request
	 * @param os
	 * @return
	 */
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpServletRequest request, @Valid @RequestBody OnlineStar os){
		checkAndGetAuth(request);
		LOG.info("{}", os);
		os.setAuthId(null);
		osService.update(os);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	@ResponseBody
    public Object profile(HttpServletRequest request, @RequestBody Map<String, Object> map){
		Account account = checkAndGetAuth(request);
		int osId = getParamInt("os_id", map);
		OnlineStar os;
		if(osId == 0)
			os = osService.getByAuthId(account.getAuthId());
		else
			os = osService.getByOsId(osId);
    	return Result.ok(os);
	}
	
	/**
	 * 上传作品
	 * @param request
	 * @param workList
	 * @return
	 */
	@RequestMapping(value = "/work/add", method = RequestMethod.POST)
	@ResponseBody
    public Object workAdd(HttpServletRequest request, @RequestBody List<OnlineStarWork> workList){
		Account account = checkAndGetAuth(request);
		OnlineStar os = getProfile(account);
		
		if(os == null) return Result.fail("Group is not selected");
		
		for(OnlineStarWork work: workList){
			work.setOsId(os.getId());
			osService.addWork(work);
		}
    	return Result.OK;
	}
	
	@RequestMapping(value = "/work/list", method = RequestMethod.POST)
	@ResponseBody
    public Object workList(HttpServletRequest request, @RequestBody Map<String, Object> map){
		Account account = checkAndGetAuth(request);
		OnlineStar os = getProfile(account);
		if(os == null) Result.fail("Group is not selected");
		
		int typeId = getParamInt("type_id", map);
		List<OnlineStarWork> data = osService.getWorkList(os.getId(), typeId);
		
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/work/remove", method = RequestMethod.GET)
	@ResponseBody
    public Object removeWork(HttpServletRequest request, @RequestBody List<OnlineStarWork> workList){
		checkAndGetAuth(request);
		for(OnlineStarWork work: workList){
			osService.removeWork(work.getId());
		}
    	return Result.OK;
	}
	
	@RequestMapping(value = "/job/list", method = RequestMethod.POST)
	@ResponseBody
    public Object jobList(HttpServletRequest request, @RequestBody Map<String, Object> map){
		checkAndGetAuth(request);
		List<JobResponse> data = jobService.jobListOfOs(map);
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/job/merchant/profile", method = RequestMethod.POST)
	@ResponseBody
    public Object mechantProfile(HttpServletRequest request, @RequestBody Map<String, Long> map){
		Account account = checkAndGetAuth(request);
		
		long jobId = map.get("job_id");
		MerchantResponse data = jobService.jobMerchant(jobId, account.getAuthId());
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/job/detail", method = RequestMethod.POST)
	@ResponseBody
    public Object jobDetail(HttpServletRequest request, @RequestBody Map<String, Long> map){
		Account account = checkAndGetAuth(request);
		
		long jobId = map.get("job_id");
		JobWithMerchant data = jobService.jobDetail(jobId, account.getAuthId());
    	return Result.ok(data);
	}
	
	
	
	@RequestMapping(value = "/job/invite/list", method = RequestMethod.POST)
	@ResponseBody
    public Object inviteList(HttpServletRequest request, @RequestBody Map<String, Object> map){
		Account account = checkAndGetAuth(request);
//		OnlineStar os = getProfile(auth);
		System.out.println(account);
		int page = getParamInt("page", map);
//		int statusId = getParamInt("status_id", map);
		int startRow = page * Constant.PAGE_SIZE;
		List<ApplyWithJob> applyList = 
				applyService.getWithJob(startRow, account.getAuthId(), 1, 2);
    	return Result.ok(applyList);
	}
	
	@RequestMapping(value = "/job/invite/pass", method = RequestMethod.POST)
	@ResponseBody
    public Object invitePass(HttpServletRequest request, @RequestBody Map<String, Long> map){
		checkAndGetAuth(request);
//		Merchant merchant = getProfile(auth);
		
		long applyId = map.get("apply_id");
		Apply apply = applyService.getById(applyId);
		applyService.handleApply(applyId, Constant.ApplyStatus.RUNNING);
		
    	return Result.OK;
	}
	
	@RequestMapping(value = "/job/invite/refuse", method = RequestMethod.POST)
	@ResponseBody
    public Object inviteRefuse(HttpServletRequest request, @RequestBody Map<String, Long> map){
		checkAndGetAuth(request);
		
		long applyId = map.get("apply_id");
		
		Apply apply = applyService.getById(applyId);
		applyService.handleApply(applyId, Constant.ApplyStatus.NO_PASS);
		
    	return Result.OK;
	}
}