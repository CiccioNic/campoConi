<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%@ include file="check.html" %> --%>
	
	<form name="loginform" id="loginform" method="get"
		action="ServletCreaSquadra">
		<table>

			<tr>
				<td><label for="username">Nome: <span class="no_auth"></span></label></td>
				<td><input id="username" class="input" name="nome"
					type="text" size="18"></td>
			</tr>
			<tr>
				<td><label for="data">Colori maglia: <span class="no_auth"></span></label></td>
				<td><input id="cap" class="input" name="colorimaglia" type="text"
					size="18"></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="submit" style="float: right" type="submit"
					name="invio" value="Invio"></td>
			</tr>

		</table>
	</form>

</body>
</html>