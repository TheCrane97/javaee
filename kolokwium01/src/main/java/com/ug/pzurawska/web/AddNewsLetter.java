package com.ug.pzurawska.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newsletter")
public class AddNewsLetter extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2>Moze jakies magazyny?<br> Podaj swoje dane:</h2>" +
				"<form action='shownewsletter'>" +
				"Imie: <input type='text' name='name' /> <br />" +
				"Nazwisko: <input type='text' name='surname' /> <br />" +
				"Kiedy wysylac? Wpisz daty (yyyy-mm-dd):" +
				"Od: <input type='text' name='beginDate' /> <br />" +
				"Do: <input type='text' name='endDate' /> <br />" +
				"Jaka czestotliwosc?:" +
				"<input type='radio' name='frequency' value='everyDay'> Codziennie<br>" + 
				"<input type='radio' name='frequency' value='everyWeek'> Tygodniowo<br>" + 
				"<input type='radio' name='frequency' value='everyMonth'> Miesiecznie<br>"+
				"Ktore magazyny wybierasz?"+
				"<input type='checkbox' name='newsLetter' value='allHorses'> Wszystko o koniach<br>"+
				"<input type='checkbox' name='newsLetter' value='horseFriend'> Kon twoj przyjaciel<br>"+
				"<input type='checkbox' name='newsLetter' value='careOfHorse'> Jak opiekowac sie konmi<br>"+
				"<input type='checkbox' name='newsLetter' value='whichHorse'> Ktorego konia wybrac<br>"+
				"<input type='submit' value=' Zamawiam ' /><br/>" +
				"</form>" +
				"<a href='/zad04/start'>Przejdz do Start</a></body></html>");
		out.close();
	}

}
