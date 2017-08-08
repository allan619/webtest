package com.gdglc.spring.cache;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.validation.constraints.Pattern.Flag;

public class DefaultCache implements ICache{
	private  Map<String, Object> cacheMap;
	private volatile static DefaultCache instance ;
	
	private  DefaultCache(){
		System.out.println("create DefaultCache");
		cacheMap = new HashMap<String, Object>();
	}
	
	private  static class SingletonHelper{
		static{
			System.out.println("SingletonHelper");
		}
		private static final DefaultCache CACHE = new DefaultCache();
	}
	/**
	 * 懒汉＋饿汉模式
	 * @return
	 */
//	public static  DefaultCache getInstance(){
//		instance = SingletonHelper.CACHE;
//		return instance;
//	}
	
	public static  DefaultCache getInstance(){
		if(null==instance){
			synchronized (DefaultCache.class) {
				if(null==instance){
					instance = new DefaultCache();
				}
			}
		}
		return instance;
	}
	
	@Override
	public void put(String key, Object value) {
		cacheMap.put(key, value);
	}

	@Override
	public Object get(String key) {	
		return cacheMap.get(key);
	}

	@Override
	public void remove(String key) {
		cacheMap.remove(key);
	}
	
	public volatile static boolean flag;
	
	public static void main(String[] args) {
		System.out.println(DefaultCache.class);
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for(;;){
//					if(flag==!flag){
//						System.out.println("!-");
//						System.exit(1);
//					}
//					try {
//						Thread.sleep(1);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		}).start();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				int i = 0;
//				for(;;){
//					System.out.println(i++);
//					flag = !flag;
//				}
//			}
//		}).start();
	}
	
	
	

}
