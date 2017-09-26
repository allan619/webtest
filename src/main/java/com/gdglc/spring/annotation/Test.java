package com.gdglc.spring.annotation;

import java.lang.reflect.Method;

import com.gdglc.spring.bean.auth.model.UserInfo;

public class Test {
	public static void main(String[] args) {
		try {
			Class<?> targetClass = Class.forName("com.gdglc.spring.annotation.AuthChildren");
			//Class targetClass =  AuthTest.class;
			Auth auth = targetClass.getAnnotation(Auth.class);
			System.out.println(auth.value()+auth.name());
			Method method = targetClass.getMethod("test", String.class);
			Auth methodAuth = method.getAnnotation(Auth.class);
			System.out.println(methodAuth);
			
		} catch (Exception e) {
			// todo Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
