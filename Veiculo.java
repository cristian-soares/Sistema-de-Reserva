    public abstract class Veiculo {
        private String marca;
        private String modelo;
        private int quantidadeDisponivel;
        private int anoFabricacao;
        private double kmRodados;

    public Veiculo(String marca, String modelo, int quantidadeDisponivel, int anoFabricacao, double kmRodados){
        this.marca = marca;
        this.modelo = modelo;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.anoFabricacao = anoFabricacao;
        this.kmRodados = kmRodados;
    }

    
    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getQuantidadeDisponivel(){
        return quantidadeDisponivel;
    }

    public int getAnoFabricacao(){
        return anoFabricacao;
    }
    
    public double getKmRodados() {
        return kmRodados;
    }
    
    @Override
    public String toString(){
        return ("Marca: " + getMarca() + "\nModelo: " + getModelo() + "\nQuantidade Disponivel: " + getQuantidadeDisponivel() + "\nAno de fabricação: " + getAnoFabricacao());
    }
    
    public abstract double calcularAluguel();
}
