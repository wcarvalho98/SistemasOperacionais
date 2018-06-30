package questao02;

import java.util.ArrayList;
import java.util.Random;

class Processo {

	private ArrayList<Pagina> pages;
	private int id;
	private int tempoDeVida;
	
	public Processo(int id, int tempoDeVida) {
		this.setId(id);
		this.setTempoDeVida(tempoDeVida);
		this.pages = new ArrayList<Pagina>(4);
		for (int i = 0; i < 4; i++)
			pages.add(new Pagina(id, i));
	}
	
	public int processa() {
		Random r = new Random();
		return r.nextInt(4);
	}
	
	public Pagina getPagina(int id) {
		return pages.get(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTempoDeVida() {
		return tempoDeVida;
	}

	public void setTempoDeVida(int tempoDeVida) {
		this.tempoDeVida = tempoDeVida;
	}
	
}
