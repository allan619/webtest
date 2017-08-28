package com.gdglc.spring.bean.other.vo;

import java.io.Serializable;

public class PointVo implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = 983876772240144127L;
	private double xpoint;
	private double ypoint;
	public double getXpoint() {
		return xpoint;
	}
	public void setXpoint(double xpoint) {
		this.xpoint = xpoint;
	}
	public double getYpoint() {
		return ypoint;
	}
	public void setYpoint(double ypoint) {
		this.ypoint = ypoint;
	}
	@Override
	public String toString() {
		return "PointVo [xpoint=" + xpoint + ", ypoint=" + ypoint + "]";
	}
	
	
}
