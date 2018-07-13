package Files;
import java.time.LocalDateTime;

import Exceptions.ArquivoAbertoException;
import Exceptions.ArquivoFechadoException;

public class Arquivo {

	private String nome;
	private String extensao;
	private LocalDateTime dataDeCriacao;
	private LocalDateTime dataDeModificacao;
	private int tamanho;
	private String dados;
	private boolean aberto;
	
	public Arquivo(String nome, String dados) {
		this.dados = dados;
		this.tamanho = dados.length() + 1;
		this.dataDeCriacao = LocalDateTime.now();
		this.dataDeModificacao = LocalDateTime.now();
		this.aberto = false;
		geraNome(nome);
		geraExtensao(nome);
	}
	
	public Arquivo(String nome) {
		this.dados = "";
		this.tamanho = 1;
		this.dataDeCriacao = LocalDateTime.now();
		this.dataDeModificacao = LocalDateTime.now();
		this.aberto = false;
		geraNome(nome);
		geraExtensao(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		this.dataDeModificacao = LocalDateTime.now();
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
		this.dataDeModificacao = LocalDateTime.now();
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public LocalDateTime getDataDeModificacao() {
		return dataDeModificacao;
	}

	public int getTamanho() {
		return tamanho;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
		this.dataDeModificacao = LocalDateTime.now();
		this.tamanho = dados.length() + 1;
	}

	public boolean isAberto() {
		return aberto;
	}
	
	public void fechaArquivo() throws ArquivoFechadoException  {
		if (isAberto()) {
			this.aberto = false;
		} else {
			throw new ArquivoFechadoException();
		}
	}
	
	public void abreArquivo() throws ArquivoAbertoException {
		if (isAberto()) {
			throw new ArquivoAbertoException();
		} else {
			this.aberto = true;
		}
	}

	private void geraNome(String nome) {
		String aux = "";
		for (int i = 0; i < nome.length(); i++) {
			if (nome.charAt(i) != '.') {
				aux += nome.charAt(i);
			} else {
				break;
			}
		}
		this.nome = aux;
	}
	
	private void geraExtensao(String nome) {
		String aux = "";
		boolean getExtensao = false;
		for (int i = 0; i < nome.length(); i++) {
			if (nome.charAt(i) == '.') {
				getExtensao = true;
			}
			if (getExtensao) {
				aux += nome.charAt(i);
			}
		}
		this.extensao = aux;
	}
	
	@Override
	public String toString() {
		String retorno = "\t*****************************************\n";
		retorno += "\t\tArquivo " + this.getNome() + "\n";
		retorno += "\t\t\tTamanho: " + this.getTamanho() + "\n";
		retorno += "\t\t\tExtensão: " + this.getExtensao() + "\n";
		retorno += "\t\t\tData de criação: " + this.getDataDeCriacao() + "\n";
		retorno += "\t\t\tData de modificação: " + this.getDataDeModificacao() + "\n";
		retorno += "\t*****************************************\n";
		return retorno;
	}
	
}
