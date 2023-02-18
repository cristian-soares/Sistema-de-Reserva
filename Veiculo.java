/**Classe que contem os atributos e métodos que são comuns nas outras classes (Carro, Van, Moto).
*/
    public abstract class Veiculo {
        private String marca;
        private String modelo;
        private boolean disponivel;
        private int anoFabricacao;
        private double kmRodados;
        private String id;
  
    /**Construtor da Classe Veículo*/
    public Veiculo(String marca, String modelo, Boolean disponivel, int anoFabricacao, double kmRodados, String id){
        this.marca = marca;
        this.modelo = modelo;
        this.disponivel = disponivel;
        this.anoFabricacao = anoFabricacao;
        this.kmRodados = kmRodados;
        this.id = id;
    }

    /**Método que retorna a marca do veículo
      *@author Caroline */
    public String getMarca(){
        return marca;
    }
    
    /**Método que retorna o modelo do veículo
     *@author Caroline*/
    public String getModelo(){
        return modelo;
    }
    /**Metodo que retorna se o veículo esta ou não disponível */
    public boolean getDisponivel(){
        return disponivel;
    }
    /**Método que retorna o ano de fabricação do veículo 
    *@author Nicholas*/
    public int getAnoFabricacao(){
        return anoFabricacao;
    }
    /**Método que retorna o valor de km Rodados 
    *@author Nicholas*/
    public double getKmRodados() {
        return kmRodados;
    }
    /**Método que retorna o id do veículo 
    *@author Caroline*/
    public String getId() {
        return id;
    }
    /**Método altera o atribulo em relação a disponibilidade do veículo 
    *@author -
    *@param dis- boolean que diz se o veiculo está (true) ou não (false) disponivel */
    public void setDisponivel(boolean dis){
        disponivel = dis;
    }
    /**Método que retorna a descrição do veículo 
    *@author Caroline*/
    @Override
    public String toString(){
        return ("Marca: " + getMarca() + "\nModelo: " + getModelo() + "\nQuantidade Disponivel: " + getDisponivel() + "\nAno de fabricação: " + getAnoFabricacao()+ "\nID: " + getId);
    }
    /**Método referente ao calculo do valor do aluguel, sem implementação, que sera sobrescrito nas subclasses*/ 
    public abstract double calcularAluguel();
}
