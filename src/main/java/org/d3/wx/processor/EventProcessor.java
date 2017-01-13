package org.d3.wx.processor;

import java.util.List;

import org.d3.wx.ResponseMaker;
import org.d3.wx.api.UserManager;
import org.d3.wx.util.Async;
import org.d3.wx.util.MapUtil;
import org.d3.wx.vo.ArticleItem;
import org.d3.wx.vo.Location;
import org.d3.wx.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.os.db.domain.User;
import com.os.storage.DB;

@Component
public class EventProcessor implements Processor {
	
	private static Logger LOG = LoggerFactory.getLogger(EventProcessor.class);
	
	private static final String SUBSCRIBE 	= "subscribe";
	private static final String LOCATION 	= "LOCATION";
	private static final String CLICK		= "CLICK";
	
	@Autowired
	private DB db;
	
	@Override
	public String process(Message msg) {
		String event = msg.getEvent();
		String ret = "success";
		switch(event){
			case SUBSCRIBE:
				ret = handleSubscribe(msg);
				break;
			case LOCATION:
				ret = handleLocation(msg);
				break;
			case CLICK:
				ret = handleClick(msg);
				break;
		}

		return ret;
	}
	/**
	 * 订阅事件
	 * @param msg
	 * @return
	 */
	private String handleSubscribe(Message msg){
		final String from = msg.getFromUserName();
		String to = msg.getToUserName();
		
		Async.execute(new Runnable() {
			@Override
			public void run() {
				User user = UserManager.getUserInfo(from);
				if(db.existUser(user)) return;
				LOG.info("new user join: {}", user);
				db.saveUser(user);
			}
		});
		
		return ResponseMaker.textXml(to, from, "想咋滴？");
	}
	/**
	 * 位置上报
	 * @param msg
	 * @return
	 */
	private String handleLocation(Message msg) {
		String latitude = msg.getLatitude();
		String longitude = msg.getLongitude();
		
		Location location = MapUtil.getBaiDuLocationXY(latitude, longitude);
		double dis = MapUtil.getShortDistance(121.36436, 31.225824, location.getLatitude(), location.getLongitude());
		System.out.println("x: " + location.getLatitude() + " ;y: " + location.getLongitude()+ " ;distance: " + dis);
		User user = new User();
		user.setOpenId(msg.getFromUserName());
		user.setLatitude(Double.valueOf(latitude));
		user.setLongitude(Double.valueOf(longitude));
		db.updateUserLocation(user);
		return "suucess";
	}
	/**
	 * 自定义按钮点击事件
	 * @param msg
	 * @return
	 */
	public String handleClick(Message msg){
		String user = msg.getFromUserName();
		String gzh = msg.getToUserName();
		String key = msg.getEventKey();
		
		List<ArticleItem> items = Lists.newArrayList();
//		items.add(new ArticleItem("肉夹馍", "正宗肉夹馍", "http://112.124.115.136/mycity/img/logo.png", ""));
//		String resp = ResponseMaker.newsXml(gzh, user, items);
		return ResponseMaker.textXml(gzh, user, "想咋滴？");
	}
}
