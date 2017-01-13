package com.os.conroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.loader.WebappClassLoader;
import org.d3.wx.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.os.db.domain.Article;
import com.os.db.domain.Player;
import com.os.service.PlayerService;

@Controller
public class MainController {
	
	private static final String JSON = "application/json;charset=UTF-8";
	private static final String TEXT = "application/json;charset=UTF-8";
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private PlayerService playerService;
	
    @RequestMapping(value="/records", produces=TEXT)
    public 
    String wanjia() {
    	return "h4/index";
    }
//   
//    @RequestMapping(value="/opinions/all", produces=TEXT)
//    public @ResponseBody
//    List<Article> opinionsAll(){
//    	return articleService.getArticles();
//    }
    public static void main(String...strings){
//    	121.36436,31.225824
//    	121.36470393469,31.225998529817
//    	double dis = Distance.getShortDistance(121.36436, 31.225824, 121.36470393469, 31.225998529817);
//    	System.out.println(dis);
    }
}