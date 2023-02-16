import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static int tipoUsuario;
    private static List<Veiculo> listaVeiculos = new ArrayList<>();
    private static List<Reserva> listaReserva = new ArrayList<>();
    private static Scanner entrada = new Scanner(System.in);
    private static String id;
    private static Veiculo v;
    public static void main(String[] args) {
        System.out.println("Bem Vindo!");
        //Carregar as listas do arquivo
        System.out.println("Escolha o tipo de usuario (1 - Administrador/ 2 - Cliente): ");
        tipoUsuario = entrada.nextInt();
        switch(tipoUsuario){
            case 1:
            gerarMenuAdm();
            tratarMenuAdm(entrada.nextInt());            
            break;
            case 2:
            gerarMenuCliente();
            tratarMenuCliente(entrada.nextInt());
            break;
            default:
            System.out.println("opcao invalida");
        }
    }

    public static void gerarMenuCliente(){
        System.out.println("################ MENU CLIENTE ################");
        System.out.println();
        System.out.println("Escolha uma das opcoes a seguir:"); 
        System.out.println("1 - Ver lista de veiculos disponiveis"); //nicholas
        System.out.println("2 - Ver detalhes de um veiculo especifico");//carol
        System.out.println("3 - Realizar reserva");//carol
        System.out.println("4 - Cancelar reserva"); //carol
        System.out.println("5 - Sair");
        System.out.println();
        System.out.println("##############################################"); 
    }

    public static void gerarMenuAdm(){
        System.out.println("############## MENU ADMINISTRADOR ##############");
        System.out.println();
        System.out.println("Escolha uma das opcoes a seguir:"); 
        System.out.println("1 - Cadastrar veiculo"); // Cristian
        System.out.println("2 - Remover veiculo");// Cristian
        System.out.println("3 - Ver lista completa de veiculos");// Cristian
        System.out.println("4 - Ver detalhes de um veiculo especifico");//nicholas
        System.out.println("5 - Ver lista completa de reservas"); //nicholas
        System.out.println("6 - Ver detalhes de uma reserva especifica"); //duda
        System.out.println("7 - Visualizar Relatorio"); //duda
        System.out.println("8 - Salvar a lista de veiculos");
        System.out.println("9 - Carregar a lista de veiculos"); 
        System.out.println("10 - Salvar a lista de reservas");
        System.out.println("11 - Carregar a lista de reservas");
        System.out.println("12 - Sair");
        System.out.println();
        System.out.println("###############################################"); 
    }

    public static void tratarMenuCliente(int opcao){
        switch(opcao){
            case 1:
            exibirListaVeiculoCliente();
            break;
            case 2:
            exibirDetalheVeiculoCliente();
            break;
            case 3:
            exibirListaVeiculoCliente();
            fazerReserva();
            break;
            case 4:
            cancelarReserva();
            break;
            case 5:
            return;
            default:
            System.out.println("Opcao invalida");
        }
    }

    public static void tratarMenuAdm(int opcao){
        switch(opcao){
            case 1:
            cadastrarVeiculo();
            break;
            case 2:
            removerVeiculo(id);
            break;
            case 3:
            exibirListaVeiculoADM();
            break;
            case 4:
            exibirDetalheVeiculoADM();
            break;
            case 5:
            exibirListaReserva();
            break;
            case 6:
            exibirDetalheReserva();
            break;
            case 7:
            menuRelatorio();
            tratarMenuRelatorio(entrada.nextInt());
            break;
            case 8:
            TratamentoArquivos.salvarListaVeiculos("",listaVeiculos);
            break;
            case 9:
            TratamentoArquivos.lerArqVeiculos("");
            break;
            case 10:
            TratamentoArquivos.salvarListaReserva("",listaReserva);
            break;
            case 11:
            TratamentoArquivos.lerArqReservas("");
            break;
            case 12:
            break;

            default:
            System.out.println("Opcao invalida");
            break;
        }

    }  

    public static void menuRelatorio(){
        System.out.println("################ RELATORIOS ################");
        System.out.println();
        System.out.println("Escolha uma das opcoes a seguir:"); 
        System.out.println("1 - Relatorio dos Veiculos reservados");
        System.out.println("2 - Relatorio das Reservas");
        System.out.println("3 - Relatorio dos Clientes");
        System.out.println("4 - Voltar"); 
        System.out.println();
        System.out.println("#############################################"); 
        
    }

    public static void tratarMenuRelatorio(int opcao){
        switch(opcao){
            case 1:
            for (Veiculo v: listaVeiculos){
                if(!v.getDisponivel()){
                    System.out.println(v);
                }
            }
            break;
            case 2:
            exibirListaReserva();
            break;
            case 3:
            for (Reserva r: listaReserva){
                System.out.println("Cliente: " + r.getNomeCliente() + "/nCPF: "+ r.getCpfCliente());
            }
            break;
            case 4:
            return;
            default:
            System.out.println("opcao invalida");
        }
        
    }

    public static Veiculo dadosVeiculo(){
        System.out.println("Qual veiculo sera adicionado? (1 - Carro / 2 - Moto / 3 - Van)");
        if (entrada.nextInt() == 1){
            System.out.println("e automatico?: 1 - Sim / 2 - Nao ");
            boolean aut;
            if (entrada.nextInt() == 1){
                aut = true;
            }else aut = false;
            System.out.println("Qual o valor de entrada: ");
            double ve = entrada.nextDouble();
            return v = new Carro(lerMarca(),lerModelo(), true, lerAno(),lerKmRodados(),LerId(),aut,ve);
        }
        if (entrada.nextInt() == 2){
            System.out.println("Numero de marchas: ");
            int marchas = entrada.nextInt();
            System.out.println("Categoria: (ex: Street · Scooter · Trail · Naked · Sport)");
            String cat = entrada.nextLine();

            return v = new Moto(lerMarca(),lerModelo(), true, lerAno(),lerKmRodados(),LerId(),marchas,cat);
        }
        
        System.out.println("Possui porta Automatica?: 1 - Sim / 2 - Nao ");
        boolean aut;
        if (entrada.nextInt() == 1){
            aut = true;
        }else aut = false;
        System.out.println("Numero de assentos: ");
        int nA = entrada.nextInt();

        return v = new Van(lerMarca(),lerModelo(), true, lerAno(),lerKmRodados(),LerId(),nA,aut);
    }

    public static String lerMarca(){
        System.out.println("Marca: ");
        return entrada.nextLine();
    }

    public static double lerKmRodados(){
        System.out.println("Km Rodados: ");
        return entrada.nextDouble();
    }

    public static String lerModelo(){
        System.out.println("Modelo: ");
        return entrada.nextLine();
    }

    public static int lerAno(){
        System.out.println("Ano Fabricacao: ");
        return entrada.nextInt();
    } 

    public static String LerId(){
        System.out.println("Id: ");
        return entrada.nextLine();
    }

    public static void cadastrarVeiculo(){
        listaVeiculos.add(dadosVeiculo());
    }

    public static Veiculo buscarIdVeiculo(String id){
        for (Veiculo veiculo : listaVeiculos) {
            if (id.equals(veiculo.getId())){
              return veiculo;  
            } 
        }
        return null;
    }

    public static void removerVeiculo(String id){
        if ( buscarIdVeiculo(id).equals(null)){
            System.out.println("Veiculo nao encontrado ");
        }
        else {
            listaVeiculos.remove(buscarIdVeiculo(id));
        }
        
    }
////////////////////////////////////
public static void exibirListaReserva(){
    for(Reserva r: listaReserva) {
        System.out.println("Nome: " + r.getNomeCliente());
        System.out.println("Tempo de reserva: " + r.getTempoReserva());
    }
}

/*
 * Metodo responsavel por fazer uma busca no List listaReserva
 * e fazer a sua impressao na tela 
 */
    public static void exibirDetalheReserva(){
        System.out.println("Entre com o cpf do cliente, na qual deseja ver a reserva: ");
        String cpf = entrada.nextLine();
        int cont = 0;
        for (Reserva r: listaReserva){
            if(r.getCpfCliente().equals(cpf)){
                System.out.println(r);
                cont++;
            }
        }
        if(cont == 0){
            System.out.println("CPF não encontrado");
        }

    }

    public static void exibirListaVeiculoADM(){
        for (Veiculo v : listaVeiculos) {
            System.out.println(v.toString());
        }
    }

    public static void exibirDetalheVeiculoADM(){
        int contador=0;
        System.out.println("Digite o Id do veiculo desejado: ");
        id = entrada.nextLine();
        for(Veiculo v: listaVeiculos) {
            if(v.getId().equals(id)) {
                System.out.println(v);
                contador++;
            }
        }
        if(contador==0) {
            System.out.println("Numero de Id inexistente");    
        }
    }

    //verifica quais veiculos tem o atributo "disponivel" = true, antes de exibir
    //alguns atributos 
    public static void exibirListaVeiculoCliente(){
        for(Veiculo v: listaVeiculos) {
            if(v.getDisponivel()==true) {
                System.out.println(v);
            }
        }
    }
        
    //verifica quais veiculos tem o atributo "disponivel" = true, antes de exibir 
    //tds os atributos
    public static void exibirDetalheVeiculoCliente(){
        String i;
        System.out.println("Entre com o id do veiculo para saber detalhes:");
        i = entrada.nextLine();
        for(Veiculo v: listaVeiculos){
           if(v.getId().equals(i)){
               System.out.println(v);
           }
           else{
               System.out.println(" Veiculo não encontrado");
           }
       }
    }

    public static void fazerReserva(){
        v = lerVeiculo();
        if(v == null){
            System.out.println("Veiculo nao encontrado");
        }else{
           Reserva r = new Reserva(v,lerNomeCliente(),lerCpf(), lerTempoReserva());
           listaReserva.add(r);
        }
        
     }


    public static String lerNomeCliente(){
        System.out.println("Digite seu nome:");
        return entrada.nextLine();
    }

    public static String lerCpf(){
        System.out.println("Digite o CPF: ");
        return entrada.nextLine();
    }

    public static Veiculo lerVeiculo(){
        System.out.println("Digite o Id do Veiculo desejado: ");
        String i;
        i = entrada.nextLine();
        return buscarIdVeiculo(i); 
    }

    public static int lerTempoReserva(){
        System.out.println("Digite o Tempo que deseja reservar: ");
        return entrada.nextInt();
    }


     public static void cancelarReserva(){ 
         System.out.println("Entre com o numero do CPF utilizado na reserva:");
         String cpf = entrada.nextLine();
         int cont = 0;
         for(Reserva rv: listaReserva){
             if(rv.getCpfCliente().equals(cpf)){
                 listaReserva.remove(rv);
                 System.out.println("Reserva Removida com sucesso");
                 cont = 1;
             }
         }
         if(cont == 0){
            System.out.println("CPF não encontrado");
        }
     }
    //Adicionar na classe veiculo um Id, para fazer as pesquisas relacionadas atraves dele
    //como o cliente escolher qual alugar

}
