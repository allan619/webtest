package com.gdglc.spring.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	public static String formate(Date date){
		if(null==date){
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		return format.format(date);
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.formate(new Date()));
	}
}
