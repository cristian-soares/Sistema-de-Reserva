
public class Reserva {
    private String nomeCliente;
    private String cpfCliente;
    private Veiculo veiculos;
    private String tempoReserva;

    public Reserva(String nomeCliente, String cpf ,Veiculo veiculo, String tempoReserva){
        this.nomeCliente = nomeCliente;
        cpfCliente = cpf;
        this.veiculo = veiculo;
        this.tempoReserva = tempoReserva;
  
    }
    
    public void addVeiculo(veic){
        veiculos.add(veic);
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

    public String getTempoReserva(){
        return tempoReserva;
    }
}
