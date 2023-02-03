    public abstract class Veiculo {
        private String marca;
        private String modelo;
        private boolean disponivel;
        private int anoFabricacao;
        private double kmRodados;
        //verificar se está disponível

    public Veiculo(String marca, String modelo, boolean disponivel, int anoFabricacao, double kmRodados){
        this.marca = marca;
        this.modelo = modelo;
        this.disponivel = disponivel;
        this.anoFabricacao = anoFabricacao;
        this.kmRodados = kmRodados;
    }

    
    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public int getAnoFabricacao(){
        return anoFabricacao;
    }
    
    public double getKmRodados() {
        return kmRodados;
    }
    
    @Override
    public String toString(){
        return ("Marca: " + getMarca() + "\nModelo: " + getModelo() + "\nQuantidade Disponivel: " + getDisponivel() + "\nAno de fabricação: " + getAnoFabricacao());
    }
    
    public abstract double calcularAluguel();
}
