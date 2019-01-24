package com.example.pzurawska.zad07.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.pzurawska.zad07.domain.Identyfikator;


@Stateless
public class IdentyfikatorManager {


	 @PersistenceContext
	 EntityManager em;

	
	
	 
	    public void addIdentyfikator(Identyfikator identyfikator) {
	        em.persist(identyfikator);
	    }

	    public Identyfikator updateIdentyfikator(Identyfikator identyfikator, int id) {
	    	identyfikator.setId(id);
	        Identyfikator stary = getIdentyfikator(id);
	        if(stary != null) {
	            em.merge(identyfikator);
	        }
	        return stary;
	    }

	    
	    public void deleteIdentyfikator(int id) {
	    	Identyfikator number = getIdentyfikator(id);
	        if(number != null) {
	            em.remove(number);
	        }
	    }

	    public Identyfikator getIdentyfikator(int id) {
	        return em.find(Identyfikator.class, id);
	    }

	    @SuppressWarnings("unchecked")
	    public List<Identyfikator> getAllIdentyfikator() {
	        return em.createNamedQuery("identyfikator.getAll").getResultList();
	    }

	    @SuppressWarnings("unchecked")
	    public void deleteAllIdentyfikator(){
	        em.createNamedQuery("identyfikator.deleteAll").executeUpdate();
	    }
	 
}
