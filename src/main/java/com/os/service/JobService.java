package com.os.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.Constant;
import com.os.mapper.JobImageMapper;
import com.os.mapper.JobMapper;
import com.os.mapper.OnlineStarMapper;
import com.os.model.Job;
import com.os.model.JobExample;
import com.os.model.JobImage;
import com.os.model.JobImageExample;
import com.os.model.JobWithMerchant;
import com.os.model.JobExample.Criteria;
import com.os.model.OnlineStar;

@Service
public class JobService {

	@Autowired
	private JobMapper jobMapper;
	@Autowired
	private JobImageMapper imageMapper;
	
	public int insert(Job job){
		return jobMapper.insert(job);
	}
	
	public int update(Job job){
		return jobMapper.updateByPrimaryKeySelective(job);
	}
	
	public int insert(JobImage image){
		return imageMapper.insert(image);
	}
	
	public List<Job> jobListOfMerchant(int page, long merchantId){
		JobExample example = new JobExample();
		example.setStartRow(page);
		example.setPageSize(Constant.PAGE_SIZE);
		Criteria criteria = example.createCriteria();
		criteria.andMerchantIdEqualTo(merchantId);
		
		List<Job> jobList = jobMapper.selectByExample(example);
		for(Job job: jobList){
			JobImageExample imageExample = new JobImageExample();
			JobImageExample.Criteria c = imageExample.createCriteria();
			c.andJobIdEqualTo(job.getId());
			List<JobImage> imageList = imageMapper.selectByExample(imageExample);
			job.setImageList(imageList);
		}
		return jobList;
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
