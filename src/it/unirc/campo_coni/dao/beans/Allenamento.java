package it.unirc.campo_coni.dao.beans;

public class Allenamento {
	private String id;
	private String durata;
	private String data;
	private String ora;
	
	public Allenamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Allenamento(String id, String durata, String data, String ora) {
		super();
		this.id = id;
		this.durata = durata;
		this.data = data;
		this.ora = ora;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}
	
	
	
	

}
