<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unirc.campo_coni.dao.beans.Allenamento"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Allenamento a = (Allenamento) request.getAttribute("allenamento");%>
	<%= a.getDurata() %>
	<%= a.getOra() %>
	<%= a.getData() %>
	<a href="modAllenamento.jsp?durata=<%=a.getDurata()%>&ora=<%=a.getOra()%>&data=<%=a.getData()%>"> Modifica</a>
</body>
</html>