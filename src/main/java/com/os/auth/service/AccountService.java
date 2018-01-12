package com.os.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.auth.mapper.AccountMapper;
import com.os.auth.model.Account;

@Service
public class AccountService {
	
	@Autowired
	private AccountMapper accMapper;
	
	public void save(Account acc){
		accMapper.save(acc);
	}
	
	public void update(Account acc){
		accMapper.updateById(acc);
	}
	
	public Account getByAuthId(long authId){
		return accMapper.getByAuthId(authId);
	}
	
	public Account getByToken(String token){
		return accMapper.getByToken(token);
	}
	
	public void selectGroup(long authId, int groupId){
		accMapper.setGroup(groupId, authId);
	}

	public void setRegistionid(long authId, String registionid) {
		accMapper.setRegistionid(authId, registionid);
	}
}
