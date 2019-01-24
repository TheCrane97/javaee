package com.example.pzurawska.zad07.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "identyfikator.getAll", query = "Select i from Identyfikator i"),
        @NamedQuery(name = "identyfikator.deleteAll", query="Delete from Identyfikator "),

})
public class Identyfikator {
	
	private int id;
	private String identyfikator;
	
	




	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public String getIdentyfikator() {
		return identyfikator;
	}
	public void setIdentyfikator(String identyfikator) {
		this.identyfikator = identyfikator;
	}
	
	

}
