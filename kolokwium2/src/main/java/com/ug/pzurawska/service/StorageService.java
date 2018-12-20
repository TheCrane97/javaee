package com.ug.pzurawska.service;

import java.util.ArrayList;
import java.util.List;

import com.ug.pzurawska.domain.Bottle;


public class StorageService {
	
	private List<Bottle> db = new ArrayList<Bottle>();
	private List<Bottle> koszyk = new ArrayList<Bottle>();
	
	public void Add(Bottle bottle){
		db.add(bottle);
	}
	
	
	public List<Bottle> GetAll(){
		return db;
	}
	
	public List<Bottle> GetAllZKoszyk(){
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
	
	public void AddToKoszyk(Bottle bottle){
		db.add(bottle);
	}
	
	
	
}