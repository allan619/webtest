package com.gdglc.spring.mvc.converter;

import java.text.StringCharacterIterator;

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

	int i = 3;
	String str = new String("abc");
	
	public void add(int i){
		i = i+4;
	}
	
	public void change(String str){
		str = str+"11";
	}
	
	public static void main(String[] args) {
		StringToIntConverter converter = new StringToIntConverter();
		converter.add(converter.i);
		converter.change(converter.str);
		System.out.println(converter.i);
		System.out.println(converter.str);
	}
}
