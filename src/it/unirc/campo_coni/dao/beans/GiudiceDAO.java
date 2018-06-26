package it.unirc.campo_coni.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;

import it.unirc.campo_coni.dao.utils.DBManager;

public class GiudiceDAO {
	private Connection conn;
	//in maniera analoga è possibile implementare public Allenatore getStudente(studente) {
	//che restituisce uno studente data la sua matricola
	public Giudice loginGiudice(Giudice giudice) {
		String query = "SELECT l.IDUTENTE AS id, g.NOME AS nome, g.COGNOME as cognome, "
				+ "g.CODICEFISCALE as codicefiscale, g.NCIVICO as numcivico,"
				+ "g.CAP as cap, g.VIA as via,"
				+ "FROM CAMPO_CONI.LOGIN AS l, CAMPO_CONI.GIUDICE AS g"
				+ "WHERE l.username = ? AND l.password = ? AND l.IDUTENTE=g.IDGIUDICE";
		Giudice res=new Giudice();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, giudice.getUsername());
			ps.setString(2, giudice.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res.setUsername(rs.getString("username") );
				res.setId(rs.getString("id"));
				res.setCap(rs.getString("cap"));
				res.setVia(rs.getString("via")); 
				res.setNome(rs.getString("nome"));
				res.setCognome(rs.getString("cognome"));
				res.setCodicefiscale(rs.getString("codicefiscale"));
				res.setNumcivico(rs.getString("numcivico"));
			} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		DBManager.closeConnection();
		return res;
	}
	public Vector<Giudice> getGiudici(){
		String query = "SELECT * FROM GIUDICE";
		Vector<Giudice> res = new Vector<Giudice>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Giudice giudice=new Giudice();
				giudice.setUsername(rs.getString("Username"));
				giudice.setNome( rs.getString("Nome") );
				giudice.setCognome( rs.getString("Cognome") );
				giudice.setPassword( rs.getString("Password") );
				res.add(giudice);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public LinkedList<Giudice> getGiudicebyNomeCognome(Giudice giudice) {
		String query ="SELECT * FROM GIUDICE a, WHERE (nome = ? AND cognome = ?)";
		LinkedList<Giudice> res = new LinkedList<Giudice>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, giudice.getNome());
			ps.setString(2, giudice.getCognome());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				giudice.setNome( rs.getString("Nome") );
				giudice.setCognome( rs.getString("Cognome") );
				giudice.setCodicefiscale( rs.getString("Codicefiscale") );
				giudice.setRecapitotelefonico(rs.getString("Recapitotelefonico"));
				giudice.setCap(rs.getString("CAP"));
				giudice.setVia(rs.getString("Via"));
				giudice.setNumcivico(rs.getString("Numcivico"));
				res.add(giudice);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public boolean inserisciDatiGiudice(Giudice giudice) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO giudice(username,password,nome,cognome,codicefiscale,recapitotelefonico,numcivico,cap,via) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)"; 		
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, giudice.getUsername());
			ps.setString(2, giudice.getPassword());
			ps.setString(3, giudice.getNome());
			ps.setString(4, giudice.getCognome());
			ps.setString(5, giudice.getCodicefiscale());
			ps.setString(6, giudice.getRecapitotelefonico());
			ps.setString(7, giudice.getNumcivico());
			ps.setString(8, giudice.getCap());
			ps.setString(9, giudice.getVia());
			ps.executeUpdate();
			//if(rs.next()) {
			//res.setUsername(rs.getString("username") );
			//res.setId(rs.getString("id"));
			//res.setCap(rs.getString("cap"));
			//res.setVia(rs.getString("via")); 
			//res.setNome(rs.getString("nome"));
			//res.setCognome(rs.getString("cognome"));
			//res.setCodicefiscale(rs.getString("codicefiscale"));
			//res.setNumcivico(rs.getString("numcivico"));} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		DBManager.closeConnection();
		return true;
	}
}


	


