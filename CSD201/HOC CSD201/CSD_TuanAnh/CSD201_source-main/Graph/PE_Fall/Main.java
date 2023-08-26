/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PE_Fall;

/**
 *
 * @author ADMIN
 */
public class Main {
    static void f1(){
         MyList ls = new MyList();
         ls.addLast("B", 5, 3);
         ls.addLast("C", 6, 5);
         ls.addLast("D", 2, 4);
         ls.addLast("E", 7, 9);
         ls.addLast("F", 4, 7);
         ls.display();
    }
    static void f2(){
        MyList ls = new MyList();
        ls.addLast("C", 9, 8);
        ls.addLast("D", 6, 3);
        ls.addLast("E", 8, 5);
        ls.addLast("F", 5, 4);
        ls.addLast("I", 4, 9);
        ls.display();
        Bee x = new Bee("Y", 3, 4);
        Bee y = new Bee("X", 1, 2);
        ls.addIndex(x, 1);
        ls.addIndex(y, 2);
        ls.display();
    }
    static void f3(){
        MyList ls = new MyList();
        ls.addLast("C", 8, 6);
        ls.addLast("D", 3, 5);
        ls.addLast("E", 9, 2);
        ls.addLast("F", 5, 8);
        ls.addLast("G", 9, 7);
        ls.addLast("H", 6, 8);
        ls.addLast("I", 7, 3);
        ls.display();
        ls.deleteSec_Thr();
        ls.display();
    }
    static void f4(){
        MyList ls = new MyList();
        ls.addLast("C", 7, 11);
        ls.addLast("D", 10, 7);
        ls.addLast("E", 6, 5);
        ls.addLast("F", 5, 6);
        ls.addLast("I", 4, 4);
        ls.addLast("J", 3, 2);
        ls.addLast("K", 2, 1);
        ls.display();
        ls.addElement();
        for (Bee o : ls.arr2) {
            System.out.print(o);
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        //f1();
        //f2();
        //f3();
        f4();
    }
}
