import java.util.*;

public class Reserva {
    private String nomeCliente;
    private String cpfCliente;
    private List<Veiculo> reservaVeiculos;
    private String tempoReserva;

    public Reserva(String nomeCliente, String cpf ,Veiculo veiculo, String tempoReserva){
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpf;
        this.veiculo = veiculo;
        this.tempoReserva = tempoReserva;
        reservaVeiculos = new ArrayList<>();
  
    }
    
    public void realizarReserva(veic){
        //pegar o metodo qu retorna se o veiculo esta disponivel ou não
        reservaVeiculos.add(veic);
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
    public void cancelarReserva(String cpf){
        for(Veiculo rv: reservaVeiculos){
            if(getCpfCliente().equals(cpf)){
                reservaVeiculos.remove(rv);
            }
            else{
                System.out.println("O CPF solicitado não realizou nenhuma reserva");
            }
        }

    }
}
