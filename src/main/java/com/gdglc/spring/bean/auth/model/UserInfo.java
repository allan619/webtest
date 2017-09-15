package com.gdglc.spring.bean.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.struts2.json.annotations.JSON;

import com.gdglc.spring.utils.DateUtil;
@Entity
@Table(name="userInfo")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class UserInfo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = -3618926879871160208L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="user_name")
	private String userName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	@OrderBy("id desc")
	private List<AddressInfo> addressList = new ArrayList<AddressInfo>();
	@Transient
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

	public List<AddressInfo> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressInfo> addressList) {
		this.addressList = addressList;
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
