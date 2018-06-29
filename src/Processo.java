public class Processo implements Runnable {

	public static boolean turn = false;
	private int id;
	
	public Processo (int id) {
		this.setId(id);
	}
	
	@Override
	public void run() {
		System.out.println("O processo " + id + " foi criado!");
		while (turn) {
			System.out.println("O processo " + id + " está aguardando!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		turn = true;
		obtemRecurso();
		turn = false;
		System.out.println("O processo " + id + " terminou!");
	}

	public void obtemRecurso() {
		try {
			System.out.println("O processo " + id + " entrou na RC!");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
