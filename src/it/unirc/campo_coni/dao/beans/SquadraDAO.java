package it.unirc.campo_coni.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.campo_coni.dao.utils.DBManager;

public class SquadraDAO {
	private Connection conn;
	public Vector<Squadra> getSquadre(){
		String query = "SELECT * FROM SQUADRA";
		Vector<Squadra> res = new Vector<Squadra>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Squadra squadra = new Squadra();
				squadra.setId(rs.getString("id"));
				squadra.setNome(rs.getString("nome"));
				squadra.setColorimaglia(rs.getString("colorimaglia"));
				res.add(squadra);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public boolean inserisciDatiSquadra(Squadra squadra) {
		String query = "INSERT INTO SQUADRA(nome,colorimaglia) VALUES(?,?)";	
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, squadra.getNome());
			ps.setString(2, squadra.getColorimaglia());
		//	ResultSet rs = 
			ps.executeQuery();
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



