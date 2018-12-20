<%@ page import="java.text.DateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.ug.pzurawska.domain.Newsletter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<jsp:useBean id="dane" class="com.ug.pzurawska.domain.Newsletter" scope="session"/>
<body>
<form action="dodajNewsletter.jsp">
				Imie: <input type="text" name="imie" value="${dane.imie}" > <br>
				Kiedy wysylac? Wpisz daty (yyyy-mm-dd):<br />
				Data Od Kiedy: <input type='date' name='odKiedy' value='<%
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if(dane.getOdKiedy()!=null){
					out.print(df.format(dane.getOdKiedy()));}
				else
					out.print(df.format(new java.util.Date()));%>'/></br>
		
		  Data Do Kiedy: <input type='date' name='doKiedy' value='<%
			DateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
				if(dane.getDoKiedy()!=null){
					out.print(dff.format(dane.getDoKiedy()));}
				else
					out.print(df.format(new java.util.Date()));%>'/></br>Jaka czestotliwosc?:<br />
				<input type="radio" name="czestotliwosc" value="Codziennie" <% if(dane.getCzestotliwosc().equals("Codziennie")){out.println("checked");}%>> Codziennie<br> 
				<input type="radio" name="czestotliwosc" value="Tygodniowo" <% if(dane.getCzestotliwosc().equals("Tygodniowo")){out.println("checked");}%>> Tygodniowo<br> 
				<input type="radio" name="czestotliwosc" value="Miesiecznie" <% if(dane.getCzestotliwosc().equals("Miesiecznie")){out.println("checked");}%>> Miesiecznie<br>
				Ktore magazyny wybierasz?<br />
				<input type="checkbox" name="magazyny01" value="Konie" <% if(dane.getMagazyny().contains("Konie")){out.println("checked");}%>> Konie<br>
				<input type="checkbox" name="magazyny02" value="Psy" <% if(dane.getMagazyny().contains("Psy")){out.println("checked");}%>> Psy<br>
				<input type="checkbox" name="magazyny03" value="Koty" <% if(dane.getMagazyny().contains("Koty")){out.println("checked");}%>> Koty<br>
				<input type="submit" value=" Zamawiam " /><br/>
				</form>






</body>
</html>