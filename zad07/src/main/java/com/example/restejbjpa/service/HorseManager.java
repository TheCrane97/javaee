package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Horse;
import com.example.restejbjpa.domain.Person;
@Stateless
public class HorseManager {


	@PersistenceContext
	EntityManager em;
	
	public void addHorse(Horse horse){	
		em.persist(horse);
	}
	
	public Horse getHorse(String name){
		Horse retrieved = em.find(Horse.class, name);
		return retrieved;
	}
	
	public List<Person> getOwnersOfHorse(String name){
		Horse retrieved = em.find(Horse.class, name);
		List<Person> result = new ArrayList<>(retrieved.getOwners());
		return result;
	}
		
//	@SuppressWarnings("unchecked")
//	public List<Object[]> getBookOfAuthrByAuthorName(String firstName){		
//		return em.createNamedQuery("bookAuthor.findByAthorFirstName").setParameter("firstName", firstName).getResultList();
//	}
	
	@SuppressWarnings("unchecked")
	public List<Horse> getAll(){
		return em.createNamedQuery("horse.all").getResultList();
	}
	
	
	public void deletAll(){
		em.createNamedQuery("horse.delete.all").executeUpdate();
	}
}
