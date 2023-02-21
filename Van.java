public class Van extends Veiculo
{
    private int numeroDeAssentos;
    private boolean possuiPortaAutomatica;
    
    public Van(String marca, String modelo, boolean disponivel, int anoFabricacao, double kmRodados,String id, int numeroDeAssentos, boolean possuiPortaAutomatica){
        super(marca, modelo, disponivel, anoFabricacao, kmRodados,id);
        this.numeroDeAssentos = numeroDeAssentos;
        this.possuiPortaAutomatica = possuiPortaAutomatica;
    }
    
    public int getNumeroDeAssentos() {
        return numeroDeAssentos;
    }
   
    public boolean getPossuiPortaAutomatica() {
        return possuiPortaAutomatica;
    }
    
    public String toString() {
        return super.toString() + "\nNumero de Assentos: " + getNumeroDeAssentos() + "\nPossui porta automatica: " + getPossuiPortaAutomatica();
    }
    
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
