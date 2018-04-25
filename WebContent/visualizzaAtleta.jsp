<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%--se questa pagina sta nell'area riservata dovra esserci il seguente if --%>
	<%@ include file="check.html" %>
	<%--commento jsp, non viene dato al browser ma rimane sul sever --%>
	il risultato del lancio dado è:
	<%=(int) (Math.random() * 6 + 1)%>
	<%-- espressione jsp essa permette di scrivere direttamente nella pagina il risultato è il modo più rapido --%>
	<%-- denro gli scriplet c'è codice java vero e proprio --%>
	<% for (int a=0;a<3;a++){ %>
	il risultato del lancio dado è:
	<%=(int) (Math.random() * 6 + 1)%><br>
	<%}%>
	<%--quando ci sono cose mixed fra html e java bisogna mettere le parentesi nel for e nel'if --%>
	<% 
		int a = 4;
	%>
	<%=a%>
	<%-- cosi stamperà a --%>
	<%-- la jsp dovrà stampare gli attributi che la servlet da --%>
	<%
		out.println("hello world");
	%>
	<%-- permette di stampare all'interno della pagina, si può usare pure questo --%>
	<%=session.getId()%>
	<%-- session è un altro oggetto predefinito di jsp --%>
	<%-- la seguente è una dichiarazione jsp --%>
	<%! int cont=1; %>
    il valore di cont è <%= a++ %>
    
    <%-- di seguito voglio mostrare tutti i cookie che ci sono nella mia richiesta  --%>
    <br>
    <%Cookie[] cookies= request.getCookies();
		if(cookies!=null) 
			for(int i=0; i<cookies.length; i++) 
				out.println(cookies[i].getName() + " " + cookies[i].getValue());
		else
			out.println("nessun cookie presente");
	%>
</body>
</html>