package Filas;

import java.util.ArrayList;

import Principal.Main;
import Threads.Elevador;
import Threads.Esquiador;

public class FilaRT {
	private ArrayList<Esquiador> filaRT = new ArrayList<Esquiador>();
	public static ArrayList<Long> tempoRT = new ArrayList<Long>();
	public boolean condicao_entrada_RT = false;
	public boolean condicao_saida_RT = false;
	public long tempo_da_RT;
	public boolean primeiro_esquiadorRT = true;
	
	
	
	
	
	public synchronized void adicionarRT(Esquiador esquiador){
		while(!condicao_entrada_RT){
			if(Main.fila_RT.filaRT.size() >= 20){
				try {
					wait();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			} else {
				Main.fila_RT.filaRT.add(esquiador);
				System.out.println("Esquiador "+esquiador.num_esquiador+" indo para RT");
				System.out.println("Total de esquiadores criados: "+Main.quantidade_de_esquiadores);
				//System.out.println("Tamanho da fila RT: "+Main.fila_RT.filaRT.size());
				condicao_entrada_RT = true;
				notifyAll();
			}
		}
		if(primeiro_esquiadorRT){
			tempo_da_RT = System.currentTimeMillis();
			primeiro_esquiadorRT = false;
		}
		condicao_entrada_RT = false;
	}
	public synchronized void removerRT(Elevador elevador){
		while(!condicao_saida_RT){
			if(filaRT.size() <= 0){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(filaRT.size() >= 3){
				for(int i = 0; i < 3; i++){
					Esquiador esquiador = filaRT.get(0);
					filaRT.remove(0);
					Main.quantidade_de_saida++;
					System.out.println("Esquiador "+esquiador.num_esquiador+" saindo de RT \n");
					elevador.cadeira.add(esquiador);
				}
				notifyAll();
				condicao_saida_RT = true;
			}
		}
		tempo_da_RT = System.currentTimeMillis() - tempo_da_RT;
		tempoRT.add(tempo_da_RT);
		tempo_da_RT = System.currentTimeMillis();
		condicao_saida_RT = false;
	}
	
	
	public ArrayList<Esquiador> getFilaRT() {
		return filaRT;
	}
	public void setFilaRT(ArrayList<Esquiador> filaRT) {
		this.filaRT = filaRT;
	}
	
	
	
}
