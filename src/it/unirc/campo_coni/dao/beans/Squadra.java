package it.unirc.campo_coni.dao.beans;

public class Squadra {
	private String id;
	private String nome;
	private String colorimaglia;
	
	
	public Squadra() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    public Squadra(String nome) {
		super();
		this.nome = nome;
	}


	public Squadra(String id, String nome, String colorimaglia) {
		super();
		this.id = id;
		this.nome = nome;
		this.colorimaglia = colorimaglia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getColorimaglia() {
		return colorimaglia;
	}

	public void setColorimaglia(String colorimaglia) {
		this.colorimaglia = colorimaglia;
	}
    
	

}
