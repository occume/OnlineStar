package com.os.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.JobMapper;
import com.os.mapper.OnlineStarMapper;
import com.os.model.Job;
import com.os.model.JobExample;
import com.os.model.JobWithMerchant;
import com.os.model.JobExample.Criteria;
import com.os.model.OnlineStar;

@Service
public class JobService {

	@Autowired
	private JobMapper jobMapper;
	
	public int insert(Job job){
		return jobMapper.insert(job);
	}
	
	public int update(Job job){
		return jobMapper.updateByPrimaryKeySelective(job);
	}
	
	public List<Job> jobListOfMerchant(long merchantId){
		JobExample example = new JobExample();
		example.createCriteria().andMerchantIdEqualTo(merchantId);
		return jobMapper.selectByExample(example);
	}
	
	public List<Job> jobList(Map<String, Object> conditionMap){
		JobExample example = new JobExample();
		Criteria c = example.createCriteria();
		
		if(conditionMap.containsKey("city_id")){
			int cityId = Integer.valueOf(conditionMap.get("city_id").toString());
			c.andCityIdEqualTo(cityId);
		}
		
		if(conditionMap.containsKey("job_type_id")){
			int jobTypeId = Integer.valueOf(conditionMap.get("job_type_id").toString());
			c.andJobTypeIdEqualTo(jobTypeId);
		}
		
		if(conditionMap.containsKey("merchant_id")){
			long merchantId = Integer.valueOf(conditionMap.get("merchant_id").toString());
			c.andMerchantIdEqualTo(merchantId);
		}
		
		return jobMapper.selectByExample(example);
	}
	
	public JobWithMerchant jobDetail(long jobId){
		
		return jobMapper.selectWithMerchant(jobId);
	}
	
	public Job getById(long id){
		return jobMapper.selectByPrimaryKey(id);
	}
}
