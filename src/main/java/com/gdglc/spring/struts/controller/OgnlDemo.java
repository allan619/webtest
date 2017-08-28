package com.gdglc.spring.struts.controller;

import java.util.HashMap;
import java.util.Map;

import com.gdglc.spring.bean.auth.model.UserInfo;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlDemo {
	public static void main(String[] args) {
		OgnlContext context = new OgnlContext();
		HelloAction action = new HelloAction();
		UserInfo info = new UserInfo();
		info.setUserName("actionName");
		action.setUser(info);
		context.put("action", action);
		Map<String, Object> request = new HashMap<String, Object>();
		UserInfo user = new UserInfo();
		user.setUserName("accp");
		request.put("user", user);
		context.put("request", request);
		context.setRoot(request);
		try {
			System.out.println(Ognl.getValue("userName", user));
			System.out.println(Ognl.getValue("user.userName", context,context.getRoot()));
			System.out.println(Ognl.getValue("#action.user.userName", context,context.getRoot()));
			System.out.println(Ognl.getValue("{1,2,3}", context,context.getRoot()).getClass());
			System.out.println(Ognl.getValue("#{'a':'abc','b':'ddd'}['a']", context,context.getRoot()));
		} catch (OgnlException e) {
			e.printStackTrace();
		}
		
	}
}
