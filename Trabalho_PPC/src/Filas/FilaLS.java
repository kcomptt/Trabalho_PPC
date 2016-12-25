package Filas;

import java.util.ArrayList;

//adcionou e removeu


import Principal.Main;
import Threads.Elevador;
import Threads.Esquiador;


public class FilaLS {
	private ArrayList<Esquiador> filaLS = new ArrayList<Esquiador>();
	public static ArrayList<Long> tempoLS = new ArrayList<Long>();
	public boolean condicao_entrada_LS = false;
	public boolean condicao_saida_LS = false;
	public long tempo_da_LS;
	public boolean primeiro_esquiadorLS = true;
	
	
	public synchronized void adicionarLS(Esquiador esquiador){
		while(!condicao_entrada_LS){
			if(filaLS.size() >= 20){
				try {
					wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			} else {
				Main.fila_LS.filaLS.add(esquiador);
				System.out.println("Esquiador "+esquiador.num_esquiador+" indo para LS \n");
				System.out.println("Total de esquiadores criados: "+Main.quantidade_de_esquiadores);
				//System.out.println("Tamanho da fila LS: "+Main.fila_LS.filaLS.size());
				condicao_entrada_LS = true;
				notifyAll();
			}
		}
		if(primeiro_esquiadorLS){
			tempo_da_LS = System.currentTimeMillis();
			primeiro_esquiadorLS = false;
		}
		condicao_entrada_LS = false;
	}
	
	public synchronized void removerLS(Elevador elevador){
		while(!condicao_saida_LS){
			if(filaLS.size() <= 0){
				try {
					wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			} else {
				Esquiador esquiador = filaLS.get(0);
				filaLS.remove(0);
				Main.quantidade_de_saida++;
				System.out.println("Esquiador "+esquiador.num_esquiador+" saindo de LS \n");
				elevador.cadeira.add(esquiador);
				condicao_saida_LS = true;
				notifyAll();
			}
		}
		tempo_da_LS = System.currentTimeMillis() - tempo_da_LS;
		tempoLS.add(tempo_da_LS);
		tempo_da_LS = System.currentTimeMillis();
		condicao_saida_LS = false;
	}

	public ArrayList<Esquiador> getFilaLS() {
		return filaLS;
	}

	public void setFilaLS(ArrayList<Esquiador> filaLS) {
		this.filaLS = filaLS;
	}
	
	
	
}
