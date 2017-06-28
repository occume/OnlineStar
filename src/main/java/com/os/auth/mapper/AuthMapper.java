package com.os.auth.mapper;

import com.os.auth.domain.Auth;

public interface AuthMapper {

	void save(Auth auth);
	
	Auth getAuth(String phone);
//	void exist(Account account);
//	
//	void save(Account account);
//	
//	void update(Account account);
}
