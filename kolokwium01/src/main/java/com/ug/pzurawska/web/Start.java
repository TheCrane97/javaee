package com.ug.pzurawska.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ug.pzurawska.domain.Horse;
import com.ug.pzurawska.service.StorageService;

@WebServlet("/start")
public class Start extends HttpServlet {

	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");

	        PrintWriter out = response.getWriter();
	        out.println("<html><body><h1>Sklep Koni</h1> <br>" +
	                "Menu: <br>" +
	                "<ul>" +
	                "<li><a href='/zad04/addHorse'>Dodaj Konia</a></li>" +
	                "<li><a href='/zad04/showHorses'>Wyswietl Konie</a></li>" +
	                "<li><a href='/zad04/showBasket'>Twoj Koszyk</a></li>" +
	                "</ul>" +
	                "</body></html>");
	        out.close();
	    }
}
