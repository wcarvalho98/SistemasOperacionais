import java.util.ArrayList;

public class RoundRobin {

	private ArrayList<Process> fila;
	private int quantum;
	private int indice;
	
	public RoundRobin(int quantum) {
		this.fila = new ArrayList<Process>();
		this.quantum = quantum;
		this.indice = 0;
	}
	
	public void addProcess(Process processo) {
		processo.setQuantum(this.quantum);
		this.fila.add(processo);
	}
	
	public void processar() {
		boolean ocupada = true;
		while (ocupada) {
			Process atual = fila.get(this.indice);
			atual.consumirTempo();
			if (atual.getId() == -1) {
				this.fila.remove(this.indice);
				this.indice--;		//Necessário para manter a ordem na fila!
			}
			this.indice++;
			if (this.indice >= this.fila.size())
				this.indice = 0;
			if (this.fila.isEmpty()) {
				System.out.println("Não há mais processos para executar!");
				ocupada = false;
			}
		}
	}
	
}
