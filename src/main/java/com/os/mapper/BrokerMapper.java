package com.os.mapper;

import com.os.model.Broker;
import com.os.model.BrokerExample;
import com.os.model.BrokerOnlineStarResponse;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BrokerMapper {
    long countByExample(BrokerExample example);

    int deleteByExample(BrokerExample example);

    int deleteByPrimaryKey(Long id);

    int addOnlineStar(@Param("brokerId") long brokerId, @Param("osId") long osId);
    
    int insert(Broker record);

    int insertSelective(Broker record);
    
    List<BrokerOnlineStarResponse> selectAccount(@Param("brokerId")long brokerId);

    List<Broker> selectByExample(BrokerExample example);

    Broker selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Broker record, @Param("example") BrokerExample example);

    int updateByExample(@Param("record") Broker record, @Param("example") BrokerExample example);

    int updateByPrimaryKeySelective(Broker record);

    int updateByPrimaryKey(Broker record);
}