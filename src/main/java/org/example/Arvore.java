package org.example;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class Arvore {
    private No raiz = null;

    private StringBuilder builderInOrder = new StringBuilder();

    private StringBuilder builderPostOrder = new StringBuilder();

    private StringBuilder builderPreOrder = new StringBuilder();

    public No procura(Integer el) {
        return procura(this.raiz, el);
    }

    private No procura(No no, Integer el) {
        if (no == null) {
            return null;
        }

        if (Objects.equals(el, no.getChave())) {
            return no;
        } else if (el.compareTo(no.getChave()) < 0) {
            return procura(no.getEsquerda(), el);
        } else {
            return procura(no.getDireita(), el);
        }
    }



    //procura altura
    public Queue<No> procuraAl(Integer al) {
        Queue<No> q = new ArrayDeque<>();
        return procuraAl(this.raiz, al, q);
    }

    private Queue<No> procuraAl(No no, Integer al, Queue<No> q) {
        if (no == null) {
            return null;
        }
        if (Objects.equals(al, no.getAltura())) {
            q.add(no);
            return q;
        }else {
            procuraAl(no.getEsquerda(), al, q);
            procuraAl(no.getDireita(), al, q);
            return q;
        }

    }



    public boolean inserir(Integer el) {
        No no = raiz;
        No anterior = null;

        if (procura(el) != null)
            return false;

        while (no != null) {
            anterior = no;
            if (el.compareTo(no.getChave()) < 0) {
                no = no.getEsquerda();
            } else {
                no = no.getDireita();
            }
        }

        if (raiz == null) {
            raiz = new No(el);
        } else {
            assert anterior != null;
            if (anterior.getChave().compareTo(el) < 0) {
                anterior.setDireita(new No(el));
            } else {
                anterior.setEsquerda(new No(el));
            }
        }

        return true;
    }

    public void preorder() {
        preorder(raiz);
    }

    private void preorder(No no) {
        if (no != null) {
            builderPreOrder.append(no.getChave()).append(" ");
            preorder(no.getEsquerda());
            preorder(no.getDireita());
        }
    }

    public void inorder() {
        inorder(raiz);
    }

    private void inorder(No no) {

        if (no != null) {
            inorder(no.getEsquerda());
            builderInOrder.append(no.getChave()).append(" ");
            inorder(no.getDireita());
        }
    }

    public void postorder() {
        postorder(raiz);
    }

    private void postorder(No no) {
        if (no != null) {
            postorder(no.getEsquerda());
            postorder(no.getDireita());
            builderPostOrder.append(no.getChave()).append(" ");
        }
    }

    public void deletarPorFusao(Integer el) {
        No tmp;
        No no;
        No pai = null;

        no = procura(el);

        if (no != null && Objects.equals(no.getChave(), el)) {
            if (no != raiz)
                pai = procuraPai(el);

            if (no.getDireita() == null) {
                deletarQuandoNaoTemFilho(no == raiz, no.getEsquerda(), pai, no);
            } else if (no.getEsquerda() == null) {
                deletarQuandoNaoTemFilho(no == raiz, no.getDireita(), pai, no);
            } else {
                tmp = no.getEsquerda();
                while (tmp.getDireita() != null) {
                    tmp = tmp.getDireita();
                }
                tmp.setDireita(no.getDireita());

                deletarQuandoNaoTemFilho(raiz == no, no.getEsquerda(), pai, no);
            }
        } else if (raiz != null) {
            System.out.println("el " + el + " não está na árvore");
        } else {
            System.out.println("Árvora está vazia");
        }
    }

    private void deletarQuandoNaoTemFilho(boolean isRaiz, No filho, No pai, No no) {
        if (isRaiz) {
            raiz = filho;
        } else if (pai.getEsquerda() == no) {
            pai.setEsquerda(filho);
        } else {
            pai.setDireita(filho);
        }
    }

    public void deletarPorCopia(Integer el) {
        No no;
        No pai = null;

        no = procura(el);

        if (no != null && Objects.equals(no.getChave(), el)) {
            if (no != raiz)
                pai = procuraPai(el);

            if (no.getDireita() == null) {
                deletarQuandoNaoTemFilho(no == raiz, no.getEsquerda(), pai, no);
            } else if (no.getEsquerda() == null) {
                deletarQuandoNaoTemFilho(no == raiz, no.getDireita(), pai, no);
            } else {
                No tmp = no.getEsquerda();
                while (tmp.getDireita() != null) {
                    tmp = tmp.getDireita();
                }
                deletarPorCopia(tmp.getChave());
                no.setChave(tmp.getChave());
            }
        } else if (raiz != null) {
            System.out.println("el " + el + " não está na árvore");
        } else {
            System.out.println("Árvora está vazia");
        }
    }

    private No procuraPai(Integer el) {
        No no = raiz;
        No anterior = null;

        while (no != null && !Objects.equals(no.getChave(), el)) {
            anterior = no;
            if (no.getChave().compareTo(el) < 0)
                no = no.getDireita();
            else
                no = no.getEsquerda();
        }

        if (no != null && Objects.equals(no.getChave(), el)) {
            return anterior;
        }
        return null;
    }

    public void extensao() {
        Queue<No> fila = new ArrayDeque<>();

        fila.add(this.raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.getChave() + " ");
            if (atual.getEsquerda() != null)
                fila.add(atual.getEsquerda());
            if (atual.getDireita() != null)
                fila.add(atual.getDireita());
        }
    }

    public void clear() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public No getRaiz() {
        return this.raiz;
    }

    public String getBuilderInOrder() {
        return builderInOrder.toString().trim();
    }

    public void cleanBuilderInOrder() {
        this.builderInOrder = new StringBuilder();
    }

    public String getBuilderPostOrder() {
        return builderPostOrder.toString().trim();
    }

    public void cleanBuilderPostOrder() {
        this.builderPostOrder = new StringBuilder();
    }

    public String getBuilderPreOrder() {
        return builderPreOrder.toString().trim();
    }

    public void cleanBuilderPreOrder() {
        this.builderPreOrder = new StringBuilder();
    }

    public boolean inserirAVL(Integer el) {
        No no = raiz;
        No anterior = null;

        if (procura(el) != null)
            return false;

        while (no != null) {
            anterior = no;

            if (el.compareTo(no.getChave()) < 0) {
                no = no.getEsquerda();
            } else {
                no = no.getDireita();
            }
        }

        if (raiz == null) {
            raiz = new No(el);
        } else {
            assert anterior != null;
            if (anterior.getEsquerda() == null && anterior.getDireita() == null) {
                raiz.incrementaAltura();
            }
            if (anterior.getChave().compareTo(el) < 0) {
                anterior.setDireita(new No(el));
            } else {
                anterior.setEsquerda(new No(el));
            }
        }
        return true;
    }

    public void insereRecursivo(Integer chave) {
        if (raiz == null) {
            raiz = new No(chave);
        } else {
            raiz.setAltura(0);
            insereRecursivo(raiz, chave);
        }
        extensaoAltura();
    }

    public No insereRecursivo(No el, Integer chave) {

        if (el == null) {
            el = new No(chave);
            return el;
        }

        if (el.getChave().compareTo(chave) < 0) {
            el.setDireita(insereRecursivo(el.getDireita(), chave));
        } else {
            el.setEsquerda(insereRecursivo(el.getEsquerda(), chave));
        }

        raiz.incrementaAltura();

        return el;
    }

    public void extensaoAltura() {
        Queue<No> fila = new ArrayDeque<>();

        fila.add(this.raiz);

        int altura = raiz.getAltura();

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            altura--;

            int alturaFilhoEsquerda = 0;
            int alturaFilhoDireita = 0;

            if (atual.getEsquerda() != null) {
                fila.add(atual.getEsquerda());
                alturaFilhoEsquerda = altura;
                atual.getEsquerda().setAltura(alturaFilhoEsquerda);
            }

            if (atual.getDireita() != null) {
                fila.add(atual.getDireita());
                alturaFilhoDireita = altura;
                atual.getDireita().setAltura(alturaFilhoDireita);
            }
            atual.setPonto(alturaFilhoEsquerda - alturaFilhoDireita);
        }
    }

    public Queue<No> puxaFolhas() {
        Queue<No> folhas= new ArrayDeque<>();
        No atual = getRaiz();
        puxaFolhas(atual, folhas);
        return folhas;
    }
    public Queue<No> puxaFolhas(No p,Queue<No> folhas) {

        if (p!=null){
            puxaFolhas(p.getEsquerda(), folhas);
            puxaFolhas(p.getDireita(), folhas);
            if(p.getEsquerda() == null&&p.getDireita() == null){
                folhas.add(p);
                return folhas;
            }
            folhas.add(p);
            return folhas;
        }
        return folhas;
    }

    public void organiza(){
        organiza(this.getRaiz());
    }
    public void organiza(No no){

    }

}
