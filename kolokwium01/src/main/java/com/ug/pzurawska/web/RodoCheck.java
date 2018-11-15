package com.ug.pzurawska.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rodoCheck")
public class RodoCheck extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");

	        PrintWriter out = response.getWriter();
	        
	        if(request.getParameter("rodo").equals("rodoStart"))
	        {
	        	if(request.getParameterNames().nextElement().equals("rodoEmail"))
	        	{
	        		if(request.getParameter("email")!="")
	        			response.sendRedirect("/kolokwium01/start");
	        		else
	        			response.sendRedirect("/kolokwium01/index.jsp");
	        	}
	        	response.sendRedirect("/kolokwium01/start");
	        }
	        
	        if(request.getParameter("rodo").equals("rodoBuy"))
	        {
	        	if(request.getParameterNames().nextElement().equals("rodoEmail"))
	        	{
	        		if(request.getParameter("email")!=null)
	        			response.sendRedirect("/kolokwium01/bought");
	        		else
	        			response.sendRedirect("/kolokwium01/showBasket");
	        	}
	        	response.sendRedirect("/kolokwium01/bought");
	        }
	        
	        
	        
	        
	        	
	 }

}
