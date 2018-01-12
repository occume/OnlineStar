package com.os.mapper;

import com.os.model.AlipayResult;
import com.os.model.AlipayResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlipayResultMapper {
    long countByExample(AlipayResultExample example);

    int deleteByExample(AlipayResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlipayResult record);

    int insertSelective(AlipayResult record);

    List<AlipayResult> selectByExample(AlipayResultExample example);

    AlipayResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlipayResult record, @Param("example") AlipayResultExample example);

    int updateByExample(@Param("record") AlipayResult record, @Param("example") AlipayResultExample example);

    int updateByPrimaryKeySelective(AlipayResult record);

    int updateByPrimaryKey(AlipayResult record);
}