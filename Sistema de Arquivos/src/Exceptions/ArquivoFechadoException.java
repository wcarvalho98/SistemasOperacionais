package Exceptions;

public class ArquivoFechadoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ArquivoFechadoException() {
		super("Arquivo já está fechado!");
	}

}
