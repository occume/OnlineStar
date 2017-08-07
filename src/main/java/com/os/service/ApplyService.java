package com.os.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.ApplyMapper;
import com.os.model.Apply;
import com.os.model.ApplyExample;
import com.os.model.ApplyWithOnlineStar;

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
	
	public Apply getByJobOnlineStar(long jobId, long osId){
		return applyMapper.selectByJobOnlineStar(jobId, osId);
	}
	
	public Apply getById(long applyId){
		return applyMapper.selectByPrimaryKey(applyId);
	}
	
//	public Apply getByJobId(long jobId){
//		Apply
//		return applyMapper.selectByExample(example);
//	}
	
	public List<ApplyWithOnlineStar> selectWithOnlineStar(long jobId){
		return applyMapper.selectWithOnlineStar(jobId);
	}
	
	public boolean exist(long jobId, long osId){
		return applyMapper.selectByJobOnlineStar(jobId, osId) != null;
	}
	
	public boolean exist(Apply apply){
		return applyMapper.selectByJobOnlineStar(apply.getJobId(), apply.getOsId()) != null;
	}
	
	public List<Apply> getApplyList(long osId){
		ApplyExample example = new ApplyExample();
		example.createCriteria().andOsIdEqualTo(osId);
		return applyMapper.selectByExample(example);
	}
	
	public void handleApply(long applyId, int toStatusId){
		applyMapper.updateByPrimaryKeySelective(new Apply(applyId, toStatusId));
	}
}
