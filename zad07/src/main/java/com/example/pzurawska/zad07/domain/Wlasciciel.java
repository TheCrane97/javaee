package com.example.pzurawska.zad07.domain;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@NamedQueries({
        @NamedQuery(name = "wlasciciel.getAll", query = "Select w from Wlasciciel w"),
        @NamedQuery(name = "wlasciciel.deleteAll", query="Delete from Wlasciciel "),
        @NamedQuery(name="wlasciciel.getById", query="select w from Wlasciciel w where w.id=:id"),
})
public class Wlasciciel {
	
	private int id;
	private String imie;
	private String nazwisko;
	private List<Kon> kon = new ArrayList<>();
		



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="wlasciciel")
	@JsonIgnoreProperties("wlasciciel")
	public List<Kon> getKon() {
		return kon;
	}
	@JsonProperty
	public void setKon(List<Kon> kon) {
		this.kon = kon;
	}
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	
}
