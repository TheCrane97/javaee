package com.ug.pzurawska.domain;

import java.util.Date;

public class Bottle {
	
	private String nazwa="";
	private Date dataProdukcji=new Date();
	private double pojemnosc=0.0;
	private String coWsrodku="";
	private String naklejki="";
	
	
	
	public Bottle(String nazwa, Date dataProdukcji, double pojemnosc, String coWsrodku, String naklejki) {
		super();
		this.nazwa = nazwa;
		this.dataProdukcji = dataProdukcji;
		this.pojemnosc = pojemnosc;
		this.coWsrodku = coWsrodku;
		this.naklejki = naklejki;
	}

	public Bottle() {}

	public String getNazwa() {
		return nazwa;
	}



	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}



	public Date getDataProdukcji() {
		return dataProdukcji;
	}



	public void setDataProdukcji(Date dataProdukcji) {
		this.dataProdukcji = dataProdukcji;
	}



	public double getPojemnosc() {
		return pojemnosc;
	}



	public void setPojemnosc(double pojemnosc) {
		this.pojemnosc = pojemnosc;
	}



	public String getCoWsrodku() {
		return coWsrodku;
	}



	public void setCoWsrodku(String coWsrodku) {
		this.coWsrodku = coWsrodku;
	}



	public String getNaklejki() {
		return naklejki;
	}



	public void setNaklejki(String naklejki) {
		this.naklejki = naklejki;
	}
	
	
	
	
	
	
	
	
}
