<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unirc.campo_coni.dao.beans.Squadra"%>
<%@ page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Vector<Squadra> s = new Vector<Squadra>();
		s = (Vector<Squadra>) request.getAttribute("squadre");
		for (int i = 0; i < s.size(); i++) {
	%>
	<table style="height: 39px;" width="307">
		<tbody>
			<tr>
				<td>Nome</td>
				<td>Colori Maglia</td>
			</tr>
			<tr>
				<td><%=s.get(i).getNome()%></td>
				<td><%=s.get(i).getColorimaglia()%></td>

			</tr>
		</tbody>
	</table>
	<!-- questi parametri vengonopassati a un' altra jsp se i dati non sono riservati..l'altra opzione è quella di passare solo id passarlo a una servlet che fara una query e prenderà gli alltri dati -->
	<%
		}
	%>

</body>
</html>