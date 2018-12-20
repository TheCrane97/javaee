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
<jsp:useBean id="wszystkieDane" class="com.ug.pzurawska.service.StorageService" scope="application"/>
<body>
<%
if(request.getParameter("nazwa")!=null){
String name=request.getParameter("nazwa");

Bottle b= new Bottle();
b=wszystkieDane.Find(name);

wszystkieDane.AddToKoszyk(b);
}

for(Bottle news:wszystkieDane.GetAllZKoszyk())
{	

	out.println("Nazwa:"+news.getNazwa()+"<br>");
	out.println("Data Produkcji:"+news.getDataProdukcji()+"<br>");
	out.println("Pojemnosc:"+news.getPojemnosc()+"<br>");
	out.println("Co jest w srodku:"+news.getCoWsrodku()+"<br>");
	out.println("Naklejki:"+news.getNaklejki()+"<br>");
	
	out.println("---------------------------"+"<br>");
}



%>

<a href="index.jsp" >Start</a>
</body>
</html>