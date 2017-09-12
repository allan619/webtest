package com.gdglc.spring.dao.auth;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gdglc.spring.bean.auth.model.AddressInfo;
import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.dao.BaseDao;

public class OneToMany {
	static BaseDao dao = new BaseDao();
	public static void main(String[] args) {
		//search();
		//save();
		update();
	}
	
	public static void search(){
		Session session = dao.getSession();
		/*UserInfo userInfo = (UserInfo)session.get(UserInfo.class, 1);
		System.out.println(userInfo);
		Set<AddressInfo> addressInfos = userInfo.getAddressInfos();
		System.out.println("---------------1");
		//Hibernate.initialize(addressInfos);
		System.out.println("-----------2");
		System.out.println(userInfo.getAddressInfos());*/
		Query query = session.createQuery(" from UserInfo u left join fetch u.addressInfos");
		List<UserInfo> list = query.list();
		System.out.println(list.get(0)==list.get(1));
		for (UserInfo item : list) {
			System.out.println(item);
			System.out.println(item.getAddressInfos().size());
			
		}
		session.close();
	}
	
	public static  void save(){
		Session session = dao.getSession();
		Transaction tx = session.beginTransaction();
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("2015");
		Set<AddressInfo> addressInfos = new HashSet<AddressInfo>();
		for(int i=1;i<4;i++){
			AddressInfo addressInfo = new AddressInfo();
			addressInfo.setTel("0000");
			addressInfo.setAddressDesc("oneToMany");
			addressInfo.setUserInfo(userInfo);
			addressInfos.add(addressInfo);
		}
		userInfo.setAddressInfos(addressInfos);
		session.save(userInfo);
		tx.commit();
		session.close();
	}
	
	public static  void update(){
		Session session = dao.getSession();
		Transaction tx = session.beginTransaction();
		UserInfo userInfo = (UserInfo)session.get(UserInfo.class, 4680055);
		Set<AddressInfo> addressInfos = userInfo.getAddressInfos();
		Iterator<AddressInfo> iterator = addressInfos.iterator();
		while(iterator.hasNext()){
			AddressInfo info = iterator.next();
			info.setUserInfo(null);
		}
		addressInfos.clear();
		session.update(userInfo);
		tx.commit();
		session.close();
	}
	
}
