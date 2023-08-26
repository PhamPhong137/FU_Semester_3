/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_1_se1703_fall22;

/**
 *
 * @author Admin MSI
 */
public class main {
    public static void main(String[] args) {
//        f1();
        f2();
//        f3();
    }
    
    public static void f1(){
        MyTree my = new MyTree();//dung du lieu dung khi xoa
        //(A,5) (C,2) (E,4) (G.3) (D,6) (F,7) use breath 
        // (C,2) (G.3) (E,4) (A,5) (D,6) (F,7) use inorder
        my.insert("A", 5);
        my.insert("C", 2);
        my.insert("E", 4);
        my.insert("G", 3);
        my.insert("D", 6);
        my.insert("F", 7);
        
        System.out.println("Breadth begining:");
        my.preOrder();
        System.out.println();
        System.out.println("Inorder:");
        my.InOrder();
        System.out.println();
    }
    
    public static void f2(){
        MyTree my = new MyTree();//dung du lieu dung khi xoa
        //(C,6) (D,2) (F,4) (H.3) (I,5) (E,8) (G,7)
        my.insert("C", 6);
        my.insert("D", 2);
        my.insert("F", 4);
        my.insert("H", 3);
        my.insert("I", 5);
        my.insert("E", 8);
        my.insert("G", 7);
        
        System.out.println("Breadth begining:");
        my.preOrder();
        System.out.println();
        System.out.println("PreOrder:");
        my.preOrder2();
        System.out.println();
        
    }
    
    static void f3(){
        MyTree my = new MyTree();
        //          (C,8) (D,6) (E,9) (F.2) (G.7) (H,1) (I,3) (J,5) (K,4)
        //output:   (C,8) (J,5) (E,9) (F.2) (G.7)  (H,1) (I,3) (K,4)
        my.insert("C", 8);
        my.insert("D", 6);
        my.insert("E", 9);
        my.insert("F", 2);
        my.insert("G", 7);
        my.insert("H", 1);
        my.insert("I", 3);
        my.insert("J", 5);
        my.insert("K", 4);
        
        System.out.println("Breadth Frist: ");
        my.BreadthFirstOrder();
    }
}
