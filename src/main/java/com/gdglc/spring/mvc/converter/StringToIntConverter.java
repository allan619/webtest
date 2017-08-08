package com.gdglc.spring.mvc.converter;

import org.springframework.core.convert.converter.Converter;

import com.mysql.jdbc.StringUtils;


public class StringToIntConverter implements Converter<String, Integer>{

	@Override
	public Integer convert(String source) {
		System.out.println("转换int");
		if(StringUtils.isEmptyOrWhitespaceOnly(source)){
			return 0;
		}
		return Integer.parseInt(source);
	}

}
