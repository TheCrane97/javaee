package com.ug.pzurawska.domain;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Newsletter {

	private String imie="";
	private Date odKiedy=new Date();
	private Date doKiedy =new Date();
	private String czestotliwosc="";
	private String magazyny="";
	
	
	public Newsletter(String imie, Date odKiedy, Date doKiedy, String czestotliwosc, String magazyny) {
		super();
		this.imie = imie;
		this.odKiedy = odKiedy;
		this.doKiedy = doKiedy ;
		this.czestotliwosc = czestotliwosc;
		this.magazyny = magazyny;
	}
	
	public Newsletter(){	}
	
	public Newsletter(String imie, String odKiedy, String doKiedy, String czestotliwosc, String magazyny) {
		super();
		this.imie = imie;
		
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		this.odKiedy = null;
		this.doKiedy = null;
		try {
			this.odKiedy = formatter.parse(odKiedy);
			this.doKiedy = formatter.parse(doKiedy);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.czestotliwosc = czestotliwosc;
		this.magazyny = magazyny;
	}

	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie = imie;
	}


	public Date getOdKiedy() {
		return odKiedy;
	}

	public String getOdKiedyString() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(odKiedy);		
		return s;
	}

	public void setOdKiedy(Date odKiedy) {
		this.odKiedy = odKiedy;
	}


	public Date getDoKiedy() {
		return doKiedy;
	}

	public String getDoKiedyString() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(doKiedy);		
		return s;
	}

	public void setDoKiedy(Date doKiedy) {
		this.doKiedy = doKiedy;
	}


	public String getCzestotliwosc() {
		return czestotliwosc;
	}


	public void setCzestotliwosc(String czestotliwosc) {
		this.czestotliwosc = czestotliwosc;
	}


	public String getMagazyny() {
		return magazyny;
	}


	public void setMagazyny(String magazyny) {
		this.magazyny = magazyny;
	}
	
	
}
