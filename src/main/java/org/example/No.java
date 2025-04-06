package org.example;

public class No {

    private Integer chave;

    private No esquerda;

    private No direita;

    private int altura;

    private int ponto;

    private No pai;

    public No() {
        this.esquerda = null;
        this.direita = null;
    }

    public No(Integer chave) {
        this(chave, null, null);
    }

    public No(Integer chave, No esquerda, No direita) {
        this.chave = chave;
        this.esquerda = esquerda;
        this.direita = direita;
        this.altura = 0;
        this.ponto = 0;
    }

    public void incrementaAltura() {
        this.altura++;
    }

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getAltura() {
        if (this.direita == null && this.esquerda == null) {
            return 1;
        }
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPonto() {
        return ponto;
    }

    public void setPonto(int ponto) {
        this.ponto = ponto;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }


}
