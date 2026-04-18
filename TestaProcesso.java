import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestaProcesso {
    public static void main(String[] args) {
        VetorDinamico vetorProcessos = new VetorDinamico();
        Scanner sc = new Scanner(System.in);
        String solicitante = "";
        String tipo = "";
        int prioridade;
        String data = "";
        int i = 0;
        int j =1;
		 while (j>0){
            try{
                System.out.print("\nSelceione a operação desejada\n1-Adicionar\n2-Remover\n3-Mostrar Processos\n0-Encerra\nEscolha:");
                j = sc.nextInt();
                sc.nextLine();
                switch(j){
                    case 1:
                        System.out.print("Digite o nome do solicitante: ");
                        solicitante = sc.nextLine();

                        System.out.print("Digite o tipo do serviço: ");
                        tipo = sc.nextLine();

                        System.out.print("Digite a prioridade do serviço(1 - Baixa | 2 - Normal | 3 - Urgente): ");
                        prioridade = sc.nextInt();

                        while(!(prioridade >=1 && prioridade <=3)){
                            System.out.print("Valor Inválido, digite o valor correto(1 - Baixa | 2 - Normal | 3 - Urgente): ");
                            prioridade = sc.nextInt();
                        }

                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        data = formato.format(cal.getTime());

                        vetorProcessos.adiciona(new Processo(solicitante,tipo,prioridade , data));
                        System.out.println("\nCapacidade do Array: " + vetorProcessos.getCapacidade()+"\nOcupação: "+vetorProcessos.getOcupacao()+"\n");

                        sc.nextLine();
                       
                        break;
                    case 2:
                        String temp = vetorProcessos.remove();
                        System.err.println(temp);
                        System.out.println("\nCapacidade do Array: " + vetorProcessos.getCapacidade()+"\nOcupação: "+vetorProcessos.getOcupacao()+"\n");
                        break;
                    case 3:
                        System.out.print("Lista de Processos\n"+vetorProcessos.listar());                    
                        break;
                    default:
                        System.out.print("Lista de Processos\n"+vetorProcessos.listar());
                        j=0;
                        break;
                }
                
            } catch(InputMismatchException e){
                System.out.println("\n[ERRO] Digite o valor correto");
                sc.nextLine();
            }
        } 
         sc.close();
    }
}

