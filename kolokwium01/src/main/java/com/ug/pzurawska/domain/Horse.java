package com.ug.pzurawska.domain;

import java.util.Date;

public class Horse {
	
	private String name;
	private String race;
	private Date dateOfBirth;
	private boolean doesSick;
	private double weight;
	
	public Horse(String name, String race, Date dateOfBirth, boolean doesSick, double weight) {
		super();
		this.name = name;
		this.race = race;
		this.dateOfBirth = dateOfBirth;
		this.doesSick = doesSick;
		this.weight = weight;
	}

	public Horse() {
		super();
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
