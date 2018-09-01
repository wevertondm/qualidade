package pkgLojaMotos;
import javax.swing.*;
public class LojaMoto {

	public static void main(String[] args) {
		
		while (true) {
			
			try {
				String nome =
						JOptionPane.showInputDialog(
						"Informe a marca (adicione [CANCELAR] para sair):   ");
			if (nome.equalsIgnoreCase("Honda")) {
				Honda moto = new Honda();
				mostrarDadosMoto(moto);
				
			 }
			else if (nome.equalsIgnoreCase("Yamaha")) {
				Yamaha moto = new Yamaha();
				JOptionPane.showMessageDialog(null, 
						"\nNome: "+moto.nome+
						"\nCilindrada:  "+moto.cilindrada+
						"\nCor: "+moto.cor,"Dados da Moto", 
						JOptionPane.CLOSED_OPTION);
			}
			else if (nome.equalsIgnoreCase("Suzuki")) {
				Suzuki moto = new Suzuki();
				JOptionPane.showMessageDialog(null, 
						"\nNome: "+moto.nome+
						"\nCilindrada:  "+moto.cilindrada+
						"\nCor: "+moto.cor,"Dados da Moto", 
						JOptionPane.CLOSED_OPTION);
			}
			else {
				JOptionPane.showMessageDialog(null,
						"Somente dispon�veis na loja: Honda, Yamaha e Suzuki",
						"Mensagem do Progrma",
						JOptionPane.CANCEL_OPTION);
				
			}//if
		}
			catch (Exception e) {
				break;
			
			}
			
		}//while
		System.out.println("\nProgrma Finalizado\n");
	}//main

	private static void mostrarDadosMoto(Honda moto) {
		JOptionPane.showMessageDialog(null, 
				"\nNome: "+moto.nome+
				"\nCilindrada:  "+moto.cilindrada+
				"\nCor: "+moto.cor,"Dados da Moto", 
				JOptionPane.CLOSED_OPTION);
	}
}//class



