package com.gdglc.spring.exception;

public class UpdateException extends BizException{
	/** serialVersionUID */
	private static final long serialVersionUID = 490801476256516881L;
	public UpdateException(){
		
	}
	public UpdateException(String message){
		super(message);
	}
	
	public UpdateException(String message,Throwable e){
		super(message,e);
	}
}
