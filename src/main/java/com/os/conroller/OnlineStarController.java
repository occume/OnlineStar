package com.os.conroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.d3.wx.AppContext;
import org.d3.wx.processor.EventProcessor;
import org.d3.wx.processor.Processor;
import org.d3.wx.processor.TextProcessor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static org.d3.wx.Constant.MsgType.*;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.os.db.domain.Item;
import com.os.db.domain.OnlineStar;
import com.os.db.domain.Result;
import com.os.service.ItemService;
import com.os.service.OnlineStarService;
import com.os.validator.Validator;

@Controller
@RequestMapping("/wh")
public class OnlineStarController {
	
	private static final String CONTENT_JSON = "application/json;charset=UTF-8";
	private static final String CONTENT_TEXT = "application/text;charset=UTF-8";
	
	private static final Logger LOG = LoggerFactory.getLogger(OnlineStarController.class);
	
	private static Map<String, Processor> processors = Maps.newHashMap();
	
	static{
		processors.put(EVENT, AppContext.getBean(EventProcessor.class));
		processors.put(TEXT,  AppContext.getBean(TextProcessor.class));
	}
	
	@Autowired
	OnlineStarService osService;
	
//	@RequestMapping(value="/reg", produces=CONTENT_JSON)
//    public @ResponseBody
//    List<Item> foodList(HttpServletRequest request, HttpServletResponse response) {
//		List<Item> items = Lists.newArrayList();
//		return items;
//  }
	
	@RequestMapping(value="/reg", produces=CONTENT_TEXT, method = RequestMethod.POST)
	@ResponseBody
    public Object regitster(HttpServletRequest request,
    			Map<String, Object> model){
		
		OnlineStar os = Validator.validateOnlineStar(request);
		osService.save(os);

    	return Result.OK;
    }
	
	@RequestMapping(value="/test", produces=CONTENT_JSON)
    public @ResponseBody
    Object test(HttpServletRequest request, HttpServletResponse response) {
		return Result.OK;
    }
	
//	@RequestMapping(value="/food")
//    public String foodListIndex(Map<String, Object> model){
//		List<Item> items = itemService.getAllItems();
//		model.put("items", items);
//		model.put("locationName", "今日菜单");
//		return "index";
//    }
//	@RequestMapping(value= "/food/{id}")  
//	public ModelAndView helloWorld(Map<String, Object> model, @PathVariable int id) {  
//		model.put("locationName", "美食详情");
//		model.put("item", itemService.getItemById(id));
//		return new ModelAndView("/detail");
//	}
	
	@RequestMapping(value="/cart")
    public String cart(Map<String, Object> model){
		model.put("locationName", "购物车");
		return "cart";
    }
	
	@RequestMapping(value="/ordering", method = RequestMethod.POST)
	@ResponseBody
    public String ordering(@RequestBody List<Item> items){
		
		return "success";
    }
	public String textFor(Document doc, String tag){
		Elements elems = doc.getElementsByTag(tag);
		String text = null;
		if(elems != null && elems.size() > 0){
			text = elems.first().text();
		}
		return text;
	}
	
}
