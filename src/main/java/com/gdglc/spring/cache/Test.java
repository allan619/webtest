package com.gdglc.spring.cache;
public class Test {
	public static void main(String[] args) {
		//SingletonHelper helper = new SingletonHelper();
		//System.out.println(DefaultCache.getInstance());
		//System.out.println(DefaultCache.getInstance());	
		new Thread(new Runnable() {
			@Override
			public void run() {
				DefaultCache cache = DefaultCache.getInstance();
				System.out.println(cache);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				DefaultCache cache = DefaultCache.getInstance();
				System.out.println(cache);
			}
		}).start();
	}
}
