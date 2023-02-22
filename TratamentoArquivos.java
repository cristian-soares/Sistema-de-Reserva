/**
 * Classe responsável por tratar arquivos de texto utilizados no sistema de reserva de veículos.
 * Permite a escrita e leitura de informações dos veículos e reservas, bem como a verificação de existência de arquivos.
 * @author Maria Eduarda, Cristian
 */

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class TratamentoArquivos {
    private static Reserva reserva;
    private static Veiculo veiculo;

    /**
     * Metodo responsável pela leitura do arquivo .txt, e adiciona em uma lista de Reservas
     * @param nomeArq
     * @return ArrayList<>
     */
    public static List<Reserva> lerArqReservas(String nomeArq){
        List<Reserva> r = new ArrayList<>();
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArq))){
            String linha = arq.readLine();

            if(linha == null){
                System.out.println(nomeArq + ": Arquivo vazio");
            }

            while(linha != null){
                String[] campos = linha.split(",");
                
                int tipo = retornaTipoVeiculo(campos[5]);
                veiculo = criarVeiculo(campos, tipo);
                reserva = new Reserva(veiculo,campos[8],campos[9],campos[10],Integer.parseInt(campos[11]));
                r.add(reserva);

                linha = arq.readLine();
            }
        } catch (IOException e) {
            System.out.println("Falha na leitura do arquivo " + nomeArq);
        }
        return r;
    }

    /**
     * Metodo responsável por salvar em um arquivo .txt, uma lista de Reservas, provenientes da Classe Sistema
     * @param nomeArq
     * @param reserva
     */
    public static void salvarListaReserva(String nomeArq, List<Reserva> reserva){
        try(FileWriter arq = new FileWriter(nomeArq)) {
            for(Reserva reservas: reserva){
                arq.write(stringVeiculo(reservas.getVeiculo()) + "," + reservas.getNomeCliente() + "," + reservas.getCpfCliente() + "," + reservas.getDataInicio() + "," + reservas.getTempoReserva() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Falha ao salvar no arquivo" + nomeArq);
        }
    }

    /**
     * Metodo responsável pela leitura do arquivo .txt, e adiciona em uma lista de Veiculos
     * @param nomeArq
     * @return ArrayList<Veiculo>
     */
     public static List<Veiculo> lerArqVeiculos(String nomeArq){
        List<Veiculo> v = new ArrayList<>();
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArq))){
            String linha = arq.readLine();

            if(linha == null){
                System.out.println(nomeArq + ": Arquivo vazio");
            }

            while(linha != null){
                String[] campos = linha.split(",");
                int tipo = retornaTipoVeiculo(campos[5]);
                veiculo = criarVeiculo(campos, tipo);
                v.add(veiculo);
                linha = arq.readLine();
            }
            
        } catch (IOException e) {
            System.out.println("Falha na leitura do arquivo " + nomeArq);
        }
        return v;
    } 

        /**
         * Metodo responsável por salvar em um arquivo .txt, uma lista de Veiculos, provenientes da Classe Sistema
         * @param nomeArq
         * @param v
         */
    public static void salvarListaVeiculos(String nomeArq, List<Veiculo> v){
        try(FileWriter arq = new FileWriter(nomeArq)) {
            for(Veiculo veiculos: v){
                arq.write(stringVeiculo(veiculos )+ "\n");
            }
        } catch (IOException e) {
            System.out.println("Falha ao salvar no arquivo " + nomeArq);
        }
    }

        /**
         * Verifica o tipo de Veiculo.
         * @param veiculos
         * @return String 
         */
    private static String stringVeiculo(Veiculo veiculos){
        if(veiculos instanceof Carro){
            Carro carro = (Carro) veiculos;
            return (veiculos.getMarca()+ "," + veiculos.getModelo()+ "," + veiculos.getDisponivel()+ "," + veiculos.getAnoFabricacao()+ ","+ veiculos.getKmRodados()+ ","+veiculos.getId()+ "," + carro.getEhAutomatico()+ "," + carro.getValorEntrada());
        }
        else if(veiculos instanceof Moto){
            Moto moto = (Moto) veiculos;
            return (veiculos.getMarca()+ "," + veiculos.getModelo()+ "," + veiculos.getDisponivel()+ "," + veiculos.getAnoFabricacao()+ ","+ veiculos.getKmRodados()+ ","+veiculos.getId()+ "," + moto.getNumeroDeMarchas()+ "," + moto.getCategoria());
        }

        Van van = (Van) veiculos;
        return (veiculos.getMarca()+ "," + veiculos.getModelo()+ "," + veiculos.getDisponivel()+ "," + veiculos.getAnoFabricacao()+ ","+ veiculos.getKmRodados()+ ","+veiculos.getId()+ "," + van. getNumeroDeAssentos()+ "," + van.getPossuiPortaAutomatica());
        
    }

    /**
     * Metodo que retorna um inteiro para ser usado na comparação com os tipos de veiculos.
     * @param id
     * @return int
     */
    private static int retornaTipoVeiculo(String id){
        String letra = id.substring(0, 1);
        if(letra.equals("C")){
            return 1;
        }else if(letra.equals("M")){
            return 2;
        }
        return 3;
    }

    /**
     * Metodo que instancia os veiculos de acordos com os tipos
     * @param campos
     * @param tipo
     * @return veiculo
     */
    private static Veiculo criarVeiculo(String[] campos, int tipo){

        if(tipo == 1)//Carro
        veiculo = new Carro(campos[0],campos[1],Boolean.parseBoolean(campos[2]),Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
        campos[5],Boolean.parseBoolean(campos[6]),Double.parseDouble(campos[7]));
    
        if(tipo == 2){//moto
        veiculo = new Moto(campos[0],campos[1],Boolean.parseBoolean(campos[2]),Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
        campos[5],Integer.parseInt(campos[6]),campos[7]);
        }
        if (tipo == 3){
        veiculo = new Van(campos[0],campos[1],Boolean.parseBoolean(campos[2]),Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
        campos[5],Integer.parseInt(campos[6]),Boolean.parseBoolean(campos[7]));
        }

        return veiculo;
    }

}