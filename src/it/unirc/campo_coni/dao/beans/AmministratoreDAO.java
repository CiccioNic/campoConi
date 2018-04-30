package it.unirc.campo_coni.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unirc.campo_coni.dao.utils.DBManager;

public class AmministratoreDAO {
	private Connection conn;
	public Amministratore loginAmminidtratore(Amministratore amministratore) {
		String query = "SELECT l.IDUTENTE AS id,"
				+ "FROM CAMPO_CONI.LOGIN AS l, CAMPO_CONI.AMMINISTRATORE AS a"
				+ "WHERE l.username = ? AND l.password = ? AND l.IDUTENTE=a.IDAMMINISTRATORE";
		Amministratore res=new Amministratore();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, amministratore.getUsername());
			ps.setString(2, amministratore.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res.setUsername(rs.getString("username") );
				res.setId(rs.getString("id"));
			} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		DBManager.closeConnection();
		return res;
	}
	public boolean inserisciDatiSquadra(Squadra squadra) {
		String query = "INSERT INTO ALLENAMENTO(nome,colorimaglia) VALUES(?,?)";	
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, squadra.getNome());
			ps.setString(2, squadra.getColorimaglia());
			ResultSet rs = ps.executeQuery();
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
