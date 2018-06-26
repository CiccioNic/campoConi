package it.unirc.campo_coni.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import it.unirc.campo_coni.dao.utils.DBManager;

public class AtletaDAO {
	private Connection conn;
	public Atleta loginAtleta(Atleta atleta) {
		String query = "SELECT l.IDUTENTE AS id, a.NOME AS nome, a.COGNOME as cognome, "
				+ "a.CODICEFISCALE as codicefiscale, a.LUOGODINASCITA as luogodinascita,"
				+ "a.DATADINASCITA as datadinascita, a.RECAPITOTELEFONICO as recapitotelefonico,"
				+ "a.DATAINZIO as datainizio, a.DATAFINE as datafine"
				+ "a.NCIVICO as numcivico, a.CAP as cap, a.VIA as via,  "
				+ "FROM CAMPO_CONI.LOGIN AS l, CAMPO_CONI.ALLENATORE AS a"
				+ "WHERE l.username = ? AND l.password = ? AND l.IDUTENTE=a.IDATLETA";
		Atleta res=new Atleta();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, atleta.getUsername());
			ps.setString(2, atleta.getPassword());
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
				res.setDatainizio(rs.getString("datainizio"));
				res.setDatafine("datafine");
			} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		DBManager.closeConnection();
		return res;
	}
	public Vector<Atleta> getAtleti(){
		String query = "SELECT * FROM ATLETA";
		Vector<Atleta> res = new Vector<Atleta>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Atleta atleta=new Atleta();
				atleta.setUsername(rs.getString("Username"));
				atleta.setNome( rs.getString("Nome") );
				atleta.setCognome( rs.getString("Cognome") );
				atleta.setPassword( rs.getString("Password") );
				res.add(atleta);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public Vector<Atleta> getAtletibySquadra(Squadra squadra){
		String query ="SELECT a.* FROM ATLETA a, SQUADRA sq WHERE (nome= ? AND a.idsquadra=sq.idsquadra)";
		Vector<Atleta> res = new Vector<Atleta>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, squadra.getNome());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Atleta atleta=new Atleta();
				atleta.setNome( rs.getString("Nome") );
				atleta.setCognome( rs.getString("Cognome") );
				atleta.setCodicefiscale( rs.getString("Codicefiscale") );
				atleta.setCap(rs.getString("CAP"));
				atleta.setDatadinascita(rs.getString("Datadinascita"));
				atleta.setLuogodinascita(rs.getString("Luogodinascita"));
				atleta.setRecapitotelefonico(rs.getString("Recapitotelefonico"));
				atleta.setDatafine(rs.getString("Datafine"));
				atleta.setDatainizio(rs.getString("Datainizio"));
				atleta.setCap(rs.getString("CAP")); 
				atleta.setVia(rs.getString("Via"));
				atleta.setNumcivico(rs.getString("Numcivico"));
				res.add(atleta);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public LinkedList<Atleta> getAtletabyNomeCognome(Atleta atleta) {
		String query ="SELECT * FROM ATLETA a, WHERE (nome = ? AND cognome = ?)";
		LinkedList<Atleta> res = new LinkedList<Atleta>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, atleta.getNome());
			ps.setString(2, atleta.getCognome());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				atleta.setNome( rs.getString("Nome") );
				atleta.setCognome( rs.getString("Cognome") );
				atleta.setCodicefiscale( rs.getString("Codicefiscale") );
				atleta.setCap(rs.getString("CAP"));
				atleta.setDatadinascita(rs.getString("Datadinascita"));
				atleta.setLuogodinascita(rs.getString("Luogodinascita"));
				atleta.setRecapitotelefonico(rs.getString("Recapitotelefonico"));
				atleta.setDatafine(rs.getString("Datafine"));
				atleta.setDatainizio(rs.getString("Datainizio"));
				atleta.setCap(rs.getString("CAP"));
				atleta.setVia(rs.getString("Via"));
				atleta.setNumcivico(rs.getString("Numcivico"));
				res.add(atleta);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public boolean inserisciDatiAtleta(Atleta atleta) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO atleta(username,password,nome,cognome,codicefiscale,datadinascita,"
				+ "luogodinascita,recapitotelefonico,datainizio,datafine,numcivico,cap,via) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"; 		
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, atleta.getUsername());
			ps.setString(2, atleta.getPassword());
			ps.setString(3, atleta.getNome());
			ps.setString(4, atleta.getCognome());
			ps.setString(5, atleta.getCodicefiscale());
			ps.setString(6, atleta.getDatadinascita());
			ps.setString(7, atleta.getLuogodinascita());
			ps.setString(8, atleta.getRecapitotelefonico());
			ps.setString(9, atleta.getDatainizio());
			ps.setString(10, atleta.getDatafine());
			ps.setString(11, atleta.getNumcivico());
			ps.setString(12, atleta.getCap());
			ps.setString(13, atleta.getVia());


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





