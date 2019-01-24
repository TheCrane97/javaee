package com.example.pzurawska.zad07.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.pzurawska.zad07.domain.Wlasciciel;

@Stateless
public class WlascicielManager {
	
	 @PersistenceContext
	    EntityManager em;
	    
	    
	    public void addWlasciciel(Wlasciciel wlasciciel) {
	        em.persist(wlasciciel);
	    }

	    public Wlasciciel updateWlasciciel(Wlasciciel wlasciciel, int id) {
	    	wlasciciel.setId(id);
	    	Wlasciciel stary = getWlasciciel(id);
	        if(stary != null) {
	            em.merge(wlasciciel);
	        }
	        return stary;
	    }

	    public void deleteWlasciciel(int id) {
	    	Wlasciciel wlasciciel = getWlasciciel(id);
	        if(wlasciciel != null) {
	            em.remove(wlasciciel);
	        }
	    }

	    public Wlasciciel getWlasciciel(int id) {
	        return em.find(Wlasciciel.class, id);
	    }

	    @SuppressWarnings("unchecked")
	    public List<Wlasciciel> getAllWlasciciel() {
	        return em.createNamedQuery("wlasciciel.getAll").getResultList();
	    }

	    @SuppressWarnings("unchecked")
	    public void deleteAllWlasciciel(){
	        em.createNamedQuery("wlasciciel.deleteAll").executeUpdate();
	    }   

}
