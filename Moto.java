/**Classe que representa um dos tipos de veículos disponíveis para o aluguel*/
public class Moto extends Veiculo
{
    private int numeroDeMarchas;
    private String categoria; //ex: 1-Street · 2- Scooter · 3- Trail · 4- Naked · 5- Sport
    
    /**Construtor da classe Moto
    @author Nicholas e Caroline*/
    public Moto(String marca, String modelo, boolean disponivel, int anoFabricacao,double kmRodados,String id, int numeroDeMarchas, String categoria) {
        super(marca, modelo, disponivel, anoFabricacao, kmRodados,id);
        this.numeroDeMarchas = numeroDeMarchas;
        this.categoria = categoria;
    }
    /**Método que retorna o numero de marchas da moto 
    *@author Nicholas*/
    public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }
    /**Método que retorna a categoria da moto 
    *@author Nicholas*/
    public String getCategoria() {
        return categoria;
    }
    /**Método que retorna a descrição da moto 
    *@author Nicholas*/
    @Override
    public String toString() {
        return super.toString() + "/nNumero de Marchas: " + getNumeroDeMarchas() + "/nCategoria: " + getCategoria();
    }
    /**Método que calcula o valor do aluguel 
    *@author Nicholas*/
    @Override
    public double calcularAluguel() {
        if (getCategoria().equals("Street") || getCategoria().equals("Scooter")) {
            return getAnoFabricacao() - (getKmRodados() * 0.015 - 300);
        }
        
        else if (getCategoria().equals("Naked")){
            return getAnoFabricacao() - (getKmRodados() * 0.015 - 250);
        }
        else {
            return getAnoFabricacao() - (getKmRodados() * 0.015 - 200);
        }
    }

}
