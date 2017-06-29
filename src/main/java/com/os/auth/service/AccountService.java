package com.os.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.auth.domain.Account;
import com.os.auth.domain.Auth;
import com.os.auth.mapper.AccountMapper;
import com.os.auth.mapper.AuthMapper;
import com.os.db.domain.OnlineStar;
import com.os.db.mapper.OnlineStarMapper;

@Service
public class AccountService {
	
	@Autowired
	private AccountMapper accMapper;
	
	public void save(Account acc){
		accMapper.save(acc);
	}
	
	public Account get(long authId){
		return accMapper.get(authId);
	}
}
