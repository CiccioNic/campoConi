package it.unirc.campo_coni.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.campo_coni.dao.utils.DBManager;

public class GaraDAO {
	private Connection conn;
	public Vector<Gara> getGara(){
		String query = "SELECT * FROM GARA";
		Vector<Gara> res = new Vector<Gara>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Gara gara = new Gara();
				gara.setId(rs.getString("Id"));
				gara.setData( rs.getString("Data") );
				gara.setOra( rs.getString("Ora") );
				res.add(gara);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public boolean inserisciDatiGara() {
		String query = "INSERT INTO gara(data,ora) VALUES(?,?)"; 		
		Gara gara = new Gara();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, gara.getData());
			ps.setString(2, gara.getOra());
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








