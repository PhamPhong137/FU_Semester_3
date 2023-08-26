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
public class Node {
    Castor value;
    Node next;

    public Node() {
    }
    public Node(Castor value) {
        this.value = value;
        this.next = null;
    }
    public Node(Castor value, Node next) {
        this.value = value;
        this.next = next;
    }
    
}
