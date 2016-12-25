package Threads;

import java.util.Random;

import Principal.Main;

public class Esquiador implements Runnable {

	public int num_esquiador;
	
	public Esquiador(int num_esquiadores){
		this.num_esquiador = num_esquiadores;
	}
	

	@Override
	public void run() {
		
		System.out.println("A fila LS tem : "+Main.fila_LS.getFilaLS().size()+" Esquiadores");
		System.out.println("A fila RS tem : "+Main.fila_RS.getFilaRS().size()+" Esquiadores");
		System.out.println("A fila LT tem : "+Main.fila_LT.getFilaLT().size()+" Esquiadores");
		System.out.println("A fila RT tem : "+Main.fila_RT.getFilaRT().size()+" Esquiadores"+"\n");
		
		Random aleatorio = new Random();
		int resultado = aleatorio.nextInt(4) + 1;
		
		if(resultado ==1){
			if(Main.fila_LT.getFilaLT().size() <= Main.fila_RT.getFilaRT().size()){
				
				Main.fila_LT.adicionarLT(this);
				
			}else if(Main.fila_RT.getFilaRT().size() <= Main.fila_LT.getFilaLT().size()){
				
				Main.fila_RT.adicionarRT(this);
			}else if(Main.fila_LS.getFilaLS().size() < (2*Main.fila_LT.getFilaLT().size())
					&& Main.fila_LS.getFilaLS().size() < (2*Main.fila_RT.getFilaRT().size())
					&& Main.fila_LS.getFilaLS().size() <= Main.fila_RS.getFilaRS().size()){
				
				Main.fila_LS.adicionarLS(this);
			}else if(Main.fila_RS.getFilaRS().size() < (2*Main.fila_LT.getFilaLT().size())
					&& Main.fila_RS.getFilaRS().size() < (2*Main.fila_RT.getFilaRT().size())
					&& Main.fila_RS.getFilaRS().size() <= Main.fila_LS.getFilaLS().size()){
				Main.fila_RS.adicionarRS(this);
			}
			
			
		
		}else if(resultado ==2){
			if(Main.fila_RT.getFilaRT().size() <= Main.fila_LT.getFilaLT().size()){
				
				Main.fila_RT.adicionarRT(this);
			}else if(Main.fila_LT.getFilaLT().size() <= Main.fila_RT.getFilaRT().size()){
				
				Main.fila_LT.adicionarLT(this);
			}else if(Main.fila_LS.getFilaLS().size() < (2*Main.fila_LT.getFilaLT().size())
					&& Main.fila_LS.getFilaLS().size() < (2*Main.fila_RT.getFilaRT().size())
					&& Main.fila_LS.getFilaLS().size() <= Main.fila_RS.getFilaRS().size()){
				
				Main.fila_LS.adicionarLS(this);
			}else if(Main.fila_RS.getFilaRS().size() < (2*Main.fila_LT.getFilaLT().size())
					&& Main.fila_RS.getFilaRS().size() < (2*Main.fila_RT.getFilaRT().size())
					&& Main.fila_RS.getFilaRS().size() <= Main.fila_LS.getFilaLS().size()){
				Main.fila_RS.adicionarRS(this);
			}
			
		}else if(resultado ==3){
			if(Main.fila_LS.getFilaLS().size() < (2*Main.fila_LT.getFilaLT().size())
					&& Main.fila_LS.getFilaLS().size() < (2*Main.fila_RT.getFilaRT().size())
					&& Main.fila_LS.getFilaLS().size() <= Main.fila_RS.getFilaRS().size()){
				
				Main.fila_LS.adicionarLS(this);
			}else if(Main.fila_RS.getFilaRS().size() < (2*Main.fila_LT.getFilaLT().size())
					&& Main.fila_RS.getFilaRS().size() < (2*Main.fila_RT.getFilaRT().size())
					&& Main.fila_RS.getFilaRS().size() <= Main.fila_LS.getFilaLS().size()){
				Main.fila_RS.adicionarRS(this);
			}else if(Main.fila_LT.getFilaLT().size() <= Main.fila_RT.getFilaRT().size()){
				
				Main.fila_LT.adicionarLT(this);
			}else if(Main.fila_RT.getFilaRT().size() <= Main.fila_LT.getFilaLT().size()){
				
				Main.fila_RT.adicionarRT(this);
			}
			
		}else if(resultado ==4){
			if(Main.fila_RS.getFilaRS().size() < (2*Main.fila_LT.getFilaLT().size())
					&& Main.fila_RS.getFilaRS().size() < (2*Main.fila_RT.getFilaRT().size())
					&& Main.fila_RS.getFilaRS().size() <= Main.fila_LS.getFilaLS().size()){
				Main.fila_RS.adicionarRS(this);
			}else if(Main.fila_LS.getFilaLS().size() < (2*Main.fila_LT.getFilaLT().size())
					&& Main.fila_LS.getFilaLS().size() < (2*Main.fila_RT.getFilaRT().size())
					&& Main.fila_LS.getFilaLS().size() <= Main.fila_RS.getFilaRS().size()){
				
				Main.fila_LS.adicionarLS(this);
			}else if(Main.fila_RT.getFilaRT().size() <= Main.fila_LT.getFilaLT().size()){
				
				Main.fila_RT.adicionarRT(this);
			}else if(Main.fila_LT.getFilaLT().size() <= Main.fila_RT.getFilaRT().size()){
				
				Main.fila_LT.adicionarLT(this);
			}
			
		}
		
	}

	

}
