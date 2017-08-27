package com.os.auth.mapper;

import org.apache.ibatis.annotations.Param;

import com.os.auth.model.Account;

public interface AccountMapper {

	void save(Account account);
	
	Account getByAuthId(long authId);
	
	void setGroup(@Param(value = "groupId")int groupId, @Param(value = "authId") long authId);
	
	void updateById(Account account);
}
