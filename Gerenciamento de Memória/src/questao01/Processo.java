package questao01;

public class Processo implements Comparable<Processo>{

	private int tamanho;
	private int id;
	private int indice;
	private int tempoDeVida;
	
	public Processo(int tamanho, int id, int tempoDeVida) {
		this.setTamanho(tamanho);
		this.setId(id);
		this.indice = -1;
		this.setTempoDeVida(tempoDeVida);
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

	public int getTempoDeVida() {
		return tempoDeVida;
	}

	public void setTempoDeVida(int tempoDeVida) {
		this.tempoDeVida = tempoDeVida;
	}

	@Override
	public int compareTo(Processo p) {
		if (this.getIndice() < p.getIndice())
			return -1;
		if (this.getIndice() > p.getIndice())
			return 1;
		return 0;
	}
	
}
