import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestePilhaProcesso {
    public static void main(String[] args) {
        PilhaProcesso pilha = new PilhaProcesso();
        Scanner sc = new Scanner(System.in);
        String solicitante = "";
        String tipo = "";
        int prioridade;
        String data = "";
        int j = 1;
        
        while (j > 0) {
            try {
                System.out.print("\nSelecione a operação desejada\n1-Empilhar (push)\n2-Desempilhar (pop)\n3-Espiar topo (peek)\n4-Mostrar Pilha\n0-Encerra\nEscolha: ");
                j = sc.nextInt();
                sc.nextLine();
                
                switch(j) {
                    case 1:
                        System.out.print("Digite o nome do solicitante: ");
                        solicitante = sc.nextLine();

                        System.out.print("Digite o tipo do serviço: ");
                        tipo = sc.nextLine();

                        System.out.print("Digite a prioridade do serviço(1 - Baixa | 2 - Normal | 3 - Urgente): ");
                        prioridade = sc.nextInt();

                        while(!(prioridade >= 1 && prioridade <= 3)) {
                            System.out.print("Valor Inválido, digite o valor correto(1 - Baixa | 2 - Normal | 3 - Urgente): ");
                            prioridade = sc.nextInt();
                        }

                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        data = formato.format(cal.getTime());

                        pilha.push(new Processo(solicitante, tipo, prioridade, data));
                        System.out.println("\nProcesso empilhado!\nTamanho da Pilha: " + pilha.size() + "\n");
                        sc.nextLine();
                        break;
                        
                    case 2:
                        try {
                            Processo p = pilha.pop();
                            System.out.println("\nProcesso removido: " + p);
                            System.out.println("Tamanho da Pilha: " + pilha.size() + "\n");
                        } catch (PilhaVaziaException e) {
                            System.out.println("\n[ERRO] " + e.getMessage() + "\n");
                        }
                        break;
                        
                    case 3:
                        try {
                            Processo p = pilha.peek();
                            System.out.println("\nTopo da pilha: " + p);
                        } catch (PilhaVaziaException e) {
                            System.out.println("\n[ERRO] " + e.getMessage() + "\n");
                        }
                        break;
                        
                    case 4:
                        System.out.println("\nPilha de Processos");
                        pilha.imprimir();
                        break;
                        
                    default:
                        System.out.println("\nPilha de Processos");
                        pilha.imprimir();
                        j = 0;
                        break;
                }
                
            } catch(InputMismatchException e) {
                System.out.println("\n[ERRO] Digite o valor correto");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
