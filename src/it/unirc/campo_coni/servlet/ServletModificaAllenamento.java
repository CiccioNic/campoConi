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
 * Servlet implementation class ServletModificaAllenamento
 */
@WebServlet("/ServletModificaAllenamento")
public class ServletModificaAllenamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificaAllenamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqAzione=request.getParameter("reqAzione");

		if(reqAzione.equals("durata")) {
			String reqDurata=request.getParameter("durata");
			Allenamento allenamento = new Allenamento();
			allenamento.setData(reqDurata);
			AllenamentoDAO allenamentoDAO = new AllenamentoDAO();
			if(allenamentoDAO.modificaDataAllenamento(allenamento));
			
			
			
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
