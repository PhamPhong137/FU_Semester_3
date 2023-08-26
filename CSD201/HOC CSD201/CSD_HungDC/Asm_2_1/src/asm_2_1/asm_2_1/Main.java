/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_2_1;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        MyTree my = new MyTree();
        
//        //f1:
//        my.insert("A", 5);
//        my.insert("C", 2);
//        my.insert("E", 4);
//        my.insert("G", 3);
//        my.insert("D", 6);
//        my.insert("F", 7);
//        my.preOrder();
//        System.out.println();
//        my.InOrder();
        
//        //f2:
//        my.insert("C", 6);
//        my.insert("D", 2);
//        my.insert("F", 4);
//        my.insert("H", 3);
//        my.insert("I", 5);
//        my.insert("E", 8);
//        my.insert("G", 7);
//        my.preOrder();
//        System.out.println();
//        my.preOrder2();
        
//        //f3:
//        my.insert("C", 8);
//        my.insert("D", 6);
//        my.insert("E", 9);
//        my.insert("F", 2);
//        my.insert("G", 7);
//        my.insert("H", 1);
//        my.insert("I", 3);
//        my.insert("J", 5);
//        my.insert("K", 4);
//        my.BreadthFirstOrder();
//        System.out.println();
//        my.deleteByCopyL(my.findNode(7));
//        my.BreadthFirstOrder();

        //f4:
        my.insert("C", 8);
        my.insert("D", 6);
        my.insert("E", 9);
        my.insert("F", 2);
        my.insert("G", 7);
        my.insert("H", 1);
        my.insert("I", 3);
        my.insert("J", 5);
        my.insert("K", 4);
        my.BreadthFirstOrder();
        System.out.println();
        my.f4(7);
        my.BreadthFirstOrder();
    }

}
