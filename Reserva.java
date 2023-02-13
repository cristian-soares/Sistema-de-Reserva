public class Reserva {
    private String nomeCliente;
    private String cpfCliente;
    private Veiculo reservaVeiculos;
    private String tempoReserva;

    public Reserva(String nomeCliente, String cpf ,Veiculo reservaVeiculos, String tempoReserva){
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpf;
        this.reservaVeiculos = reservaVeiculos;
        this.tempoReserva = tempoReserva;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public String getCpfCliente(){
        return cpfCliente;
    }

    public Veiculo getVeiculo(){
        return reservaVeiculos;
    }

    public String getTempoReserva(){
        return tempoReserva;
    }
  
}
