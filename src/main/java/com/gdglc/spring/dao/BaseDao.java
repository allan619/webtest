package com.gdglc.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDao {
	static SessionFactory sessionFactory;
	static{
		Configuration configuration = new Configuration().configure("/hibernate/hibernate.xml");
		//获取会话工厂
		System.out.println("加载会话工厂");
		sessionFactory = configuration.buildSessionFactory();
	}
	static{
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("准备退出");
				try{
					if(null!=sessionFactory){
						sessionFactory.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					sessionFactory = null;
				}
				System.out.println("退出成功");
			}
		}));
	}
	public Session getSession(){
		return sessionFactory.openSession();
	}
	
	public static void main(String[] args) {
		//System.exit(0);
	}
}
