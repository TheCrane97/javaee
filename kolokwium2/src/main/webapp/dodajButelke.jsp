<%@ page import="java.text.DateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.ug.pzurawska.domain.Bottle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="dane" class="com.ug.pzurawska.domain.Bottle" scope="session"/>
<jsp:useBean id="wszystkieDane" class="com.ug.pzurawska.service.StorageService" scope="application"/>

<jsp:setProperty property="nazwa" param="nazwa" name="dane" />
<jsp:setProperty property="poejmnosc" param="pojemnosc" name="dane" />
<jsp:setProperty property="coWsrodku" param="coWsrodku" name="dane" />
<jsp:setProperty property="naklejki" param="naklejki" name="dane" />

<body>
<%
if(dane.getNazwa()!=null && dane.getDataProdukcji()!=null && dane.getPojemnosc()!=0.0 && dane.getCoWsrodku()!=null && dane.getNaklejki()!=null)
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dataProd = format.parse(request.getParameter("dataProddukcji"));
		
		
		dane.setNazwa(request.getParameter("nazwa"));
		dane.setDataProdukcji(dataProd);
		
		dane.setPojemnosc(Double.parseDouble(request.getParameter("pojemnosc")));
		
		
		dane.setCoWsrodku(request.getParameter("coWsrodku"));
		
		String naklejki="";
		if(request.getParameter("naklejki01")!=null)
			naklejki+=request.getParameter("naklejki01")+" ";
		
		if(request.getParameter("naklejki02")!=null)
			naklejki+=request.getParameter("naklejki02")+" ";
		
		if(request.getParameter("naklejki03")!=null)
			naklejki+=request.getParameter("naklejki03")+" ";
		
		dane.setNaklejki(naklejki);
		
		
		wszystkieDane.Add(new Bottle(dane.getNazwa(),dane.getDataProdukcji(),dane.getPojemnosc(),dane.getCoWsrodku(),naklejki));
		
		out.println("Dodano  "+"<br>"+
			" Nazwa: "+dane.getNazwa() +"<br>"+
			" Data Produkcji: "+dane.getDataProdukcji() +"<br>"+
			"Pojemnosc: "+dane.getPojemnosc() +"<br>"+
			" Co jest w srodku: "+dane.getCoWsrodku() +"<br>"+
			" Naklejki: "+dane.getNaklejki() +
				"");
		
	}else
		out.println("Nie udalo sie dodac do bazy");
	
	
	
	%>

<a href="index.jsp" >Start</a>



</body>
</html>