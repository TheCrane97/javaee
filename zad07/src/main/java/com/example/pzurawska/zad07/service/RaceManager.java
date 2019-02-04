package com.example.pzurawska.zad07.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.pzurawska.zad07.domain.Race;



@Stateless
public class RaceManager {
	

	  @PersistenceContext
	    EntityManager em;

	  
	  public void addRace(Race race) {
	        em.persist(race);
	  }

	   public Race updateRace(Race race, int id) {
	        race.setId(id);
	        Race old = getRace(id);
	        if(old != null) {
	            em.merge(race);
	        }
	        return old;
	   }  
	   
	   public void deleteRace(int id) {
		   Race race = getRace(id);
	        if(race != null) {
	            em.remove(race);
	        }
	    }
	   
	    public Race getRace(int id) {
	        return em.find(Race.class, id);
	    }	   
	    
	    
	    @SuppressWarnings("unchecked")
	    public List<Race> getAllRace() {
	        return em.createNamedQuery("race.getAll").getResultList();
	    }	    

	    @SuppressWarnings("unchecked")
	    public void deleteAllRace(){
	        em.createNamedQuery("race.deleteAll").executeUpdate();
	    }	    

}
