public class Process {

	private int id;
	private int tempoTotal;
	private int tempoObtido;
	private int quantum;
	
	public Process(int id, int tempoTotal) {
		this.id = id;
		this.tempoTotal = tempoTotal;
		this.tempoObtido = 0;
	}
	
	public void consumirTempo() {
		try {
			System.out.println("Processo #" + this.id + " está em execução!");
			Thread.sleep(1500);
			this.tempoObtido += this.quantum;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempoTotal <= tempoObtido) {
			fimProcesso();
		}
	}
	
	private void fimProcesso() {
		System.out.println("Processo #" + this.id + " terminou sua execução!");
		this.id = -1;	//Id para retirar da fila de processos
	}
	
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	
	public int getId() {
		return this.id;
	}
	
}
