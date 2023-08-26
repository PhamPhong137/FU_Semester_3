/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_1_2;

/**
 *
 * @author Admin
 */
public class Node {
    Bird bird;
    Node next;

    public Node(Bird bird) {
        this(bird, null);
    }

    public Node(Bird bird, Node next) {
        this.bird = bird;
        this.next = next;
    }
    
}
