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
import it.unirc.campo_coni.dao.beans.Gara;
import it.unirc.campo_coni.dao.beans.GaraDAO;

/**
 * Servlet implementation class RicercaGara
 */
@WebServlet("/RicercaGara")
public class ServletRicercaGara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRicercaGara() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String un = request.getParameter("data");
		//per memorizzare l'informazione per un passo solo si usano gli attributi della rihiesta,
		//alla richiesta devo aggiungere un attributo, in questo dovremmo specififcare l'oggetto da passare alla jsp
		GaraDAO garaDAO = new GaraDAO();
		//Gara gara= new Gara(un,"","");
		Vector<Gara> gare = new Vector<Gara>();
		gare = garaDAO.getGare();
		request.setAttribute("gare", gare);//viene messo il risultato del'elaborazione della servlet nella request e questa viene inoltrata alla jsp
		request.getRequestDispatcher("VisualizzaGare.jsp").forward(request, response);//questa response sara quella che verrà inoltrata dalla jsp
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// a differnza del send redirect il browser non vede il forward, il send redirect a differenza non permetteil passaggio di parametri
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
