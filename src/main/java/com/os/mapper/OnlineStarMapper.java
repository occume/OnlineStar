package com.os.mapper;

import com.os.model.OnlineStar;
import com.os.model.OnlineStarExample;
import com.os.model.OnlineStarLabel;
import com.os.model.OnlineStarRecommend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OnlineStarMapper {
	
    long countByExample(OnlineStarExample example);

    int deleteByExample(OnlineStarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OnlineStar record);
    
    int insertLabel(OnlineStarLabel label);

    int insertSelective(OnlineStar record);

    List<OnlineStar> selectByExample(OnlineStarExample example);
    
    List<OnlineStarRecommend> selectPopular();
    
    List<OnlineStarRecommend> selectFresh();

    OnlineStar selectByPrimaryKey(Long id);
    
    List<OnlineStarLabel> selectLabelByOsId(Long osId);

    int updateByExampleSelective(@Param("record") OnlineStar record, @Param("example") OnlineStarExample example);

    int updateByExample(@Param("record") OnlineStar record, @Param("example") OnlineStarExample example);

    int updateByPrimaryKeySelective(OnlineStar record);

    int updateByPrimaryKey(OnlineStar record);
}