package com.ug.pzurawska.domain;

import java.util.Date;

public class Bottle {
	
	private String nazwa="";
	private Date dataProdukcji=new Date();
	private double pojemnosc=0.0;
	private String coWsrodku="";
	private boolean pekniete;
	
	
	
	public Bottle(String nazwa, Date dataProdukcji, double pojemnosc, String coWsrodku, boolean pekniete) {
		super();
		this.nazwa = nazwa;
		this.dataProdukcji = dataProdukcji;
		this.pojemnosc = pojemnosc;
		this.coWsrodku = coWsrodku;
		this.pekniete = pekniete;
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



	public boolean isPekniete() {
		return pekniete;
	}



	public void setPekniete(boolean pekniete) {
		this.pekniete = pekniete;
	}
	
	
	
	
	
	
	
	
}
