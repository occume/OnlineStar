package org.d3.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.os.mapper.ApplyMapper;
import com.os.mapper.JobMapper;
import com.os.mapper.OnlineStarMapper;
import com.os.model.Apply;
import com.os.model.ApplyWithJob;
import com.os.model.ApplyWithOnlineStar;
import com.os.model.Job;
import com.os.model.JobExample;
import com.os.model.JobWithMerchant;
import com.os.model.OnlineStar;
import com.os.model.OnlineStarExample;
import com.os.service.OnlineStarService;

public class MybatisTest {
	
	public static ApplicationContext ctx;
	public static OnlineStarService oss;
	
	static{
		ctx = new ClassPathXmlApplicationContext("/beans.xml");
		oss = ctx.getBean(OnlineStarService.class);
	}
	
	public static void main(String...strings){
		
//		OnlineStarMapper osMapper = ctx.getBean(OnlineStarMapper.class);
//		OnlineStar os = new OnlineStar();
//		os.setAuthId(1l);
////		os.set
//		int id = osMapper.insert(os);
//		System.out.println(os.getId());
//		OnlineStarExample osExample = new OnlineStarExample();
//		osExample.createCriteria().andAuthIdEqualTo(1l);
//		List<OnlineStar> osList = osMapper.selectByExample(osExample);
//		System.out.println(osList);
//		
//		applyTest();
		jobTest();
//		
//		Apply apply = applyMapper.selectByJobOnlineStar(2l, 1l);
//		System.out.println(apply);
//		OrderService orderService = ctx.getBean(OrderService.class);
//		NarraterService ns = ctx.getBean(NarraterService.class);
//		System.out.println(ns.getAll().get(0).getYoukuUrl());
//		saveFollow();
//		getNarratersByFollow();
	}
	
	private static void applyTest(){
		ApplyMapper applyMapper = ctx.getBean(ApplyMapper.class);
		
		List<ApplyWithOnlineStar> appList = applyMapper.selectWithOnlineStar(1l);
		System.out.println(appList);
		
		List<ApplyWithJob> appList1 = applyMapper.selectWithJob(1L);
		System.out.println(appList1);
	}
	
	private static void jobTest(){
		JobMapper jobMapper = ctx.getBean(JobMapper.class);
//		JobExample example = new JobExample();
//		example.createCriteria().andTitleEqualTo("ABC");
//		example.createCriteria().andCityIdEqualTo(1)
//		.andJobTypeIdEqualTo(1)
//		.andMerchantIdEqualTo(1l);
//		example.setPageSize(2);
//		example.setStartRow(0);
//		List<Job> jobList = jobMapper.selectByExample(example);
//		System.out.println(jobList);
		
		JobWithMerchant job = jobMapper.selectWithMerchant(1l);
		System.out.println(job);
	}
	
	public static void saveFollow(){
//		OnlineStar os = new OnlineStar("jd", "13333333333", "530050582", "HuaJiao");
//		oss.save(os);
	}
	
}
