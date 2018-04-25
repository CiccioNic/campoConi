package it.unirc.campo_coni.dao.beans;

public class Allenatore {
	private String id;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String codicefiscale;
	private String datadinascita;
	private String luogodinascita;
	private String recapitotelefonico;
	private String numcivico;
	private String cap;
	private String via;
	public Allenatore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Allenatore(String id, String username, String password, String nome, String cognome, String codicefiscale,
			String datadinascita, String luogodinascita, String recapitotelefonico, String numcivico, String cap,
			String via) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.codicefiscale = codicefiscale;
		this.datadinascita = datadinascita;
		this.luogodinascita = luogodinascita;
		this.recapitotelefonico = recapitotelefonico;
		this.numcivico = numcivico;
		this.cap = cap;
		this.via = via;
	}
	
	public Allenatore(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodicefiscale() {
		return codicefiscale;
	}
	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	public String getDatadinascita() {
		return datadinascita;
	}
	public void setDatadinascita(String datadinascita) {
		this.datadinascita = datadinascita;
	}
	public String getLuogodinascita() {
		return luogodinascita;
	}
	public void setLuogodinascita(String luogodinascita) {
		this.luogodinascita = luogodinascita;
	}
	public String getRecapitotelefonico() {
		return recapitotelefonico;
	}
	public void setRecapitotelefonico(String recapitotelefonico) {
		this.recapitotelefonico = recapitotelefonico;
	}
	public String getNumcivico() {
		return numcivico;
	}
	public void setNumcivico(String numcivico) {
		this.numcivico = numcivico;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	
	
	
}

	
	