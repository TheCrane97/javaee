package com.example.pzurawska.zad07.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "owner.getAll", query = "Select o from Owner o"),
        @NamedQuery(name = "owner.deleteAll", query="Delete from Owner "),
        @NamedQuery(name = "owner.getHorsesOfOwner", query="Select o.horses from Owner o where o.firstname=:firstname")
})
public class Owner {
	
	private int id;
	private String firstname;
	private String lastname;
	
	private List<Horse> horses = new ArrayList<>();
	
	
	public Owner() {}
	
	public Owner(String firstname,String lastname)
	{
		this.firstname=firstname;
		this.lastname=lastname;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }
	

}
