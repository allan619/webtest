package com.gdglc.spring.struts.controller.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyTimeInterceptor extends MethodFilterInterceptor{

/*	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截");
		invocation.invoke();
		return null;
	}*/

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截");
		invocation.invoke();
		return null;
	}

}
