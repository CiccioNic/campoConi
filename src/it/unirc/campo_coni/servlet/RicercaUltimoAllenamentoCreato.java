package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Allenamento;
import it.unirc.campo_coni.dao.beans.AllenamentoDAO;

/**
 * Servlet implementation class RicercaUltimoAllenamentoCreato
 */
@WebServlet("/RicercaUltimoAllenamentoCreato")
public class RicercaUltimoAllenamentoCreato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaUltimoAllenamentoCreato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AllenamentoDAO allenamentoDAO = new AllenamentoDAO();
		Allenamento allenamento= new Allenamento();
		allenamento = allenamentoDAO.getUltimoAllenamentoCreato();
		request.setAttribute("allenamento", allenamento);
		request.getRequestDispatcher("UltimoAllenamentoCreato.jsp").forward(request, response);
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
