package com.example.pzurawska.zad07.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.pzurawska.zad07.domain.Identity;


@Stateless
public class IdentityManager {


	 @PersistenceContext
	 EntityManager em;

	
	
	 
	    public void addIdentity(Identity identity) {
	        em.persist(identity);
	    }

	    public Identity updateIdentity(Identity identity, int id) {
	    	identity.setId(id);
	        Identity old = getIdentity(id);
	        if(old != null) {
	            em.merge(identity);
	        }
	        return old;
	    }

	    
	    public void deleteIdentity(int id) {
	    	Identity number = getIdentity(id);
	        if(number != null) {
	            em.remove(number);
	        }
	    }

	    public Identity getIdentity(int id) {
	        return em.find(Identity.class, id);
	    }

	    @SuppressWarnings("unchecked")
	    public List<Identity> getAllIdentity() {
	        return em.createNamedQuery("identity.getAll").getResultList();
	    }

	    @SuppressWarnings("unchecked")
	    public void deleteAllIdentity(){
	        em.createNamedQuery("identity.deleteAll").executeUpdate();
	    }
	 
}
