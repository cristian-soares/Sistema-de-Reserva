/**Classe que representa um dos tipos de veículos disponíveis para o aluguel*/
public class Van extends Veiculo
{
    private int numeroDeAssentos;
    private boolean possuiPortaAutomatica;
    /**Construtor da classe 
    *@author Nicholas e Caroline*/
    public Van(String marca, String modelo, boolean disponivel, int anoFabricacao, double kmRodados,String id, int numeroDeAssentos, boolean possuiPortaAutomatica){
        super(marca, modelo, disponivel, anoFabricacao, kmRodados,id);
        this.numeroDeAssentos = numeroDeAssentos;
        this.possuiPortaAutomatica = possuiPortaAutomatica;
    }
    /**Método que retorna o número de assentos da van 
    *@author Nicholas*/
    public int getNumeroDeAssentos() {
        return numeroDeAssentos;
    }
   /**Método que retorna se possui porta automática 
    *@author Nicholas*/
    public boolean getPossuiPortaAutomatica() {
        return possuiPortaAutomatica;
    }
    /**Método que retorna a descrição da van 
    *@author Nicholas*/
    @Override
    public String toString() {
        return super.toString() + "/nNumero de Assentos: " + getNumeroDeAssentos() + "/nPossui porta automatica: " + getPossuiPortaAutomatica();
    }
    /**Método que calcula o valor do aluguel 
    *@author Nicholas*/
     @Override
    public double calcularAluguel() {
        if (getNumeroDeAssentos() <= 14 && !getPossuiPortaAutomatica()) {
            return getAnoFabricacao() - (getKmRodados() * 0.01);
        }
        else if (getNumeroDeAssentos() > 14 && !getPossuiPortaAutomatica()){
            return getAnoFabricacao() - (getKmRodados() * 0.05);
        }
        else if (getNumeroDeAssentos() < 14 && getPossuiPortaAutomatica()==true){
            return getAnoFabricacao() - (getKmRodados() * 0.05);
        }
        else {
            return getAnoFabricacao();
        }
    }
}
