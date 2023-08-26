/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

/**
 *
 * @author PC-Phong
 */
public class Node {

    int value;
    Node left;
    Node right;
    
    Node next;
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
