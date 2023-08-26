/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

/**
 *
 * @author PC-Phong
 */
public class DoublyLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyList m = new MyList();
        m.addFirst(9);
        m.addFirst(5);
        m.addFirst(6);
        m.addLast(10);
        m.addFirst(-5);
        m.addIndex(100, 3);
        m.display();
    }

}
