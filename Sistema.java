/**
 * Classe Sistema
 * Classe responsável por gerenciar o sistema de reserva de veículos. 
 * Permite o cadastro, remoção, visualização de veículos e reservas. 
 * Também inclui funcionalidades para verificação de disponibilidade e cancelamento de reservas. 
 * 
 * @author Caroline, Cristian, Maria Eduarda, Nicholas 
 */

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
    private static Scanner e;
    private static String id;
    private static Veiculo v;
    public static void main(String[] args) {
        System.out.println("Bem Vindo ao ALUGA FACIL!");
        atribuirlistaVeiculo();
        atribuirlistaReserva();
        int s = 1;
        while(s == 1){
            System.out.println("Escolha uma opcao: 1 - Administrador / 2 - Cliente / 3 - Sair do Sistema: ");
            tipoUsuario = entrada.nextInt();

            int sair = 0;

            switch(tipoUsuario){
            case 1:
            do{
                gerarMenuAdm();
                sair = tratarMenuAdm(entrada.nextInt());  
            }while(sair == 1);      
            break;
            case 2:
            do{
                gerarMenuCliente();
                sair = tratarMenuCliente(entrada.nextInt());
            }while(sair == 1); 
            break;
            case 3:
            s = 0;
            break;
            default:
            System.out.println("opcao invalida");
            }   
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
       
    }

    /////// TRATAMENTO DE MENUS ///////

    public static void gerarMenuCliente(){
        System.out.println("################ MENU CLIENTE ################");
        System.out.println();
        System.out.println("Escolha uma das opcoes a seguir:"); 
        System.out.println("1 - Ver lista de veiculos disponiveis"); 
        System.out.println("2 - Ver detalhes de um veiculo especifico");
        System.out.println("3 - Realizar reserva");
        System.out.println("4 - Cancelar reserva"); 
        System.out.println("5 - Voltar");
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
        System.out.println("7 - Visualizar Relatorios");
        System.out.println("8 - Salvar a lista de veiculos");
        System.out.println("9 - Carregar a lista de veiculos"); 
        System.out.println("10 - Salvar a lista de reservas");
        System.out.println("11 - Carregar a lista de reservas");
        System.out.println("12 - Voltar");
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
            TratamentoArquivos.salvarListaReserva("reserva.txt",getListaReservas());
            return 1;
            case 4:
            cancelarReserva();
            return 1;
            case 5:
            return 0;
    
            default:
            System.out.println("Opcao invalida ");
            System.out.println("Digite uma opcao valida");
            return 1;
        }
    }

    public static int tratarMenuAdm(int opcao){
        switch(opcao){
            case 1:
            cadastrarVeiculo();
            return 1;
            case 2:
            removerVeiculo(lerId(tipoVeiculo("removido")));
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
            int sair1 = 0;
            do{
                menuRelatorio();
                tratarMenuRelatorio(entrada.nextInt());
            }while(sair1 == 0);
            return 1;
            case 8:
            TratamentoArquivos.salvarListaVeiculos("veiculo.txt",getListaVeiculo());
            return 1;
            case 9:
            atribuirlistaVeiculo();
            return 1;
            case 10:
            TratamentoArquivos.salvarListaReserva("reserva.txt",getListaReservas());
            return 1;
            case 11:
            atribuirlistaReserva();
            return 1;
            case 12:
            return 0;
            
            default:
            System.out.println("Opcao invalida");
           
            System.out.println("Digite uma opcao valida");
            return 1;
        }

    }  
    
    public static void menuRelatorio(){
        System.out.println("################ RELATORIOS ################");
        System.out.println();
        System.out.println("Escolha uma das opcoes a seguir:"); 
        System.out.println("1 - Relatorio dos Veiculos reservados");
        System.out.println("2 - Relatorio dos Clientes");
        System.out.println("3 - Relatorio Financeiro");
        System.out.println("4 - Voltar"); 
        System.out.println();
        System.out.println("#############################################"); 
        
    }

    public static int tratarMenuRelatorio(int opcao){
        switch(opcao){
            case 1: 
            for (Reserva r: listaReserva){
                System.out.println(r.getVeiculo() + "\n" + r.getTempoReserva() + " dias");
                System.out.println(" ");
            }
            return 1;

            case 2:
            for (Reserva r: listaReserva){
                System.out.println("Cliente: " + r.getNomeCliente() + "/nCPF: "+ r.getCpfCliente());
                System.out.println(" ");
            }
            return 1;

            case 3:
            relatorioFinanceiro();
            return 1;

            case 4:
            return 0;

            default:
            System.out.println("opcao invalida");
            return 1;
        }
    }

    public static List<Reserva> getListaReservas(){
        return Collections.unmodifiableList(listaReserva);
    }

    public static List<Veiculo> getListaVeiculo(){
        return Collections.unmodifiableList(listaVeiculos);
    }



///////////////////// TRATAR TEMPO RESERVA /////////////////////////////

    public static boolean compararData(String data) { 
        Calendar c = Calendar.getInstance(); 
        String[] dat = data.split("/");
        int dia;
        int j;
        int mes;
        int i;
    
        dia = Integer.parseInt(dat[0]);
        mes = Integer.parseInt(dat[1]);
    
        j = c.get(Calendar.DAY_OF_MONTH);
        i = 1 + c.get(Calendar.MONTH);
    
        if (mes > i) {
           return true;
        }else if(mes == i){
            if (dia > j){
                return true;
            }
        }
        return false;
    }

///////////////// TRATAMENTO VEICULOS /////////////////////

    /**
     *  Método que confere o Id inserido
     */
    public static String conferirId(int tipo){
        String id = lerId(tipo);

        while(buscarIdVeiculo(id) != null){
            System.out.println("Id ja existente");
            id = lerId(tipo);
        }
        return id;

    }

    /**
     * Método para leitura do tipo de veículo a ser inserido 
     */
    public static int tipoVeiculo(String letra){
        System.out.println("Qual veiculo sera " + letra + "? (1 - Carro / 2 - Moto / 3 - Van)");
        int i = entrada.nextInt();
        return i;
    }

    /** 
     * Método para inserção dos dados do veículo 
     */
    public static Veiculo dadosVeiculo(){
        int i = tipoVeiculo("adicionado");
        if (i == 1){
            System.out.println("e automatico?: 1 - Sim / 2 - Nao ");
            boolean aut;
            if (entrada.nextInt() == 1){
                aut = true;
            }else aut = false;
            System.out.println("Qual o valor de entrada: ");
            e = new Scanner(System.in);
            double ve = e.nextDouble();
            return v = new Carro(lerMarca(),lerModelo(), true, lerAno(),lerKmRodados(),conferirId(i),aut,ve);
        
        }
        if (i == 2){
            System.out.println("Numero de marchas: ");
            e = new Scanner(System.in);
            int marchas = e.nextInt();
            System.out.println("Categoria: (ex: Street · Scooter · Trail · Naked · Sport)");
            e = new Scanner(System.in);
            String cat = e.nextLine();

            return v = new Moto(lerMarca(),lerModelo(), true, lerAno(),lerKmRodados(),conferirId(i),marchas,cat);
        }
        
        System.out.println("Possui porta Automatica?: 1 - Sim / 2 - Nao ");
        boolean aut;
        if (entrada.nextInt() == 1){
            aut = true;
        }else aut = false;
        System.out.println("Numero de assentos: ");
        e = new Scanner(System.in);
        int nA = e.nextInt();

        return v = new Van(lerMarca(),lerModelo(), true, lerAno(),lerKmRodados(),conferirId(i),nA,aut);
    }

    /**
     * Responsável pela leitura dos Kms rodados do veiculo inserido pelo usuario 
     */
    public static String lerMarca(){
        System.out.println("Marca: ");
        e = new Scanner(System.in);
        return e.nextLine();
    }

    /**
     *  Método que atribui à lista de veículos, os dados da lista gerado pelo Tratamento de Arquivo 
     */
    public static  void atribuirlistaVeiculo(){
        for (Veiculo vel : TratamentoArquivos.lerArqVeiculos("veiculo.txt")) {
            listaVeiculos.add(vel);
        }
    }

    /** 
     * Responsável pela leitura dos Kms rodados do veiculo inserido pelo usuario 
     */
    public static double lerKmRodados(){
        System.out.println("Km Rodados: ");
        e = new Scanner(System.in);
        return e.nextDouble();
    }

    /**
     *  Responsável pela leitura do Modelo do veiculo inserido pelo usuario 
     */
    public static String lerModelo(){
        System.out.println("Modelo: ");
        e = new Scanner(System.in);
        return e.nextLine();
    }

    /**
     * Responsável pela leitura do Ano de fabricação do veiculo inserido pelo usuario 
     */
    public static int lerAno(){
        System.out.println("Ano Fabricacao: ");
        e = new Scanner(System.in);
        return e.nextInt();
    } 


    /**
     *  Método responsável por verificar o Id para identificar o tipo de Veículo 
     */
    private static boolean verificarId(String id, int tipo){
        String letra = id.substring(0, 1);

        if(letra.equals("C") && (tipo == 1)){
            return true;
        }

        if (letra.equals("M") && (tipo == 2)) {
            return true;
        }   

        if (letra.equals("V") && (tipo == 3)){
            return true;
        }
        
        
        return false;
    }
    
    /**
     * Método responsável por Ler o Id do veículo inserido pelo usuário 
     */
    public static String lerId(int tipo){
        System.out.println("Id: (inicie com 'C' para carro, 'M' para moto e 'V' para Van, por exemplo 'C123') ");
        e = new Scanner(System.in);
        String entrada = e.nextLine();
        
        while (!verificarId(entrada,tipo)){
            System.out.println("Formato invalido, digite novamente");
            entrada = e.nextLine();
        }
        return entrada;

    }

    /** 
     * Método responsável por realizar o cadastro do veículo desejado 
     */
    public static void cadastrarVeiculo(){
        listaVeiculos.add(dadosVeiculo());
        System.out.println("Veiculo cadastrado com sucesso");
        System.out.println("");
    }

    /** 
     * Método que Busca Id do veículo a partir da lista de Veículos 
     */
    public static Veiculo buscarIdVeiculo(String id){
        for (Veiculo veiculo : listaVeiculos) {
            if (id.equals(veiculo.getId())){
              return veiculo;  
            } 
        }
        return null;
    }

    /** 
     * Método responsável por percorrer a lista de Véiculos a partir do Id e realiza a remoção, caso exista. 
     */
    public static void removerVeiculo(String id){
        if ( buscarIdVeiculo(id).equals(null)){
            System.out.println("Veiculo nao encontrado ");
        }
        else {
            listaVeiculos.remove(buscarIdVeiculo(id));
            System.out.println("Veiculo removido");
        }
        
    }

    /** 
     * Exibe a Lista completa de Veículos 
     */
    public static void exibirListaVeiculoADM(){
        for (Veiculo v : listaVeiculos) {
            System.out.println(v.toString());
            System.out.println(" ");
        }
    }

    /** 
     * Percorre a Lista de Veículos e exibe detalhes de um veículo especifico a partir do ID 
     */
    public static void exibirDetalheVeiculoADM(){
        int contador=0;
        System.out.println("Digite o Id do veiculo desejado: ");
        e = new Scanner(System.in);
        id = e.nextLine();

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

    /** 
     * Exibe a Lista de Veículos Disponíveis para fazer reserva 
     */ 
    public static void exibirListaVeiculoCliente(){
        for(Veiculo v: listaVeiculos) {
            if(v.getDisponivel()==true) {
                System.out.println(v);
                System.out.println("");
            }
        }
    }
        
    /** 
     * Verifica quais veiculos tem o atributo 'disponivel' como verdadeiro,
     * antes de exibir todos os atributos
     */
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


///////////////////// TRATAMENTO RESERVA ////////////////////

/**
 * Método que atribui à lista de reservas, os dados da lista gerada pelo Tratamento de Arquivo 
 */
public static  void atribuirlistaReserva(){
    for (Reserva res : TratamentoArquivos.lerArqReservas("reserva.txt")) {
        listaReserva.add(res);
    }
}

/** 
 * Método que exibe a lista de reserva
 */
public static void exibirListaReserva(){
    for(Reserva r: listaReserva) {
        System.out.println("Nome: " + r.getNomeCliente());
        System.out.println("Tempo de reserva: " + r.getTempoReserva() + " dias");

    }
}

/**
 *  Exibe os detalhes de uma reserva específica, percorrendo a lista de reserva de acordo com o Cpf
 */
    public static void exibirDetalheReserva(){
        System.out.println("Entre com o cpf do cliente, na qual deseja ver a reserva: ");
        e = new Scanner(System.in);
        String cpf = e.nextLine();
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

    ///////////////// metodo que verifica a disponibilidade 

    public static void fazerReserva(){
        System.out.println(" ");
        if(listaVeiculos.size() != 0){
        v = lerVeiculo();
        while (v==null){
            System.out.println("Veiculo nao encontrado");
            v = lerVeiculo();
        }
        int t = lerTempoReserva();

        while (!verificarTempoValido(t)){
            System.out.println("Tempo de Reserva invalido, insira outro tempo: ");
            t = lerTempoReserva();
        }

        String d = lerDataInicio();

        while (!compararData(d)){
            System.out.println("Data invalida, insira outra data: ");
            d = lerDataInicio();
        }

        v.setDisponivel(false); 

        Reserva r = new Reserva(v,lerNomeCliente(),lerCpf(),d,t);
        listaReserva.add(r);
        System.out.println("Reserva efetuada " + "\nValor: " + v.calcularAluguel());
        
        }else {
            System.out.println("Nao ha veiculos cadastrados para realizar a reserva");
        }
        
     }

     public static String lerNomeCliente(){
        System.out.println("Digite seu nome:");
        e = new Scanner(System.in);
        return e.nextLine();
    }

    public static String lerCpf(){
        System.out.println("Digite o CPF: ");
        e = new Scanner(System.in);
        return e.nextLine();
    }

    public static Veiculo lerVeiculo(){
        System.out.println("Digite o Id do Veiculo desejado: ");
        String i;
        e = new Scanner(System.in);
        i = e.nextLine();
        return buscarIdVeiculo(i); 
    }

    public static int lerTempoReserva(){
        System.out.println("Digite o Tempo que deseja reservar: ");
        e = new Scanner(System.in);
        return e.nextInt();
    }

    public static String lerDataInicio(){
        System.out.println("Digite a Data para Inicio da Reserva: exemplo(DD/MM)");
        e = new Scanner(System.in);
        return e.nextLine();
    } 

    public static boolean verificarTempoValido(int tempo){
        if (tempo > 7){
            return false;
        }
            return true;
    }

     public static void cancelarReserva(){ 
         System.out.println("Entre com o numero do CPF utilizado na reserva:");
         e = new Scanner(System.in);
         String cpf = e.nextLine();
         int cont = 0;
         
        for(Reserva rv: listaReserva){
            if(rv.getCpfCliente().equals(cpf)){ 
                rv.getVeiculo().setDisponivel(true);
                listaReserva.remove(rv);
                System.out.println("Reserva Removida com sucesso");
                cont = 1;
                break;
            }
        }
            
         if(cont == 0){
            System.out.println("CPF não encontrado");
        }
    }


    public static void relatorioFinanceiro(){
        System.out.println("Digite o mes desejado: ex ('1' para o mes de janeiro)");
        e = new Scanner(System.in);
        int mes = e.nextInt();
        double total = 0;

        for (Reserva val : listaReserva) {
            String data = val.getDataInicio();
            String[] dat = data.split("/");
            int datames = Integer.parseInt(dat[1]);

            if (mes == datames){
                total = total + val.getVeiculo().calcularAluguel();
            }


        } 

        System.out.println("############ RELATORIO FINANCEIRO ############");
        System.out.println("No mes " + mes + " o faturamento foi de: " + total);
    }
}