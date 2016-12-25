package Estatistica;

import Principal.Main;
import Threads.Elevador;

public class Assentos {
	
	public static double total_assentos = 0;
	
public void taxaAproveitamento(){
	
	total_assentos = Main.contador_elevadores * 4;
	System.out.println("Taxa de Aproveitamento: "+(Elevador.assentos_ocupados/total_assentos)*100+"%");
	System.out.println("quantidade de saida "+ Main.quantidade_de_saida);
	System.out.println("Quantidade de esquiadores nas filas");
	System.out.println("A fila LS tem : "+Main.fila_LS.getFilaLS().size()+" Esquiadores");
	System.out.println("A fila RS tem : "+Main.fila_RS.getFilaRS().size()+" Esquiadores");
	System.out.println("A fila LT tem : "+Main.fila_LT.getFilaLT().size()+" Esquiadores");
	System.out.println("A fila RT tem : "+Main.fila_RT.getFilaRT().size()+" Esquiadores"+"\n");
	
	
}

}
