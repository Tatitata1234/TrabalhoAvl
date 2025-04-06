package org.example;

public class Menu {
    Arvore arvore = new Arvore();

    private StringBuilder titulo = new StringBuilder("""
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
    private StringBuilder content = new StringBuilder();
    private StringBuilder descricao = new StringBuilder("""
        1 - Criar uma Árvore
        2 - Inserir um valor
        3 - Excluir um valor
        4 - Buscar um valor
        5 - Sair
        """);

    public StringBuilder getTitulo() {
        return titulo;
    }
    public void setTitulo(StringBuilder titulo) {
        this.titulo = titulo;
    }
    public StringBuilder getDescricao() {
        return descricao;
    }
    public void setDescricao(StringBuilder descricao) {
        this.descricao = descricao;
    }
    public StringBuilder getContent() {
        return content;
    }
    public void setContent(StringBuilder content) {
        this.content = content;
    }
    public Arvore getArvore() {return arvore;}
    public void setArvore(Arvore arvore) {this.arvore = arvore;}

    public void geraArvoreGrafica(){

    }

    //    private int op=0;
//    while (op!=5){
//        switch(op){
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//        }
//
//
//    }
}
