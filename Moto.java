 /**
     * Classe Carro, responsável pela implemnetação das características da Moto e cálculo do aluguel
     * @author Caroline, Nicholas
    */

public class Moto extends Veiculo{
    private int numeroDeMarchas;
    private String categoria; //ex: 1-Street · 2- Scooter · 3- Trail · 4- Naked · 5- Sport
    
    public Moto(String marca, String modelo, boolean disponivel, int anoFabricacao,double kmRodados,String id, int numeroDeMarchas, String categoria) {
        super(marca, modelo, disponivel, anoFabricacao, kmRodados,id);
        this.numeroDeMarchas = numeroDeMarchas;
        this.categoria = categoria;
    }
    
    public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public String toString() {
        return super.toString() + "\nNumero de Marchas: " + getNumeroDeMarchas() + "\nCategoria: " + getCategoria();
    }
    
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
