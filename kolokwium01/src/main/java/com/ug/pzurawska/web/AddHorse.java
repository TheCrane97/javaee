package com.ug.pzurawska.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addHorse")
public class AddHorse extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2>Dodaj Konia:</h2>" +
				"<form action='showHorses'>" +
				"Imie: <input type='text' name='name' /> <br />" +
				"Rasa: <input type='text' name='race' /> <br />" +
				"Data urodzenia(yyyy-mm-dd): <input type='text' name='dateOfBirth' /> <br />" +
				"Waga(np: 425.84): <input type='text' name='weight' /> <br />" +
				"Czy zdrowy?: <select name='doesSick'>" +
				"<option value='true'>Tak</option>" +
				"<option value='false'>Nie</option>" +
				"</select><br />" +
				"<input type='submit' value=' Dodaj ' /><br/>" +
				"</form>" +
				"<a href='/zad04/start'>Przejdz do Start</a></body></html>");
		out.close();
	}
}
