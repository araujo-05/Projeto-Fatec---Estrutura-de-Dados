// Implementando a central de atendimento
public class CentralAtendimento {

    private PilhaPrioridade pendentes;
    private PilhaPrioridade historico;

    public CentralAtendimento() {
        pendentes = new PilhaPrioridade();
        historico = new PilhaPrioridade();
    }

    public void abrirProcesso(Processo p) {
        pendentes.push(p);
        historico = new PilhaPrioridade(); 
    }

    public Processo atenderProximo() {
        Processo p = pendentes.pop(); 
        historico.push(p);
        return p;
    }

    public void desfazerUltimoAtendimento() {
        Processo p = historico.pop();
        pendentes.push(p);
    }

    public void listarPendentes() {
        pendentes.listar();
    }

    public void listarHistorico() {
        historico.listar();
    }
}