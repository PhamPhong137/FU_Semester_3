/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assign2_1;

/**
 *
 * @author Admin
 */
public class Main {

    static void f1() {
        MyTree list = new MyTree();
        list.insert("A", 7, 9);
        list.insert("C", 4, 3);
        list.insert("D", 8, 6);
        list.insert("E", 2, 5);
        list.insert("Y", 6, -7);
        list.insert("F", -6, 7);
        list.BreadthFirstOrder();
        System.out.println("");
        list.InOrder();
        System.out.println("");
    }

    static void f2() {
        MyTree list = new MyTree();
        list.insert("C", 8, 2);
        list.insert("D", 6, 1);
        list.insert("E", 9, 4);
        list.insert("F", 2, 3);
        list.insert("G", 7, 8);
        list.insert("H", 1, 7);
        list.insert("I", 3, 9);
        list.insert("J", 5, 5);
        list.insert("K", 4, 6);
        list.BreadthFirstOrder();
        System.out.println("");
        list.breadth2();
        System.out.println("");
    }

    static void f3() {
        MyTree list = new MyTree();
        list.insert("C", 8, 2);
        list.insert("D", 6, 1);
        list.insert("E", 9, 4);
        list.insert("F", 2, 3);
        list.insert("G", 7, 8);
        list.insert("H", 1, 7);
        list.insert("I", 3, 9);
        list.insert("J", 5, 5);
        list.insert("K", 4, 6);
        list.postOrder();
        System.out.println("");
        list.postOrderIndex();
        Node p = list.node;
        list.deleteByCopyL(list.getParent(p));
        list.postOrder();
        System.out.println("");
    }

    static void f4() {
        MyTree list = new MyTree();
        list.insert("C", 8, 2);
        list.insert("D", 6, 1);
        list.insert("E", 9, 4);
        list.insert("F", 2, 3);
        list.insert("G", 7, 8);
        list.insert("H", 1, 7);
        list.insert("I", 3, 9);
        list.insert("J", 5, 5);
        list.insert("K", 4, 6);
        list.postOrder();
        System.out.println("");
        list.postOrderIndex();
        Node node_4 = list.node;
        int height = list.heightTree(node_4);
        node_4.value.setWing(height);
        list.postOrder();
        System.out.println("");
    }

    public static void main(String[] args) {
        //f1();
        //f2();
        // f3();
        f4();
    }
}
