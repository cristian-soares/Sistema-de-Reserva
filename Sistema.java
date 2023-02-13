import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static String tipoUsuario;
    private static List<Veiculo> listaVeiculos;
    private static List<Reserva> listaReservaCliente;
    private static Scanner entrada;

   // public static void main(String[] args) {
        
    //}

    public static void gerarMenuCliente(){
        System.out.println("################ MENU CLIENTE ################");
        System.out.println();
        System.out.println("Escolha uma das opcoes a seguir:"); 
        System.out.println("1 - Ver lista de veiculos disponiveis");
        System.out.println("2 - Ver detalhes de um veiculo especifico");
        System.out.println("3 - Realizar reserva");
        System.out.println("4 - Cancelar reserva"); 
        System.out.println("5 - Sair");
        System.out.println();
        System.out.println("##############################################"); 
    }

    public static void gerarMenuAdm(){
        System.out.println("############## MENU ADMINISTRADOR ##############");
        System.out.println();
        System.out.println("Escolha uma das opcoes a seguir:"); 
        System.out.println("1 - Cadastrar veiculo");
        System.out.println("2 - Remover veiculo");
        System.out.println("3 - Ver lista completa de veiculos");
        System.out.println("4 - Ver detalhes de um veiculo especifico");
        System.out.println("5 - Ver lista completa de reservas"); 
        System.out.println("6 - Ver detalhes de uma reserva especifica"); 
        System.out.println("7 - Remover Reserva"); 
        System.out.println("8 - Visualizar Relatorio");
        System.out.println("9 - Salvar a lista de veiculos");
        System.out.println("10 - Carregar a lista de veiculos"); 
        System.out.println("11 - Salvar a lista de reservas");
        System.out.println("12 - Carregar a lista de reservas");
        System.out.println("13 - Sair");
        System.out.println();
        System.out.println("###############################################"); 
    }

    public static void tratarMenuCliente(){

    }

    public static void tratarMenuAdm(){

    }   

    public static void cadastrarVeiculo(Veiculo v){

    }

    public static void removerVeiculo(Veiculo v){

    }

    public static void salvarEmArquivo(){

    }

    public static void exibirListaReserva(){

    }

    public static void exibirListaVeiculoADM(){
        
    }

    public static void exibirListaVeiculoCliente(){
        //verifica quais veiculos tem o atributo "disponivel" = true, antes de exibir 
    }

    public static void fazerReserva(Veiculo v){

    }

    public static void cancelarReserva(String cpf){

        //percorre a lista de reservas pelo cpf
        //verifica o tempo de reserva
        //exclui a reserva se possivel

    }

    //Adicionar na classe veiculo um Id, para fazer as pesquisas relacionadas atraves dele
    //como o cliente escolher qual alugar

}
