package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Allenamento;
import it.unirc.campo_coni.dao.beans.AllenamentoDAO;
import it.unirc.campo_coni.dao.beans.Allenatore;
import it.unirc.campo_coni.dao.beans.AllenatoreDAO;

/**
 * Servlet implementation class ServletCreaAllenamento
 */
@WebServlet("/ServletCreaAllenamento")
public class ServletCreaAllenamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreaAllenamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqData = request.getParameter("data");
		String reqDurata = request.getParameter("durata");
     	String reqOra = request.getParameter("ora");
        Allenamento allenamento = new Allenamento();
		allenamento.setData(reqData);
		allenamento.setDurata(reqDurata);
		allenamento.setOra(reqOra);

		AllenamentoDAO allenamentoDAO = new AllenamentoDAO();
		if(allenamentoDAO.inserisciDatiAllenamento(allenamento)) {
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
