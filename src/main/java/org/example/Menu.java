package org.example;

import java.util.Scanner;

public class Menu {
    private Menu(){}

    public static void main(String[] args) {
        Menu.run();
    }


    public static String titulo(){
        return ("""
                  
                --r-----------------------------------------------------------------------------------------------------
                  
                  /$$$$$$                                                           /$$$$$$  /$$    /$$ /$$     \s
                 /$$__  $$                                                         /$$__  $$| $$   | $$| $$     \s
                | $$  \\ $$  /$$$$$$  /$$    /$$ /$$$$$$   /$$$$$$   /$$$$$$       | $$  \\ $$| $$   | $$| $$     \s
                | $$$$$$$$ /$$__  $$|  $$  /$$//$$__  $$ /$$__  $$ /$$__  $$      | $$$$$$$$|  $$ / $$/| $$     \s
                | $$__  $$| $$  \\__/ \\  $$/$$/| $$  \\ $$| $$  \\__/| $$$$$$$$      | $$__  $$ \\  $$ $$/ | $$     \s
                | $$  | $$| $$        \\  $$$/ | $$  | $$| $$      | $$_____/      | $$  | $$  \\  $$$/  | $$     \s
                | $$  | $$| $$         \\  $/  |  $$$$$$/| $$      |  $$$$$$$      | $$  | $$   \\  $/   | $$$$$$$$
                |__/  |__/|__/          \\_/    \\______/ |__/       \\_______/      |__/  |__/    \\_/    |________/
                                                                                                                \s
                                                                                                                \s
                                                                                                                \s
                
                Integrantes: Thais Landfeldt, Victório Faraco, João Trajano
                -------------------------------------------------------------------------------------------------------
                """);
    }

    public static void arvoreString(Arvore a){
        StringBuilder arvere = new StringBuilder();
        No no = a.getRaiz();
        int h =0;
        arvere.append("   ");
        arvere.append(no.getChave()).append("\n");

        arvoreString(no.getEsquerda(), h+1, arvere);
        arvoreString(no.getDireita(), h+1, arvere);

        System.out.println(arvere.toString());
    }

    public static StringBuilder arvoreString(No no, int h, StringBuilder arvere){
        if (no == null){
            return arvere;
        }
        for (int i = 0; i < h ; i++) {
            arvere.append("   ");
        }

        arvere.append("|->").append(no.getChave()).append("\n");

        arvoreString(no.getEsquerda(), h+1, arvere);
        arvoreString(no.getDireita(), h+1, arvere);

        return arvere;
    }

    static String op (){
        return """
        
        
        Digite a Opção:
        1 - Criar uma Árvore
        2 - Inserir um valor
        3 - Excluir um valor
        4 - Buscar um valor
        5 - Caminhando pela árvore
        6 - Limpa a árvore
        7 - Sair
        
        
        """;
    }

    private static Arvore criaArvore(Arvore arvore) {
        Scanner scan = new Scanner(System.in);
        int escolha = 0;

        if (!arvore.isEmpty()){
            System.out.println("Arvore ja criada...");
            System.out.println("Deseja Criar outra árvore ?\n1 - Sim\nQualquer outro número - Não");
            escolha = scan.nextInt();
            if (escolha == 1){
                arvore.clear();
                System.out.println("Criando árvore, digite o valor a ser inserido:\n");
                arvore.inserirEBalancearAVL(scan.nextInt());
            }
        }else {
            System.out.println("Criando árvore...");
            System.out.println("Digite o número que deseja inserir");
            arvore.inserirEBalancearAVL(scan.nextInt());
        }
        return arvore;
    }

    private static Arvore insere(Arvore arvore) {
        Scanner scan = new Scanner(System.in);
        int escolha = 0;
        if (!arvore.isEmpty()){
            System.out.println("Digite o número que deseja inserir");
            escolha = scan.nextInt();
            while (arvore.procura(escolha)!=null){
                System.out.println("Esse nó ja está na árvore, digite outro número:\n");
                escolha = scan.nextInt();
            }

            arvore.inserirEBalancearAVL(escolha);
        }else {
            System.out.println("Árvore ainda não criada...");
        }
        return arvore;
    }

    private static void procura(Arvore arvore) {

        Scanner scan = new Scanner(System.in);
        int escolha = 0;

        if (!arvore.isEmpty()){
            System.out.println("Digite o número que deseja procurar");
            escolha = scan.nextInt();

            while (arvore.procura(escolha)==null){

                System.out.println("Esse valor não existe na árvore, digite outro número:\n");
                escolha = scan.nextInt();

            }
            System.out.println(arvore.procura(escolha).toString());;

        }else {

            System.out.println("Árvore ainda não criada");

        }
    }

    private static Arvore exclui(Arvore arvore) {
        int escolha = 0;
        Scanner scan = new Scanner(System.in);
        if (!arvore.isEmpty()){
            System.out.println("Digite o número que deseja excluir");
            escolha = scan.nextInt();
            while (arvore.procura(escolha)==null){
                System.out.println("Esse nó não existe na árvore, digite outro número:\n");
                escolha = scan.nextInt();
            }
            arvore.excluir(escolha);
        }else {
            System.out.println("Árvore ainda não criada");
        }
        return arvore;
    }

    private static void caminha(Arvore arvore) {
        Scanner scan = new Scanner(System.in);
        int escolha = 0;
        if (!arvore.isEmpty()){
            System.out.println("""
                    Como deseja visualizar o caminho da arvore?
                    1 - Pré-Ordem
                    2 - Em  Ordem
                    3 - Pós-Ordem
                    Digite qual sua escolha:
                    """);
            escolha = scan.nextInt();
            while (escolha<1 || escolha>3){
                System.out.println("Digite um valor válido:");
                escolha = scan.nextInt();
            }
            switch (escolha){
                case 1:
                    arvore.preorder();
                    System.out.println(arvore.getBuilderPreOrder().toString());;
                    arvore.cleanBuilderPreOrder();
                    break;
                case 2:
                    arvore.inorder();
                    System.out.println(arvore.getBuilderInOrder().toString());;
                    arvore.cleanBuilderInOrder();
                    break;
                case 3:
                    arvore.postorder();
                    System.out.println(arvore.getBuilderPostOrder().toString());;
                    arvore.cleanBuilderPostOrder();
                    break;
                default:
                    System.out.println("erro ao caminhar");
            }
        }else
            System.out.println("A árvore está vazia...");
    }

    public static void run(){
        Scanner scan = new Scanner(System.in);
        int option = 0;
        Arvore arvore = new Arvore();
        System.out.println(titulo());;

        do {

            if (!arvore.isEmpty()){
                arvoreString(arvore);
            }

            System.out.println(op());;
            option = scan.nextInt();

            switch (option){
                case 1:
                    arvore = criaArvore(arvore);
                    break;
                case 2:
                    arvore = insere(arvore);
                    break;
                case 3:
                    arvore = exclui(arvore);
                    break;
                case 4:
                    procura(arvore);
                    break;
                case 5:
                    caminha(arvore);
                    break;
                case 6:
                    arvore.clear();
                    System.out.println("Árvore Limpa...");
                    break;
                case 7:
                    System.out.println("Saindo...\n\n\n");
                    break;
                default:
                    System.out.println("Opção inválida...");
                    break;
            }

        }while (option!=7);

        scan.close();
    }

}