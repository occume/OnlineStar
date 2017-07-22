package com.os.mapper;

import com.os.model.Apply;
import com.os.model.ApplyExample;
import com.os.model.ApplyWithOnlineStar;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {
    long countByExample(ApplyExample example);

    int deleteByExample(ApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Apply record);

    int insertSelective(Apply record);

    List<Apply> selectByExample(ApplyExample example);

    Apply selectByPrimaryKey(Long id);
    
    Apply selectByJobOnlineStar(@Param("jobId")Long jobId, @Param("osId")Long osId);
    
    List<ApplyWithOnlineStar> selectWithOnlineStar(Long jobId);

    int updateByExampleSelective(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByExample(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}