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

    /**
     * Construtor da Classe Reserva
     * @param veiculo
     * @param nomeCliente
     * @param cpf
     * @param dataInicio
     * @param tempoReserva
     */
    public Reserva(Veiculo veiculo, String nomeCliente, String cpf , String dataInicio ,int tempoReserva){
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpf;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.tempoReserva = tempoReserva;
    }

    /**
     * Retorna o Nome do Cliente 
     * @return String contendo o nome do usuario
     */
    public String getNomeCliente(){
        return nomeCliente;
    }

    /**
     * Retorna o CPF do Cliente 
     * @return String contendo o CPF do usuario
     */
    public String getCpfCliente(){
        return cpfCliente;
    }

    /**
     * Responsável por retornar o veiculo para realizar reserva
     * @return veiculo 
     */
    public Veiculo getVeiculo(){
        return veiculo;
    }

    /**
     * Metodo reponsável por retornar a data de inicio da contabilização da reserva 
     * @return String contendo a data de inicio 
     */
    public String getDataInicio(){
        return dataInicio;
    }

    /**
     * Metodo que retorna o tempo de reserva
     * @return
     */
    public int getTempoReserva(){
        return tempoReserva;
    }

    /**
     * Retorna todas as informações do cliente para reserva
     */
    @Override 
    public String toString(){
        return ("Nome cliente" + getNomeCliente() + "\nCPF: " + getCpfCliente() + "\nVeiculo alugado: " + getVeiculo() +"\nData de Inicio da Reserva: "+ getDataInicio() + "/nTempo Reserva: " + getTempoReserva() + " dias");
    }
  
}
