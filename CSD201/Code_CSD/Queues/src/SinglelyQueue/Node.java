/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinglelyQueue;

public class Node {

    Object info;
    Node next;

    public Node(Object info) {
        this.info = info;
    }

    public Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }

}
