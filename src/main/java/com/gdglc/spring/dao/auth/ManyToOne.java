package com.gdglc.spring.dao.auth;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gdglc.spring.bean.auth.model.AddressInfo;
import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.dao.BaseDao;

public class ManyToOne {
	static BaseDao dao = new BaseDao();
	public static void main(String[] args) {
		//search();
		//save();
		//update();
		delete();
	}
	//查询
	public static void search(){
		Session session = dao.getSession();
//		AddressInfo info = (AddressInfo)session.get(AddressInfo.class, 1);
//		System.out.println(info);
//		System.out.println("------------------");
//		System.out.println(info.getUserInfo());
		Query query = session.createQuery(" from AddressInfo a  left join fetch a.userInfo ");
		List<AddressInfo> list = (List<AddressInfo>) query.list();
		for (AddressInfo item : list) {
			System.out.println(item);
		}
		
		System.out.println("----------------");
		query = session.createQuery("select a,a.userInfo from AddressInfo a  where a.userInfo.userName = 'accp123' ");
		list = query.list();
		System.out.println(list.size());
		session.close();
	}
	
	public static void save(){
		Session session = dao.getSession();
		Transaction tx = session.beginTransaction();
		AddressInfo addressInfo = new AddressInfo();
		addressInfo.setTel("122345");
		addressInfo.setAddressDesc("test");
		UserInfo userInfo = new UserInfo();
		//userInfo.setId(1);
		userInfo.setUserName("t10");
		addressInfo.setUserInfo(userInfo);
		session.save(addressInfo);
		tx.commit();
		session.close();
	}
	
	public static void update(){
		Session session = dao.getSession();
		Transaction tx = session.beginTransaction();
		AddressInfo info = (AddressInfo)session.get(AddressInfo.class, 1);
		info.setTel("abcd");
		UserInfo userInfo = info.getUserInfo();
		userInfo.setUserName("addressUpdate");
		session.update(info);
		tx.commit();
		session.close();
	}
	
	public static void delete(){
		Session session = dao.getSession();
		Transaction tx = session.beginTransaction();
		AddressInfo info = (AddressInfo)session.get(AddressInfo.class, 10);
		info.setTel("abcdf");
		session.delete(info);
		tx.commit();
		session.close();
	}
	
	
	
}
