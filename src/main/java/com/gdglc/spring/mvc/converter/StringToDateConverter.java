package com.gdglc.spring.mvc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>{
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	{
		dateFormat.setLenient(false);
	}
	@Override
	public Date convert(String source) {
		System.out.println("字符串转换为时间");
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Could not convert String [" + source + "] of type [" +
					source.getClass().getName() + "] to  target class [" + Date.class.getName() + "]");
		}
	}
	


}
