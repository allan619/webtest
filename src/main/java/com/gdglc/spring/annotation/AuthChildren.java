package com.gdglc.spring.annotation;
@Auth(name="accp2")
public class AuthChildren extends AuthTest{
	
	@Override
	public void test(@Auth String name){
		System.out.println("hello"+name);
	}
}
