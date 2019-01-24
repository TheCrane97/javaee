package com.example.pzurawska.zad07.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.pzurawska.zad07.domain.Rasa;



@Stateless
public class RasaManager {
	

	  @PersistenceContext
	    EntityManager em;

	  
	  public void addRasa(Rasa rasa) {
	        em.persist(rasa);
	  }

	   public Rasa updateRasa(Rasa rasa, int id) {
	        rasa.setId(id);
	        Rasa stary = getRasa(id);
	        if(stary != null) {
	            em.merge(rasa);
	        }
	        return stary;
	   }  
	   
	   public void deleteRasa(int id) {
		   Rasa rasa = getRasa(id);
	        if(rasa != null) {
	            em.remove(rasa);
	        }
	    }
	   
	    public Rasa getRasa(int id) {
	        return em.find(Rasa.class, id);
	    }	   
	    
	    
	    @SuppressWarnings("unchecked")
	    public List<Rasa> getAllRasa() {
	        return em.createNamedQuery("rasa.getAll").getResultList();
	    }	    

	    @SuppressWarnings("unchecked")
	    public void deleteAllRasa(){
	        em.createNamedQuery("rasa.deleteAll").executeUpdate();
	    }	    

}
