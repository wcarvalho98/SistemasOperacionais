package scan;

import java.util.ArrayList;

import common_files.Requisicao;

public class Scan {
	
	private final int TAMANHO = 40;
	private int iterador;
	private ArrayList<Requisicao> requisicoes;
	private static Scan instance;
	
	private Scan() {
		this.iterador = 0;
		this.requisicoes = new ArrayList<Requisicao>();
		for (int i = 0; i < TAMANHO; i++)
			requisicoes.add(null);
	}
	
	public static Scan getInstance() {
		if (instance == null)
			instance = new Scan();
		return instance;
	}

	public ArrayList<Requisicao> getRequisicoes() {
		return requisicoes;
	}
	
	public void adicionaRequisicao(int id) {
		Requisicao req = new Requisicao(id);
		requisicoes.set(id, req);
	}
	
	private void atendeRequisicao(int id) {
		requisicoes.set(id, null);
	}
	
	private boolean temRequisicao() {
		boolean resultado = false;
		for (int i = 0; i < TAMANHO && !resultado; i++) {
			if (requisicoes.get(i) != null)
				resultado = true;
		}
		return resultado;
	}
	
	public void escalonaBraco(boolean fim) throws InterruptedException {
		printRequisicoes();
		boolean direita = true;
		while (temRequisicao()) {
			if (requisicoes.get(iterador) == null)
				System.out.println(iterador + ".\tRequisicao []");
			else {
				System.out.println(requisicoes.get(iterador).toString());
				atendeRequisicao(iterador);
			}
			if (direita) {
				if (++iterador == TAMANHO) {
					direita = false;
					iterador -= 2;
				}
			} else {
				if (--iterador == 0)
					direita = true;
			}
			Thread.sleep(500);
		}
		printRequisicoes();
		if (fim)
			System.out.println("Fim das requisições!");
	}
	
	private void printRequisicoes() {
		System.out.println("-----------------------------------------");
		System.out.println("Printando requisições:");
		for (int i = 0; i < TAMANHO; i++) {
			if (requisicoes.get(i) == null)
				System.out.println(i + ".\tRequisicao []");
			else
				System.out.println(requisicoes.get(i).toString());
		}
		System.out.println("-----------------------------------------");
	}
	
}
