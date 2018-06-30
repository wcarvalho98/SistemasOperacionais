package questao02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class MP {

	private ArrayList<Processo> processos;
	private Queue<Pagina> paginas;
	private static MP instance;
	
	private MP() {
		this.paginas = new LinkedList<Pagina>();
		this.processos = new ArrayList<Processo>(4);
	}
	
	public static MP getInstance() {
		if (instance == null)
			instance = new MP();
		return instance;
	}
	
	public void adicionaProcesso(Processo p) {
		this.processos.add(p);
	}
	
	public void gerenciaProcessos() throws InterruptedException {
		int iterador = 0;
		Processo atual;
		int pagina;
		while (!processos.isEmpty()) {
			atual = processos.get(iterador);
			pagina = atual.processa();
			if (paginas.contains(atual.getPagina(pagina))) {
				processa(atual, pagina);
			} else {
				System.err.println("Falta da página #" + atual.getPagina(pagina).getId() + " "
						+ "do processo #" + atual.getId() + "!");
				escalonaPagina(atual, pagina);
				processa(atual, pagina);
			}
			if (++iterador == processos.size())
				iterador = 0;
		}
	}
	
	private void processa(Processo atual, int pagina) throws InterruptedException {
		System.out.println("Processo #" + atual.getId() + " está utilizando "
				+ "a página #" + atual.getPagina(pagina).getId());
		Thread.sleep(3000);
		if (atual.getTempoDeVida() == 1) {
			processos.remove(atual);
			System.out.println("Processo #" + atual.getId() + " está saindo da memória!");
		} else {
			atual.setTempoDeVida(atual.getTempoDeVida() - 1);
			System.out.println("Processo #" + atual.getId() + " possui "
					+ "" + atual.getTempoDeVida() + " unidades de tempo restante!");
		}
	}
	
	private void escalonaPagina(Processo p, int pagina) {
		if (paginas.size() == 8) {
			paginas.poll();
		}
		paginas.offer(p.getPagina(pagina));
	}
	
}
