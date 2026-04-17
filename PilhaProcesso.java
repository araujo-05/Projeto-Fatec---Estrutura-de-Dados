public class PilhaProcesso {
    
    private VetorDinamico vetor;
    
    public PilhaProcesso() {
        this.vetor = new VetorDinamico();
    }
    
    public void push(Processo p) {
        vetor.adiciona(p);
    }
    
    public Processo pop() {
        if (isEmpty()) {
            throw new PilhaVaziaException("Não é possível remover de uma pilha vazia!");
        }
        int indiceTopo = vetor.getOcupacao() - 1;
        Processo processoRemovido = vetor.processos[indiceTopo];
        vetor.remove();
        return processoRemovido;
    }
    
    public Processo peek() {
        if (isEmpty()) {
            throw new PilhaVaziaException("Pilha vazia! Não há elementos para exibir.");
        }
        int indiceTopo = vetor.getOcupacao() - 1;
        return vetor.processos[indiceTopo];
    }
    
    public boolean isEmpty() {
        return vetor.estaVazio();
    }
    
    public int size() {
        return vetor.getOcupacao();
    }
    
    public void imprimir() {
        if (isEmpty()) {
            System.out.println("Pilha Vazia");
            return;
        }
        System.out.println("\nTopo da Pilha");
        for (int i = vetor.getOcupacao() - 1; i >= 0; i--) {
            System.out.print(vetor.processos[i]);
        }
        System.out.println("Base da Pilha\n");
    }
}
