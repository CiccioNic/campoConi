package it.unirc.campo_coni.servlet;

import java.io.IOException;
import java.util.Vector;

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
 * Servlet implementation class SevletRicercaSquadra
 */
@WebServlet("/SevletRicercaSquadra")
public class SevletRicercaSquadra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevletRicercaSquadra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SquadraDAO squadraDAO = new SquadraDAO();
		//Gara gara= new Gara(un,"","");
		Vector<Squadra> squadre = new Vector<Squadra>();
		squadre = squadraDAO.getSquadre();
		request.setAttribute("squadre", squadre);//viene messo il risultato del'elaborazione della servlet nella request e questa viene inoltrata alla jsp
		request.getRequestDispatcher("VisualizzaGare.jsp").forward(request, response);//questa response sara quella che verrà inoltrata dalla jsp
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
