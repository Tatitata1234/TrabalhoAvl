package org.example;

import org.junit.jupiter.api.Test;

import java.util.Queue;

public class TrabalhoTest {


    @Test
    void trabalho() {
        //Arvore<Integer> arvore2 = new Arvore<>();
        //arvore2.insereRecursivoAVL(2);

        //     g
        //    / \w
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
        arvore.insereRecursivo(2);
        arvore.insereRecursivo(4);
        arvore.insereRecursivo(1);
        arvore.insereRecursivo(6);
        arvore.insereRecursivo(9);
        arvore.insereRecursivo(10);



        Queue <No> queue = arvore.procuraAl(0);

        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll().getChave());
        }
//        System.out.println(Menu.titulo());
//        System.out.println(Menu.arvoreString(arvore));
    }

}
