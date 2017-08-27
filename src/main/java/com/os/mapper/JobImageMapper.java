package com.os.mapper;

import com.os.model.JobImage;
import com.os.model.JobImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobImageMapper {
    long countByExample(JobImageExample example);

    int deleteByExample(JobImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JobImage record);

    int insertSelective(JobImage record);

    List<JobImage> selectByExample(JobImageExample example);

    JobImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JobImage record, @Param("example") JobImageExample example);

    int updateByExample(@Param("record") JobImage record, @Param("example") JobImageExample example);

    int updateByPrimaryKeySelective(JobImage record);

    int updateByPrimaryKey(JobImage record);
}