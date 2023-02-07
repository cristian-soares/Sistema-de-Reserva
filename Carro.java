    //Classe Carro, representa um dos veículos disponíveis para aluguel
    public class Carro extends Veiculo{
        private boolean ehAutomatico;  
        private double valorEntrada; 
        
    //Construtor da classe 
    public Carro(String marca, String modelo, boolean disponivel, int anoFabricacao,double kmRodados, boolean ehAutomatico, double valorEntrada){
        super(marca, modelo, disponivel, anoFabricacao, kmRodados);
        this.ehAutomatico = ehAutomatico;
        this.valorEntrada = valorEntrada;
    }
    
    //Metodo para retornar o estado do atributo ehAutomático
    public boolean getEhAutomatico(){
        return ehAutomatico;
    }
    
    //Metodo para retornar o estado do atributo valorEntrada
    public double getValorEntrada(){
        return valorEntrada;
    }

    //Metodo que descreve as caracteristicas do carro
    @Override
    public String toString(){
        return super.toString() + "\nCategoria: " + getEhAutomatico() + "\nValor de Entrada: " + getValorEntrada();
    }
    
    //Metodo para calcular o aluguel
    @Override
    public double calcularAluguel() {
        if (!ehAutomatico) {
            return valorEntrada+(getAnoFabricacao() - (getKmRodados() * 0.015));
        }
        else {
        return valorEntrada+(getAnoFabricacao() - (getKmRodados() * 0.01));
        }
    }
    
        
}
