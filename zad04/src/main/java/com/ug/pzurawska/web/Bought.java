package com.ug.pzurawska.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bought")
public class Bought extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
	
		out.append("<html><body><h1>Kupiono Konie!!</h1><br><a href='/zad04/start'>Przejdz do Start</a></body></html>");
	}
}
