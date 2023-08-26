/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2_2;

/**
 *
 * @author dmngh
 */
public class Node {
    Bird value;
    Node left;
    Node right;
    
    public Node() {
    }

    public Node(Bird value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(String type, int rate, int wing) {
        value = new Bird(type, rate, wing);
        left = null;
        right = null;

    }
}
