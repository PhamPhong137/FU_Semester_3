/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_3.Q1;

/**
 *
 * @author TLC
 */
public class Node {
    Node next;
    Bee value;

    public Node() {
    }

    public Node(Node next, Bee value) {
        this.next = next;
        this.value = value;
    }
    Node(Bee value){
        this.value=value;
        next=null;
    }
    
}
