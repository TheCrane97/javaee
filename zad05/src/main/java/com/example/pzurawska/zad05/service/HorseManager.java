package com.example.pzurawska.zad05.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.pzurawska.zad05.domain.Horse;


@Singleton
public class HorseManager {
	
	private List<Horse> db = Collections.synchronizedList(new ArrayList<>());

	public void addHorse(Horse horse) {
		db.add(horse);
	}

	public void deleteHorse(Horse horse){
		db.remove(horse);
 	}
	
	public Horse getHorse(String name) {
		
		for(Horse horse: db)
		{
			if(horse.getName().equals(name))
				return horse;
			
		}
		return new Horse("Nie znaleziono konia", "Nie znaleziono konia", "0000-00-00", false, 0);
	}
	
	public List<Horse> getAllHorses(){
		return db;
	}
	
	public void deleteAllHorses(){
		db.clear();
	}
	
}
