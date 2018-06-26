package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Allenatore;
import it.unirc.campo_coni.dao.beans.AllenatoreDAO;
import it.unirc.campo_coni.dao.beans.Giudice;
import it.unirc.campo_coni.dao.beans.GiudiceDAO;

/**
 * Servlet implementation class ServletCreaGiudice
 */
@WebServlet("/ServletCreaGiudice")
public class ServletCreaGiudice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreaGiudice() {
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
		String reqRecapitoTelefonico = request.getParameter("recapitotelefonico");
		String reqNumCivico = request.getParameter("numcivico");
		String reqCap = request.getParameter("cap");
		String reqVia = request.getParameter("via");
		Giudice giudice = new Giudice();
		giudice.setUsername(reqUsername);
		giudice.setPassword(reqPassword);
		giudice.setNome(reqNome);
		giudice.setCognome(reqCognome);
		giudice.setCodicefiscale(reqCodiceFiscale);
		giudice.setRecapitotelefonico(reqRecapitoTelefonico);
		giudice.setNumcivico(reqNumCivico);
		giudice.setCap(reqCap);
		giudice.setVia(reqVia);
		GiudiceDAO giudiceDAO = new GiudiceDAO();
		if(giudiceDAO.inserisciDatiGiudice(giudice)) {
			response.sendRedirect("paginaOperazioneAvvenuta.html");
		}
		else
			response.sendRedirect("errore.html");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
