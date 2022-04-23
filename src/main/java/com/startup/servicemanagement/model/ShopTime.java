package com.startup.servicemanagement.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ShopTime {
	
	private String weekDays;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date endDate;
	
	public String getWeekDays() {
		return weekDays;
	}
	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	

}
