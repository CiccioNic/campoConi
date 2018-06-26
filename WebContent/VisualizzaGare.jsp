<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unirc.campo_coni.dao.beans.Gara"%>
<%@ page import="java.util.Vector"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Vector<Gara> g = new Vector<Gara>();
	    g =  (Vector<Gara>)request.getAttribute("gare");
	    for (int i = 0; i < g.size(); i++){
	%>
	<table style="height: 39px;" width="307">
		<tbody>
			<tr>
				<td>Ora</td>
				<td>Data</td>
			</tr>
			<tr>
			<td><%=g.get(i).getOra()%></td>
			<td><%=g.get(i).getData()%></td>
			<td><a href="modGara.jsp?ora=<%=g.get(i).getOra()%>&data=<%=g.get(i).getData()%>">Modifica</a></td>
			</tr>
		</tbody>
	</table>
		<!-- questi parametri vengonopassati a un' altra jsp se i dati non sono riservati..l'altra opzione è quella di passare solo id passarlo a una servlet che fara una query e prenderà gli alltri dati -->
		<%
			}
		%>
	
</body>
</html>