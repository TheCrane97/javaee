<%@ page import="java.text.DateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.ug.pzurawska.domain.Bottle"%>
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

<h1>Baza danych</h1>

<%
	for(Bottle news:wszystkieDane.GetAll())
	{	
		%>
		<form action="dodajDoKoszyka.jsp" >
		
		<%
		out.println("Nazwa:"+news.getNazwa()+"<br>");
		out.println("Data Produkcji:"+news.getDataProdukcji()+"<br>");
		out.println("Pojemnosc:"+news.getPojemnosc()+"<br>");
		out.println("Co jest w srodku:"+news.getCoWsrodku()+"<br>");
		out.println("Naklejki:"+news.getNaklejki()+"<br>");
		out.println("<input name='id' hidden value='" + news.getId() + "'/>");
		out.println("<input type='submit' value='Dodaj do koszyka!'/>");
		%>
	
		</form>
		
		
		<%
		out.println("---------------------------"+"<br>");
	}
%>
<br>
<a href="index.jsp" >Start</a>
</body>
</html>