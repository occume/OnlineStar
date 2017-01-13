package org.d3.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.os.db.domain.Follow;
import com.os.db.domain.OnlineStar;
import com.os.service.OnlineStarService;

public class MybatisTest {
	
	public static ApplicationContext ctx;
	public static OnlineStarService oss;
	
	static{
		ctx = new ClassPathXmlApplicationContext("/beans.xml");
		oss = ctx.getBean(OnlineStarService.class);
	}
	
	public static void main(String...strings){
//		OrderService orderService = ctx.getBean(OrderService.class);
//		NarraterService ns = ctx.getBean(NarraterService.class);
//		System.out.println(ns.getAll().get(0).getYoukuUrl());
		saveFollow();
//		getNarratersByFollow();
	}
	
	public static void saveFollow(){
		OnlineStar os = new OnlineStar("jd", "13333333333", "530050582", "HuaJiao");
		oss.save(os);
	}
	
}
