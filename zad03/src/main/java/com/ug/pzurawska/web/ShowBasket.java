package com.ug.pzurawska.web;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ug.pzurawska.domain.Horse;
import com.ug.pzurawska.service.StorageService;

@WebServlet("/showBasket")
public class ShowBasket extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
		
		out.append("<html><body><h2>Koszyk: </h2><br/>");
		
		if(request.getParameter("name")!=null) 
		{
			StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
			String name = request.getParameter("name");
			Horse horse = ss.getHorse(name);
			ss.addToBasket(horse);
			
			List<Horse> allHorses = ss.getBasket();
		
	
			for (Horse horseInBasket: allHorses) {
				out.append("<p>Imie: " + horseInBasket.getName() + "</p>");
				out.append("<p>Rasa: " + horseInBasket.getRace() + "</p>");
				out.append("<p>Data urodzenia: " + horseInBasket.getDateOfBirth() + "</p>");
				out.append("<p>Waga: " + horseInBasket.getWeight() + "</p>");
				out.append("<p>Czy chory?: " + horseInBasket.isDoesSick() + "</p><br>");
			}
		}else
		{
			StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
			List<Horse> allHorses = ss.getBasket();
			
			
			for (Horse horseInBasket: allHorses) {
				out.append("<p>Imie: " + horseInBasket.getName() + "</p>");
				out.append("<p>Rasa: " + horseInBasket.getRace() + "</p>");
				out.append("<p>Data urodzenia: " + horseInBasket.getDateOfBirth() + "</p>");
				out.append("<p>Waga: " + horseInBasket.getWeight() + "</p>");
				out.append("<p>Czy chory?: " + horseInBasket.isDoesSick() + "</p><br>");
			}
			
			
			
		}
		out.append("<a href='/zad03/'>Przejdz do Start</a></body></html>");
		out.close();

	
		
		}
	
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}

}
