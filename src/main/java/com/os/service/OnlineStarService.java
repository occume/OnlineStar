package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.OnlineStarMapper;
import com.os.model.OnlineStar;
import com.os.model.OnlineStarExample;

@Service
public class OnlineStarService {

	@Autowired
	private OnlineStarMapper osMapper;
	
	public int insert(OnlineStar os){
		return osMapper.insert(os);
	}
	
	public int update(OnlineStar os){
		return osMapper.updateByPrimaryKeySelective(os);
	}
	
	public OnlineStar getByAuthId(long authId){
		OnlineStarExample example = new OnlineStarExample();
		example.createCriteria().andAuthIdEqualTo(authId);
		List<OnlineStar> list = osMapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}
}
