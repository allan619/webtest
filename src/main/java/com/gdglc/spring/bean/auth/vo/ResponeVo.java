package com.gdglc.spring.bean.auth.vo;

import java.io.Serializable;

public class ResponeVo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 8357191209469964225L;
	public static final int SUCESS = 1; 
	public static final int ERROR = 2; 
	/**
	 * 响应编码，1：正常执行 2:非正常执行
	 */
	private int code = 1;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
