package org.example;

import org.junit.jupiter.api.Test;

import java.util.Queue;

public class TrabalhoTest {


    @Test
    void trabalho() {
        //Arvore<Integer> arvore2 = new Arvore<>();
        //arvore2.insereRecursivoAVL(2);

        //     g
        //    / \
        //   d   m
        //  /   / \
        // a    l  o
        //  \       \
        //   c       p
        //  /         \
        // b           q
        Arvore arvore = new Arvore();
        arvore.insereRecursivo(5);
        arvore.insereRecursivo(4);
        arvore.insereRecursivo(1);
        arvore.insereRecursivo(3);
        arvore.insereRecursivo(7);
        arvore.insereRecursivo(8);
        //arvore.insereRecursivo(2);
        arvore.insereRecursivo(4);
        arvore.insereRecursivo(1);
        arvore.insereRecursivo(6);
        arvore.insereRecursivo(9);
        //arvore.insereRecursivo(10);

        System.out.println(arvore.getRaiz().getAltura());
    }

    @Test
    void trabalho2() {
        //Arvore<Integer> arvore2 = new Arvore<>();
        //arvore2.insereRecursivoAVL(2);

        //     5
        //    / \
        //   4   7
        //  /   / \
        // 1   6   8
        //  \       \
        //   3       9
        //  /         \
        // 2           10
        Arvore arvore = new Arvore();
        arvore.inserirEBalancearAVL(5);
        arvore.inserirEBalancearAVL(4);
        arvore.inserirEBalancearAVL(1);
        arvore.inserirEBalancearAVL(3);
        arvore.inserirEBalancearAVL(7);
        arvore.inserirEBalancearAVL(8);
        arvore.inserirEBalancearAVL(2);
        arvore.inserirEBalancearAVL(4);
        arvore.inserirEBalancearAVL(1);
        arvore.inserirEBalancearAVL(6);
        arvore.inserirEBalancearAVL(9);
        arvore.inserirEBalancearAVL(10);

        Queue<No> q= arvore.procuraAl(0);

        for (No n : q) {
            System.out.println("valor: " + n.getChave());
            System.out.println("altura: " + n.getAltura());
        }

//        System.out.println(new Menu().getTitulo());
//        System.out.println(new Menu().getDescricao());
    }


    @Test
    void inserirEExcluir() {

        //     5
        //    / \
        //   4   7
        //  /   / \
        // 1   6   8
        Arvore arvore = new Arvore();
        arvore.inserirEBalancearAVL(32);
        arvore.inserirEBalancearAVL(16);
        arvore.inserirEBalancearAVL(48);
        arvore.inserirEBalancearAVL(8);
        arvore.inserirEBalancearAVL(40);
        arvore.inserirEBalancearAVL(24);
        arvore.inserirEBalancearAVL(56);
        arvore.inserirEBalancearAVL(28);
        arvore.inserirEBalancearAVL(36);
        arvore.inserirEBalancearAVL(44);
        arvore.inserirEBalancearAVL(52);
        arvore.inserirEBalancearAVL(60);
        arvore.inserirEBalancearAVL(58);
        arvore.inserirEBalancearAVL(62);

        arvore.excluir(8);

//        System.out.println(new Menu().getTitulo());
    }

}
