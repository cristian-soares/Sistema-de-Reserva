    public class Carro extends Veiculo{
        private boolean ehAutomatico;  
        private double valorEntrada; //Valor pago antes da reserva, utilizado para calcular o Aluguel

    public Carro(String marca, String modelo, boolean disponivel, int anoFabricacao,double kmRodados, boolean ehAutomatico, double valorEntrada){
        super(marca, modelo, disponivel, anoFabricacao, kmRodados);
        this.ehAutomatico = ehAutomatico;
        this.valorEntrada = valorEntrada;
    }

    public boolean getEhAutomatico(){
        return ehAutomatico;
    }

    public double getValorEntrada(){
        return valorEntrada;
    }

    @Override
    public String toString(){
        return super.toString() + "\nCategoria: " + getEhAutomatico() + "\nValor de Entrada: " + getValorEntrada();
    }
    
    @Override
    public double calcularAluguel() {
        if (!ehAutomatico) {
            return getAnoFabricacao() - (getKmRodados() * 0.015);
        }
        else {
        return getAnoFabricacao() - (getKmRodados() * 0.01);
        }
    }
    
        
}
