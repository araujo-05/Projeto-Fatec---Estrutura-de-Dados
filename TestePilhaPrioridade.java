public class TestePilhaPrioridade {
    public static void main(String[] args) {
        PilhaPrioridade pilha = new PilhaPrioridade();

        // Adiciona em ordem: baixa → normal → urgente
        pilha.push(new Processo("Ana",    "Financeiro", 1, "17/04/2026 08:00")); // baixa
        pilha.push(new Processo("Bruno",  "Saúde",      2, "17/04/2026 08:05")); // normal
        pilha.push(new Processo("Carlos", "Urgência",   3, "17/04/2026 08:10")); // urgente

        System.out.println("Listagem por prioridade:");
        pilha.listar();

        System.out.println("\nOrdem de atendimento (pop):");
        System.out.println(pilha.pop()); // deve sair Carlos (urgente)
        System.out.println(pilha.pop()); // deve sair Bruno  (normal)
        System.out.println(pilha.pop()); // deve sair Ana    (baixa)
    }

    
}