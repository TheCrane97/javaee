package com.example.pzurawska.zad07.domain;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@NamedQueries({
        @NamedQuery(name = "owner.getAll", query = "Select o from Owner o"),
        @NamedQuery(name = "owner.deleteAll", query="Delete from Owner "),
        @NamedQuery(name="owner.getById", query="Select o from Owner o where o.id=:id"),
})
public class Owner {
	
	private int id;
	private String name;
	private String surname;
	private List<Horse> horse = new ArrayList<>();
		

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="owner")
	@JsonIgnoreProperties("owner")
	public List<Horse> getHorse() {
		return horse;
	}
	
	@JsonProperty
	public void setHorse(List<Horse> horse) {
		this.horse = horse;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
