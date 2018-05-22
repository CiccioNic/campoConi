package it.unirc.campo_coni.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.campo_coni.dao.beans.Allenatore;
import it.unirc.campo_coni.dao.beans.AllenatoreDAO;
import it.unirc.campo_coni.dao.beans.Atleta;
import it.unirc.campo_coni.dao.beans.AtletaDAO;
import it.unirc.campo_coni.dao.beans.Giudice;
import it.unirc.campo_coni.dao.beans.GiudiceDAO;
import it.unirc.campo_coni.dao.beans.Squadra;
import it.unirc.campo_coni.dao.beans.SquadraDAO;

/**
 * Servlet implementation class RicercaAtleta
 */
@WebServlet("/Ricerca")
public class Ricerca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ricerca() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ruolo=request.getParameter("ruolo");
		if(ruolo.equals("atleta")) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			//int nome=Integer.parseInt(nome1);
			//int cognome = Integer.parseInt(cognome1);
			Atleta atleta = new Atleta(nome,cognome);
			AtletaDAO atletaDAO=new AtletaDAO();
			LinkedList<Atleta> atleti=atletaDAO.getAtletabyNomeCognome(atleta);


			/*
		Atleta[] a=new Atleta[10];
		Vector<Atleta> a1 = new Vector<Atleta>();
		List<Atleta> l;
		l=new ArrayList<Atleta>();
		l=new LinkedList<>();*/


			request.setAttribute("atleta", atleta);
			//questo componente fa il forward a qualcun altro
			request.getRequestDispatcher("VisualizzAtleta.jsp ").forward(request,response);
			//la jsp scrivera la response e la restituirà al browser, quindi aggiungo il risultato dell'elaborazione
			//alla mia richiesta e la inoltro alla jsp
			//a differenza del sendredirect il forward è nascosto al browser e permette il passaggio dei parametri a differenza del 
			//sendredirect
		}
		if(ruolo.equals("allenatore")) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			//int nome=Integer.parseInt(nome1);
			//int cognome = Integer.parseInt(cognome1);
			Allenatore allenatore = new Allenatore(nome,cognome);
			AllenatoreDAO allenatoreDAO=new AllenatoreDAO();
			LinkedList<Allenatore> allenatori=allenatoreDAO.getAllenatorebyNomeCognome(allenatore);



			request.setAttribute("allenatore", allenatore);
			request.getRequestDispatcher("VisualizzAtleta.jsp ").forward(request,response);

		}
		if(ruolo.equals("giudice")) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			//int nome=Integer.parseInt(nome1);
			//int cognome = Integer.parseInt(cognome1);
			Giudice giudice = new Giudice(nome,cognome);
			GiudiceDAO giudiceDAO=new GiudiceDAO();
			LinkedList<Giudice> giudici=giudiceDAO.getGiudicebyNomeCognome(giudice);
			request.setAttribute("giudice", giudice);
			request.getRequestDispatcher("VisualizzAtleta.jsp ").forward(request,response);

		}
		if(ruolo.equals("squadra")) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String nome = request.getParameter("nome");
			//int nome=Integer.parseInt(nome1);
			//int cognome = Integer.parseInt(cognome1);
			Squadra squadra = new Squadra(nome);
			SquadraDAO squadraDAO=new SquadraDAO();
		    LinkedList<Squadra> squadre = squadraDAO.getSquadre(squadra);
			request.setAttribute("giudice", giudice);
			request.getRequestDispatcher("VisualizzAtleta.jsp ").forward(request,response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
