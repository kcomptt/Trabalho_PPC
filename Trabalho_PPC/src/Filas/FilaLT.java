package Filas;

import java.util.ArrayList;

import Principal.Main;
import Threads.Elevador;
import Threads.Esquiador;

//mudar o adcionou e o removeu


public class FilaLT {
	private ArrayList<Esquiador> filaLT = new ArrayList<Esquiador>();
	public static ArrayList<Long> tempoLT = new ArrayList<Long>();
	public long tempo_da_LT;
	public boolean primeiro_esquiadorLT = true;
	public boolean condicao_entrada_LT = false;
	public boolean condicao_de_saida_LT = false;

	
	
	public synchronized void adicionarLT(Esquiador esquiador){
		while(!condicao_entrada_LT){
			if(Main.fila_LT.filaLT.size() >= 20){
				try {
					wait();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			} else {
				Main.fila_LT.filaLT.add(esquiador);
				System.out.println("Esquiador "+esquiador.num_esquiador+" indo para LT \n");
				System.out.println("Total de esquiadores criados: "+Main.quantidade_de_esquiadores);
				//System.out.println("Tamanho da fila LT: "+Main.fila_LT.filaLT.size());
				condicao_entrada_LT = true;
				notifyAll();
			}
		}
		if(primeiro_esquiadorLT){
			tempo_da_LT = System.currentTimeMillis();
			primeiro_esquiadorLT = false;
		}
		condicao_entrada_LT = false;
	}
	
	
	public synchronized void removerLT(Elevador elevador){
		while(!condicao_de_saida_LT){
			if(filaLT.size() <= 0){
				try {
					wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			} else if(filaLT.size() >= 3){
				for(int i = 0; i < 3; i++){
					Esquiador esquiador = filaLT.get(0);
					System.out.println("Esquiador "+esquiador.num_esquiador+" saindo de LT \n");
					Main.fila_LT.filaLT.remove(0);
					Main.quantidade_de_saida++;
					elevador.cadeira.add(esquiador);
				}
				notifyAll();
				condicao_de_saida_LT = true;
			}
		}
		tempo_da_LT = System.currentTimeMillis() - tempo_da_LT;
		tempoLT.add(tempo_da_LT);
		tempo_da_LT = System.currentTimeMillis();
		condicao_de_saida_LT = false;
	}
	

	public ArrayList<Esquiador> getFilaLT() {
		return filaLT;
	}


	public void setFilaLT(ArrayList<Esquiador> filaLT) {
		this.filaLT = filaLT;
	}

}
