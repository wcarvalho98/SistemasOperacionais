import java.util.concurrent.Semaphore;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		
						//Variável de bloqueio//
		
		/**Processo p0 = new Processo(0);
		Processo p1 = new Processo(1);
		Processo p2 = new Processo(2);
		Processo p3 = new Processo(3);
		Processo p4 = new Processo(4);
		
		new Thread(p0).start();
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
		new Thread(p4).start();*/
		
						//Semáforo//
		
		/**Semaphore semaforo = new Semaphore(2);
		
		ProcessoSem ps0 = new ProcessoSem(0, semaforo);
		ProcessoSem ps1 = new ProcessoSem(1, semaforo);
		ProcessoSem ps2 = new ProcessoSem(2, semaforo);
		ProcessoSem ps3 = new ProcessoSem(3, semaforo);
		ProcessoSem ps4 = new ProcessoSem(4, semaforo);
		
		new Thread(ps0).start();
		new Thread(ps1).start();
		new Thread(ps2).start();
		new Thread(ps3).start();
		new Thread(ps4).start();*/
		
						//Round Robin//
		
		/**RoundRobin escalonador = new RoundRobin(5);
		
		Process pr0 = new Process(0, 10);
		Process pr1 = new Process(1, 10);
		Process pr2 = new Process(2, 10);
		Process pr3 = new Process(3, 10);
		Process pr4 = new Process(4, 10);
		Process pr5 = new Process(5, 10);
		Process pr6 = new Process(6, 10);
		Process pr7 = new Process(7, 10);
		Process pr8 = new Process(8, 10);
		Process pr9 = new Process(9, 10);
		
		escalonador.addProcess(pr0);
		escalonador.addProcess(pr1);
		escalonador.addProcess(pr2);
		escalonador.addProcess(pr3);
		escalonador.addProcess(pr4);
		escalonador.addProcess(pr5);
		escalonador.addProcess(pr6);
		escalonador.addProcess(pr7);
		escalonador.addProcess(pr8);
		escalonador.addProcess(pr9);
		
		escalonador.processar();*/
	}

}
