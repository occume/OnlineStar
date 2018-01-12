package com.os.auth.mapper;

import org.apache.ibatis.annotations.Param;

import com.os.auth.model.Account;

public interface AccountMapper {

	void save(Account account);
	
	Account getByAuthId(long authId);
	
	Account getByToken(@Param(value = "token")String token);
	
	void setGroup(@Param(value = "groupId")int groupId, @Param(value = "authId") long authId);
	
	void updateById(Account account);

	void setRegistionid(@Param(value="authId")long authId, @Param(value="registionid")String registionid);
}
