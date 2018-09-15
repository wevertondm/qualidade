package PassagemAerea;

import javax.swing.*;

public class ReservaPassagemAerea {

	static int opcao, opcao1, opcao2;
	static String sopcao;
	static int voo[];
	static String origem[];
	static String destino[];
	static int lugares[];
	static String dadosDeEntradaDosVoosCadastradosNoPrograma = "";

	public static void main(String[] args) {
		// Cria os vetores (NÃO CONSIDERE ESSA PARTE DO CÓDIGO)
		voo = new int[3];
		origem = new String[3];
		destino = new String[3];
		lugares = new int[3];
		// Carrega vetores (NÃO CONSIDERE ESSA PARTE DO CÓDIGO)
		voo[0] = 1;
		origem[0] = "BHTE";
		destino[0] = "SÃO PAULO";
		lugares[0] = 20;
		dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[0] + "\t"
				+ origem[0] + "\t" + destino[0] + "\t" + lugares[0];
		voo[1] = 2;
		origem[1] = "SÃO PAULO";
		destino[1] = "CURITIBA";
		lugares[1] = 25;
		dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[1] + "\t"
				+ origem[1] + "\t" + destino[1] + "\t" + lugares[1];
		voo[2] = 3;
		origem[2] = "CURITIBA";
		destino[2] = "JOINVILLE";
		lugares[2] = 15;
		dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[2] + "\t"
				+ origem[2] + "\t" + destino[2] + "\t" + lugares[2];
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja verificar dados?", "Confirmação do programa",
				JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			mostrarDadosVoo();
		}
		// MENU GERAL
		while (true) {
			try {
				// MENU GERAL
				opcao1 = Integer.parseInt(
						JOptionPane.showInputDialog("OPÇÕES\n\n" + "1 - Consulta\n2 - Reservar\n3 - Finalizar\n\n"));
				if (opcao1 == 1) {
					// MENU CONSULTAR
					while (true) {
						try {
							// MENU CONSULTAR
							opcao2 = Integer.parseInt(JOptionPane.showInputDialog("CONSULTAR VÔOS \n\n"
									+ "1 - Por  número  do  vôo\n2 - Por  Origem\n3 - Por Destino\n4 - Consulta Geral\n5 - Voltar\n\n"));
							if (opcao2 == 1) {
								opcao = Integer.parseInt(JOptionPane.showInputDialog(
										"CONSULTAR VÔO POR NÚMERO DO VÔO\n\n" + "Informe o número do vôo"));
								if (opcao < 1 || opcao > 3) {
									JOptionPane.showMessageDialog(null, "Número do vôo Inexistente");
								} else {
									for (int i = 0; i <= 2; i++) {
										if (voo[i] == (opcao)) {
											mostrarDadosUsuario(i);
										} 

									}
								} 
							} 
							if (opcao2 == 2) {
								sopcao = JOptionPane
										.showInputDialog("CONSULTAR VÔO POR ORIGEM DO VÔO\n\n" + "Informe a origem");
								Boolean verOrigem = true;
								verOrigem = verVooPorOrigemO(sopcao);
								if (verOrigem == false) {
									JOptionPane.showMessageDialog(null, "Origem não cadastrada no programa. Verifique",
											"Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
								} else {
									
									for (int i = 0; i <= 2; i++) {
										if (origem[i].equalsIgnoreCase(sopcao)) {
											mostrarDadosUsuario(i);
										}
									} 
								} 
							}
							if (opcao2 == 3) {
								sopcao = JOptionPane
										.showInputDialog("CONSULTAR VÔO POR DESTINO DO VÔO\n\n" + "Informe a origem");
								Boolean verDestino = true;
								verDestino = verVPD(sopcao);
								if (verDestino == false) {
									JOptionPane.showMessageDialog(null, "Origem não cadastrada no programa. Verifique",
											"Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
								} else {
									for (int i = 0; i <= 2; i++) {
										if (destino[i].equalsIgnoreCase(sopcao)) {
											mostrarDadosUsuario(i);
										} 
									} 
								} 
							}
							if (opcao2 == 4) {
								mostrarDadosVoo();
							}
							if (opcao2 == 5) {
								break;
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa será finalizado");
							break;
						}
					} // while Consultar
				} // fim opcao 1
				if (opcao1 == 2) {
					JOptionPane.showMessageDialog(null, "OPÇÃO 2 - RESERVA \nOpção em desenvolvimento ...");
				}
				if (opcao1 == 3) {
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa será finalizado");
				break;
			}
		} // while geral
		System.out.println("\n\nPROGRAMA FINALIZADO!");
	}

	private static void mostrarDadosVoo() {
		JTextArea saida = new JTextArea(10, 40);
		saida.setText("Nro\tOrigem\tDestino\tPassageiros");
		saida.append(dadosDeEntradaDosVoosCadastradosNoPrograma);
		JScrollPane scroll = new JScrollPane(saida);
		JOptionPane.showMessageDialog(null, scroll, "Dados dos vôos: ", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void mostrarDadosUsuario(int i) {
		String resultado = "Vôo: " + voo[i] + "\n" + "Origem: "
				+ origem[i] + "\n" + "Destino: " + destino[i]
				+ "\n" + "Lugares: " + lugares[i];
		JOptionPane.showMessageDialog(null, resultado);
	} 
	// primeira refatoração
	private static Boolean verVooPorOrigemO(String args) {
		for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
			if (origem[variavelFor].equalsIgnoreCase(sopcao)) {
				return true;
			}
		}
		return false;
	}

	private static Boolean verVPD(String args) {
		for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
			if (destino[variavelFor].equalsIgnoreCase(sopcao)) {
				return true;
			}
		}
		return false;
	}
} // class