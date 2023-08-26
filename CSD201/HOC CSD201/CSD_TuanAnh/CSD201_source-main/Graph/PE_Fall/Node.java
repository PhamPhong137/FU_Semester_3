/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PE_Fall;

/**
 *
 * @author ADMIN
 */
public class Node {
    Bee value;
    Node next;

    public Node() {
    }

    public Node(Bee value, Node next) {
        this.value = value;
        this.next = next;
    }
     public Node(Bee value) {
        this.value = value;
        this.next = null;
    }
}
