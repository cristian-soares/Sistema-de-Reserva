import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static int tipoUsuario;
    private static List<Veiculo> listaVeiculos = new ArrayList<>();
    private static List<Reserva> listaReserva = new ArrayList<>();
    private static Scanner entrada = new Scanner(System.in);
    private static int id;
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
           // TratamentoArquivos.salvarListaVeiculos("");
            break;
            case 9:
           // TratamentoArquivos.lerArqVeiculos("");
            break;
            case 10:
          //  TratamentoArquivos.salvarListaReserva("");
            break;
            case 11:
           // TratamentoArquivos.lerArqReservas("");
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
        Veiculo v;
        System.out.println("Qual veiculo sera adicionado? (1 - Carro / 2 - Moto / 3 - Van)");
        if (entrada.nextInt() == 1){
        System.out.println("Marca: ");
        String m = entrada.nextLine();
        System.out.println("Modelo: ");
        String mo = entrada.nextLine();
        System.out.println("Ano Fabricacao: ");
        String m = entrada.nextLine();
        System.out.println("Modelo: ");
        String mo = entrada.nextLine();

           //return v = new Carro(m,);
        }
        if (entrada.nextInt() == 2){
        return v = new Moto();
        }
        return v = new Van();
    }

    public static void cadastrarVeiculo(){
        listaVeiculos.add(dadosVeiculo());
    }

    public static Veiculo buscarIdVeiculo(int id){
        for (Veiculo veiculo : listaVeiculos) {
            if (id == veiculo.getId()){
              return veiculo;  
            } 
        }
        return null;
    }

    public static void removerVeiculo(int id){
        if ( buscarIdVeiculo(id) == null){
            System.out.println("Veiculo nao encontrado ");
        }
        else {
            listaVeiculos.remove(buscarIdVeiculo(id));
        }
        
    }

    public static void exibirListaReserva(){
     
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
       
    }

    public static void exibirListaVeiculoCliente(){
        //verifica quais veiculos tem o atributo "disponivel" = true, antes de exibir
        //alguns atributos 
    }

    public static void exibirDetalheVeiculoCliente(){
        //verifica quais veiculos tem o atributo "disponivel" = true, antes de exibir 
        //tds os atributos
    }

    public static void fazerReserva(){
          /*ler o id do veiculo, 
            conferir se existe
            passar parametros 
            cria obj reserva
        add na lista 
            */
       

    }

    public static void cancelarReserva(){
        /*ler o cpf do cliente, 
        conferir se existe
            */

        //percorre a lista de reservas pelo cpf
        //verifica o tempo de reserva
        //exclui a reserva se possivel

    }

    //Adicionar na classe veiculo um Id, para fazer as pesquisas relacionadas atraves dele
    //como o cliente escolher qual alugar

}
