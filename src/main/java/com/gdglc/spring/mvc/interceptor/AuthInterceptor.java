package com.gdglc.spring.mvc.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("进入拦截");
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		//获取执行方法
		Method method = handlerMethod.getMethod();
		RequestMapping requestMapping = method.getAnnotation(org.springframework.web.bind.annotation.RequestMapping.class);
		String[] value = requestMapping.value();
		return true;
	}


}
