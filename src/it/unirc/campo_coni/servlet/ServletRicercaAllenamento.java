package it.unirc.campo_coni.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Allenamento;
import it.unirc.campo_coni.dao.beans.AllenamentoDAO;
import it.unirc.campo_coni.dao.beans.Squadra;
import it.unirc.campo_coni.dao.beans.SquadraDAO;

/**
 * Servlet implementation class ServletRicercaAllenamento
 */
@WebServlet("/ServletRicercaAllenamento")
public class ServletRicercaAllenamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRicercaAllenamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AllenamentoDAO allenamentoDAO = new AllenamentoDAO();
		Vector<Allenamento> allenamenti = new Vector<Allenamento>();
		allenamenti = allenamentoDAO.getAllenamenti();
		request.setAttribute("allenamenti", allenamenti);//viene messo il risultato del'elaborazione della servlet nella request e questa viene inoltrata alla jsp
		request.getRequestDispatcher("VisualizzaAllenamento.jsp").forward(request, response);//questa response sara quella che verrà inoltrata dalla jsp
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
