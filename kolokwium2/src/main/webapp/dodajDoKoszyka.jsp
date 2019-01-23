<%@ page import="java.text.DateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Iterator" %>
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
<jsp:useBean id="koszyk" class="com.ug.pzurawska.service.StorageService" scope="session"/>

<body>
<h1>Koszyk</h1>

    <%
   
   if(request.getParameter("id")!=null)
   {
	    long id = Long.valueOf(request.getParameter("id"));
    	Bottle bottle = wszystkieDane.Find(id);
    	koszyk.add(bottle);
   }
    
    double total = 0;
    Map<Long, Bottle> k = koszyk.getAllFromKoszyk();
    
    
    if(k.size() > 0) {
        Iterator it = k.values().iterator();
        Bottle s;
        while (it.hasNext()) {
            s = (Bottle) it.next();
    		out.println("Nazwa:"+s.getNazwa()+"<br>");
    		out.println("Data Produkcji:"+s.getDataProdukcji()+"<br>");
    		out.println("Pojemnosc:"+s.getPojemnosc()+"<br>");
    		out.println("Co jest w srodku:"+s.getCoWsrodku()+"<br>");
    		out.println("Naklejki:"+s.getNaklejki()+"<br>");
    		out.println("--------------------------------------------------------------------------"+"<br>");
        }
    } else {
        out.println("<h2>Koszyk jest pusty</h2>");
    }
    
    
    
    
    
    
    %>




	

<a href="index.jsp" >Start</a>
</body>
</html>