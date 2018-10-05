package pkgPilha;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
public class TestePilha {
    // Definindo a classe que representará cada elemento da Pilha
    private static class Pilha {
        public int numero;
        public double valor;
        public int pedido;
        public Pilha prox;
    }
    public static void main(String[] args) {
        Pilha topo = null;
        Pilha aux;
        int op = 0;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(opcoesMenu(), "1"));
            } catch (Exception e) {
                // Silent exception
                System.out.println("");
            }

            if (op < 1 || op > 8) {
                mensagem("Opção Inválida!");
            }
            // INSERIR/EMPILHAR CHAPAS - DESAFIO 1
            if (op == 1) {
                topo = empilhar(topo);
            }
            // CONSULTAR CHAPAS CADASTRADAS
            if (op == 2) {
                consultarChapasCadastradas(topo);
            }
            // DESEMPILHAR CHAPA
            if (op == 3) {
                topo = desempilharChapas(topo);
            }
            // ESVAZIAR PÁTIO
            if (op == 4) {
                topo = esvaziarPatio(topo);
            }
            // QUANTIDADE E CHAPAS 
            if (op == 5) {
                quantidadesChapas(topo);
            }
            // FILTRAR CHAPAS CADASTRADAS - DESAFIO 3
            if (op == 6) {
                filtrarChapasCadastradas(topo);
            } 
            
        } while (op != 7);
        System.out.println(">>> PROGRAMA FINALIZADO!");

    } // FIM MÉTODO MAIN()

	private static void quantidadesChapas(Pilha topo) {
		Pilha aux;
		aux = topo;
		int n = 0;
		while (aux != null) {
		    aux = aux.prox;
		    n++;
		}
		mensagem("A Pilha contém: " + n + " elementos.");
	}

	private static Pilha esvaziarPatio(Pilha topo) {
		return topo(topo);
	}

	private static Pilha topo(Pilha topo) {
		return mensagemPilha(topo);
	}

	private static Pilha mensagemPilha(Pilha topo) {
		if (topo == null) {
		    mensagem("A Pilha está vazia!");
		} else {
		    topo = null;
		    mensagem("A Pilha foi esvaziada!");
		}
		return topo;
	}

	private static Pilha desempilharChapas(Pilha topo) {
		if (topo == null) {
		    mensagem("A PILHA está vazia!");
		} else {
		    mensagem("Número: " + topo.numero + ", foi removido.");
		    topo = topo.prox;
		}
		return topo;
	}

	private static void filtrarChapasCadastradas(Pilha topo) {
		Pilha aux;
		filtroChapas(topo);
	}

	private static void filtroChapas(Pilha topo) {
		Pilha aux;
		numeroPilhas(topo);
	}

	private static void numeroPilhas(Pilha topo) {
		Pilha aux;
		nPedidos(topo);
	}

	private static void nPedidos(Pilha topo) {
		Pilha aux;
		mensagemConsulta(topo);
	}

	private static void mensagemConsulta(Pilha topo) {
		Pilha aux;
		consultarSaida(topo);
	}

	private static void consultarSaida(Pilha topo) {
		Pilha aux;
		statusPilha(topo);
	}

	private static void statusPilha(Pilha topo) {
		Pilha aux;
		consultarStatusPilha(topo);
	}

	private static void consultarStatusPilha(Pilha topo) {
		Pilha aux;
		if (topo == null) {
		    mensagem("A PILHA está vazia!");
		} else {
		    int npedido = Integer.parseInt(JOptionPane.showInputDialog(
		            "NÚMERO DO PEDIDO", "0"));
		    JTextArea saida = new JTextArea(6, 35); // HEIGHT X WIDTH
		    JScrollPane scroll = new JScrollPane(saida);
		    saida.append("FILTRO, CHAPAS PARA O PEDIDO NRO: " + npedido + "\n");
		    saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
		    saida.append("================================\n");
		    aux = topo;
		    while (aux != null) {
		        if (aux.pedido == npedido) {
		            saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
		        }
		        aux = aux.prox;
		    }
		    JOptionPane.showMessageDialog(null, scroll, 
		            "CONSULTAR CHAPAS CADASTRADAS", 
		            JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void consultarChapasCadastradas(Pilha topo) {
		Pilha aux;
		if (topo == null) {
		    mensagem("A PILHA está vazia!");
		} else {
		    JTextArea saida = new JTextArea(6, 35); // HEIGHT X WIDTH
		    JScrollPane scroll = new JScrollPane(saida);
		    saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
		    saida.append("===============================\n");
		    aux = topo;
		    while (aux != null) {
		        // VERIFICAR ENDER E PROX (DESAFIO 2)
		        if (aux.prox != null) {
		            System.out.println("Num: " + aux.numero + ", endereço: " 
		                    + aux.hashCode() + " => " + " Prox => " 
		                    + aux.prox.hashCode() + "\n");
		        }

		        saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
		        aux = aux.prox;
		    }
		    JOptionPane.showMessageDialog(null, scroll, 
		            "CONSULTAR CHAPAS CADASTRADAS", 
		            JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static Pilha empilhar(Pilha topo) {
		Pilha aux;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DA CHAPA", "0"));
		aux = topo;
		boolean achou = false;
		while (aux != null) {
		    if (aux.numero == numero) {
		        achou = true;
		        mensagem("Esse número de chapa já foi empilhado.\nFavor verificar!");
		        break;
		    }
		    aux = aux.prox;
		}
		if (achou == false) {
		    Pilha novo = new Pilha();
		    novo.numero = numero;
		    novo.valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR DA CHAPA", "0"));
		    novo.pedido = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
		    novo.prox = topo;
		    topo = novo;
		}
		return topo;
	}

    // STRING - OPÇÕES MENU
    private static String opcoesMenu() {
        String menu = "\nMENU DE OPÇÕES\n"
                + "\n1 - Empilhar Chapas."
                + "\n2 - Consultar Todas as Chapas."
                + "\n3 - Desempilhar Chapas."
                + "\n4 - Remover Todas as Chapas Da Pilha."
                + "\n5 - Verificar Quantidade de Chapas."
                + "\n6 - Filtrar Chapas Por Pedido."
                + "\n7 - Sair";
        return menu;
    }
    // MÉTODO VOID MENSAGEM()

    private static void mensagem(String a) {
        JOptionPane.showMessageDialog(null, a, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    }
} // FIM CLASSE