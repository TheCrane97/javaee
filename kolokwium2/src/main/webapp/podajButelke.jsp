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
				Pojemnosc(np: 0.5): <input type="text" name="pojemnosc" value="${dane.pojemnosc}" > <br>
		 		Co sie w niej znajduje?:<br />
				<input type="radio" name="coWsrodku" value="sok" <% if(dane.getCoWsrodku().equals("sok")){out.println("checked");}%>> sok<br> 
				<input type="radio" name="coWsrodku" value="nektar" <% if(dane.getCoWsrodku().equals("nektar")){out.println("checked");}%>> nektar<br> 
				<input type="radio" name="coWsrodku" value="woda" <% if(dane.getCoWsrodku().equals("woda")){out.println("checked");}%>> woda<br>
				Co dodac na butelke?<br />
				<input type="checkbox" name="naklejki01" value="naklejki z owocami" <% if(dane.getNaklejki().contains("naklejki z owocami")){out.println("checked");}%>> naklejki z owocami<br>
				<input type="checkbox" name="naklejki02" value="naklejki z drzewami" <% if(dane.getNaklejki().contains("naklejki z drzewami")){out.println("checked");}%>> naklejki z drzewami<br>
				<input type="checkbox" name="naklejki03" value="naklejki z warzywami" <% if(dane.getNaklejki().contains("naklejki z warzywami")){out.println("checked");}%>> naklejki z warzywami<br>
				<input type="submit" value=" Zamawiam " /><br/>
</form>






</body>
</html>