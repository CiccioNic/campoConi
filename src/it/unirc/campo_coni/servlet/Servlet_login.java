package it.unirc.campo_coni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.campo_coni.dao.beans.Allenatore;
import it.unirc.campo_coni.dao.beans.AllenatoreDAO;
import it.unirc.campo_coni.dao.beans.Atleta;
import it.unirc.campo_coni.dao.beans.AtletaDAO;
import it.unirc.campo_coni.dao.beans.Giudice;
import it.unirc.campo_coni.dao.beans.GiudiceDAO;

/**
 * Servlet implementation class Servlet_login
 */
@WebServlet("/Servlet_login")
public class Servlet_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stud
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqUser = request.getParameter("username");
		String reqPassword = request.getParameter("password");
		String ruolo=request.getParameter("ruolo");

		if(ruolo.equals("allenatore")) {
			Allenatore allenatore = new Allenatore();
			allenatore.setUsername(reqUser);
			allenatore.setPassword(reqPassword);
			AllenatoreDAO allenatoredao = new AllenatoreDAO();
			if(allenatoredao.loginAllenatore(allenatore)!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("autenticato" , true);
				String ricorda=request.getParameter("ricorda");
				if(ricorda!=null && ricorda.equals("1")) {
					Cookie cookie = new Cookie("loginCookie", "fewfwe");
					//questo cookie vuole un nome e un valore
					//il valore dovrebbe essere imprecidibile
					cookie.setMaxAge(60*60*24*2);
					//il cookie deve essere restituito assieme alla pagina al browser
					response.addCookie(cookie);
				}
				response.sendRedirect("area_riservata.html");
			}

			else 
				response.sendRedirect("errore.html");
		}


		if(ruolo.equals("atleta")) {
			Atleta atleta = new Atleta();
			atleta.setUsername(reqUser);
			atleta.setPassword(reqPassword);
			AtletaDAO atletadao = new AtletaDAO();
			if(atletadao.loginAtleta(atleta)!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("autenticato" , true);
				response.sendRedirect("area_riservata.html");
				//			String ricorda=request.getParameter("ricorda");
				//			//quando l'utente non clicca su ricorda questo getParameter è null e quindi questo if non lo può fare
				//			if(ricorda!=null && ricorda.equals("1")) {
				//				System.out.println("aggiungo cookie");
				//				Cookie cookie = new Cookie("loginCookie", "fewfwe");
				//				//questo cookie vuole un nome e un valore
				//				//il valore dovrebbe essere imprecidibile
				//				cookie.setMaxAge(60*60*24*2);
				//				//il cookie deve essere restituito assieme alla pagina al browser
				//				response.addCookie(cookie);
			}
			else 
				response.sendRedirect("errore.html");
		}
		if(ruolo.equals("giudice")) {
			Giudice giudice= new Giudice();
			giudice.setUsername(reqUser);
			giudice.setPassword(reqPassword);
			GiudiceDAO giudicedao = new GiudiceDAO();
			if(giudicedao.loginGiudice(giudice)!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("autenticato" , true);
				response.sendRedirect("area_riservata.html");
				String ricorda=request.getParameter("ricorda");
				//				if(ricorda!=null && ricorda.equals("1")) {
				//					Cookie cookie = new Cookie("loginCookie", "fewfwe");
				//					//questo cookie vuole un nome e un valore
				//					//il valore dovrebbe essere imprecidibile
				//					cookie.setMaxAge(60*60*24*2);
				//					//il cookie deve essere restituito assieme alla pagina al browser
				//					response.addCookie(cookie);
			}
			else {
				response.sendRedirect("errore.html");
			}
		}
	}
}
