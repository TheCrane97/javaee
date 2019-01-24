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
        @NamedQuery(name = "rasa.getAll", query = "Select r from Rasa r"),
        @NamedQuery(name = "rasa.deleteAll", query="Delete from Rasa "),

})
public class Rasa {
	
	private int id;
	private String nazwa;
	private String opis;
	
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	


	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	
	
	
}
