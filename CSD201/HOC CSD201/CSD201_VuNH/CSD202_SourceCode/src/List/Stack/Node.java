/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.Stack;

/**
 *
 * @author Hp
 */
public class Node {

    int info;
    Node next;

    Node() {

    }

    Node(int info) {
        this.info = info;
        this.next = null;
    }

    Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }
}
