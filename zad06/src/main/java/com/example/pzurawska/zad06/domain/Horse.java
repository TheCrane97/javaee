package com.example.pzurawska.zad06.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "horse.getAll", query = "Select h from Horse h"),
        @NamedQuery(name = "horse.deleteAll", query="Delete from Horse ")
})
public class Horse {
	
	private int id;
	private String name;
	private String race;
	private Date dateOfBirth;
	private boolean doesSick;
	private double weight;

    
	public Horse(){}
	
	public Horse(String name, String race, Date dateOfBirth, boolean doesSick, double weight) {
		this.name = name;
		this.race = race;
		this.dateOfBirth = dateOfBirth;
		this.doesSick = doesSick;
		this.weight = weight;
	}
	
	
	public Horse(String name, String race, String date, boolean doesSick, double weight) {
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
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
