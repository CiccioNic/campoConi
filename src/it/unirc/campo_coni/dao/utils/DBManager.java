package it.unirc.campo_coni.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static Connection conn = null;
	private static final String DbDriver = "oracle.jdbc.driver.OracleDriver";
	private static final String DbURL = "jdbc:oracle:thin:@localhost:1521:GlobalDB";
	private static final String username = "CAMPO_CONI";
	private static final String password = "CAMPO_CONI";
	// private static String DbDriver = "com.mysql.jdbc.Driver";
	// private static String DbURL = "jdbc:mysql://localhost:3306/test";
	// private static String username = "root";
	// private static String password = "";
	private DBManager(){}
	/**
	* Metododo che restituisce true se la connessione e' aperta.
	*/
	public static boolean isOpen(){
	// if (conn == null)
	// return false;
	// else
	// return true;
	return (conn!=null);
	}
	public static Connection startConnection(){
	if ( isOpen() )
	return conn;
	try {
	Class.forName(DbDriver);// Carica il Driver del DBMS
	conn = DriverManager.getConnection(DbURL, username, password);// Apertura connessione
	}
	catch (Exception e) {
	e.printStackTrace();
	return null;
	}
	return conn;
	}
	public static boolean closeConnection(){
	if ( !isOpen() )
	return true;
	try {
	conn.close();
	conn = null;
	}
	catch (SQLException e){
	e.printStackTrace();
	return false;
	}
	return true;
	}
	
}
