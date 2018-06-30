package questao02;

class Main {

	public static void main(String[] args) throws InterruptedException {
		
		MP memoria = MP.getInstance();
		
		Processo p0 = new Processo(0, 3);
		Processo p1 = new Processo(1, 3);
		Processo p2 = new Processo(2, 3);
		Processo p3 = new Processo(3, 3);
		
		memoria.adicionaProcesso(p0);
		memoria.adicionaProcesso(p1);
		memoria.adicionaProcesso(p2);
		memoria.adicionaProcesso(p3);
		
		memoria.gerenciaProcessos();

	}

}
