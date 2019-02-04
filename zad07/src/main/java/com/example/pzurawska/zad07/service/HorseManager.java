package com.example.pzurawska.zad07.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.pzurawska.zad07.domain.Horse;
import com.example.pzurawska.zad07.domain.Owner;

@Stateless
public class HorseManager {
	
	@PersistenceContext
	EntityManager em;
	
	
	
	
	public void addHorse(Horse horse) {
		em.persist(horse);
	}

	public Horse updateHorse(Horse horse, int id) {
		horse.setId(id);
		Horse old = getHorse(id);
		if(old != null) {
			em.merge(horse);
		}
		return old;
	}

	public void deleteHorse(int id) {
		Horse horse = getHorse(id);
		if(horse != null) {
			em.remove(horse);
		}
 	}

	public Horse getHorse(int id) {
		return em.find(Horse.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Horse> getAllHorses(){
		return em.createNamedQuery("horse.getAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwners(){
		return em.createNamedQuery("horse.Owner").getResultList();
	}
	
	public void deleteAllHorses(){
		em.createNamedQuery("horse.deleteAll").executeUpdate();
	}

}
