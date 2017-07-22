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
import com.os.model.OnlineStar;
import com.os.model.Result;
import com.os.service.ApplyService;
import com.os.service.OnlineStarService;

@Controller
@RequestMapping("/os")
public class OnlineStarController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(OnlineStarController.class);
	
	@Autowired
	private OnlineStarService osService;
	@Autowired
	private ApplyService applyService;
	
	private OnlineStar getGroup(Auth auth){
		return osService.get(auth.getId());
	}
	
	@RequestMapping(value = "/update", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object profileUpdate(HttpSession session, @Valid @RequestBody OnlineStar os){
		checkAndGetAuth(session);
		osService.update(os);
    	return Result.OK;
	}

	@RequestMapping(value = "/upload", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object uploadFile(HttpSession session, @RequestParam("file") MultipartFile file){
		System.out.println(file);
    	return Result.OK;
	}
	
	@RequestMapping(value = "/job/apply", produces = TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object applyJob(HttpSession session, @RequestBody Map<String, Long> map){
		Auth auth = checkAndGetAuth(session);
		OnlineStar os = getGroup(auth);
		Result result;
		if(os != null){
			long jobId = map.get("job_id");
			Apply apply = Apply.newApply(jobId, os.getId());
			if(applyService.exist(apply)){
				result = Result.fail("Have applied");
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
}