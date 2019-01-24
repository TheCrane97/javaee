package com.example.pzurawska.zad07.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.pzurawska.zad07.domain.Kon;
import com.example.pzurawska.zad07.domain.Wlasciciel;

@Stateless
public class KonManager {
	
	@PersistenceContext
	EntityManager em;
	
	
	
	
	public void addKon(Kon kon) {
		em.persist(kon);
	}

	public Kon updateKon(Kon kon, int id) {
		kon.setId(id);
		Kon stary = getKon(id);
		if(stary != null) {
			em.merge(kon);
		}
		return stary;
	}

	public void deleteKon(int id) {
		Kon kon = getKon(id);
		if(kon != null) {
			em.remove(kon);
		}
 	}

	public Kon getKon(int id) {
		return em.find(Kon.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Kon> getAllKon(){
		return em.createNamedQuery("kon.getAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Wlasciciel> getallperson(){
		return em.createNamedQuery("kon.wlasciciel").getResultList();
	}
	
	public void deleteAllKon(){
		em.createNamedQuery("kon.deleteAll").executeUpdate();
	}

}
