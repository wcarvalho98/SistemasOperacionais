package questao01;

public class Processo {

	private int tamanho;
	private int id;
	private int indice;
	
	public Processo(int tamanho, int id) {
		this.setTamanho(tamanho);
		this.setId(id);
		this.indice = -1;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
}
