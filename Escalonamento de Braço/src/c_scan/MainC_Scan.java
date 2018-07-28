package c_scan;


public class MainC_Scan {

public static void main(String[] args) throws InterruptedException {
		
		C_Scan c_scan = C_Scan.getInstance();
		c_scan.adicionaRequisicao(1);
		c_scan.adicionaRequisicao(9);
		c_scan.adicionaRequisicao(12);
		c_scan.adicionaRequisicao(36);
		c_scan.escalonaBraco(false);
		c_scan.adicionaRequisicao(16);
		c_scan.adicionaRequisicao(34);
		c_scan.escalonaBraco(true);
		
	}
	
}
