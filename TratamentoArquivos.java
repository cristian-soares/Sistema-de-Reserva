import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class TratamentoArquivos {
    private static List<Reserva> r;
    private static List<Veiculo> v;
    private static Reserva reserva;
    private static Veiculo veiculo;

    public static List<Reserva> lerArqReservas(String nomeArq){
        r = new ArrayList<>();
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArq))){
            String linha = arq.readLine();

            while(linha != null){
                String[] campos = linha.split(",");
                 reserva = new Reserva(campos[0],campos[1],campos[2],campos[3]);
                r.add(reserva);

                linha = arq.readLine();
            }
        } catch (IOException e) {
            System.out.println("Falha na leitura do arquivo " + nomeArq);
        }
        return r;
    }

    public static void salvarListaReserva(String nomeArq){
        try(FileWriter arq = new FileWriter(nomeArq)) {
            for(Reserva reserva: r){
                arq.write();
            }
        } catch (IOException e) {
            System.out.println("Falha ao salvar no arquivo " + nomeArq);
        }
    }

     public static List<Veiculo> lerArqVeiculos(String nomeArq){
        v = new ArrayList<>();
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArq))){
            String linha = arq.readLine();

            while(linha != null){
                String[] campos = linha.split(",");
                int tipo = retornaTipoVeiculo(campos[5]);

                if(tipo == 1)//Carro
                    veiculo = new Carro(campos[0],campos[1],Boolean.parseBoolean(campos[2]),Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
                    campos[5],Boolean.parseBoolean(campos[6]),Double.parseDouble(campos[7]));
                
                if(tipo == 2){
                    veiculo = new Moto(campos[0],campos[1],Boolean.parseBoolean(campos[2]),Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
                    campos[5],Integer.parseInt(campos[6]),campos[7]);
                }
                if (tipo == 3){
                    veiculo = new Van(campos[0],campos[1],Boolean.parseBoolean(campos[2]),Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
                    campos[5],Integer.parseInt(campos[6]),Boolean.parseBoolean(campos[7]));
                }
                v.add(veiculo);

                linha = arq.readLine();
            }
            
        } catch (IOException e) {
            System.out.println("Falha na leitura do arquivo " + nomeArq);
        }
        return v;
    } 

    public static void salvarListaVeiculos(String nomeArq){
        try(FileWriter arq = new FileWriter(nomeArq)) {
            for(Veiculo veiculos: v){
                arq.write(veiculos.ge);
            }
        } catch (IOException e) {
            System.out.println("Falha ao salvar no arquivo " + nomeArq);
        }
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

}