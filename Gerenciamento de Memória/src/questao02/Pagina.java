package questao02;

class Pagina {

	private int idProcesso;
	private int id;
	
	public Pagina(int idProcesso, int id) {
		setIdProcesso(idProcesso);
		setId(id);
	}
	
	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
}
