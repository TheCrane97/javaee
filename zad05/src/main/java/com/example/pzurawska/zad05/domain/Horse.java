package com.example.pzurawska.zad05.domain;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.restwsdemo.domain.Person;

import java.util.Date;

@XmlRootElement
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
