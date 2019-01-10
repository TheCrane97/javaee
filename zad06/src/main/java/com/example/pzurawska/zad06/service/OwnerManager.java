package com.example.pzurawska.zad06.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.example.pzurawska.zad06.domain.Horse;
import com.example.pzurawska.zad06.domain.Owner;




@Stateless
public class OwnerManager {

	@PersistenceContext
	EntityManager em;
	
	
	public void addOwner(Owner owner){	
		em.persist(owner);
	}
	
	public Owner getOwner(Long id){
		Owner retrieved = em.find(Owner.class, id);
		return retrieved;
	}

	
	@SuppressWarnings("unchecked")
	public List<Owner> getAll(){
		return em.createNamedQuery("owner.getAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Horse> getHorsesOfOwner(){
		return em.createNamedQuery("owner.getHorsesOfOwner").getResultList();
	}
	
	
	public void deletAll(){
		em.createNamedQuery("owner.deleteAll").executeUpdate();
	}
}
