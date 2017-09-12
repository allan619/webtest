package com.gdglc.spring.bean.auth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

import com.gdglc.spring.utils.DateUtil;

public class UserInfo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = -3618926879871160208L;
	private int id;
	private String userName;
	private Date createDate;
	private Set<AddressInfo> addressInfos;
	public UserInfo(){
		
	}
	
	public UserInfo(int id,String userName){
		this.id = id;
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	public Set<AddressInfo> getAddressInfos() {
		return addressInfos;
	}

	public void setAddressInfos(Set<AddressInfo> addressInfos) {
		this.addressInfos = addressInfos;
	}

	@JSON(serialize=false)
	public String getCreateDateStr(){
		return DateUtil.formate(getCreateDate());
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName
				+ ", createDate=" + createDate + "]";
	}
	
	
}
