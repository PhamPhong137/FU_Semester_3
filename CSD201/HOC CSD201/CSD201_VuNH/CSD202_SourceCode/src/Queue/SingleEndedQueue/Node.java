/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.SingleEndedQueue;

/**
 *
 * @author Hp
 */
public class Node {

    public int info;
    public Node next;

    Node() {

    }

    Node(int info) {
        this.info = info;
        this.next = null;
    }
}
