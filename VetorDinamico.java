public class VetorDinamico{
    
    Processo processos[];
    private int capacidade;
    private int ocupacao = 0;

    public VetorDinamico(){
        capacidade = 4;
        processos = new Processo[capacidade];
    }

    public int getCapacidade(){
        return this.capacidade;
    }

    public int getOcupacao(){
        return this.ocupacao;
    }

    public boolean estaCheio(){
       return capacidade == ocupacao;
    }

    public boolean estaVazio(){
        if(ocupacao == 0) return true;
        else return false;
    }
    public void adiciona(Processo p){
        if(estaCheio()){
            redimensiona(capacidade * 2);
        } 
        processos[ocupacao++] = p; 
        
        
    }
    public String remove(){
        if (estaVazio()) return "\n0 Processos\n";
        // ocupacao--;
        String aux = "\nProcesso: "+processos[--ocupacao].toString()+" removido";
        if (capacidade >= 4 && ocupacao <= capacidade / 4) 
            redimensiona(capacidade / 2);
        return aux;
    }
    private void redimensiona(int novaCapacidade){
        Processo[] temp = new Processo[novaCapacidade];
        for (int i = 0; i < ocupacao; i++){
            temp[i] = processos[i];
        }
		processos = temp;
        capacidade = novaCapacidade;

    }
        

    public String listar(){
        if(estaVazio()) return "\n0 Processos\n";
        String lista = "\nCapacidade do Array: " +capacidade+"\nOcupação: "+ocupacao+"\n";
        for (int i = 0; i < ocupacao; i++) {
            lista += processos[i];
        }
        
        return lista;
    }

    public int buscarPorProtocolo(int protocolo){
        for (int i=0; i<ocupacao; i++) {
            if (processos[i].getProtocolo() == protocolo) {
                return i;
            } 
        }
        return -1;
    }
}
