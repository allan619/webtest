package com.gdglc.spring.bean.auth.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserInfoDemo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = -5256118882385142042L;
	@NotNull
	@NotBlank
	private String name;
	@Max(value=5)
	private int age;
	@JsonIgnore
	@JSONField(serialize=false)
	private DeptInfo dept;
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	//默认为国际时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public DeptInfo getDept() {
		return dept;
	}
	public void setDept(DeptInfo dept) {
		this.dept = dept;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@JsonIgnore
	public String getCreateDateStr(){
		return "test";
	}
	
}
