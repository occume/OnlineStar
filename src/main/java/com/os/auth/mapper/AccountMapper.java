package com.os.auth.mapper;

import org.apache.ibatis.annotations.Param;

import com.os.auth.domain.Account;
import com.os.auth.domain.Auth;

public interface AccountMapper {

	void save(Account account);
}
