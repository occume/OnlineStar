package com.os.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.ApplyMapper;
import com.os.model.Apply;

@Service
public class ApplyService {

	@Autowired
	private ApplyMapper applyMapper;
	
	public int create(Apply apply){
		return applyMapper.insert(apply);
	}
	
	public int update(Apply apply){
		return applyMapper.updateByPrimaryKey(apply);
	}
	
	public Apply get(long jobId, long osId){
		return applyMapper.selectByJobOnlineStar(jobId, osId);
	}
	
	public boolean exist(long jobId, long osId){
		return applyMapper.selectByJobOnlineStar(jobId, osId) != null;
	}
	
	public boolean exist(Apply apply){
		return applyMapper.selectByJobOnlineStar(apply.getJobId(), apply.getOsId()) != null;
	}
}
