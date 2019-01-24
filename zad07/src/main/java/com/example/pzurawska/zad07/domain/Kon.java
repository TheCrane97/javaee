package com.example.pzurawska.zad07.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "kon.getAll", query = "Select k from Kon k"),
        @NamedQuery(name = "kon.deleteAll", query="Delete from Kon "),
        @NamedQuery(name="kon.getById", query="Select k from Kon k where k.id=:id"),
        @NamedQuery(name="kon.getBywlasciciel", query="select k.wlasciciel from Kon k where k.id=:id"),
        @NamedQuery(name="kon.wlasciciel", query="Select w from Wlasciciel w")
})
public class Kon {
	
	private int id;
	private String imie;
	private Date rokUrodzenia;
	private boolean czyChory;
	private double waga;
    private Rasa rasa;
    private Identyfikator identyfikator;
    private List<Wlasciciel> wlasciciel = new ArrayList<>();
    

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
    @ManyToOne(fetch = FetchType.EAGER) //
	@JoinColumn(name = "rasa_id", nullable = false)
	public Rasa getRasa() {
		return rasa;
	}
	public void setRasa(Rasa rasa) {
		this.rasa = rasa;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "identyfikator_id", unique=true)
	public Identyfikator getIdentyfikator() {
		return identyfikator;
	}
	public void setIdentyfikator(Identyfikator identyfikator) {
		this.identyfikator = identyfikator;
	}
	
	@ManyToMany(fetch=FetchType.EAGER) //
	@JsonIgnoreProperties({"kon"})
	public List<Wlasciciel> getWlasciciel() {
		return wlasciciel;
	}
	
	@JsonProperty
	public void setWlasciciel(List<Wlasciciel> wlasciciel) {
		this.wlasciciel = wlasciciel;
	}
	

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Date getRokUrodzenia() {
		return rokUrodzenia;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public void setRokUrodzenia(Date rokUrodzenia) {
		this.rokUrodzenia = rokUrodzenia;
	}

	public boolean isCzyChory() {
		return czyChory;
	}

	public void setCzyChory(boolean czyChory) {
		this.czyChory = czyChory;
	}

	public double getWaga() {
		return waga;
	}

	public void setWaga(double waga) {
		this.waga = waga;
	}

	
    
    
    

}
