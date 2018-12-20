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
<body>

<form action="dodajButelke.jsp">
				Nazwa: <input type="text" name="nazwa" value="${dane.nazwa}" > <br>
				Data produkcji; Format daty (yyyy-mm-dd):<br />
			 	<input type='date' name='dataProdukcji' value='<%
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if(dane.getDataProdukcji()!=null){
					out.print(df.format(dane.getDataProdukcji()));}
				else
					out.print(df.format(new java.util.Date()));%>'/></br>
		
		 		Co sie w niej znajduje?:<br />
				<input type="radio" name="coWsrodku" value="sok" <% if(dane.getCoWsrodku().equals("sok")){out.println("checked");}%>> Codziennie<br> 
				<input type="radio" name="coWsrodku" value="nektar" <% if(dane.getCoWsrodku().equals("nektar")){out.println("checked");}%>> Tygodniowo<br> 
				<input type="radio" name="coWsrodku" value="woda" <% if(dane.getCoWsrodku().equals("woda")){out.println("checked");}%>> Miesiecznie<br>
				Ktore magazyny wybierasz?<br />
				<input type="checkbox" name="magazyny01" value="Konie" <% if(dane.getMagazyny().contains("Konie")){out.println("checked");}%>> Konie<br>
				<input type="checkbox" name="magazyny02" value="Psy" <% if(dane.getMagazyny().contains("Psy")){out.println("checked");}%>> Psy<br>
				<input type="checkbox" name="magazyny03" value="Koty" <% if(dane.getMagazyny().contains("Koty")){out.println("checked");}%>> Koty<br>
				<input type="submit" value=" Zamawiam " /><br/>
</form>






</body>
</html>