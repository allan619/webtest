package com.gdglc.spring.annotation;
@Auth(name="accp",value="authKey")
public class AuthTest {
	@Auth
	private String name;
	@Auth(name="fanfa",value="abc")
	public void test(@Auth String name){
		System.out.println(name);
	}
}
