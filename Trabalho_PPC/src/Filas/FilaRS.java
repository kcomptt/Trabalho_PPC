package Filas;

import java.util.ArrayList;

import Principal.Main;
import Threads.Elevador;
import Threads.Esquiador;





public class FilaRS {
	private ArrayList<Esquiador> filaRS = new ArrayList<Esquiador>();
	public static ArrayList<Long> tempoRS = new ArrayList<Long>();
	public boolean condicao_entrada_RS = false;
	public boolean condicao_saida_RS = false;
	public long tempo_da_RS;
	public boolean primeiro_esquiadorRS = true;

	
	
	
	
	public synchronized void adicionarRS(Esquiador esquiador){
		while(!condicao_entrada_RS){
			if(filaRS.size() >= 20){
				try {
					wait();
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			} else {
				
				Main.fila_RS.filaRS.add(esquiador);
				System.out.println("Esquiador "+esquiador.num_esquiador+" indo para RS \n");
				System.out.println("Total de esquiadores criados: "+Main.quantidade_de_esquiadores);
				condicao_entrada_RS = true;
				notifyAll();
			}
		}
		if(primeiro_esquiadorRS){
			tempo_da_RS = System.currentTimeMillis();
			primeiro_esquiadorRS  = false;
		}
		condicao_entrada_RS = false;
	}
	
	
	
	public synchronized void removerRS(Elevador elevador){
		while(!condicao_saida_RS){
			if(filaRS.size() <= 0){
				try {
					wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			} else {
				Esquiador esquiador = filaRS.get(0);
				filaRS.remove(0);
				Main.quantidade_de_saida++;
				System.out.println("Esquiador "+esquiador.num_esquiador+" saindo de RS \n");
				elevador.cadeira.add(esquiador);
				condicao_saida_RS = true;
				notifyAll();
			}
		}
		tempo_da_RS = System.currentTimeMillis() - tempo_da_RS;
		tempoRS.add(tempo_da_RS);
		tempo_da_RS = System.currentTimeMillis();
		condicao_saida_RS = false;
	}


	public ArrayList<Esquiador> getFilaRS() {
		return filaRS;
	}


	public void setFilaRS(ArrayList<Esquiador> filaRS) {
		this.filaRS = filaRS;
	}
	
	
	

}
