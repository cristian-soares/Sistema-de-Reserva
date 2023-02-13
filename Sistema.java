import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static String tipoUsuario;
    private static List<Veiculo> listaVeiculos;
    private static List<Reserva> listaReservaCliente;
    private static Scanner entrada;

   // public static void main(String[] args) {
        //Duda
    //}

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
            break;
            default:
            System.out.println("Opcao invalida");
            break;
        }
    }

    public static void tratarMenuAdm(int opcao){
        switch(opcao){
            case 1:
            cadastrarVeiculo();
            break;
            case 2:
            removerVeiculo();
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
            break;
            case 8:
            salvarListaVeiculos(String nomeArq);
            break;
            case 9:
            lerArqVeiculos(String nomeArq);
            break;
            case 10:
            salvarListaReserva(String nomeArq);
            break;
            case 11:
            lerArqReservas(String nomeArq);
            break;
            case 12:
            break;

            default:
            System.out.println("Opcao invalida");
            break;
        }

    }  

    public static void menuRelatorio(){
        
    }

    public static void cadastrarVeiculo(){
        
    }

    public static void removerVeiculo(){

    }
 
    /*Arquivo
    public static void salvarEmArquivo(){

    }
    public static void salvarEmArquivo(){

    }
    public static void salvarEmArquivo(){

    }
    public static void salvarEmArquivo(){

    }
    Arquivo*/

    public static void exibirListaReserva(){

    }

    public static void exibirDetalheReserva(){

    }

    public static void exibirListaVeiculoADM(){
        
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
