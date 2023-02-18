/**Classe responsável pelas reservas, contém as informações dos clientes 
    *@author -*/
public class Reserva {
    private String nomeCliente;
    private String cpfCliente;
    private Veiculo veiculo;
    private int tempoReserva;
    /**Construtor da classe reserva 
    *@author -*/
    public Reserva(Veiculo veiculo, String nomeCliente, String cpf , int tempoReserva){
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpf;
        this.veiculo = veiculo;
        this.tempoReserva = tempoReserva;
    }
    /**Método que retorna o Nome do cliente 
    *@author -*/
    public String getNomeCliente(){
        return nomeCliente;
    }
    /**Método que retorna o CPF do cliente 
    *@author -*/
    public String getCpfCliente(){
        return cpfCliente;
    }
    /**Método que retorna o veiculo reservado 
    *@author -*/
    public Veiculo getVeiculo(){
        return veiculo;
    }
    /**Método que retorna o tempo dereserva 
    *@author -*/
    public int getTempoReserva(){
        return tempoReserva;
    }
    /**Método que retorna as informações da reserva 
    *@author -*/
    @Override 
    public String toString(){
        return ("Nome cliente" + getNomeCliente() + "/nCPF: " + getCpfCliente() + "/nVeiculo alugado: " + getVeiculo() + "/nTempo Reserva: " +getTempoReserva());
    }
  
}
