package com.gdglc.spring;

import java.io.Serializable;

public class User implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 2481144442723236184L;
	private String name;

	public User(){
		System.out.println("创建User");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
