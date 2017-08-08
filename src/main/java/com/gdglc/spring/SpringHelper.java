package com.gdglc.spring;

import org.springframework.context.ApplicationContext;

public class SpringHelper {
	private static ApplicationContext context;

	public static void setContext(ApplicationContext context) {
		SpringHelper.context = context;
	}
	
	public static Object getBean(String name){
		return context.getBean(name);
	}
	
}
