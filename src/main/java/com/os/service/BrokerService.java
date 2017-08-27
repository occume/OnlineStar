package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.BrokerMapper;
import com.os.model.Broker;
import com.os.model.BrokerExample;
import com.os.model.BrokerOnlineStarResponse;
import com.os.model.OnlineStar;

@Service
public class BrokerService {

	@Autowired
	private BrokerMapper brokerMapper;
	
	public int update(Broker broker){
		return brokerMapper.updateByPrimaryKeySelective(broker);
	}
	
	public int insert(Broker broker){
		return brokerMapper.insert(broker);
	}
	
	public List<BrokerOnlineStarResponse> onlineStarList(long brokerId){
		return brokerMapper.selectAccount(brokerId);
	}
	
	public int addOnlineStar(long brokerId, long osId){
		return brokerMapper.addOnlineStar(brokerId, osId);
	}
	
	public Broker getByAuthId(long authId){
		BrokerExample example = new BrokerExample();
		example.createCriteria().andAuthIdEqualTo(authId);
		List<Broker> list = brokerMapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}
}
