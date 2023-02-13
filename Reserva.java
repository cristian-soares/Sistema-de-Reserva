public class Reserva {
    private String nomeCliente;
    private String cpfCliente;
    private Veiculo reservaVeiculo;
    private String tempoReserva;

    public Reserva(String nomeCliente, String cpf ,Veiculo reservaVeiculo, String tempoReserva){
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpf;
        this.reservaVeiculo = reservaVeiculo;
        this.tempoReserva = tempoReserva;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public String getCpfCliente(){
        return cpfCliente;
    }

    public Veiculo getVeiculo(){
        return reservaVeiculo;
    }

    public String getTempoReserva(){
        return tempoReserva;
    }
  
}
