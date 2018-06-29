package questao01;

import java.util.ArrayList;

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
	
	public void gerenciaProcessos() {
		while (true) {
			
		}
	}
	
	private boolean alocaProcesso(Processo p) {
		boolean aloca = false;
		if (p.getTamanho() > espacoDisponivel) {
			System.out.println("Processo #" + p.getId() + " maior que espaço disponível!");
			return aloca;			
		}
		int tamanho = p.getTamanho() / BITMAP;
		int counter = 0;
		int idx = 0;
		for (int i = 0; i < alocado.length; i++) {
			if (!alocado[i]) {
				counter++;
				if (counter == tamanho) {
					idx = i - (counter - 1);
					aloca = true;
					break;
				}
			} else {
				counter = 0;
			}
		}
		for (int i = idx; i < (idx + tamanho); i++) 
			alocado[i] = true;
		p.setIndice(idx);
		return aloca;		
	}
	
	private boolean segmentaMemoria() {
		boolean segmenta = false;
		return segmenta;
	}
	
}
