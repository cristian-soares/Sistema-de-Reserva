public class Reserva {
    private String nomeCliente;
    private String cpfCliente;
    private Veiculo veiculo;
    private int tempoReserva;

    public Reserva(String nomeCliente, String cpf ,Veiculo veiculo, int tempoReserva){
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpf;
        this.veiculo = veiculo;
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

    public int getTempoReserva(){
        return tempoReserva;
    }

    @Override 
    public String toString(){
        return ("Nome cliente" + getNomeCliente() + "/nCPF: " + getCpfCliente() + "/nVeiculo alugado: " + getVeiculo() + "/nTempo Reserva: " +getTempoReserva());
    }
  
}
