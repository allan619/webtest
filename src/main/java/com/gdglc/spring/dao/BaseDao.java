package com.gdglc.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDao {
	static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration().configure("/hibernate/hibernate.xml");
		//获取会话工厂
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public Session getSession(){
		return sessionFactory.openSession();
	}
}
