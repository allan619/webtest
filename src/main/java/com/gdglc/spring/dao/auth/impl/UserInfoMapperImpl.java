package com.gdglc.spring.dao.auth.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.bean.auth.vo.UserInfoVo;
import com.gdglc.spring.dao.auth.UserInfoMapper;

public class UserInfoMapperImpl implements UserInfoMapper{

	@Override
	public List<UserInfo> findAll() {
		// todo Auto-generated method stub
		return null;
	}

	@Override
	public int add(UserInfo userInfo) {
		// todo Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// todo Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserInfo userInfo) {
		// todo Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo findById(int id) {
		// todo Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findByUser(UserInfoVo vo) {
		// todo Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		//加载hibernate的配置文件，并解析
		Configuration configuration = new Configuration().configure("/hibernate/hibernate.xml");
		System.out.println(configuration);
		//获取会话工厂
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//获取连接
		Session session = sessionFactory.openSession();
		System.out.println(session);
		UserInfo info = (UserInfo)session.get(UserInfo.class, 2);
		//UserInfo info2 = (UserInfo)session.load(UserInfo.class, 2);
		//System.out.println(info==info2);
		//System.out.println(info.getId()+info.getUserName());
		System.out.println("====================查询结束");
		System.out.println("info="+info);
		
		//保存
		UserInfo addUserInfo = new UserInfo();
		addUserInfo.setUserName("add");
		//addUserInfo.setCreateDate(new Date());
		Transaction ts = session.beginTransaction();
		session.save(addUserInfo);
		System.out.println(addUserInfo);
		//刷新缓存
		addUserInfo.setUserName("flush");
		session.flush();
		addUserInfo.setUserName("flush2");
		ts.commit();
		
		//修改
		System.out.println("-------修改开始------");
		ts = session.beginTransaction();
		UserInfo updateUserInfo = new UserInfo();
		updateUserInfo.setId(2);
		updateUserInfo.setUserName("update4");
		//session.update(updateUserInfo);
		session.merge(updateUserInfo);
		System.out.println("info="+info);
		ts.commit();
		session.close();
		sessionFactory.close();
	}

}
