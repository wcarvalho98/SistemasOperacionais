package questao01;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		MP memoria = MP.getInstance();
		
		Processo p0 = new Processo(102400, 0, 2);
		Processo p1 = new Processo(102400, 1, 5);
		Processo p2 = new Processo(102400, 2, 5);
		Processo p3 = new Processo(102400, 3, 3);
		Processo p4 = new Processo(204800, 4, 2);
		Processo p5 = new Processo(102400, 5, 3);
		Processo p6 = new Processo(102400, 6, 4);
		Processo p7 = new Processo(102400, 7, 3);
		Processo p8 = new Processo(102400, 8, 1);
		Processo p9 = new Processo(102400, 9, 2);
		
		memoria.adicionaProcesso(p0);
		memoria.adicionaProcesso(p1);
		memoria.adicionaProcesso(p2);
		memoria.adicionaProcesso(p3);
		memoria.adicionaProcesso(p4);
		memoria.adicionaProcesso(p5);
		memoria.adicionaProcesso(p6);
		memoria.adicionaProcesso(p7);
		memoria.adicionaProcesso(p8);
		memoria.adicionaProcesso(p9);
		
		memoria.gerenciaProcessos();
		
	}
	
}
