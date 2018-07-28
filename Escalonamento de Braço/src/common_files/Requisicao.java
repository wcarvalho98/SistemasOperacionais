package common_files;

public class Requisicao {

	private int id;
	
	public Requisicao(int id) {
		this.id  = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return id +".\tRequisicao [id = " + id + "]";
	}
	
}
