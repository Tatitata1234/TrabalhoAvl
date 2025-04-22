package org.example;

import java.util.Scanner;

public interface Menu {


    static String titulo(){
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

    static void arvoreString(Arvore a){
        StringBuilder arvere = new StringBuilder();
        No no = a.getRaiz();
        int h =0;
        arvere.append("   ");
        arvere.append(no.getChave()).append("\n");

        arvoreString(no.getEsquerda(), h+1, arvere);
        arvoreString(no.getDireita(), h+1, arvere);

        System.out.println(arvere.toString());
    }

    static StringBuilder arvoreString(No no, int h, StringBuilder arvere){
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

    static void run(){
        Scanner scan = new Scanner(System.in);
        int option = 0;
        Arvore arvore = new Arvore();
        System.out.println(titulo());;
        do {
            if (arvore.isEmpty()){
                System.out.println("\nSem árvore ainda\n");
            }else {
                arvoreString(arvore);
            }

            System.out.println(op());;
            option = scan.nextInt();

            switch (option){
                case 1:
                    if (arvore.getRaiz()!= null){
                        System.out.println("Arvore ja criada...");
                    }else {
                        System.out.println("Criando árvore...");
                        System.out.println("Digite o número que deseja inserir");
                        arvore.insereRecursivo(scan.nextInt());
                    }
                    break;
                case 2:
                    if (arvore.getRaiz()!=null){
                        System.out.println("Digite o número que deseja inserir");
                        arvore.inserirEBalancearAVL(scan.nextInt());
                    }else {
                        System.out.println("Árvore ainda não criada");
                    }
                    break;
                case 3:
                    if (arvore.getRaiz()!=null){
                        System.out.println("Digite o número que deseja excluir");
                        arvore.deletarPorFusao(scan.nextInt());
                    }else {
                        System.out.println("Árvore ainda não criada");
                    }
                    break;
                case 4:
                    if (arvore.getRaiz()!=null){
                        System.out.println("Digite o número que deseja procurar");
                        System.out.println(arvore.procura(scan.nextInt()).toString());;
                    }else {
                        System.out.println("Árvore ainda não criada");
                    }
                    break;
            }
        }while (option!=5);
        scan.close();
    }

    static String op (){
        return """
        1 - Criar uma Árvore
        2 - Inserir um valor
        3 - Excluir um valor
        4 - Buscar um valor
        5 - Sair
        """;
    }

}
