package com.example.pzurawska.zad06.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.pzurawska.zad06.domain.Horse;


@Stateless
public class HorseManager {
	
	@PersistenceContext
	EntityManager em;
	
	
	public void addHorse(Horse horse){	
		em.persist(horse);
	}
	
	public Horse getHorse(Long id){
		Horse retrieved = em.find(Horse.class, id);
		return retrieved;
	}

	
	@SuppressWarnings("unchecked")
	public List<Horse> getAll(){
		return em.createNamedQuery("horse.getAll").getResultList();
	}
	
	
	public void deletAll(){
		em.createNamedQuery("horse.deleteAll").executeUpdate();
	}

	/*public void addHorse(Horse horse) {
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
	}*/
	
}
