package questao01;

import java.util.ArrayList;
import java.util.Collections;

public class MP {
	
	private final int TAMANHO = 512000;		//valor em kb
	private final int BITMAP = 4;			//valor em kb
	private static MP instance;
	private int espacoDisponivel;
	private boolean[] alocado;
	private ArrayList<Processo> processos;
	
	private MP() {
		this.alocado = new boolean[TAMANHO/BITMAP];
		this.processos = new ArrayList<Processo>();
		this.espacoDisponivel = TAMANHO;
		for (int i = 0; i < this.alocado.length; i++)
			this.alocado[i] = false;
	}
	
	public static MP getInstance() {
		if (instance == null)
			instance = new MP();
		return instance;
	}
	
	public void adicionaProcesso(Processo p) {
		processos.add(p);
	}
	
	public void gerenciaProcessos() throws InterruptedException {
		int iterador = 0;
		Processo atual;
		while (!processos.isEmpty()) {
			atual = processos.get(iterador);
			if (atual.getIndice() == -1) {
				if (atual.getTamanho() > espacoDisponivel) {
					System.err.println("Processo #" + atual.getId() + " maior que espaço disponível!");
				} else {
					if(alocaProcesso(atual)) {
						System.out.println("Processo #" + atual.getId() + " alocado na memória!");
						System.out.println("Tamanho do processo: " + atual.getTamanho());
						System.out.println("Espaço disponível atualmente: " + this.espacoDisponivel);
					} else {
						System.out.println("Segmentando memória para alocar o processo #" + atual.getId() + "!");
						segmentaMemoria();
						System.out.println("Memória segmentada!");
						if (alocaProcesso(atual)) {
							System.out.println("Processo #" + atual.getId() + " alocado na memória!");							
						} else {
							System.err.println("Ocorreu um erro ao alocar o processo #" + atual.getId() + "!");
						}
					}
				}
			}
			if (++iterador == processos.size()) {
				desalocaProcesso();
				iterador = 0;
			}
			Thread.sleep(1000);
		}
	}
	
	private boolean alocaProcesso(Processo p) {
		boolean aloca = false;
		int tamanho = (int) Math.nextUp((float) (p.getTamanho() / BITMAP));
		int counter = 0;
		int idx = 0;
		for (int i = 0; i < alocado.length; i++) {
			if (!alocado[i]) {
				counter++;
				if (counter == tamanho) {
					idx = i - (counter - 1);
					aloca = true;
					if ((p.getTamanho() % BITMAP) == 0) {
						this.espacoDisponivel -= p.getTamanho();
					} else {
						this.espacoDisponivel -= ((BITMAP - (p.getTamanho() % BITMAP)) + p.getTamanho());
					}
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (!aloca)
			return aloca;
		for (int i = idx; i < (idx + tamanho); i++) 
			alocado[i] = true;
		p.setIndice(idx);
		return aloca;		
	}
	
	private void desalocaProcesso() {
		if (this.espacoDisponivel == TAMANHO) {
			System.out.println("Sem processos na memória!");
			return;
		}
		ArrayList<Processo> remover = new ArrayList<Processo>();
		for (Processo p : this.processos) {
			if (p.getIndice() != -1) {
				if (p.getTempoDeVida() == 1) {
					if ((p.getTamanho() % BITMAP) == 0) {
						this.espacoDisponivel += p.getTamanho();
					} else {
						this.espacoDisponivel += ((BITMAP - (p.getTamanho() % BITMAP)) + p.getTamanho());
					}
					desalocaProcesso(p);
					remover.add(p);
				} else {
					p.setTempoDeVida(p.getTempoDeVida() - 1);
					System.out.println("Processo #" + p.getId() + " possui " 
					+ p.getTempoDeVida() + " unidades de tempo restante!");
				}
			}
		}
		for (int i = 0; i < remover.size(); i++) {
			processos.remove(remover.get(i));
			System.out.println("Processo #" + remover.get(i).getId() + " está saindo da memória!");
		}
	}
	
	private void desalocaProcesso(Processo p) {
		int idx = p.getIndice();
		int tamanho = (int) Math.nextUp((float) (p.getTamanho() / BITMAP));
		for (int i = idx; i < (idx + tamanho); i++)
			alocado[i] = false;
	}
	
	private void alocaProcesso(Processo p, int indice) {
		int tamanho = (int) Math.nextUp((float) (p.getTamanho() / BITMAP));
		for (int i = indice; i < (indice + tamanho); i++)
			alocado[i] = true;
	}
	
	private void segmentaMemoria() {
		ArrayList<Processo> alocados = new ArrayList<Processo>();
		for (Processo p : this.processos) {
			if (p.getIndice() != -1)
				alocados.add(p);
		}
		Collections.sort(alocados);
		Processo atual;
		int tmp;
		for (int i = 0; i < alocados.size(); i++) {
			atual = alocados.get(i);
			tmp = -1;
			for (int j = 0; j < atual.getIndice(); j++) {
				if (!alocado[j]) {
					tmp = j;
					break;
				}
			}
			if (tmp != -1) {
				desalocaProcesso(atual);
				alocaProcesso(atual, tmp);
			}
		}
	}
	
}
