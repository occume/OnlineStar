package com.os.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.os.db.domain.User;

public interface UserMapper {

  void addUser(User user);
  
  void updateUserLocation(User user);
  
  User getByOpenId(String openId);

  User getByName(String name);
  
  User auth(User user);
  
  void batchAddUser(@Param("list")List<User> users); 
  
  void addFriend(@Param(value="uid1")int uid1, 
		  		 @Param(value="uid2")int uid2, 
		  		 @Param(value="type")int type);
  
  List<User> getFriendsById(@Param(value="id")int id);
  
//  List<UserRelation> getRelationsById(@Param(value="id")int id, @Param(value="list")List<Integer> ids);
}
