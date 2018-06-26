package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Gara;
import it.unirc.campo_coni.dao.beans.GaraDAO;

/**
 * Servlet implementation class ServletModificaGara
 */
@WebServlet("/ServletModificaGara")
public class ServletModificaGara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificaGara() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqData = request.getParameter("data");
		String reqOra = request.getParameter("ora");
		Gara gara = new Gara();
		gara.setData(reqData);
		gara.setOra(reqOra);
		GaraDAO garaDAO = new GaraDAO();
		if(garaDAO.modificaDatiGara(gara)) {
			response.sendRedirect("paginaOperazioneAvvenuta.html");
		}
		//else
		//	response.sendRedirect("errore.html");
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
