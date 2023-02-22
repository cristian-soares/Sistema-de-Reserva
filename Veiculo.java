/**
    *Classe que possui os atributos e metodos comuns de todos os veiculos disponiveis para aluguel 
    * @author Caroline, Nicholas
*/

public abstract class Veiculo {
        private String marca;
        private String modelo;
        private boolean disponivel;
        private int anoFabricacao;
        private double kmRodados;
        private String id;
  
    /*Construtor da classe*/
    public Veiculo(String marca, String modelo, Boolean disponivel, int anoFabricacao, double kmRodados, String id){
        this.marca = marca;
        this.modelo = modelo;
        this.disponivel = disponivel;
        this.anoFabricacao = anoFabricacao;
        this.kmRodados = kmRodados;
        this.id = id;
    }

    /* Metodo que retorna qual a Marca do veiculo */
    public String getMarca(){
        return marca;
    }
    
    /* Metodo que retorna qual o Modelo */
    public String getModelo(){
        return modelo;
    }

    /* Metodo que retorna se o veiculo está disponivel ou não */
    public boolean getDisponivel(){
        return disponivel;
    }

    /* Metodo que retorna qual o ano de fabricacao */
    public int getAnoFabricacao(){
        return anoFabricacao;
    }

    /* Metodo que retorna a quantidade de Km rodados */
    public double getKmRodados() {
        return kmRodados;
    } 

    /* Metodo que retorna o id */
    public String getId() {
        return id;
    }

    /* Metodo que altera o valor do atributo disponivel */
    public void setDisponivel(boolean dis){
        disponivel = dis;
    }

    /* Metodo que retorna a descricao do veiculo */
    @Override
    public String toString(){
        return ("Marca: " + getMarca() + "\nModelo: " + getModelo() + "\nDisponibilidade: " + getDisponivel() + "\nAno de fabricação: " + getAnoFabricacao() + "\nId do Veiculo: " + getId());
    }

    /* Metodo referente ao calculo do valor do aluguel, sem implementacao que sera sobrescrito nas subclasses */ 
    public abstract double calcularAluguel();
}
