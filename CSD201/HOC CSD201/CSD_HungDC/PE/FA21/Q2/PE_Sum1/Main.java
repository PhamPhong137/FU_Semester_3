/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PE_Sum1;

/**
 *
 * @author ADMIN
 */
public class Main {

    static void f1() {
        BSTree ls = new BSTree();
        ls.insert("A", 7, 9);
        ls.insert("C", 4, 3);
        ls.insert("D", 8, 6);
        ls.insert("E", 2, 5);
        ls.insert("F", 6, 7);
        ls.BreadthFirstOrder();
        System.out.println("");
        ls.InOrder();
    }

    static void f2() {
        BSTree ls = new BSTree();
        ls.insert("C", 3, 6);
        ls.insert("D", 7, 2);
        ls.insert("F", 4, 5);
        ls.insert("G", 8, 7);
        ls.insert("E", 2, 8);
        ls.insert("H", 6, 3);
        ls.insert("I", 5, 4);
        ls.postOrder();
        System.out.println("");
        ls.postOrder2();
    }

    static void f3() {
        BSTree ls = new BSTree();
        ls.insert("C", 5, 2);
        ls.insert("D", 2, 1);
        ls.insert("E", 6, 5);
        ls.insert("F", 1, 3);
        ls.insert("G", 4, 6);
        ls.insert("H", 3, 4);
        ls.BreadthFirstOrder();
        System.out.println("");
        ls.deleteDepMax();
        ls.BreadthFirstOrder();
    }

    static void f4() {
        BSTree ls = new BSTree();
        ls.insert("C", 5, 2);
        ls.insert("D", 2, 1);
        ls.insert("E", 6, 5);
        ls.insert("F", 1, 3);
        ls.insert("G", 4, 6);
        ls.insert("H", 3, 4);
        ls.BreadthFirstOrder();
        System.out.println("");
        ls.rotateNodeTh2();
        ls.BreadthFirstOrder();
    }

    public static void main(String[] args) {
        //f1();
        //f2();
        //f3();
        f4();
    }
}
