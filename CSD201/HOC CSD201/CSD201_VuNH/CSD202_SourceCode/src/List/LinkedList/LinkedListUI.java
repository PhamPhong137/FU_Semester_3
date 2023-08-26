/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.LinkedList;

/**
 *
 * @author Hp
 */
public class LinkedListUI {

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addLast(8);
        myList.addLast(10);
        myList.addLast(7);
        myList.traverse();
//        System.out.println(myList.head.info + " " + myList.tail.info);
//        myList.sortAsc();
//        myList.sortInRange(myList.head, myList.tail);
//        myList.traverse();

        Node found = myList.findByIndex(-1);
        if (found != null) {
            System.out.println(myList.findByIndex(3).info);
        } else {
            System.out.println("null");
        }
    }
}
