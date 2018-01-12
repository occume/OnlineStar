package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.Constant;
import com.os.mapper.ApplyMapper;
import com.os.model.Apply;
import com.os.model.ApplyExample;
import com.os.model.ApplyWithJob;
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
//		return applyMapper.selectWithJob(osId)
//	}
	
	public List<ApplyWithJob> getWithJob(int startRow, long authId, int statusId, int typeId){
		startRow = startRow * Constant.PAGE_SIZE;
		return getWithJob(startRow, Constant.PAGE_SIZE, authId, statusId, typeId);
	}
	
	public List<ApplyWithJob> getWithJob(int startRow, int pageSize, long authId, int statusId, int typeId){
		return applyMapper.selectWithJob(startRow, pageSize, authId, statusId, typeId);
	}
	
	public List<ApplyWithOnlineStar> selectWithOnlineStar(long jobId){
		return applyMapper.selectWithOnlineStar(jobId);
	}
	
	public boolean exist(long jobId, long authId){
		return applyMapper.selectByJobOnlineStar(jobId, authId) != null;
	}
	
	public boolean exist(Apply apply){
		return applyMapper.selectByJobOnlineStar(apply.getJobId(), apply.getAuthId()) != null;
	}
	
	public List<Apply> getApplyList(long authId){
		ApplyExample example = new ApplyExample();
		example.createCriteria().andAuthIdEqualTo(authId);
		return applyMapper.selectByExample(example);
	}
	
	public void handleApply(long applyId, int toStatusId){
		applyMapper.updateByPrimaryKeySelective(new Apply(applyId, toStatusId));
	}
}
