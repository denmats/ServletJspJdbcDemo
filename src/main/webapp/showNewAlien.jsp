<%@page import="com.denmats.web.model.Alien"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
   <%
	   //use RequestDispatcher
	   Alien a = (Alien)request.getAttribute("newAlien");
	   out.println("New Alien with id = " +a.getAid()+" is created.");
	%>
</body>
</html>