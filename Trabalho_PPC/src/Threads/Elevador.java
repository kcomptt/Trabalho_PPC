package Threads;

import java.util.ArrayList;

import Principal.Main;




public class Elevador implements Runnable {
	public ArrayList<Esquiador> cadeira = new ArrayList<Esquiador>();
	public static double assentos_ocupados = 0;
	public static boolean sua_vez = false;
	
public int id;
	
	public Elevador(int id){
		this.id = id;
	}
	
	
	
	@Override
	public void run() {
		System.out.println("A fila LS tem : "+Main.fila_LS.getFilaLS().size()+" Esquiadores");
		System.out.println("A fila RS tem : "+Main.fila_RS.getFilaRS().size()+" Esquiadores");
		System.out.println("A fila LT tem : "+Main.fila_LT.getFilaLT().size()+" Esquiadores");
		System.out.println("A fila RT tem : "+Main.fila_RT.getFilaRT().size()+" Esquiadores"+"\n");
		
		
		while(!atendeCondicao()){
			
			if(Main.fila_LT.getFilaLT().size() >= 3 && Main.fila_LT.getFilaLT().size() >= Main.fila_RT.getFilaRT().size()
					&& cadeira.size() <= 1){
			
				Main.fila_LT.removerLT(this);
			}
			if(Main.fila_RT.getFilaRT().size() >= 3 && cadeira.size() <= 1){
			
				Main.fila_RT.removerRT(this);
			}
			if(Main.fila_LS.getFilaLS().size() > 0 && cadeira.size() < 4 && !sua_vez){
			
				Main.fila_LS.removerLS(this);
				sua_vez = true;
			}
			if(Main.fila_RS.getFilaRS().size() > 0 && cadeira.size() < 4 && sua_vez){
			
				Main.fila_RS.removerRS(this);
				sua_vez = false;
			}
			if(Main.quantidade_de_esquiadores>=120 && !sua_vez){
				if(Main.fila_LS.getFilaLS().size()==0){
					sua_vez=true;
					
				}
				
			}
			
			if(Main.quantidade_de_esquiadores>=120 && sua_vez){
				if(Main.fila_RS.getFilaRS().size()==0){
					sua_vez =false;
				}
			}
			
		}
		
		
		assentos_ocupados += this.cadeira.size();
	}
	public boolean atendeCondicao(){
		
		if(cadeira.size() == 4){
			return true;
		} else if (cadeira.size() == 0){
			return false;
		} else if(cadeira.size() == 3 && (Main.fila_LS.getFilaLS().size() > 0 
				|| Main.fila_RS.getFilaRS().size() > 0)){
			return false;
		} else if (cadeira.size() == 1 && (Main.fila_LT.getFilaLT().size() > 2 
				|| Main.fila_RT.getFilaRT().size() > 2 || Main.fila_LS.getFilaLS().size() > 0
				|| Main.fila_RS.getFilaRS().size() > 0)){
			return false;
		} else if(cadeira.size() == 2 && (Main.fila_LS.getFilaLS().size() > 0 
				|| Main.fila_RS.getFilaRS().size() > 0)){
			return false;
		} else {
			return true;
		}
	
}

}
