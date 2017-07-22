package com.os.auth.mapper;

import org.apache.ibatis.annotations.Param;

import com.os.auth.model.Auth;

public interface AuthMapper {

	void save(Auth auth);
	
	Auth getAuthByPhone(String phone);
	
	Auth getAuth(@Param(value="phone")String phone, 
	  		 @Param(value="password")String password);
//	void exist(Account account);
//	
//	void save(Account account);
//	
//	void update(Account account);
}
