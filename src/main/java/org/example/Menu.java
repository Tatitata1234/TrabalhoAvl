package org.example;

import java.util.Queue;

public interface Menu {

    static String op (){
        return """
        1 - Criar uma Árvore
        2 - Inserir um valor
        3 - Excluir um valor
        4 - Buscar um valor
        5 - Sair
        """;
    }

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

    static String arvoreString(Arvore a){
        StringBuilder arvore = new StringBuilder();
        Queue <No> nos;
        for (int h = a.getRaiz().getAltura(); h>-1; h--) {
            nos = a.procuraAl(h);
            for (int i = 0; i < nos.size(); i++) {
                arvore.append(nos.poll().getChave());
            }
        }

        return arvore.toString();
    }
}
