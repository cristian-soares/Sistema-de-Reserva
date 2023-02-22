 /**
     * Classe Moto, responsável pela implemnetação das características da Moto e cálculo do aluguel
     * @author Caroline, Nicholas
    */

public class Moto extends Veiculo{
    private int numeroDeMarchas;
    private String categoria; //ex: 1-Street · 2- Scooter · 3- Trail · 4- Naked · 5- Sport
    
    /**
     * Construtor da classe
     * @param marca
     * @param modelo
     * @param disponivel
     * @param anoFabricacao
     * @param kmRodados
     * @param id
     * @param numeroDeMarchas
     * @param categoria
     */
    public Moto(String marca, String modelo, boolean disponivel, int anoFabricacao,double kmRodados,String id, int numeroDeMarchas, String categoria) {
        super(marca, modelo, disponivel, anoFabricacao, kmRodados,id);
        this.numeroDeMarchas = numeroDeMarchas;
        this.categoria = categoria;
    }
    
    /** 
     * Método que retorna  o numero de marchas de moto
    * @return int numeroDeMarchas
      */
      public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }

    /** 
     * Método que retorna  a categoria de moto
     *@return String categoria
    */
    
    public String getCategoria() {
        return categoria;
    }

    /** 
     * Método que retorna a descrição completa moto
    *@return String com a descrição dos atributos de moto da referida classe e da super
    */
    @Override
    public String toString() {
        return super.toString() + "/nNumero de Marchas: " + getNumeroDeMarchas() + "/nCategoria: " + getCategoria();
    }
    
    /** 
     * Método que sobrescreve o método da super classe, cujo objetivo é clacular o valor do aluguel
     *@return double valor do aluguel
    */
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
