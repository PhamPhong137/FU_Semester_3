/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author ADMIN
 */
public class Main {
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
        ls.changeMax();
        ls.display();
    }
    static void f4(){
        MyList ls = new MyList();
        ls.addLast("C", 7, 9);
        ls.addLast("D", 6, 7);
        ls.addLast("E", 5, 6);
        ls.addLast("F", 4, 11);
        ls.addLast("I", 10, 5);
        ls.addLast("J", 3, 4);
        ls.addLast("K", 2, 3);
        ls.display();
        ls.addElement();
        ls.deleteElement();
        ls.sort();
        for (int i = 0; i < ls.arr1.size(); i++) {
            ls.addIndex(ls.arr1.get(i).place, ls.arr1.get(i).depth, ls.arr1.get(i).type, ls.arr.get(i));
        }
        ls.display();
    }
    public static void main(String[] args) {
        f3();
//        f4();
    }
}
