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

/**
 * Construtor da classe
 * @param marca
 * @param modelo
 * @param disponivel
 * @param anoFabricacao
 * @param kmRodados
 * @param id
 */
public Veiculo(String marca, String modelo, Boolean disponivel, int anoFabricacao, double kmRodados, String id){
    this.marca = marca;
    this.modelo = modelo;
    this.disponivel = disponivel;
    this.anoFabricacao = anoFabricacao;
    this.kmRodados = kmRodados;
    this.id = id;
}

/**
 *  Metodo que retorna qual a Marca do veiculo 
 * @return string com o atributo marca
 **/
public String getMarca(){
    return marca;
}

/**
 *  Metodo que retorna qual o Modelo 
 * @return string com o atributo modelo
*/
public String getModelo(){
    return modelo;
}

/**
 * Metodo que retorna se o veiculo está disponivel ou não
 * @return boolean com o atributo disponivel
 *  */
public boolean getDisponivel(){
    return disponivel;
}

/**
 * Metodo que retorna qual o ano de fabricacao 
 * @return int com o atributo anoFabricacao
*/
public int getAnoFabricacao(){
    return anoFabricacao;
}

/**
 *  Metodo que retorna a quantidade de Km rodados 
 * @return double com o atributo kmRodados
 * */
public double getKmRodados() {
    return kmRodados;
} 

/**
 *  Metodo que retorna o id
 * @return String com o atributo id */
public String getId() {
    return id;
}

/**
 *  Metodo que altera o valor do atributo disponivel 
 * @param dis que altera o atributo disponivel
*/
public void setDisponivel(boolean dis){
    disponivel = dis;
}

/**
 *  Metodo que retorna a descricao do veiculo 
 * @return string com as caracteristicas do veiculo
*/
@Override
public String toString(){
    return ("Marca: " + getMarca() + "\nModelo: " + getModelo() + "\nDisponibilidade: " + getDisponivel() + "\nAno de fabricação: " + getAnoFabricacao() + "\nId do Veiculo: " + getId());
}

/* Metodo referente ao calculo do valor do aluguel, sem implementacao que sera sobrescrito nas subclasses */ 
public abstract double calcularAluguel();
}