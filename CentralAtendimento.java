// Implementando a central de atendimento
public class CentralAtendimento {

    private PilhaProcesso pendentes;
    private PilhaProcesso historico;

    public CentralAtendimento() {
        pendentes = new PilhaProcesso();
        historico = new PilhaProcesso();
    }

    public void abrirProcesso(Processo p) {
        pendentes.push(p);
        historico = new PilhaProcesso(); 
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
        pendentes.imprimir();
    }

    public void listarHistorico() {
        historico.imprimir();
    }
}