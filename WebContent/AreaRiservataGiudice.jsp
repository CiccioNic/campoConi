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
				<a href=""> Inserisci i risultati di una gara</a>
			</p>
			<p class="big">
				<a href=""> Crea un allenamento </a>
			</p>
			<p class="big">
				<a href=""> Modifica un allenameto da te creato</a>
			</p>
			<p class="big">
				<a href=""> Elimina un allanemento da te creato</a>
			</p class = "big">

			<a href=""> Visualizza l'elenco delle gare</a>
			</p>
			<p class="big">
				<a href=""> Visualizza i risultati delle gare</a>
			</p>
		</div>
		<div id="content_right">
			<%@ include file="RecommendedLinks.html"%>
			<dl class="curved">
				<dt>
					LOGIN<br /> <span class="small"> Entra nella tua area
						riservata oppure registrati</span>
				</dt>
				<dd>
					<p></p>
					<form name="loginform" id="loginform" method="post"
						action="Servlet_login">
						<p>
							<label for="username">Username <span class="no_auth"></span></label>
							<input id="username" class="input" name="uname" type="text"
								size="18">
						</p>
						<p>
							<label for="password">Password</label> <input id="password"
								class="input" name="pword" type="password" size="18">
						</p>
						<p>
						<fieldset>
							<legend>Log in as:</legend>
							Allenatore <input type="radio" name="ruolo" value="allenatore" />
							Atleta <input type="radio" name="ruolo" value="atleta" />
							Giudice <input type="radio" name="ruolo" value="giudice" />
						</fieldset>
						</p>

						<p>
							<input id="scadenza" name="scadenza" type="checkbox" value="1">
							Ricorda su questo computer per <select id="ore" name="ore">
								<option value="6">6</option>
								<option value="12">12</option>
								<option value="24">24</option>
								<option selected="selected" value="48">48</option>
							</select> ore
						</p>
						<p>
							<input class="submit" style="float: right" type="submit"
								name="login" value="Accedi"> <a href="Registrazione.jsp">Registrati
							</a>
						</p>
					</form>
					</p>
				</dd>
			</dl>
			<%@ include file="MoreInfo.html"%>

		</div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>