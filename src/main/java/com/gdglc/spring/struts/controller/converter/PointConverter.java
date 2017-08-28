package com.gdglc.spring.struts.controller.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.gdglc.spring.bean.other.vo.PointVo;

public class PointConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(null!=values&&values.length>0){
			String value = values[0];
			value = value.replaceAll("，", ",");
			String[] split = value.split(",");
			if(split.length==2){
				double xpoint = doubleValue(split[0]);
				double ypoint = doubleValue(split[1]);
				PointVo point = new PointVo();
				point.setXpoint(xpoint);
				point.setYpoint(ypoint);
				return point;
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		PointVo point = (PointVo)o;
		return point.getXpoint()+","+point.getYpoint();
	}
	
	public static void main(String[] args) {
		String value = "23.56，48.89";
		value = value.replaceAll("，", ",");
		String[] split = value.split(",");
		if(split.length==2){
			double xpoint = doubleValue(split[0]);
			double ypoint = doubleValue(split[1]);
			PointVo point = new PointVo();
			point.setXpoint(xpoint);
			point.setYpoint(ypoint);
			System.out.println(point);
		}
	}

}
