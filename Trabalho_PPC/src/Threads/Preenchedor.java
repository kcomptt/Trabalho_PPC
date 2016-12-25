package Threads;

import Principal.Main;

public class Preenchedor implements Runnable {

	@Override
	public void run() {
		while(Main.quantidade_de_esquiadores < 120){
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			(new Thread(new Esquiador(Main.quantidade_de_esquiadores +1))).start();
			Main.quantidade_de_esquiadores++;
			
		}
		
	}
		
	

}
