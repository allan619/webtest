package com.gdglc.spring.bean.auth.model;

import java.io.Serializable;

public class AddressInfo implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = -991179101604838583L;

	private int id;
	private String tel;
	private String addressDesc;
	private UserInfo userInfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddressDesc() {
		return addressDesc;
	}
	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
