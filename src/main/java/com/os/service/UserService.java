package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.db.domain.User;
import com.os.db.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public void batchSaveUsers(List<User> users){
		userMapper.batchAddUser(users);
	}
	
	public void updateUserLocation(User user){
		userMapper.updateUserLocation(user);
	}
	
	public User getByOpenId(User user){
		return userMapper.getByOpenId(user.getOpenId());
	}
}
