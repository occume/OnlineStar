package com.os.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.auth.mapper.AccountMapper;
import com.os.auth.mapper.AuthMapper;
import com.os.auth.model.Account;
import com.os.auth.model.Auth;

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
	
	public void selectGroup(long authId, int groupId){
		accMapper.setGroup(groupId, authId);
	}
}
