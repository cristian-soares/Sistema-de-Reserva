    /**
     * Classe Carro, responsável pela implementação das características do carro e cálculo do aluguel
     * @author Caroline, Nicholas
    */

public class Carro extends Veiculo{
        private boolean ehAutomatico;  
        private double valorEntrada; 
        
    /**
     * Construtor da classe 
     */

    public Carro(String marca, String modelo, boolean disponivel, int anoFabricacao,double kmRodados,String id, boolean ehAutomatico, double valorEntrada){
        super(marca, modelo, disponivel, anoFabricacao, kmRodados,id);
        this.ehAutomatico = ehAutomatico;
        this.valorEntrada = valorEntrada;
    }
    
    /**
     * Metodo para retornar se o carro e automatico 
     * @return boolean verificando se o carro é automatico.
     */
    public boolean getEhAutomatico(){
        return ehAutomatico;
    }
    
    /**
     * Metodo para retornar o valor da entrada, para alugar o carro
     * @return valor de entrada do inserido pelo usuario
     */
    public double getValorEntrada(){
        return valorEntrada;
    }

    /**
     * Metodo que descreve as caracteristicas do carro 
     */
    @Override
    public String toString(){
        return super.toString() + "\nEH Automatico: " + getEhAutomatico() + "\nValor de Entrada: " + getValorEntrada();
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
