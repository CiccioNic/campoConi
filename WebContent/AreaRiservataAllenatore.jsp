<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Coni RC</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<%@ include file="header.html"%>
	<div id="container">
		<div id="content">
			<h1>
				Benvenuto! <span style="font-weight: bold; color: #C4DA64;">StopWatch</span>
			</h1>
			<p class="big">
				<a href="ricerca.html"> Desideri sapere di più su atleti,
					giudici, squadre o allenatori?</a>
			</p>
			<p class="big">
				<a href=""> Visualizza l'elenco degli allenamenti</a>
			</p>
			<p class="big">
				<a href="FormCreaAllenamento.html"> Crea un allenamento </a>
			</p>
			<p class="big">
				<a href=""> Modifica un allenameto da te creato</a>
			</p>
			<p class="big">
				<a href=""> Elimina un allanemento da te creato</a>
			</p class = "big">
            <p class="big">
			<a href=""> Visualizza l'elenco delle gare</a>
			</p>
			<p class="big">
				<a href=""> Visualizza i risultati delle gare</a>
			</p>
		</div>
		<div id="content_right">
			<%@ include file="RecommendedLinks.html"%>
		
			<%@ include file="MoreInfo.html"%>

		</div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>