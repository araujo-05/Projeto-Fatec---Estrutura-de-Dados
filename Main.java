// Gerando um Menu para o atendimento em java.

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CentralAtendimento central = new CentralAtendimento();
        int opcao=0;
        boolean controlaLoop = true;

        do {
            try{
                System.out.println("\nMENU\n1-Abrir  2-Atender  3-Desfazer  4-Pendentes  5-Historico  0-Sair");
                System.out.print("Opção: ");
                opcao = sc.nextInt();
                sc.nextLine();
                switch(opcao) {
                    case 0:
                        controlaLoop = false;
                        break;
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Tipo: ");
                        String tipo = sc.nextLine();

                        int pr = 0;
                        while(controlaLoop){
                            try{
                                System.out.print("Prioridade (1-3): ");
                                pr = sc.nextInt();
                                if(pr < 1 || pr > 3) throw new InputMismatchException();
                                controlaLoop = false;
                            }catch(InputMismatchException e){
                                System.out.print("[ERRO] DIGITE APENAS OS VALORES PERMITIDOS\n");
                                sc.nextLine();
                            }
                        }
                        controlaLoop = true;

                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String data = formato.format(cal.getTime());

                        Processo p = new Processo(nome, tipo, pr, data);
                        central.abrirProcesso(p);

                        System.out.println("\nProcesso aberto!");
                        break;
                    case 2:
                        try {
                            System.out.println("\nAtendido: " + central.atenderProximo());
                        } catch (PilhaVaziaException e) {
                            System.out.println("\nErro: Nenhum processo para atender!");
                        }
                        break;
                    case 3:
                        try {
                            central.desfazerUltimoAtendimento();
                            System.out.println("Desfeito!");
                        } catch (PilhaVaziaException e) {
                            System.out.println("\nErro: Nenhum histórico para desfazer!");
                        }
                        break;
                    case 4:
                        central.listarPendentes();
                        break;
                    case 5:
                        central.listarHistorico();
                        break;
                    default:
                        System.out.print("[ERRO] DIGITE APENAS OS VALORES PERMITIDOS");    
                    }
                }catch(InputMismatchException e){
                    System.out.print("[ERRO] DIGITE APENAS OS VALORES PERMITIDOS\n");
                    sc.nextLine();
                }
        } while (controlaLoop);

        sc.close();
    }
}