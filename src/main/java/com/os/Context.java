package com.os;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.os.auth.model.Account;
import com.os.auth.service.AccountService;

@Component
public class Context implements ApplicationContextAware{
	
	private static ApplicationContext context;
	private static AccountService accountService;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		Context.context = applicationContext;
		accountService = Context.context.getBean(AccountService.class);
	}
	
	public static Object getBean(String beanName){
		if (null == beanName){
			return null;
		}
		return context.getBean(beanName);
	}
	
	public static Account getByToken(String token){
		return accountService.getByToken(token);
	}
}

