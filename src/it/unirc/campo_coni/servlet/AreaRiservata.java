package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AreaRiservata
 */
@WebServlet("/AreaRiservata")
public class AreaRiservata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaRiservata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ci restituisce tutti i cookies che il browser ci ha inviato 
		boolean trovatoCookie=false;
		Cookie[] cookies= request.getCookies();
		//se l'utente non ha cookies questo vale null, se è diverso da null scandiamo l'array
		if(cookies!=null) {
			for(int i=0; i<cookies.length; i++) 
				if(cookies[i].getName().equals("loginCookie")){
					String value=cookies[i].getValue();
					// a me interessa sapere se al termine di questa procedura 
					//ho trovato un cookie con quel valore e con quel nome, uso una variabile trovatocookie
					if(value.equals("fewfwe"))
						trovatoCookie=true;
					//quando trovo il cooie che mi interessa esco dal for
					break;
						
			}
		}
		HttpSession session = request.getSession();
		if(session.getAttribute("autenticato")==null && trovatoCookie==false)
			response.sendRedirect("errore.html");
		else {
			response.getWriter().write("Benvenuto nell'area riservata...");
			response.getWriter().write("l'ID di sessione é" + session.getId());
		}
		// TODO Auto-generated method stub
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
