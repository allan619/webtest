package com.gdglc.spring.exception;

public class BizException extends Exception{
	/** serialVersionUID */
	private static final long serialVersionUID = -3279697287941987257L;
	public BizException(){
		
	}
	public BizException(String message){
		super(message);
	}
	
	public BizException(String message,Throwable e){
		super(message,e);
	}
}
