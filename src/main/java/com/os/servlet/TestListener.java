package com.os.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Thread ClassLoader: " + Thread.currentThread().getContextClassLoader());
		System.out.println(getClass().getClassLoader());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
