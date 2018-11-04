package com.ug.pzurawska.service;

import java.util.ArrayList;
import java.util.List;

import com.ug.pzurawska.domain.Horse;

public class StorageService {
	
	private List<Horse> db = new ArrayList<Horse>();
	private List<Horse> basket = new ArrayList<Horse>();
	
	public void add(Horse horse){
		Horse newhorse = new Horse(horse.getName(),horse.getRace(),horse.getDateOfBirth(),horse.isDoesSick(),horse.getWeight());
		db.add(newhorse);
	}
	
	public void addToBasket(Horse horse){
		Horse newhorse = new Horse(horse.getName(),horse.getRace(),horse.getDateOfBirth(),horse.isDoesSick(),horse.getWeight());
		basket.add(newhorse);
	}
	
	public List<Horse> getAllHorses(){
		return db;
	}
	
	public List<Horse> getBasket(){
		return basket;
	}

	public Horse getHorse(String name) {
		
		Horse horse;
		
		for(int i=0;i<=db.size()+1;i++)
		{
			horse = db.get(i);
			if(horse.getName().equals(name))
				return horse;	
		}
		
		return null;
	}

}
