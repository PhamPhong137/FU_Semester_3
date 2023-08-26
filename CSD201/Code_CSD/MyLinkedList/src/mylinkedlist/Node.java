/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinkedlist;

/**
 *
 * @author PC-Phong
 */
public class Node {

    String info;
    Node next;

    public Node() {
    }

    public Node(String info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(String info) {
        this.info = info;
    }

}
