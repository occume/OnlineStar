package com.os.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.auth.mapper.AuthMapper;
import com.os.auth.model.Auth;

@Service
public class AuthService {
	
	@Autowired
	private AuthMapper authMapper;
	
	public void save(Auth auth){
		authMapper.save(auth);
	}
	
	public void resetPassword(Auth auth){
		authMapper.resetPassword(auth);
	}
	
	public int resetToken(Auth auth){
		return authMapper.resetToken(auth);
	}
	
	public Auth getAuth(String phone){
		return authMapper.getAuthByPhone(phone);
	}
	
	public Auth getAuth(String phone, String password){
		return authMapper.getAuth(phone, password);
	}
	
	public Auth getByOpenKeyWx(String openKey){
		return authMapper.getByWx(openKey);
	}
	
	public Auth getByOpenKeyWeibo(String openKey){
		return authMapper.getByWeibo(openKey);
	}
	
	public Auth getByOpenKeyQQ(String openKey){
		return authMapper.getByQQ(openKey);
	}
	
	public int bindOpenKeyWx(Auth auth){
		return authMapper.bindWx(auth);
	}
	
	public int bindOpenKeyWeibo(Auth auth){
		return authMapper.bindWeibo(auth);
	}
	
	public int bindOpenKeyQQ(Auth auth){
		return authMapper.bindQQ(auth);
	}
	
	public boolean exist(String phone){
		return authMapper.getAuthByPhone(phone) != null;
	}
	
	public boolean exist(Auth auth){
		authMapper.save(auth);
		return true;
	}
}
