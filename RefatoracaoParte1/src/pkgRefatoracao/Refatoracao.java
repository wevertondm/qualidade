package pkgRefatoracao;
import java.util.Calendar;
import java.util.Scanner;


public class Refatoracao {
	
	static Calendar calendario;
	static Scanner  entrada;

	public static void main(String[] args) 
	{
    double mensalidade=0;
    double novaMensalidade=0;
 
    int mes=0;
    int mesAtual=0;
    entrada = new Scanner(System.in);
    int contador = 1;
    while(contador<=3)
    
    	{//valor da mensalidade
    	System.out.println("\nValor da mensalidade:  ");
    	mensalidade = entrada.nextDouble();
    	
    	//mes da mesalidade   	
    	System.out.println("M�s de Refer�ncia:  ");
    	mes = entrada.nextInt();
    	
    	//mes atual
    	calendario = Calendar.getInstance();
    	mesAtual = calendario.get(Calendar.MONTH)+1;
    	
    	
    	novaMensalidade = verificarValorMensalidade(mensalidade, novaMensalidade, mes, mesAtual);
    	
    	imprimirResultados(mensalidade, novaMensalidade, mes, mesAtual);
    	contador++;
    	
     }//while

	}//main

	private static void imprimirResultados(double mensalidade, double novaMensalidade, int mes, int mesAtual) {
		System.out.println("Resultado");
    	System.out.println("M�s Atual:  "+mesAtual);
    	System.out.println("Refer�ncia:  "+mes);
    	System.out.println("Mensalidade: "+mensalidade);
    	System.out.println("Novo Valor:  "+novaMensalidade);
	}

	private static double verificarValorMensalidade(double mensalidade, double novaMensalidade, int mes, int mesAtual) {
		if (mes < mesAtual)
    	{
    		double valorCalculadoMensalidade = mensalidade * 1.10;
			novaMensalidade = valorCalculadoMensalidade;
    	}
    	
    	else if (mes == mesAtual)
    	{
    		novaMensalidade = mensalidade;
    		
    	}
		return novaMensalidade;
	}

}//class
