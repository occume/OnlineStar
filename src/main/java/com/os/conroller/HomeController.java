package com.os.conroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.os.model.Result;
import com.os.service.CommonService;
import com.os.service.OnlineStarService;

@Controller
@RequestMapping("/home/v1")
public class HomeController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private OnlineStarService osService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public Object home(){
    	return "h5/index";
	}
	
	@RequestMapping(value = "/on-service", method = RequestMethod.GET)
	@ResponseBody
    public Object onService(){
    	return Result.ok(System.currentTimeMillis());
	}
	
	@RequestMapping(value = "/banner/list", method = RequestMethod.GET)
	@ResponseBody
    public Object bannerLIst(){
    	return Result.ok(commonService.getBannerImageList());
	}
	
	@RequestMapping(value = "/os/popular/list", method = RequestMethod.GET)
	@ResponseBody
    public Object osPopular(){
    	return Result.ok(osService.popularList());
	}
	
	@RequestMapping(value = "/os/fresh/list", method = RequestMethod.GET)
	@ResponseBody
    public Object osFresh(){
    	return Result.ok(osService.freshList());
	}
	
	@RequestMapping(value = "/os/popular/work/list", method = RequestMethod.GET)
	@ResponseBody
    public Object osPopularWorks(){
    	return Result.ok(osService.popularWorkList());
	}
	
	@RequestMapping(value = "/os/fresh/work/list", method = RequestMethod.GET)
	@ResponseBody
    public Object osFreshWorks(){
    	return Result.ok(osService.freshWorkList());
	}
}