package com.example.restejbjpa.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "horse.all", query = "Select h from Horse h"),
	@NamedQuery(name = "horse.delete.all", query = "Delete from Horse "),
	@NamedQuery(name = "horse.findByName", query = "Select h from Horse h where h.name = :name"),
	@NamedQuery(name = "horsePerson.findHorsesByOwners",
	query = "Select p.firstName, p.lastName, h.name, h.race from Horse h JOIN h.owners p where p.firstName = :firstName")

	})
public class Horse {

	private String name;
	private String race;
	private Date dateOfBirth;
	private boolean doesSick;
	private double weight;
	private List<Person> owners = new ArrayList<>();
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
	
	
	@ManyToMany(mappedBy = "horses", fetch = FetchType.EAGER)
	public List<Person> getOwners() {
		return owners;
	}

	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}
}
