package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Horse;
import com.example.restejbjpa.domain.Person;

@Stateless
public class PersonManager {	
	
	@PersistenceContext
	EntityManager em;
	
	public Person getPerson(Long id){
		return em.find(Person.class, id);
	}
	
	public Horse getHorse(String name){
		return em.find(Horse.class, name);
	}
	
	public Horse updateHorse(Horse horse){
		return em.merge(horse);
	}

	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons(){
		return em.createNamedQuery("person.getAll").getResultList();
	}
	
	public void addPerson(Person person){
		em.persist(person);		
	}
	
	public void clearPersons(){
		em.createNamedQuery("person.deleteAll").executeUpdate();
	}

}
