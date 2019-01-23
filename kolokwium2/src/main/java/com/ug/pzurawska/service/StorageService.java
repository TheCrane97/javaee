package com.ug.pzurawska.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ug.pzurawska.domain.Bottle;


public class StorageService {
	
	private List<Bottle> db = new ArrayList<Bottle>();
	private List<Bottle> koszyk = new ArrayList<Bottle>();
	
	
	
	public void Add(Bottle bottle){
		db.add(bottle);
	}
	
	public void AddToKoszyk(Bottle bottle){
		koszyk.add(bottle);
	}
	
	public List<Bottle> GetAll(){
		return db;
	}
	
	public List<Bottle> GetKoszyk(){
		return koszyk;
	}
	

	public Bottle Find(String name)
	{
		 for (Bottle bottle : db) {
		        if (bottle.getNazwa().equals(name)) {
		            return bottle;
		        }
		    }
		 return null;
		
	}
	
	public Bottle Find(long id)
	{
		 for (Bottle bottle : db) {
		        if (bottle.getId()==id) {
		            return bottle;
		        }
		    }
		 return null;
		
	}
	
	
	
	private Map<Long, Bottle> koszyczek = new HashMap<Long, Bottle>();

	public void add(Bottle bottle) {
		Bottle newbottle = new Bottle(bottle.getNazwa(),bottle.getDataProdukcji(),bottle.getPojemnosc(),bottle.getCoWsrodku(),bottle.getNaklejki());
		koszyczek.put(newbottle.getId(), newbottle);
	}

	public Map<Long, Bottle> getAllFromKoszyk(){
		return koszyczek;
	}
	
	
}