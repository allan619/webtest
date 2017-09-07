package com.gdglc.spring.dao.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.dao.BaseDao;

public class HqlDemo {
	public static void main(String[] args) {
		//testAll();
		//testWhere();
		//testUnique();
		//testPage();
		//testClo();
		testUpdate();
	}

	// 查询全部记录
	public static void testAll() {
		BaseDao dao = new BaseDao();
		// 获取session
		Session session = dao.getSession();
		// 获取查询对象
		Query query = session.createQuery(" from UserInfo");
		System.out.println(UserInfo.class.getName());
		List<UserInfo> list = query.list();
		System.out.println(list.size());
		session.close();
	}

	// 查询全部记录
	public static void testWhere() {
		BaseDao dao = new BaseDao();
		// 获取session
		Session session = dao.getSession();
		// 获取查询对象
		Query query = session.createQuery(" from UserInfo where userName like :userName order by createDate desc ");
		System.out.println(UserInfo.class.getName());
		//适用于使用？的方式
		//query.setParameter(0, "%flush%");
		//使用命名参数
		//query.setParameter("name", "%flush%");
//		Map<String,Object> param = new HashMap<String,Object>();
//		param.put("userName", "%flush%");
		UserInfo param = new UserInfo();
		param.setUserName("%flush%");
		query.setProperties(param);
		
		List<UserInfo> list = query.list();
		System.out.println(list.size());
		if(null!=list){
			for (UserInfo item : list) {
				System.out.println(item);
			}
		}
		session.close();
	}
	
	public  static void testUnique(){
		BaseDao dao = new BaseDao();
		// 获取session
		Session session = dao.getSession();
		// 获取查询对象
		Query query = session.createQuery("select count(u) from UserInfo u");
		int count = ((Number)query.uniqueResult()).intValue();
		System.out.println(count);
		session.close();
	}
	
	public static void testPage(){
		BaseDao dao = new BaseDao();
		// 获取session
		Session session = dao.getSession();
		// 获取查询对象
		Query query = session.createQuery(" from UserInfo where userName like :userName order by createDate desc ");
		System.out.println(UserInfo.class.getName());
		//适用于使用？的方式
		//query.setParameter(0, "%flush%");
		//使用命名参数
		//query.setParameter("name", "%flush%");
//		Map<String,Object> param = new HashMap<String,Object>();
//		param.put("userName", "%flush%");
		UserInfo param = new UserInfo();
		param.setUserName("%flush%");
		query.setProperties(param);
		query.setFirstResult(3);
		query.setMaxResults(3);
		List<UserInfo> list = query.list();
		System.out.println(list.size());
		if(null!=list){
			for (UserInfo item : list) {
				System.out.println(item);
			}
		}
		session.close();
	}
	
	public  static void testClo(){
		BaseDao dao = new BaseDao();
		// 获取session
		Session session = dao.getSession();
		// 获取查询对象
		Query query = session.createQuery("select new com.gdglc.spring.bean.auth.vo.ViewVo(u.id,u.userName) from UserInfo u");
		List list = query.list();
		if(null!=list){
			for (Object item : list) {
				System.out.println(item+":"+item.getClass());
			}
		}
		session.close();
	}
	
	public static void testUpdate(){
		BaseDao dao = new BaseDao();
		// 获取session
		Session session = dao.getSession();
		Transaction ts = session.beginTransaction();
		// 获取查询对象
		Query query = session.createQuery("update UserInfo u set u.userName = ? where u.userName = ?");
		query.setParameter(0, "accp123");
		query.setParameter(1, "accp");
		int count = query.executeUpdate();
		ts.commit();
		System.out.println(count);
		session.close();
	}
}
