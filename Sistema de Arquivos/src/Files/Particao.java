package Files;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Particao {

	private String nome;
	private int tamanhoTotal;
	private int tamanhoUtilizado;
	private ArrayList<Diretorio> diretorios;
	private LocalDateTime dataDeCriacao;
	
	public Particao(String nome, int tamanhoTotal) {
		this.nome = nome;
		this.tamanhoTotal = tamanhoTotal;
		this.tamanhoUtilizado = 0;
		this.diretorios = new ArrayList<Diretorio>();
		this.dataDeCriacao = LocalDateTime.now();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTamanhoTotal() {
		return tamanhoTotal;
	}

	public void setTamanhoTotal(int tamanhoTotal) {
		this.tamanhoTotal = tamanhoTotal;
	}

	public int getTamanhoUtilizado() {
		return tamanhoUtilizado;
	}

	public ArrayList<Diretorio> getDiretorios() {
		return diretorios;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}
	
	public void adicionaDiretorio(Diretorio dir) {
		this.diretorios.add(dir);
		this.tamanhoUtilizado += dir.getTamanho();
	}
	
	public void atualizaTamanho() {
		this.tamanhoUtilizado = 0;
		for (int i = 0; i < diretorios.size(); i++)
			this.tamanhoUtilizado += diretorios.get(i).getTamanho();
	}
	
	@Override
	public String toString() {
		String retorno = "----------------------------------------------------------------\n";
		retorno += "Partição " + this.getNome() + "\n";
		retorno += "\tTamanho total: " + this.tamanhoTotal + "\n";
		retorno += "\tTamanho utilizado: " + this.tamanhoUtilizado + "\n";
		retorno += "\tData de criação: " + this.dataDeCriacao + "\n";
		if (diretorios.size() != 0) {
			retorno += "\tDiretórios dentro dessa partição:\n";
			Diretorio dir;
			for (int i = 0; i < diretorios.size(); i++) {
				dir = diretorios.get(i);
				retorno += "\t*****************************************\n";
				retorno += "\t\tDiretório " + dir.getNome() + "\n";
				retorno += "\t\t\tTamanho: " + dir.getTamanho() + "\n";
				retorno += "\t\t\tData de criação: " + dir.getDataDeCriacao() + "\n";
				retorno += "\t\t\tData de modificação: " + dir.getDataDeModificacao() + "\n";
				retorno += "\t*****************************************\n";
			}
		}
		retorno += "----------------------------------------------------------------\n";
		return retorno;
	}
	
}
