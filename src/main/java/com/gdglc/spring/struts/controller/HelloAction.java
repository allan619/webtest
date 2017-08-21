package com.gdglc.spring.struts.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.opensymphony.xwork2.Action;

public class HelloAction implements Action,SessionAware,ApplicationAware,RequestAware{
	private UserInfo user;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("struts2执行"+this);
		//使用不和servletapi耦合的方式设置作用域
		/*Map<String, Object> session = ActionContext.getContext().getSession();
		Map<String, Object> application = ActionContext.getContext().getApplication();
		//session.put("name", "accp");
		application.put("name", "accp10");
		session.remove("name");*/
		//耦合的方式
		/*HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext application = ServletActionContext.getServletContext();
		application.removeAttribute("name");
		application.setAttribute("name", "123");*/
		HttpServletResponse response = ServletActionContext.getResponse();
		//使用接口的方式
		session.put("name", "accp777");
		request.put("name", "accprequest");
		application.put("name", "haha");
		if(StringUtils.isBlank(user.getUserName())){
			return "add";
		}
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

}
