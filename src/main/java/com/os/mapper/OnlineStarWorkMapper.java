package com.os.mapper;

import com.os.model.OnlineStarWork;
import com.os.model.OnlineStarWorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnlineStarWorkMapper {
    long countByExample(OnlineStarWorkExample example);

    int deleteByExample(OnlineStarWorkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OnlineStarWork record);

    int insertSelective(OnlineStarWork record);

    List<OnlineStarWork> selectByExample(OnlineStarWorkExample example);

    OnlineStarWork selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OnlineStarWork record, @Param("example") OnlineStarWorkExample example);

    int updateByExample(@Param("record") OnlineStarWork record, @Param("example") OnlineStarWorkExample example);

    int updateByPrimaryKeySelective(OnlineStarWork record);

    int updateByPrimaryKey(OnlineStarWork record);
}