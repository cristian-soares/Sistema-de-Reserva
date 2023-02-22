    /**
     * Classe Carro, responsável pela implemnetação das características da van, além do cálculo do aluguel
     * @author Caroline, Nicholas
    */

    public class Van extends Veiculo{
        private int numeroDeAssentos;
        private boolean possuiPortaAutomatica;
        
        /**
         * Construtor da Classe
         * @param marca
         * @param modelo
         * @param disponivel
         * @param anoFabricacao
         * @param kmRodados
         * @param id
         * @param numeroDeAssentos
         * @param possuiPortaAutomatica
         */
        public Van(String marca, String modelo, boolean disponivel, int anoFabricacao, double kmRodados,String id, int numeroDeAssentos, boolean possuiPortaAutomatica){
            super(marca, modelo, disponivel, anoFabricacao, kmRodados,id);
            this.numeroDeAssentos = numeroDeAssentos;
            this.possuiPortaAutomatica = possuiPortaAutomatica;
        }
        /**
         * Retorna a quantidade de assentos presentes na van
         *@return int contendo o número de assentos
        */
     
        public int getNumeroDeAssentos() {
            return numeroDeAssentos;
        }
          
    /**
         * Retorna true caso possua porta automatica e false caso não possua
         *@return boolean contendo a existência de porta automatica 
        */
        public boolean getPossuiPortaAutomatica() {
            return possuiPortaAutomatica;
        }
    
        /**
         * Retorna um compilado com todas as informações da van
         *@return String contendo as informações contidas na van
        */
        @Override
        public String toString() {
            return super.toString() + "\nNumero de Assentos: " + getNumeroDeAssentos() + "\nPossui porta automatica: " + getPossuiPortaAutomatica();
        }
        
        /**
         * Retorna o valor do aluguel
         *@return double contendo o valor do aluguel
        */
         @Override
        public double calcularAluguel() {
            if (getNumeroDeAssentos() <= 14 && !getPossuiPortaAutomatica()) {
                return getAnoFabricacao() - (getKmRodados() * 0.01);
            }
            else if (getNumeroDeAssentos() > 14 && !getPossuiPortaAutomatica()){
                return getAnoFabricacao() - (getKmRodados() * 0.05);
            }
            else if (getNumeroDeAssentos() < 14 && getPossuiPortaAutomatica()==true){
                return getAnoFabricacao() - (getKmRodados() * 0.05);
            }
            else {
                return getAnoFabricacao();
            }
        }
    }
    