package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Gara;
import it.unirc.campo_coni.dao.beans.GaraDAO;
import it.unirc.campo_coni.dao.beans.Squadra;
import it.unirc.campo_coni.dao.beans.SquadraDAO;

/**
 * Servlet implementation class ServletCreaSquadra
 */
@WebServlet("/ServletCreaSquadra")
public class ServletCreaSquadra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreaSquadra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqNome = request.getParameter("nome");
		String reqColorimaglia = request.getParameter("colorimaglia");
		Squadra squadra = new Squadra();
		squadra.setNome(reqNome);
		squadra.setColorimaglia(reqColorimaglia);
		SquadraDAO squadraDAO = new SquadraDAO();
		if(squadraDAO.inserisciDatiSquadra(squadra)==true) {
			response.sendRedirect("paginaOperazioneAvvenuta.html");
		}
		else {
			response.sendRedirect("errore.html");
		}
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

