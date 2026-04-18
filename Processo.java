
public class Processo {

	private int protocolo;
    private String solicitante;
    private String tipoServico;
    private int prioridade;
    private String dataHora;
    private static int contador = 1;
    
    
    public Processo(String solicitante, String tipoServico, int prioridade, String dataHora) {
    	
    	this.protocolo = contador++;
    	this.solicitante = solicitante;
    	this.tipoServico = tipoServico;
    	this.prioridade = prioridade;
        this.dataHora = dataHora;
    }
    
    public int getProtocolo() {
    	
    	return protocolo;
    }
    
    public String getSolicitante() {
    	
    	return solicitante;
    }
    
    public void setSolicitante(String solicitante) {
    	
    	this.solicitante = solicitante;
    }
    
    public String getTipoServico () {
    	
    	return tipoServico;
    }
    
    public void setTipoServico (String tipoServico) {
    	
    	this.tipoServico = tipoServico;
    }
    
    public int getPrioridade () {
    	
    	return prioridade;
    }
    
    public void setPrioridade (int prioridade) {
    	
    	this.prioridade = prioridade;
    }
    
    public String getDataHora () {
    	
    	return dataHora;
    }
    
    public void setDataHora (String dataHora) {
    	
    	this.dataHora = dataHora;
    }
    
    private String getDescricaoPrioridade() {
        return switch (this.prioridade) {
            case 1 -> "Baixa";
            case 2 -> "Normal";
            case 3 -> "Urgente";
            default -> "Indefinida";
        };
    }
    
    
    @Override
    public String toString() {
    	
    	String protocoloFormat = String.format("%03d", protocolo);
    	
    	return "[#"+protocoloFormat+"] "+solicitante+" | "+tipoServico+" | "+getDescricaoPrioridade()+" | "+dataHora+"\n";
    	
    }
    
    @Override
    public boolean equals (Object obj) {
    	
    	if (this == obj)return true;
    	if (obj == null || getClass() != obj.getClass()) return false;
    	Processo processo = (Processo) obj;

    	return protocolo == processo.protocolo;
    }
    
  	
}

