package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Atleta;
import it.unirc.campo_coni.dao.beans.AtletaDAO;
import it.unirc.campo_coni.dao.beans.Gara;
import it.unirc.campo_coni.dao.beans.GaraDAO;

/**
 * Servlet implementation class ServletCreaAtleta
 */
@WebServlet("/ServletCreaAtleta")
public class ServletCreaAtleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreaAtleta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqUsername = request.getParameter("username");
		String reqPassword = request.getParameter("password");
		String reqNome = request.getParameter("nome");
		String reqCognome = request.getParameter("cognome");
		String reqCodiceFiscale = request.getParameter("codicefiscale");
		String reqDataDiNascita = request.getParameter("datadinascita");
		String reqLuogoDiNascita = request.getParameter("luogodinascita");
		String reqRecapitoTelefonico = request.getParameter("recapitotelefonico");
		String reqDataInizio = request.getParameter("datainizio");
		String reqDataFine = request.getParameter("datafine");
		String reqNumCivico = request.getParameter("numcivico");
		String reqCap = request.getParameter("cap");
		String reqVia = request.getParameter("via");
		Atleta atleta = new Atleta();
		atleta.setUsername(reqUsername);
		atleta.setPassword(reqPassword);
		atleta.setNome(reqNome);
		atleta.setCognome(reqCognome);
		atleta.setCodicefiscale(reqCodiceFiscale);
		atleta.setDatadinascita(reqDataDiNascita);
        atleta.setLuogodinascita(reqLuogoDiNascita);
        atleta.setRecapitotelefonico(reqRecapitoTelefonico);
        atleta.setDatainizio(reqDataInizio);
        atleta.setDatafine(reqDataFine);
        atleta.setNumcivico(reqNumCivico);
        atleta.setCap(reqCap);
        atleta.setVia(reqVia);
		AtletaDAO atletaDAO = new AtletaDAO();
		if(atletaDAO.inserisciDatiAtleta(atleta)) {
			response.sendRedirect("paginaOperazioneAvvenuta.html");
		}
		else
			response.sendRedirect("errore.html");
        response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
