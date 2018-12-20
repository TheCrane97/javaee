<%@ page import="java.text.DateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.ug.pzurawska.domain.Newsletter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="wszystkieDane" class="com.ug.pzurawska.service.StorageService" scope="application"/>
<body>
<%
	for(Newsletter news:wszystkieDane.GetAll())
	{
		out.println("Imie:"+news.getImie()+"<br>");
		out.println("Od:"+news.getOdKiedy()+"<br>");
		out.println("Do:"+news.getDoKiedy()+"<br>");
		out.println("Czestotliwosc:"+news.getCzestotliwosc()+"<br>");
		out.println("Magazyny:"+news.getMagazyny()+"<br>");
		out.println("---------------------------"+"<br>");
	}
%>

<a href="index.jsp" >Start</a>
</body>
</html>