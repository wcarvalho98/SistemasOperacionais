import java.util.concurrent.Semaphore;

public class ProcessoSem implements Runnable {

	private int id;
	private Semaphore semaforo;
	
	public ProcessoSem(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			regiaoCritica();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	finally {
			semaforo.release();
		}
	}
	
	private void regiaoCritica() {
		System.out.println("Processo #" + this.id + " entrando em RC!");
		processar();
		System.out.println("Processo #" + this.id + " saindo da RC!");
	}
	
	private void processar() {
		try {
			System.out.println("Processo #" + this.id + " processando");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
