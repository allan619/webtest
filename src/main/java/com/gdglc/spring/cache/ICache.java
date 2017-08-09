package com.gdglc.spring.cache;

public interface ICache {
	/**
	 * 添加缓存对象
	 * @param key 键
	 * @param value 值
	 */
	public void put(String key,Object value);
	
	public Object get(String key);
	
	public void remove(String key);

}
