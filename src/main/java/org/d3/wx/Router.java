package org.d3.wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.d3.wx.AppContext;
import org.d3.wx.api.In;
import org.d3.wx.processor.EventProcessor;
import org.d3.wx.processor.Processor;
import org.d3.wx.processor.TextProcessor;
import org.d3.wx.vo.Message;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.d3.wx.Constant.ParamKey.*;
import static org.d3.wx.Constant.ErrorCode.*;
import static org.d3.wx.Constant.MsgType.*;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.primitives.Longs;
import com.os.service.ItemService;

//@Controller
public class Router {
	
	private static final String CONTENT_JSON = "application/json;charset=UTF-8";
	private static final String CONTENT_TEXT = "application/text;charset=UTF-8";
	
	private static final Logger LOG = LoggerFactory.getLogger(Router.class);
	
	private static Map<String, Processor> processors = Maps.newHashMap();
	
	@PostConstruct
	public void onLauncher(){
		processors.put(EVENT, AppContext.getBean(EventProcessor.class));
		processors.put(TEXT,  AppContext.getBean(TextProcessor.class));
	}
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value="/wx", produces=CONTENT_TEXT)
    public @ResponseBody
    String route(HttpServletRequest request, HttpServletResponse response) {
		
    	String signature = paramFor(request, SIGNATURE);
    	String timeStamp = paramFor(request, TIMESTAMP);
    	String nonce = paramFor(request, NONCE);
    	
    	if(!In.checkSignature(timeStamp, nonce, signature)){
    		LOG.error("signature fail");
    		return SIGNATURE_ERROR;
    	}
    	
    	String echostr = paramFor(request, ECHOSTR);
    	if(!Strings.isNullOrEmpty(echostr)){
    		LOG.info("1st conf, {}", echostr);
    		return echostr;
    	}
    	
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		} catch (IOException e) {
			LOG.error("parse reqeust.inputStream error: {}", e.getMessage());
		}
		
		StringBuffer sb = new StringBuffer();
		for(;;){
			String line = "";
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(line == null) break;
			sb.append(line + "\n");
		}
		
		Document doc = null;
		try {
			doc = Jsoup.parse(sb.toString());
		} catch (Exception e) {
			LOG.error("parse post xml data error: {}" + e.getMessage());
			return "success";
		}
		
		Message msg = messageFor(doc);
		
		LOG.debug("In message: ", msg);
		
		String msgType = msg.getMsgType();
		Processor p = processors.get(msgType);
		
		if(p == null){
			LOG.error("msgType error: {}", msgType);
			return "success";
		}
		
		String ret = p.process(msg);
		LOG.debug("Out resp: ", ret);
		return ret;
    }
	
	private Message messageFor(Document doc){
		Message msg = new Message();
		
		msg.setFromUserName(textFor(doc, "FromUserName"));
		msg.setToUserName(textFor(doc, "ToUserName"));
		msg.setCreateTime(Long.valueOf(textFor(doc, "CreateTime")));
		msg.setMsgType(textFor(doc, "MsgType"));
		msg.setContent(textFor(doc, "Content"));
		msg.setEvent(textFor(doc, "Event"));
		Long msgId = Longs.stringConverter().convert(textFor(doc, "MsgId"));
		if(msgId != null){
			msg.setMsgId(msgId);
		}
		
		msg.setLatitude(textFor(doc, "Latitude"));
		msg.setLongitude(textFor(doc, "Longitude"));
		
		msg.setEventKey(textFor(doc, "EventKey"));
		
		return msg;
	}
	
	@RequestMapping(value="/wx/test", produces=CONTENT_JSON)
    public @ResponseBody
    String test(HttpServletRequest request, HttpServletResponse response) {
		return "This is a test!";
    }
	
	public String textFor(Document doc, String tag){
		Elements elems = doc.getElementsByTag(tag);
		String text = null;
		if(elems != null && elems.size() > 0){
			text = elems.first().text();
		}
		return text;
	}
	
	private String paramFor(HttpServletRequest request, String key){
		return request.getParameter(key);
	}
}
