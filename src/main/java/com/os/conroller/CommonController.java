package com.os.conroller;

import java.util.Map;

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




import com.os.model.Result;
import com.os.service.CommonService;

@Controller
@RequestMapping("/common/v1")
public class CommonController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;
	
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
}