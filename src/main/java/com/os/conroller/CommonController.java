package com.os.conroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.os.auth.model.Auth;
import com.os.model.Feedback;
import com.os.model.Image;
import com.os.model.Result;
import com.os.model.response.AboutUs;
import com.os.service.CommonService;
import com.os.util.FileUtil;

@Controller
@RequestMapping("/common/v1")
public class CommonController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
    public Object uploadFile(HttpSession session, @RequestParam("file") MultipartFile[] files){

		LOG.info("files.size: {}", files.length);
		
		if(files.length == 0){
			return Result.fail("No file");
		}
		
		List<Image> works = Lists.newArrayList();
		for(MultipartFile file: files){
			if(file.getSize() == 0){
				LOG.warn("File size is 0");
				continue;
			}
			
			Image work = new Image();
			work.setOriginalName(file.getOriginalFilename());
			work.setContentType(file.getContentType());
			work.setSize(file.getSize());
//			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'));
//			String name = UUID.nameUUIDFromBytes(file.getOriginalFilename().getBytes()).toString() + suffix;
//			work.setName(name);
//			System.out.println(Paths.get("../").toFile().getAbsolutePath());
			
			try {
				String key = FileUtil.put2Qiniu(file.getBytes());
				work.setName(key);
//				Files.write(Paths.get("../images/" + name), file.getBytes());
				commonService.saveImage(work);
				works.add(work);
			} catch (IOException e) {
				LOG.error("", e);
			}
			
		}
    	return Result.ok(works);
	}
	
	@RequestMapping(value = "/meta", method = RequestMethod.GET)
	@ResponseBody
    public Object meta(){
    	return Result.ok(commonService.getGroupList());
	}
	
	@RequestMapping(value = "/group/list", method = RequestMethod.GET)
	@ResponseBody
    public Object groupList(){
    	return Result.ok(commonService.getGroupList());
	}
	
	@RequestMapping(value = "/job/type/list", method = RequestMethod.GET)
	@ResponseBody
    public Object jobTypeList(){
    	return Result.ok(commonService.getJobTypeList());
	}
	
	@RequestMapping(value = "/province/list", method = RequestMethod.GET)
	@ResponseBody
    public Object provinceList(){
    	return Result.ok(commonService.getProvinceList());
	}

	@RequestMapping(value = "/city/list", method = RequestMethod.GET)
	@ResponseBody
    public Object cityList(){
		return Result.ok(commonService.getCityList());
	}
	
	@RequestMapping(value = "/city/list/{provinceId}", method = RequestMethod.GET)
	@ResponseBody
    public Object cityListByProvinceId(@PathVariable int provinceId){
		return Result.ok(commonService.getCityList(provinceId));
	}
	
	@RequestMapping(value = "/bankcard-type/list/{prefix}", method = RequestMethod.GET)
	@ResponseBody
    public Object cityListByProvinceId(@PathVariable String prefix){
		return Result.ok(commonService.getBankcardTypeList(prefix));
	}
	
	@RequestMapping(value = "/feedback/add", method = RequestMethod.POST)
	@ResponseBody
    public Object feedbackAdd(HttpSession session, @RequestBody Feedback feedback){
		Auth auth = checkAndGetAuth(session);
		feedback.setAuthId(auth.getId());
		commonService.feedbackAdd(feedback);
		return Result.OK;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	@ResponseBody
    public Object about(){
		return Result.ok(AboutUs.about);
	}
}