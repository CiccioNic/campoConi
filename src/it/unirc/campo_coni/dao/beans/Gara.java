package it.unirc.campo_coni.dao.beans;

public class Gara {
	private String id;
	private String data;
	private String ora;
	
	public Gara() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gara(String id, String data, String ora) {
		super();
		this.id = id;
		this.data = data;
		this.ora = ora;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
