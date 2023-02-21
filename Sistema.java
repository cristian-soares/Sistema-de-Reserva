import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Calendar;

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
        int sair = 0;
        switch(tipoUsuario){
            case 1:
            do{
                gerarMenuAdm();
                sair = tratarMenuAdm(entrada.nextInt());  
            }while(sair == 0);        
            break;
            case 2:
            do{
                gerarMenuCliente();
                sair = tratarMenuCliente(entrada.nextInt());
            }while(sair == 0); 
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
        System.out.println("7 - Visualizar Relatorios"); //duda
        System.out.println("8 - Salvar a lista de veiculos");
        System.out.println("9 - Carregar a lista de veiculos"); 
        System.out.println("10 - Salvar a lista de reservas");
        System.out.println("11 - Carregar a lista de reservas");
        System.out.println("12 - Sair");
        System.out.println();
        System.out.println("###############################################"); 
    }

    public static int tratarMenuCliente(int opcao){
        switch(opcao){
            case 1:
            exibirListaVeiculoCliente();
            return 1;
            case 2:
            exibirDetalheVeiculoCliente();
            return 1;
            case 3:
            exibirListaVeiculoCliente();
            fazerReserva();
            return 1;
            case 4:
            cancelarReserva();
            return 1;
            case 5:
            return 0;
    
            default:
            System.out.println("Opcao invalida ");
            System.out.println("Digite uma opcao valida: ");
            return 1;
        }
    }

    public static int tratarMenuAdm(int opcao){
        switch(opcao){
            case 1:
            cadastrarVeiculo();
            return 1;
            case 2:
            removerVeiculo(id);
            return 1;
            case 3:
            exibirListaVeiculoADM();
            return 1;
            case 4:
            exibirDetalheVeiculoADM();
            return 1;
            case 5:
            exibirListaReserva();
            return 1;
            case 6:
            exibirDetalheReserva();
            return 1;
            case 7:
            menuRelatorio();
            tratarMenuRelatorio(entrada.nextInt());
            return 1;
            case 8:
            TratamentoArquivos.salvarListaVeiculos("",getListaVeiculo());
            return 1;
            case 9:
            TratamentoArquivos.lerArqVeiculos("");
            return 1;
            case 10:
            TratamentoArquivos.salvarListaReserva("",getListaReservas());
            return 1;
            case 11:
            TratamentoArquivos.lerArqReservas("");
            return 1;
            case 12:
            return 0;
            
            default:
            System.out.println("Opcao invalida");
           
            System.out.println("Digite uma opcao valida: ");
            return 1;
        }

    }  

    public static void menuRelatorio(){
        System.out.println("################ RELATORIOS ################");
        System.out.println();
        System.out.println("Escolha uma das opcoes a seguir:"); 
        System.out.println("1 - Relatorio dos Veiculos reservados");
        System.out.println("2 - Relatorio dos Clientes");
        System.out.println("3 - Voltar"); 
        /* 
         * System.out.println("3 - Veiculos mais reservados");
         * 
         * novo atributo que controle a quantidade de vezes que o v foi reservado 
         * exibir a lista ordenada a partir disso
        */
        System.out.println();
        System.out.println("#############################################"); 
        
    }

    public static void tratarMenuRelatorio(int opcao){
        switch(opcao){


///////////////////      VOLTAR AQUI


            case 1://Mostrar junto o tempo de reserva 
            for (Reserva r: listaReserva){
                System.out.println(r.getVeiculo() + " " + r.getTempoReserva());
            }
            break;
            case 2:
            for (Reserva r: listaReserva){
                System.out.println("Cliente: " + r.getNomeCliente() + "/nCPF: "+ r.getCpfCliente());
            }
            break;
            case 3:
            return;
            default:
            System.out.println("opcao invalida");
        }
        
    }

    public static List<Reserva> getListaReservas(){
        return Collections.unmodifiableList(listaReserva);
    }

    public static List<Veiculo> getListaVeiculo(){
        return Collections.unmodifiableList(listaVeiculos);
    }
///////////////////// TRATAR TEMPO RESERVA /////////////////////////////

/*public static boolean compararData(){
    Calendar c = Calendar.getInstance();
    String d = reserva.getTempoReserva();
    String[] data = d.split("/");

    //converter string int?
    if(data[1] >= (c.get(Calendar.MONTH))){
        if(data[0] > (c.get(Calendar.DAY_OF_MONTH))){
            return true;
        }
        return false;   
    }
    return false;
}
*/
public static boolean compararData(String data) {
    Calendar c = Calendar.getInstance(); 
    String[] dat = data.split("/");
    int dia;
    int j;
    int mes;
    int i;
    
    dia = Integer.parseInt(dat[0]);
    mes = Integer.parseInt(dat[1]);
    
    j=c.get(Calendar.DAY_OF_MONTH);
    i=c.get(Calendar.MONTH);
    
    if(mes>=i) {
        if(dia>j) {
            return true;
        }
        return false;
    }
    return false;
}

    public static Veiculo dadosVeiculo(){
        System.out.println("Qual veiculo sera adicionado? (1 - Carro / 2 - Moto / 3 - Van)");
        int i = entrada.nextInt();
        if (i == 1){
            
            System.out.println("e automatico?: 1 - Sim / 2 - Nao ");
            boolean aut;
            if (entrada.nextInt() == 1){
                aut = true;
            }else aut = false;
            System.out.println("Qual o valor de entrada: ");
            double ve = entrada.nextDouble();
            
            return v = new Carro(marca,modelo, true, lerAno(),lerKmRodados(),LerId(),aut,ve);
        
        }
        if (i == 2){
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
        System.out.println("Tempo de reserva: " + r.getTempoReserva() + " dias");

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
        int t = lerTempoReserva();
        String d = lerDataInicio();
        boolean check = false;
        while(check == false){
        if (verificarTempoValido(t) && compararData(d)){
            check = true;
        } else {
            if (verificarTempoValido(t) == false){
                System.out.println("Tempo de Reserva inválido, insira outro tempo: ");
                lerTempoReserva();
            }
            if (compararData(d)== false){
                System.out.println("Data inválida, insira outra data: ");
                lerDataInicio();
            }
        }
    }
        if(v == null){
            System.out.println("Veiculo nao encontrado");
        }else{
            v.setDisponivel(false); 
            Reserva r = new Reserva(v,lerNomeCliente(),lerCpf(),d,t);
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

    public static String lerDataInicio(){
        System.out.println("Digite a Data para Inicio da Reserva: exemplo(DD/MM)");
        return entrada.nextLine();
    } 

    public static boolean verificarTempoValido(int tempo){
        if (tempo > 7){
            return false;
        }
            return true;
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
                 v.setDisponivel(true);
             }
         }
         if(cont == 0){
            System.out.println("CPF não encontrado");
        }
     }
    //Adicionar na classe veiculo um Id, para fazer as pesquisas relacionadas atraves dele
    //como o cliente escolher qual alugar

}
