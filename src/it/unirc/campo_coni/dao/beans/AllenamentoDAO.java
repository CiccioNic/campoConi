package it.unirc.campo_coni.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.campo_coni.dao.utils.DBManager;

public class AllenamentoDAO {
	
	private Connection conn;
	//in maniera analoga è possibile implementare public Allenatore getStudente(studente) {
	//che restituisce uno studente data la sua matricola
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
	public Vector<Allenamento> getAllenamenti(){
		String query = "SELECT * FROM ALLENAMENTO";
		Vector<Allenamento> res = new Vector<Allenamento>();
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Allenamento allenamento = new Allenamento();
				allenamento.setId(rs.getString("Id"));
				allenamento.setDurata( rs.getString("Durata") );
				allenamento.setData( rs.getString("Data") );
				allenamento.setOra( rs.getString("Ora") );
				res.add(allenamento);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public boolean inserisciDatiAllenamento(Allenamento allenamento) {
		String query = "INSERT INTO ALLENAMENTO(data,ora,durata) VALUES(?,?,?)";	
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, allenamento.getData());
			ps.setString(2, allenamento.getOra());
			ps.setString(3, allenamento.getDurata());
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
