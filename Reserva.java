/**
 * Representa uma reserva de um veículo feita por um cliente. 
 * Contém informações sobre o veículo reservado, o cliente que fez a reserva, 
 * o período de reserva e o preço a ser pago.
 * 
 * @author Cristian, Maria Eduarda
 */

public class Reserva {
    private String nomeCliente;
    private String cpfCliente;
    private Veiculo veiculo;
    private String dataInicio;
    private int tempoReserva;


    public Reserva(Veiculo veiculo, String nomeCliente, String cpf , String dataInicio ,int tempoReserva){
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpf;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.tempoReserva = tempoReserva;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public String getCpfCliente(){
        return cpfCliente;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }

    public String getDataInicio(){
        return dataInicio;
    }

    public int getTempoReserva(){
        return tempoReserva;
    }

    @Override 
    public String toString(){
        return ("Nome cliente" + getNomeCliente() + "\nCPF: " + getCpfCliente() + "\nVeiculo alugado: " + getVeiculo() +"\nData de Inicio da Reserva: "+ getDataInicio() + "/nTempo Reserva: " + getTempoReserva() + " dias");
    }
  
}
