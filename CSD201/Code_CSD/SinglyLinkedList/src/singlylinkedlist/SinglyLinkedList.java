/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 *
 * @author PC-Phong
 */
public class SinglyLinkedList {

    public static void main(String[] args) {
        Mylist m = new Mylist();
        m.addFirst(7);
        m.addFirst(9);
        m.addFirst(5);
        m.addFirst(9);
        m.addFirst(-8);
        m.addFirst(10);
        // m.addIndex(100, 4);
        //  m.sortIndex();
        // m.delFirst();
        //  int a = m.delFirst();
        //  m.deleLast();
        // System.out.println("First: " + m.getFirst());
        //  System.out.println("Last: " + m.getLast());

        // System.out.println(m.searchIndex(10));
        // m.deleteIndex(2);
        m.display();
        System.out.println("");
        m.swapNode(0, 3);
        m.display();
//        System.out.println("Search:");
//        m.searchIndexOfValue(9);
        //    System.out.println("Deleted:" + a);

    }

}
