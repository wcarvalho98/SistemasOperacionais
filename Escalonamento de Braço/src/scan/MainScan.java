package scan;

public class MainScan {

	public static void main(String[] args) throws InterruptedException {
		
		Scan scan = Scan.getInstance();
		scan.adicionaRequisicao(1);
		scan.adicionaRequisicao(9);
		scan.adicionaRequisicao(12);
		scan.adicionaRequisicao(36);
		scan.escalonaBraco(false);
		scan.adicionaRequisicao(16);
		scan.adicionaRequisicao(34);
		scan.escalonaBraco(true);
		
	}

}
