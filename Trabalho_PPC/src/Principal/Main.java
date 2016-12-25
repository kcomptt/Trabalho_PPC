package Principal;

import Filas.FilaLS;
import Filas.FilaLT;
import Filas.FilaRS;
import Filas.FilaRT;
import Threads.Gerenciador;
import Threads.Preenchedor;


public class Main {
	public static FilaLT fila_LT = new FilaLT();
	public static FilaLS fila_LS = new FilaLS();
	public static FilaRS fila_RS = new FilaRS();
	public static FilaRT fila_RT = new FilaRT();
	public static int quantidade_de_esquiadores = 0;
	public static int quantidade_de_saida =0;
	public static int contador_elevadores = 0;
	
	public static void main(String[] args) {
	
		Thread preenchedor = new Thread(new Preenchedor());
		preenchedor.start();
		Thread gerenciador = new Thread(new Gerenciador());
		gerenciador.start();

	}

}
