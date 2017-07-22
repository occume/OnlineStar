package com.os.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.JobMapper;
import com.os.mapper.OnlineStarMapper;
import com.os.model.Job;
import com.os.model.JobExample;
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
	
	public List<Job> jobList(Map<String, Object> conditionMap){
		JobExample example = new JobExample();
		example.createCriteria().
		//example.createCriteria();
		if(conditionMap.containsKey("city_id")){
			int cityId = Integer.valueOf(conditionMap.get("city_id").toString());
			example.createCriteria().andCityIdEqualTo(cityId);
		}
		
		return jobMapper.selectByExample(example);
	}
}
