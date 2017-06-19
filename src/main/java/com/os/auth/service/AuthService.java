package com.os.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.auth.domain.Auth;
import com.os.auth.mapper.AuthMapper;
import com.os.db.domain.OnlineStar;
import com.os.db.mapper.OnlineStarMapper;

@Service
public class AuthService {
	
	@Autowired
	private AuthMapper authMapper;
	
	public void save(Auth auth){
		authMapper.save(auth);
	}
}
