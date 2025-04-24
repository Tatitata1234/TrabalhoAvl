package org.example;

import java.util.Scanner;

public class Menu {
    private Menu(){}

    public static void main(String[] args) {
        Menu.run();
    }


    public static String titulo(){
        return ("""
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

    public static void run(){
        Scanner scan = new Scanner(System.in);
        int option = 0;
        int escolha = 0;
        Arvore arvore = new Arvore();
        System.out.println(titulo());;
        do {
            switch (option){
                case 1:
                    if (!arvore.isEmpty()){
                        System.out.println("Arvore ja criada...");
                        System.out.println("Deseja Criar outra árvore ?\n1 - Sim\nQualquer outro número - Não");
                        escolha = scan.nextInt();
                        if (escolha == 1){
                            arvore.clear();
                            arvore.inserirEBalancearAVL(scan.nextInt());
                        }
                    }else {
                        System.out.println("Criando árvore...");
                        System.out.println("Digite o número que deseja inserir");
                        arvore.inserirEBalancearAVL(scan.nextInt());
                    }
                    break;
                case 2:
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
                    break;
                case 3:
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
                    break;
                case 4:
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
                    break;
                case 5:
                    arvore.clear();
                    System.out.println("Árvore Limpa...");
                    break;
                default:
                    System.out.println("Opção inválida...");
                    break;
            }

            if (!arvore.isEmpty()){
                arvoreString(arvore);
            }

            System.out.println(op());;
            option = scan.nextInt();

        }while (option!=6);
        scan.close();
    }

    static String op (){
        return """
        
        Digite a Opção:
        1 - Criar uma Árvore
        2 - Inserir um valor
        3 - Excluir um valor
        4 - Buscar um valor
        5 - Limpa a árvore
        6 - Sair
        
        
        """;
    }

}
