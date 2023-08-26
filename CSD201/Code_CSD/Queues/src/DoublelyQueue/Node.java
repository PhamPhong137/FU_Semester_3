/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublelyQueue;

/**
 *
 * @author PC-Phong
 */
public class Node {

    Object info;
    Node next, prev;

    public Node() {
    }

    public Node(Object info, Node next, Node prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public Node(Object info) {
        this.info = info;
    }

}
