    /**Classe carro que representa um dos tipos de veículos disponíveis para o aluguel */
    public class Carro extends Veiculo{
        private boolean ehAutomatico;  
        private double valorEntrada; 
        
    /**Construtor da classe Moto 
    *@author Caroline e Nicholas*/ 
    public Carro(String marca, String modelo, boolean disponivel, int anoFabricacao,double kmRodados,String id, boolean ehAutomatico, double valorEntrada){
        super(marca, modelo, disponivel, anoFabricacao, kmRodados,id);
        this.ehAutomatico = ehAutomatico;
        this.valorEntrada = valorEntrada;
    }
    
    /**Método que retorna se o carro é ou não automático 
    *@author Nicholas*/
    public boolean getEhAutomatico(){
        return ehAutomatico;
    }
    
    /**Método que retorna o valor de entrada a ser pago para alugar o carro
    *@author Caroline*/
    public double getValorEntrada(){
        return valorEntrada;
    }

    /**Método que retorna a descrição do carro 
    *@author Caroline*/
    @Override
    public String toString(){
        return super.toString() + "\nCategoria: " + getEhAutomatico() + "\nValor de Entrada: " + getValorEntrada();
    }
    
    /**Método que calcula o valor do aluguel 
    *@author Caroline e Nicholas*/
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
