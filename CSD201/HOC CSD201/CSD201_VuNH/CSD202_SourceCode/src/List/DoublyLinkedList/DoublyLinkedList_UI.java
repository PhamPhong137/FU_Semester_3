/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.DoublyLinkedList;

/**
 *
 * @author Hp
 */
public class DoublyLinkedList_UI {
    public static void main(String[] args) {
        DoublyLinkedList list= new DoublyLinkedList();
        list.addHead(new Node(1));
        list.addHead(new Node(3));
        list.addHead(new Node(2));
        list.addTail(new Node(5));
        list.addTail(new Node(6));
        list.display();
    }
}
