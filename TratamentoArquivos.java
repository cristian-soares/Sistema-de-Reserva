import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class TratamentoArquivos {
    private static Reserva reserva;
    private static Veiculo veiculo;

    public static List<Reserva> lerArqReservas(String nomeArq){
        List<Reserva> r = new ArrayList<>();
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArq))){
            String linha = arq.readLine();

            if(linha == null){
                System.out.println("Arquivo vazio");
            }

            while(linha != null){
                String[] campos = linha.split(",");
                int tipo = retornaTipoVeiculo(campos[5]);
                veiculo = criarVeiculo(campos, tipo);
                 reserva = new Reserva(veiculo,campos[8],campos[9],Integer.parseInt(campos[10]));
                r.add(reserva);

                linha = arq.readLine();
            }
        } catch (IOException e) {
            System.out.println("Falha na leitura do arquivo " + nomeArq);
        }
        return r;
    }

    public static void salvarListaReserva(String nomeArq, List<Reserva> reserva){
        try(FileWriter arq = new FileWriter(nomeArq)) {
            for(Reserva reservas: reserva){
                arq.write(stringVeiculo(reservas.getVeiculo()) + "," + reservas.getNomeCliente() + "," + reservas.getCpfCliente() + "," + reservas.getTempoReserva());
            }
        } catch (IOException e) {
            System.out.println("Falha ao salvar no arquivo" + nomeArq);
        }
    }

     public static List<Veiculo> lerArqVeiculos(String nomeArq){
        List<Veiculo> v = new ArrayList<>();
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArq))){
            String linha = arq.readLine();

            if(linha == null){
                System.out.println("Arquivo vazio");
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

    public static void salvarListaVeiculos(String nomeArq, List<Veiculo> v){
        try(FileWriter arq = new FileWriter(nomeArq)) {
            for(var veiculos: v){
                arq.write(stringVeiculo(veiculos));
            }
        } catch (IOException e) {
            System.out.println("Falha ao salvar no arquivo " + nomeArq);
        }
    }

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

    private static int retornaTipoVeiculo(String id){
        String letra = id.substring(0, 1);
        if(letra.equals("C")){
            return 1;
        }else if(letra.equals("M")){
            return 2;
        }
        return 3;
    }

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