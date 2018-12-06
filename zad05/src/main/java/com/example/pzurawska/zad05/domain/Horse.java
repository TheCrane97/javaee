package com.example.pzurawska.zad05.domain;

import javax.xml.bind.annotation.XmlRootElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
public class Horse {
	
	private String name;
	private String race;
	private Date dateOfBirth;
	private boolean doesSick;
	private double weight;
	
	public Horse(){}
	
	public Horse(String name, String race, Date dateOfBirth, boolean doesSick, double weight) {
		super();
		this.name = name;
		this.race = race;
		this.dateOfBirth = dateOfBirth;
		this.doesSick = doesSick;
		this.weight = weight;
	}
	
	
	public Horse(String name, String race, String date, boolean doesSick, double weight) {
		super();
		this.name = name;
		this.race = race;
		this.doesSick = doesSick;
		this.weight = weight;
		
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		this.dateOfBirth = null;
		try {
			dateOfBirth = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isDoesSick() {
		return doesSick;
	}

	public void setDoesSick(boolean doesSick) {
		this.doesSick = doesSick;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
