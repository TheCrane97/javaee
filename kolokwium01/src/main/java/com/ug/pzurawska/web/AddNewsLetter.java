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
				"Kiedy wysylac? Wpisz daty (yyyy-mm-dd):<br />" +
				"Od: <input type='text' name='beginDate' /> <br />" +
				"Do: <input type='text' name='endDate' /> <br />" +
				"Jaka czestotliwosc?:<br />" +
				"<input type='radio' name='frequency' value='Codziennie'> Codziennie<br>" + 
				"<input type='radio' name='frequency' value='Tygodniowo'> Tygodniowo<br>" + 
				"<input type='radio' name='frequency' value='Miesiecznie'> Miesiecznie<br>"+
				"Ktore magazyny wybierasz?<br />"+
				"<input type='checkbox' name='newsLetter01' value='Wszystko o koniach'> Wszystko o koniach<br>"+
				"<input type='checkbox' name='newsLetter02' value='Kon twoj przyjaciel'> Kon twoj przyjaciel<br>"+
				"<input type='checkbox' name='newsLetter03' value='Jak opiekowac sie konmi'> Jak opiekowac sie konmi<br>"+
				"<input type='checkbox' name='newsLetter04' value='Ktorego konia wybrac'> Ktorego konia wybrac<br>"+
				"<input type='submit' value=' Zamawiam ' /><br/>" +
				"</form>" +
				"<a href='/kolokwium01/start'>Przejdz do Start</a></body></html>");
		out.close();
	}

}
