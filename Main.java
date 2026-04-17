// Gerando um Menu para o atendimento em java.

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CentralAtendimento central = new CentralAtendimento();
        int op;

        do {
            System.out.println("\n1-Abrir  2-Atender  3-Desfazer  4-Pendentes  5-Historico  0-Sair");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Tipo: ");
                String tipo = sc.nextLine();

                System.out.print("Prioridade (1-3): ");
                int pr = sc.nextInt();

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String data = formato.format(cal.getTime());

                Processo p = new Processo(nome, tipo, pr, data);
                central.abrirProcesso(p);

                System.out.println("Processo aberto!");

            } else if (op == 2) {
                try {
                    System.out.println("Atendido: " + central.atenderProximo());
                } catch (PilhaVaziaException e) {
                    System.out.println("Erro: Nenhum processo para atender!");
                }

            } else if (op == 3) {
                try {
                    central.desfazerUltimoAtendimento();
                    System.out.println("Desfeito!");
                } catch (PilhaVaziaException e) {
                    System.out.println("Erro: Nenhum histórico para desfazer!");
                }

            } else if (op == 4) {
                central.listarPendentes();

            } else if (op == 5) {
                central.listarHistorico();
            }

        } while (op != 0);

        sc.close();
    }
}