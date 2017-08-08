package com.gdglc.spring.bean.auth.model;

import java.io.Serializable;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class DeptInfo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1986768248113087842L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
