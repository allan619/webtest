package com.gdglc.spring.struts.controller.auth;

import com.gdglc.spring.SpringHelper;
import com.gdglc.spring.biz.auth.IUserBiz;
import com.gdglc.spring.exception.BizException;

public class UserAction {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String showList(){
		System.out.println("---UserAction showList---"+this.name);
		return "list";
	}
	
	public String add(){
		System.out.println("---UserAction add---");
		return "add";
	}
	
	public String delete(){
		System.out.println("---UserAction delete---");
		return "test";
	}
	
	public String update(){
		return "update";
	}
	
	public String showInfo(){
		return "info";
	}
	
	
}
