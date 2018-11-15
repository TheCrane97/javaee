package com.ug.pzurawska.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

	private String name;
	private String surname;
	private Date beginDate;
	private Date endDate;
	String frequency;
	private List<String> magazine = new ArrayList<String>();
	
	
	
	public User(String name,String surname, Date beginDate, Date endDate,String frequency) {
		super();
		this.name=name;
		this.surname = surname;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.frequency=frequency;
	}
	
	

	public String getFrequency() {
		return frequency;
	}



	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<String> getMagazine() {
		return magazine;
	}
	public void setMagazine(List<String> magazine) {
		this.magazine = magazine;
	}
	
	public void addMagazineToList(String magazine)
	{
		this.magazine.add(magazine);
	}
	
	
}
