package com.example.pzurawska.zad07.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "horse.getAll", query = "Select h from Horse h"),
        @NamedQuery(name = "horse.deleteAll", query="Delete from Horse "),
        @NamedQuery(name="horse.getByIdentity", query="Select h from Horse h where h.id=:id"),
        @NamedQuery(name="horse.getByOwner", query="Select h.owner from Horse h where h.id=:id"),
        @NamedQuery(name="horse.Owner", query="Select o from Owner o")
})
public class Horse {
	
	private int id;
	private String name;
	private Date dateOfBirth;
	private boolean sick;
	private double weight;
    private Race race;
    private Identity identity;
    private List<Owner> owner = new ArrayList<>();
    

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
    @ManyToOne(fetch = FetchType.EAGER) //
	@JoinColumn(name = "race_id", nullable = false)
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "identity_id", unique=true)
	public Identity getIdentity() {
		return identity;
	}
	

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	
	@ManyToMany(fetch=FetchType.EAGER) //
	@JsonIgnoreProperties({"horse"})
	public List<Owner> getOwner() {
		return owner;
	}
	
	@JsonProperty
	public void setOwner(List<Owner> owner) {
		this.owner = owner;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isSick() {
		return sick;
	}

	public void setSick(boolean sick) {
		this.sick = sick;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	
    
    
    

}
