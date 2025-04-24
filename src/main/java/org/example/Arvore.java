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

    public No inserirAVL(Integer el) {
        No no = raiz;
        No anterior = null;

        if (procura(el) != null)
            return null;

        No novoNo = new No(el);
        if (raiz == null) {
            raiz = novoNo;
            raiz.setAltura(1);
            return novoNo;
        }

        while (no != null) {
            anterior = no;

            if (el.compareTo(no.getChave()) < 0) {
                no = no.getEsquerda();
            } else {
                no = no.getDireita();
            }
        }

        assert anterior != null;

        novoNo.setPai(anterior);
        if (anterior.getChave().compareTo(el) < 0) {
            anterior.setDireita(novoNo);
        } else {
            anterior.setEsquerda(novoNo);
        }

        corrigeAltura(novoNo);
        return novoNo;
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
        } else if (el.getChave().compareTo(chave) > 0){
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
                atual.getEsquerda().setAltura(Math.max(alturaFilhoEsquerda, 0));
            }

            if (atual.getDireita() != null) {
                fila.add(atual.getDireita());
                alturaFilhoDireita = altura;
                atual.getDireita().setAltura(Math.max(alturaFilhoDireita, 0));
            }
            atual.setPonto(alturaFilhoEsquerda - alturaFilhoDireita);
        }
    }

    public void inserirEBalancearAVL (Integer el) {
        No noInserido = inserirAVL(el);
        if (noInserido != null) {
            balancearAvl(noInserido);
        }
        corrigeAltura(noInserido);
    }

    private void balancearAvl(No folha) {
        if (folha == raiz) {
            return;
        }
        No pai = folha.getPai();
        while (pai != null) {
            int filhoEsqAltura = pai.getEsquerda() != null ? pai.getEsquerda().getAltura() : 0;
            int filhoDirAltura = pai.getDireita() != null ? pai.getDireita().getAltura() : 0;
            int diferenca = filhoEsqAltura - filhoDirAltura;
            pai.setPonto(diferenca);
            if (Math.abs(diferenca) >= 2) {
                if (diferenca > 0) {
                    if (pai.getEsquerda().getPonto() >= 0) {
                        rotaSimplesDireita(pai);
                    } else {
                        rotaSimplesEsquerda(pai.getEsquerda());
                        rotaSimplesDireita(pai);
                    }
                } else {
                    if (pai.getDireita().getPonto() <= 0) {
                        rotaSimplesEsquerda(pai);

                    } else {
                        rotaSimplesDireita(pai.getDireita());
                        rotaSimplesEsquerda(pai);
                    }
                }
                balancearAvl(folha);
                break;
            }

            pai = pai.getPai();
        }
    }

    private No maiorNoSubArvore(No raiz) {
        if (raiz.getDireita() == null)
            return raiz;

        // busca o elemento mais à diretia de uma subárvore
        No noBusca = raiz.getDireita();
        while (noBusca.getDireita() != null){
            noBusca = noBusca.getDireita();
        }
        return noBusca;
    }

    // exclui um nó por cópia
    private void excluirPorCopia(No no) {
        // todo : não excluiu o desejado e excluiu o maior
        No raizSubEsquerda = no.getEsquerda();
//        No raizSubDireita = no.getDireita();
        // buscar maior valor da subarvore à esquerda (neste ponto é garantido que há filhos na esquerda, nunca sendo nulo)
        No noMaiorEsquerda = maiorNoSubArvore(raizSubEsquerda);
        int chaveMaior = noMaiorEsquerda.getChave();

        no.setChave(chaveMaior);

        // exclui maior nó filho
        excluirQuandoUmFilhoOuMenos(noMaiorEsquerda);

        // balancear com método adequado
        balancearAvl(noMaiorEsquerda); // noMaiorEsquerda é o nó afetado mais distante da raiz
    }

    // exclui um nodo passado de parâmetro, que tenha n<=1 filhos
    private void excluirQuandoUmFilhoOuMenos(No no) {
        No pai = no.getPai();
        // busca o filho do nó, tanto esquerdo quanto direito, null caso não tenha
        No filho = no.getDireita() != null ? no.getDireita() : no.getEsquerda();

        if (pai == null) { // nó excluído é a raiz
            this.raiz = filho;
        } else {
            // verificar lado que o nó deve ficar
            if (no.getChave() > pai.getChave()) {
                pai.setDireita(filho);
            } else {
                pai.setEsquerda(filho);
            }
        }

        // balancear com método adequado
        if (filho != null)
            balancearAvl(filho); // filho é o nó afetado mais distante da raiz
        else
            balancearAvl(no);
    }

    // exclui o nó com o número informado
    public void excluir(Integer el) {
        // encontrar nó a ser excluído
        No desejado = procura(el); // nó que se deseja excluir
        if (desejado == null)
            return;
//        No pai = desejado.getPai();
        // caso tenha dois filhos
        if (desejado.getDireita() != null && desejado.getEsquerda() != null) {
            // exclusão por cópia
            excluirPorCopia(desejado);
        // caso contrário (um ou menos)
        } else {
            // exclusão simples
            excluirQuandoUmFilhoOuMenos(desejado);
        }

        System.out.println("baboseira");

        // Importante: balanceamento é feito nos métodos de exclusão especiais, por ter informações melhores
//        return true;
    }

    private void rotaSimplesEsquerda(No pai) {
        No filhoDir = pai.getDireita();
        No filhoEsqFilhoDir = filhoDir.getEsquerda();
        No vo = pai.getPai();

        filhoDir.setPai(pai.getPai());
        filhoDir.setEsquerda(pai);
        pai.setPai(filhoDir);
        pai.setDireita(filhoEsqFilhoDir);

        if (pai == raiz) {
            raiz = filhoDir;
        } else {
            if (vo.getDireita() == pai) {
                vo.setDireita(filhoDir);
            } else {
                vo.setEsquerda(filhoDir);
            }
        }
    }

    private void rotaSimplesDireita(No pai) {
        No filhoEsq = pai.getEsquerda();
        No filhoDirFilhoEsq = filhoEsq.getDireita();
        No vo = pai.getPai();

        filhoEsq.setPai(pai.getPai());
        filhoEsq.setDireita(pai);
        pai.setPai(filhoEsq);
        pai.setEsquerda(filhoDirFilhoEsq);

        if (pai == raiz) {
            raiz = filhoEsq;
        } else {
            if (vo.getDireita() == pai) {
                vo.setDireita(filhoEsq);
            } else {
                vo.setEsquerda(filhoEsq);
            }
        }
    }

    public int calculaAltura(No raizAtual){
        if(raizAtual == null){
            return -1;
        }
        else{
            int esq = calculaAltura(raizAtual.getEsquerda());
            int dir = calculaAltura(raizAtual.getDireita());
            if(esq > dir)
                return esq + 1;
            else
                return dir + 1;
        }
    }

    private void corrigeAltura(No novoNo) {
        No proximo = novoNo;
        while (!Objects.equals(proximo, null)) {
            int altura = calculaAltura(proximo);
            altura++;
            proximo.setAltura(altura);
            proximo.setPonto(0);
            proximo = proximo.getPai();
        }
    }
}
