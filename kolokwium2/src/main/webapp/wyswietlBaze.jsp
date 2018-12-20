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
<%
	for(Bottle news:wszystkieDane.GetAll())
	{	
		%>
		<form action="wyswietlKoszyk.jsp">
		
		<%
		out.println("Nazwa:"+news.getNazwa()+"<br>");
		out.println("Data Produkcji:"+news.getDataProdukcji()+"<br>");
		out.println("Pojemnosc:"+news.getPojemnosc()+"<br>");
		out.println("Co jest w srodku:"+news.getCoWsrodku()+"<br>");
		out.println("Naklejki:"+news.getNaklejki()+"<br>");
		
		%>
		<button type="submit" name="nazwa" value="${news.getNazwa()}">Dodaj do koszyka!</button>
		</form>
		
		
		<%
		out.println("---------------------------"+"<br>");
	}
%>
<br>
<a href="index.jsp" >Start</a>
</body>
</html>