package com.example.pzurawska.zad07.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Bet {

	private int id;
	private Horse horse;
	private Person person;
	private double price;
	
	
	public Bet(Horse horse,Person person, double price)
	{
		this.horse=horse;
		this.person=person;
		this.price=price;
	}
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Horse getHorse() {
		return horse;
	}
	public void setHorse(Horse horse) {
		this.horse = horse;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
