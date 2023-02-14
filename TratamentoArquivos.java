import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class TratamentoArquivos {
    private static List<Reserva> r;
    private static List<Veiculo> v;

    public static List<Reserva> lerArqReservas(String nomeArq){
        r = new ArrayList<>();
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArq))){
            String linha = arq.readLine();

            while(linha != null){
                String[] campos = linha.split(",");
                Reserva reserva = new Reserva(campos[0],campos[1],campos[2],campos[3]);
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
            for(Reserva reserva: listaReservaCliente){
                arq.write(reserva.ge);
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
                Veiculo veiculo = new Veiculo(campos[0],campos[1],Integer.parseInt(campos[2]),Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),Integer.parseInt(campos[5]));
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
            for(Veiculo veiculos: listaVeiculos){
                arq.write(veiculos.ge);
            }
        } catch (IOException e) {
            System.out.println("Falha ao salvar no arquivo " + nomeArq);
        }
    }

}