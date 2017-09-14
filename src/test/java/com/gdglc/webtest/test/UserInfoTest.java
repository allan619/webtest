package com.gdglc.webtest.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.biz.auth.IUserBiz;
import com.gdglc.spring.exception.BizException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-hibernate.xml"})
public class UserInfoTest {
	@Autowired
	private IUserBiz userBiz;
	@Test
	public void add(){
		System.out.println(userBiz);
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("2016");
		try {
			userBiz.add(userInfo);
		} catch (BizException e) {
			e.printStackTrace();
			Assert.assertEquals(1, 0);
		}
	}
	
	@Test
	public void findPage(){
		System.out.println(userBiz);
		try {
			List<UserInfo> userList = userBiz.findByUser(null);
			Assert.assertNotNull(userList);
			Assert.assertEquals(2, userList.size());
		} catch (BizException e) {
			e.printStackTrace();
			Assert.assertEquals(1, 0);
		}
	}
	public static void main(String[] args) {
		System.out.println("123");
	}
}
