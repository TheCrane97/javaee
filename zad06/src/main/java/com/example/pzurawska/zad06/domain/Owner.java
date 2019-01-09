package com.example.pzurawska.zad06.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "owner.getAll", query = "Select o from Owner o"),
        @NamedQuery(name = "owner.deleteAll", query="Delete from Owner ")
})
public class Owner {
	
	private int id;
	private String name;
	private String surname;
	
	private List<Horse> horses = new ArrayList<>();
	
	
	public Owner() {}
	
	public Owner(String name,String surname)
	{
		this.name=name;
		this.surname=surname;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }
	

}
