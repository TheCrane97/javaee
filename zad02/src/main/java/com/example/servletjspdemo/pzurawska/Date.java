package com.example.servletjspdemo.pzurawska;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/date")
public class Date extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body><h1><p id=\"demo\"></p></h1>"
        		+ "<script>\r\n" + 
        		"var d = new Date();\r\n" + 
        		"document.getElementById(\"demo\").innerHTML = d;\r\n" + 
        		"</script>"
        		+ "</body></html>");
    }
}
