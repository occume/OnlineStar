package com.os.mapper;

import com.os.model.Job;
import com.os.model.JobExample;
import com.os.model.JobWithMerchant;
import com.os.model.response.JobResponse;
import com.os.model.response.MerchantResponse;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JobMapper {
	
    long countByExample(JobExample example);

    int deleteByExample(JobExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Job record);

    int insertSelective(Job record);

    List<Job> selectByExample(JobExample example);
    
    List<JobResponse> selectJobListOfOs(Map<String, Object> params);
    
    MerchantResponse selectWithMerchantResponse(@Param("id")Long id);

    Job selectByPrimaryKey(Long id);
    
    JobWithMerchant selectWithMerchant(@Param("id")Long id);

    int updateByExampleSelective(@Param("record") Job record, @Param("example") JobExample example);

    int updateByExample(@Param("record") Job record, @Param("example") JobExample example);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}