public class PilhaPrioridade {
    private PilhaProcesso baixa;   // prioridade 1
    private PilhaProcesso normal;  // prioridade 2
    private PilhaProcesso urgente; // prioridade 3

    public PilhaPrioridade() {
        baixa   = new PilhaProcesso();
        normal  = new PilhaProcesso();
        urgente = new PilhaProcesso();
    }

    public void push(Processo p) {
    switch (p.getPrioridade()) {
        case 1 -> baixa.push(p);
        case 2 -> normal.push(p);
        case 3 -> urgente.push(p);
        default -> throw new IllegalArgumentException("Prioridade inválida: " + p.getPrioridade());
        }
    }

    public Processo pop() {
    if (!urgente.isEmpty()) return urgente.pop();
    if (!normal.isEmpty())  return normal.pop();
    if (!baixa.isEmpty())   return baixa.pop();
    throw new PilhaVaziaException("Todas as pilhas estão vazias!");
    }

    public Processo peek() {
    if (!urgente.isEmpty()) return urgente.peek();
    if (!normal.isEmpty())  return normal.peek();
    if (!baixa.isEmpty())   return baixa.peek();
    throw new PilhaVaziaException("Todas as pilhas estão vazias!");
    }
    
    public int tamanho() {
    return urgente.size() + normal.size() + baixa.size();
    }

    public void listar() {
    System.out.println("=== URGENTE ===");
    urgente.imprimir();
    System.out.println("=== NORMAL ===");
    normal.imprimir();
    System.out.println("=== BAIXA ===");
    baixa.imprimir();
    }

    
}