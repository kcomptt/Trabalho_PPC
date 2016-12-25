package Estatistica;

import Filas.FilaLS;
import Filas.FilaLT;
import Filas.FilaRS;
import Filas.FilaRT;


public class Tempo {
	
	long tempoTotalLS = 0;
	long tempoTotalRS = 0;
	long tempoTotalLT = 0;
	long tempoTotalRT = 0;
	long tempoTotal =0;
	



	public void tempos(){

	for(int i = 0; i < FilaLS.tempoLS.size(); i++){
		tempoTotalLS += FilaLS.tempoLS.get(i);
	}
	
	for(int i = 0; i < FilaRS.tempoRS.size(); i++){
		tempoTotalRS += FilaRS.tempoRS.get(i);
	}
	
	for(int i = 0; i < FilaLT.tempoLT.size(); i++){
		tempoTotalLT += FilaLT.tempoLT.get(i);
	}
	
	for(int i = 0; i < FilaRT.tempoRT.size(); i++){
		tempoTotalRT += FilaRT.tempoRT.get(i);
	}
	tempoTotal =(tempoTotalLS+tempoTotalRS+tempoTotalLT+tempoTotalRT)/4;
	
	System.out.println("##########################################################");
	System.out.println("FIM");
	System.out.println("Tempo médio espera LS: "+tempoTotalLS/FilaLS.tempoLS.size());
	System.out.println("Tempo médio espera RS: "+tempoTotalRS/FilaRS.tempoRS.size());
	System.out.println("Tempo médio espera LT: "+tempoTotalLT/FilaLT.tempoLT.size());
	System.out.println("Tempo médio espera RT: "+tempoTotalRT/FilaRT.tempoRT.size());
	System.out.println("tempo médio total: "+tempoTotal);
	
	
	
}
}



