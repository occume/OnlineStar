package com.os.storage;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.os.db.domain.Narrater;
import com.os.db.domain.User;
import com.os.service.UserService;
import com.os.util.NamedThreadFactory;

@Component
public class DB {

	private Lock lock = new ReentrantLock();
	private List<User> users = Lists.newArrayList();
	private ExecutorService executor;
	/*
	 * narraters cache
	 */
	private List<Narrater> narraters;
	
	@Autowired
	private UserService userService;

	@PostConstruct
	public void onLaunched(){
		executor = Executors.newSingleThreadExecutor(new NamedThreadFactory("DB-Writer"));

	}
	
	public void updateUserLocation(User user){
		userService.updateUserLocation(user);
	}
	
	public boolean existUser(User user){
		return userService.getByOpenId(user) != null;
	}
	
	public void saveUser(User user){
		try{
			lock.lock();
			users.add(user);
			if(users.size() >= 1){
				doSaveUser(Lists.newArrayList(users));
				users.clear();
			}
		}
		finally{
			lock.unlock();
		}
	}
	
	public void doSaveUser(final List<User> users){
		executor.execute(new Runnable(){
			@Override
			public void run() {
				userService.batchSaveUsers(users);
			}
		});
	}
	
	public List<Narrater> getAllNarrater(){
		return narraters;
	}
	
	public Narrater getNarraterByYoukuId(String youkuId){
		for(Narrater n: narraters){
			if(n.getYoukuId().equals(youkuId)){
				return n;
			}
		}
		return null;
	}
}