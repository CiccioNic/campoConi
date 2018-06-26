package it.unirc.campo_coni.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;

import it.unirc.campo_coni.dao.utils.DBManager;

public class AllenatoreDAO {
	private Connection conn;
	//in maniera analoga è possibile implementare public Allenatore getStudente(studente) {
	//che restituisce uno studente data la sua matricola
	public Allenatore loginAllenatore(Allenatore allenatore) {
		String query = "SELECT l.IDUTENTE AS id, a.NOME AS nome, a.COGNOME as cognome, "
				+ "a.CODICEFISCALE as codicefiscale, a.LUOGODINASCITA as luogodinascita,"
				+ "a.DATADINASCITA as datadinascita, a.RECAPITOTELEFONICO as recapitotelefonico,"
				+ "a.NCIVICO as numcivico, a.CAP as cap, a.VIA as via,  "
				+ "a. FROM CAMPO_CONI.LOGIN AS l, CAMPO_CONI.ALLENATORE AS a"
				+ " WHERE l.username = ? AND l.password = ? AND l.IDUTENTE=a.IDALLENATORE";
		Allenatore res=new Allenatore();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, allenatore.getUsername());
			ps.setString(2, allenatore.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res.setUsername(rs.getString("username") );
				res.setId(rs.getString("id"));
				res.setCap(rs.getString("cap"));
				res.setVia(rs.getString("via")); 
				res.setNome(rs.getString("nome"));
				res.setCognome(rs.getString("cognome"));
				res.setCodicefiscale(rs.getString("codicefiscale"));
				res.setDatadinascita(rs.getString("datadinascita"));
				res.setLuogodinascita(rs.getString("luogodinascita"));
				res.setRecapitotelefonico(rs.getString("recapitotelefonico"));
				res.setNumcivico(rs.getString("numcivico"));
			} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		DBManager.closeConnection();
		return res;
	}
	public Vector<Allenatore> getAllenatori(){
		String query = "SELECT * FROM ALLENATORE";
		Vector<Allenatore> res = new Vector<Allenatore>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Allenatore allenatore=new Allenatore();
				allenatore.setUsername(rs.getString("Username"));
				allenatore.setNome( rs.getString("Nome") );
				allenatore.setCognome( rs.getString("Cognome") );
				allenatore.setPassword( rs.getString("Password") );
				res.add(allenatore);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public LinkedList<Allenatore> getAllenatorebyNomeCognome(Allenatore allenatore) {
		String query ="SELECT * FROM ALLENATORE a, WHERE (nome = ? AND cognome = ?)";
		LinkedList<Allenatore> res = new LinkedList<Allenatore>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, allenatore.getNome());
			ps.setString(2, allenatore.getCognome());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				allenatore.setNome( rs.getString("Nome") );
				allenatore.setCognome( rs.getString("Cognome") );
				allenatore.setCodicefiscale( rs.getString("Codicefiscale") );
				allenatore.setCap(rs.getString("CAP"));
				allenatore.setDatadinascita(rs.getString("Datadinascita"));
				allenatore.setLuogodinascita(rs.getString("Luogodinascita"));
				allenatore.setRecapitotelefonico(rs.getString("Recapitotelefonico"));
				allenatore.setCap(rs.getString("CAP"));
				allenatore.setVia(rs.getString("Via"));
				allenatore.setNumcivico(rs.getString("Numcivico"));
				res.add(allenatore);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean inserisciDatiAllenatore(Allenatore allenatore) {
		String query = "INSERT INTO allenatore(username, password, nome, cognome, codicefiscale, datadinascita,"
				+ " luogodinascita, recapitotelefonico, numcivico, cap, via) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, allenatore.getUsername());
			ps.setString(2, allenatore.getPassword());
			ps.setString(3, allenatore.getNome());
			ps.setString(4, allenatore.getCognome());
			ps.setString(5, allenatore.getCodicefiscale());
			ps.setString(6, allenatore.getDatadinascita());
			ps.setString(7, allenatore.getLuogodinascita());
			ps.setString(8, allenatore.getRecapitotelefonico());
			ps.setString(9, allenatore.getNumcivico());
			ps.setString(10, allenatore.getCap());
			ps.setString(11, allenatore.getVia());
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
