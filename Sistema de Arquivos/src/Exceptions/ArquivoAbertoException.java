package Exceptions;

public class ArquivoAbertoException extends Exception{

	private static final long serialVersionUID = 1L;

	public ArquivoAbertoException() {
		super("Arquivo já está aberto!");
	}
	
}
