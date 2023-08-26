/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assign2_1;

/**
 *
 * @author Admin
 */
public class Node {
     Bird value;
    Node left,right;

    public Node() {
    }

    public Node(Bird value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public Node(String type, int rate,int wing){
        value = new Bird(type, rate,wing);
        left = null;
        right = null;
        
    }

    public Bird getValue() {
        return value;
    }

    public void setValue(Bird value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
