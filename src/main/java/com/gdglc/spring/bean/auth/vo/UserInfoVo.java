package com.gdglc.spring.bean.auth.vo;

import java.io.Serializable;
import java.util.Date;

public class UserInfoVo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = -8803102747635829786L;
	private String userName;
	private String beginDate;
	private String endDate;
	//每页的行数
	private Integer num=2;
	//第几页
	private Integer pageNum =1;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		if(null==num||num<=0){
			num = 2;
		}
		this.num = num;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		if(null==pageNum||pageNum<=0){
			pageNum = 1;
		}
		this.pageNum = pageNum;
	}
	public Integer getBegin(){
		return (pageNum-1)*num;
	}
	
	
}
