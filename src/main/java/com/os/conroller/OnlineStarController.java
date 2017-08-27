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
import com.os.auth.model.Auth;
import com.os.model.Apply;
import com.os.model.ApplyWithJob;
import com.os.model.Job;
import com.os.model.JobWithMerchant;
import com.os.model.OnlineStar;
import com.os.model.OnlineStarWork;
import com.os.model.Result;
import com.os.model.Wallet;
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
	
	private OnlineStar getProfile(Auth auth){
		return osService.getByAuthId(auth.getId());
	}
	/**
	 * 个人中心更新
	 * @param session
	 * @param os
	 * @return
	 */
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpSession session, @Valid @RequestBody OnlineStar os){
		checkAndGetAuth(session);
		osService.update(os);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	@ResponseBody
    public Object profile(HttpSession session, @RequestBody Map<String, Object> map){
		Auth auth = checkAndGetAuth(session);
		int osId = getParamInt("os_id", map);
		OnlineStar os;
		if(osId == 0)
			os = osService.getByAuthId(auth.getId());
		else
			os = osService.getByOsId(osId);
    	return Result.ok(os);
	}
	
	/**
	 * 上传作品
	 * @param session
	 * @param workList
	 * @return
	 */
	@RequestMapping(value = "/work/add", method = RequestMethod.POST)
	@ResponseBody
    public Object workAdd(HttpSession session, @RequestBody List<OnlineStarWork> workList){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		if(os == null) return Result.fail("Group is not selected");
		
		for(OnlineStarWork work: workList){
			work.setOsId(os.getId());
			osService.save(work);
		}
    	return Result.OK;
	}
	
	@RequestMapping(value = "/work/list", method = RequestMethod.POST)
	@ResponseBody
    public Object workList(HttpSession session, @RequestBody Map<String, Object> map){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		if(os == null) Result.fail("Group is not selected");
		
		int typeId = getParamInt("type_id", map);
		List<OnlineStarWork> data = osService.getWorkList(os.getId(), typeId);
		
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/job/list", method = RequestMethod.POST)
	@ResponseBody
    public Object jobList(HttpSession session, @RequestBody Map<String, Object> map){
		checkAndGetAuth(session);
		List<Job> data = jobService.jobList(map);
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/job/detail", method = RequestMethod.POST)
	@ResponseBody
    public Object jobDetail(HttpSession session, @RequestBody Map<String, Long> map){
		checkAndGetAuth(session);
		long jobId = map.get("job_id");
		JobWithMerchant data = jobService.jobDetail(jobId);
    	return Result.ok(data);
	}
	
	@RequestMapping(value = "/job/apply", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object applyJob(HttpSession session, @RequestBody Map<String, Long> map){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		Result result;
		if(os != null){
			long jobId = map.get("job_id");
			Apply apply = Apply.newApply(jobId, os.getId());
			if(applyService.exist(apply)){
				result = Result.fail("Already applied");
			}
			else{
				applyService.create(Apply.newApply(jobId, os.getId()));
				result = Result.OK;
			}
		}
		else{
			result = Result.fail("Group is not selected");
		}
    	return result;
	}
	
	@RequestMapping(value = "/job/apply/list", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object applyList(HttpSession session, @RequestBody Map<String, Object> map){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		int page = getParamInt("page", map);
		int statusId = getParamInt("status_id", map);
		int startRow = page * Constant.PAGE_SIZE;
		List<ApplyWithJob> applyList = 
				applyService.selectWithJob(startRow, os.getId(), statusId);
    	return Result.ok(applyList);
	}
	
	@RequestMapping(value = "/job/apply/abolish", method = RequestMethod.POST)
	@ResponseBody
    public Object applyAbolish(HttpSession session, @RequestBody Map<String, Long> map){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		long applyId = map.get("apply_id");
		Apply apply = applyService.getById(applyId);
		if(apply == null || apply.getOsId() != os.getId()){
			return Result.fail("Permission denied");
		}
		applyService.handleApply(applyId, 4);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/job/apply/complete", method = RequestMethod.POST)
	@ResponseBody
    public Object applyComplete(HttpSession session, @RequestBody Map<String, Long> map){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		long applyId = map.get("apply_id");
		Apply apply = applyService.getById(applyId);
		if(apply == null || apply.getOsId() != os.getId()){
			return Result.fail("Permission denied");
		}
		applyService.handleApply(applyId, 3);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/wallet", method = RequestMethod.GET)
	@ResponseBody
    public Object wallet(HttpSession session){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		Wallet wallet = walletService.getByOsId(os.getId());
    	return Result.ok(wallet);
	}
	
	@RequestMapping(value = "/wallet/password/set", method = RequestMethod.POST)
	@ResponseBody
    public Object walletPasswordSet(HttpSession session, @RequestBody Map<String, String> map){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		Wallet wallet = walletService.getByOsId(os.getId());
		String password = map.get("password");
		wallet.setPassword(password);
		walletService.setPassword(wallet);
    	return Result.ok(wallet);
	}
	
	@RequestMapping(value = "/wallet/password/reset", method = RequestMethod.POST)
	@ResponseBody
    public Object walletPasswordReset(HttpSession session, @RequestBody Map<String, String> map){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		Wallet wallet = walletService.getByOsId(os.getId());
		String password = map.get("password");
		String oldPassword = map.get("old_password");
		if(oldPassword.equalsIgnoreCase(wallet.getPassword())){
			wallet.setPassword(password);
			walletService.setPassword(wallet);
		}
		else{
			return Result.fail("Password incorrect");
		}
		
    	return Result.ok(wallet);
	}
	
	@RequestMapping(value = "/wallet/bankcard/add", method = RequestMethod.POST)
	@ResponseBody
    public Object walletBankcardAdd(HttpSession session){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
		Wallet wallet = walletService.getByOsId(os.getId());
    	return Result.ok(wallet);
	}
	
	@RequestMapping(value = "/wallet/bankcard/list", method = RequestMethod.GET)
	@ResponseBody
    public Object walletBankcardList(HttpSession session){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getProfile(auth);
    	return Result.ok(walletService.getBankcardList(os.getId()));
	}
}