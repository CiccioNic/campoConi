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
			<h1>Registrazione</h1>

			<div id="box">
				<h2>
					<img src="images/last.gif" alt="ad"> Inserisci i tuoi dati
				</h2>



				<form name="loginform" id="loginform" method="post"
					action="ServletCreaAtleta">
					<table>

						<tr>
							<td><label for="username">Username: <span
									class="no_auth"></span></label></td>
							<td><input id="username" class="input" name="username"
								type="text" size="18"></td>
						</tr>
						<tr>
							<td><label for="cap">CAP: <span class="no_auth"></span></label></td>
							<td><input id="cap" class="input" name="cap" type="text"
								size="18"></td>
						</tr>
						<tr>
							<td><label for="password">Password: </label></td>
							<td><input id="password" class="input" name="password"
								type="password" size="18"></td>
						</tr>
						<tr>
							<td><label for="via"> Via: <span class="no_auth"></span>
							</label></td>
							<td><input id="via" class="input" name="via" type="text"
								size="18"></td>
						</tr>
						<tr>
							<td><label for="nome">Nome: <span class="no_auth"></span></label></td>
							<td><input id="nome" class="input" name="nome" type="text"
								size="18"></td>
						</tr>
						<tr>
							<td><label for="numcivico">Num. civico: <span
									class="no_auth"></span>
							</label></td>

							<td><input id="numcivico" class="input" name="numcivico"
								type="text" size="18"></td>
						</tr>
						<tr>
							<td><label for="cognome">Cognome: <span
									class="no_auth"></span></label></td>
							<td><input id="cognome" class="input" name="cognome"
								type="text" size="18"></td>
						</tr>
						<tr>
							<td><label for="recapitotelefonico">Recapito
									telefonico: <span class="no_auth"></span>

							</label></td>
							<td><input id="recapitotelefonico" class="input"
								name="recapitotelefonico" type="text" size="18"></td>
						</tr>
						<tr>
							<td><label for="codicefiscale">Cod. fiscale: <span
									class="no_auth"></span></label></td>
							<td><input id="codicefiscale" class="input"
								name="codicefiscale" type="text" size="18"></td>
						</tr>
						<tr>
							<td><label for="luogodinascita">Luogo di nascita: <span
									class="no_auth"></span></label></td>
							<td><input id="luogodinascita" class="input"
								name="luogodinascita" type="text" size="18"></td>
						</tr>
						<tr>
							<td><label for="datadinascita">Data di nascita: <span
									class="no_auth"></span></label></td>
							<td><input id="datadinascita" type="date" name =  "datadinascita"></td>

						</tr>
						<tr>
							<td><label for="datainizio">Data inizio: <span
									class="no_auth"></span></label></td>
							<td><input id="datadinascita" type="date" name="datainizio"></td>

						</tr>
						<tr>
							<td><label for="datafine">Data fine: <span
									class="no_auth"></span></label></td>
							<td><input id="datadinascita" type="date" name="datafine"></td>

						</tr>
						<tr>
							<td colspan="2"><fieldset>
									<legend>Registrati come:</legend>
									Allenatore <input type="radio" name="ruolo" value="allenatore" />
									Atleta <input type="radio" name="ruolo" value="atleta" />
									Giudice <input type="radio" name="ruolo" value="giudice" />
								</fieldset></td>
						</tr>
						<tr>
							<td></td>
							<td><input class="submit" style="float: right" type="submit"
								name="invio" value="Invio"></td>
						</tr>

					</table>
				</form>


			</div>

		</div>
		<div id="content_right">
			<%@ include file="RecommendedLinks.html"%>

			<%@ include file="MoreInfo.html"%>
		</div>
	</div>
	<%@ include file="footer.html"%>

</body>
</html>