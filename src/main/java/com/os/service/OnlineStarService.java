package com.os.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.db.domain.OnlineStar;
import com.os.db.mapper.OnlineStarMapper;

@Service
public class OnlineStarService {
	@Autowired
	private OnlineStarMapper osMapper;
	
	public void save(OnlineStar os){
		osMapper.save(os);
	}
}
