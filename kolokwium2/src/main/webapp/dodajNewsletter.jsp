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
<body>
<jsp:useBean id="dane" class="com.ug.pzurawska.domain.Newsletter" scope="session"/>
<jsp:useBean id="wszystkieDane" class="com.ug.pzurawska.service.StorageService" scope="application"/>

<jsp:setProperty property="imie" param="imie" name="dane" />
<jsp:setProperty property="czestotliwosc" param="czestotliowsc" name="dane" />


<%
	
	if(dane.getImie()!=null && dane.getOdKiedy()!=null && dane.getDoKiedy()!=null && dane.getCzestotliwosc()!=null && dane.getMagazyny()!=null)
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dok = format.parse(request.getParameter("doKiedy"));
		Date odk = format.parse(request.getParameter("odKiedy"));
		
		dane.setImie(request.getParameter("imie"));
		dane.setDoKiedy(dok);
		dane.setOdKiedy(odk);
		dane.setCzestotliwosc(request.getParameter("czestotliwosc"));
		dane.setMagazyny(request.getParameter("magazyny"));
		String magazyny="";
		if(request.getParameter("magazyny01")!=null)
			magazyny+=request.getParameter("magazyny01")+" ";
		
		if(request.getParameter("magazyny02")!=null)
			magazyny+=request.getParameter("magazyny02")+" ";
		
		if(request.getParameter("magazyny03")!=null)
			magazyny+=request.getParameter("magazyny03")+" ";
		
		dane.setMagazyny(magazyny);
		
		
		wszystkieDane.Add(new Newsletter(dane.getImie(),dane.getOdKiedy(),dane.getDoKiedy(),dane.getCzestotliwosc(),magazyny));
		out.println("Dodano  "+"<br>"+
			" Imie: "+dane.getImie() +"<br>"+
			" Od Kiedy: "+dane.getOdKiedyString() +"<br>"+
			" Do Kiedy: "+dane.getDoKiedyString() +"<br>"+
			" Czestotliwosc: "+dane.getCzestotliwosc() +"<br>"+
			" Magazyny: "+dane.getMagazyny() +
				"");
		
	}else
		out.println("Nie udalo sie dodac do bazy");
	
	
	
	%>

<a href="index.jsp" >Start</a>




</body>
</html>