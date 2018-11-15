package com.ug.pzurawska.web;

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

@WebServlet("/showHorses")
public class ShowAllHorses extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		if(request.getParameter("name")!=null && request.getParameter("race")!=null && request.getParameter("dateOfBirth")!=null && request.getParameter("weight")!=null)
		{

			String name = request.getParameter("name");
			String race = request.getParameter("race");
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			Date dateOfBirth = null;
			try {
				dateOfBirth = formatter.parse(request.getParameter("dateOfBirth"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			double weight = Double.parseDouble(request.getParameter("weight"));
			boolean doesSick = Boolean.parseBoolean(request.getParameter("doesSick"));

			Horse newHorse = new Horse(name,race,dateOfBirth,doesSick,weight);
			StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
			ss.add(newHorse);
	
			List<Horse> allHorses = ss.getAllHorses();
	
			out.append("<html><body><h2>Wszystkie Konie: </h2><h3>Dodano Konia do bazy</h3>");
	
			for (Horse horse: allHorses) {
				out.append("<p>Imie: " + horse.getName() + "</p>");
				out.append("<p>Rasa: " + horse.getRace() + "</p>");
				out.append("<p>Data urodzenia: " + horse.getDateOfBirth() + "</p>");
				out.append("<p>Waga: " + horse.getWeight() + "</p>");
				out.append("<p>Czy chory?: " + horse.isDoesSick() + "</p>");
				out.append("<form action='showBasket'><input type='hidden' name='name' value='" + horse.getName() +"' ><button type=submit>Dodaj do koszyka</button></form><br>");
			}
	
			
		}else
		{
			StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
	
			List<Horse> allHorses = ss.getAllHorses();
	
			out.append("<html><body><h2>Wszystkie Konie: </h2>");
	
			for (Horse horse: allHorses) {
				out.append("<p>Imie: " + horse.getName() + "</p>");
				out.append("<p>Rasa: " + horse.getRace() + "</p>");
				out.append("<p>Data urodzenia: " + horse.getDateOfBirth() + "</p>");
				out.append("<p>Waga: " + horse.getWeight() + "</p>");
				out.append("<p>Czy chory?: " + horse.isDoesSick() + "</p>");
				out.append("<form action='showBasket'><input type='hidden' name='name' value='" + horse.getName() +"' ><button type=submit>Dodaj do koszyka</button></form><br>");
			}
	
			
		}
		
		out.append("<a href='/kolokwium01/start'>Przejdz do Start</a></body></html>");
		out.close();
	}
	
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}

}
