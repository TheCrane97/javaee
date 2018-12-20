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
import javax.servlet.http.HttpSession;

import com.ug.pzurawska.domain.Horse;
import com.ug.pzurawska.service.StorageService;
import com.ug.pzurawska.domain.User;

@WebServlet("/allnewsletter")
public class ShowNewsLetter extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("name")!=null &&  request.getParameter("surname")!=null && request.getParameter("beginDate")!=null && request.getParameter("endDate")!=null && request.getParameter("frequency")!=null)
		{
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			Date beginDate = null;
			Date endDate = null;
			String magazine="";
			try {
				beginDate = formatter.parse(request.getParameter("beginDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			try {
				endDate = formatter.parse(request.getParameter("endDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String frequency = request.getParameter("frequency");
	
			
			
			if(request.getParameter("newsLetter01")!=null)
			{
				magazine+=request.getParameter("newsLetter01")+" ";
			}
			
			if(request.getParameter("newsLetter02")!=null)
			{
				magazine+=request.getParameter("newsLetter02")+" ";
			}
			if(request.getParameter("newsLetter03")!=null)
			{
				magazine+=request.getParameter("newsLetter03")+" ";
			}
			if(request.getParameter("newsLetter04")!=null)
			{
				magazine+=request.getParameter("newsLetter04")+" ";
			}
			User person = new User(name,surname,beginDate,endDate,frequency,magazine);
			
			StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
			ss.addUser(person);
			
			
			session.setAttribute("sess_news", person);
	
			List<User> allUsers = ss.getAllUsers();
			List<String> magazines;
	
			out.append("<html><body>");
	
			for (User user: allUsers) {
				out.append("<p>Imie: " + user.getName() + "</p>");
				out.append("<p>Nazwisko: " + user.getSurname() + "</p>");
				out.append("<p>Data poczatkowa: " + user.getBeginDate() + "</p>");
				out.append("<p>Data koncowa: " + user.getEndDate() + "</p>");
				out.append("<p>Czestotliwosc: " + user.getFrequency() + "</p>");
				out.append("<p>Magazyny: "+ user.getMagazine() +"</p>");
				
				
				
				out.append("----------------------------------------------------------------------------------<br>");
			}
		
		}else
		{
			StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
	
			List<User> allUsers = ss.getAllUsers();
			List<String> magazines;
	
			out.append("<html><body>");
	
			for (User user: allUsers) {
				out.append("<p>Imie: " + user.getName() + "</p>");
				out.append("<p>Nazwisko: " + user.getSurname() + "</p>");
				out.append("<p>Data poczatkowa: " + user.getBeginDate() + "</p>");
				out.append("<p>Data koncowa: " + user.getEndDate() + "</p>");
				out.append("<p>Czestotliwosc: " + user.getFrequency() + "</p>");
				out.append("<p>Magazyny:</p>");
				out.append("<p>Magazyny: "+ user.getMagazine() +"</p>");
				
				
				out.append("----------------------------------------------------------------------------------<br>");
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
