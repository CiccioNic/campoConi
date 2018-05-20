package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Allenamento;
import it.unirc.campo_coni.dao.beans.Allenatore;
import it.unirc.campo_coni.dao.beans.AllenatoreDAO;
import it.unirc.campo_coni.dao.beans.Gara;
import it.unirc.campo_coni.dao.beans.GaraDAO;

/**
 * Servlet implementation class ServletRegistrazione
 */
@WebServlet("/ServletRegistrazione")
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruolo=request.getParameter("ruolo");
		if(ruolo=="allenatore") {
			String reqUsername = request.getParameter("username");
			String reqPassword = request.getParameter("password");
			String reqNome = request.getParameter("nome");
			String reqCognome = request.getParameter("cognome");
			String reqCodiceFiscale = request.getParameter("codicefiscale");
			String reqDataDiNascita = request.getParameter("datadinascita");
			String reqLuogoDiNascita = request.getParameter("luogodinascita");
			String reqRecapitoTelefonico = request.getParameter("recapitotelefonico");
			String reqNumCivico = request.getParameter("numcivico");
			String reqCap = request.getParameter("cap");
			String reqVia = request.getParameter("via");
			Allenatore allenatore = new Allenatore();
			allenatore.setUsername(reqUsername);
			allenatore.setPassword(reqPassword);
			allenatore.setNome(reqNome);
			allenatore.setCognome(reqCognome);
			allenatore.setCodicefiscale(reqCodiceFiscale);
			allenatore.setDatadinascita(reqCodiceFiscale);
			allenatore.setLuogodinascita(reqLuogoDiNascita);
			allenatore.setRecapitotelefonico(reqRecapitoTelefonico);
			allenatore.setNumcivico(reqNumCivico);
			allenatore.setCap(reqCap);
			allenatore.setVia(reqVia);
			AllenatoreDAO allenatoreDAO = new AllenatoreDAO();
			if(allenatoreDAO.inserisciDatiAllenatore(allenatore)) {
				response.sendRedirect("paginaOperazioneAvvenuta.html");
			}
			//else
			//	response.sendRedirect("errore.html");



        }
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
