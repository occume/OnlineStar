package org.d3.wx;

import javax.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware{
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		AppContext.context = applicationContext;
	}

	private static ApplicationContext context;
	
	public static Object getBean(String beanName){
		if (null == beanName){
			return null;
		}
		return context.getBean(beanName);
	}
	
	public static <T> T getBean(Class<T> clazz){
		return context.getBean(clazz);
	}
	
	@PostConstruct
	public void onStart() {

	}
}
