package Threads;

import Estatistica.Assentos;
import Estatistica.Tempo;
import Principal.Main;

public class Gerenciador implements Runnable{
	
	public static int contador_elevadores = 0;
	public static double total_assentos = 0;
	Tempo t = new Tempo();
	Assentos a = new Assentos();


	@Override
	public void run() {
		while(!(Main.quantidade_de_esquiadores>= 120 && Main.fila_LS.getFilaLS().size() <= 0
				&& Main.fila_RS.getFilaRS().size() <= 0 && Main.fila_LT.getFilaLT().size() <= 2
				&& Main.fila_RT.getFilaRT().size() <= 2)){
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			(new Thread(new Elevador(Main.contador_elevadores))).start();
			Main.contador_elevadores++;
			
		}
		t.tempos();
		a.taxaAproveitamento();

	}
}
		
		
		
	

