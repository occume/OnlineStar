package com.os.auth.mapper;

import org.apache.ibatis.annotations.Param;

import com.os.auth.model.Account;
import com.os.auth.model.Auth;

public interface AccountMapper {

	void save(Account account);
	
	Account get(long authId);
	
	void setGroup(@Param(value = "groupId")int groupId, @Param(value = "authId") long authId);
}
