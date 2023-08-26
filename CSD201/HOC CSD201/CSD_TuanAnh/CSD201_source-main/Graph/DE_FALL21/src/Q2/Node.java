/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author ADMIN
 */
public class Node {
     Bee value;
    Node left,right;

    public Node() {
    }

    public Node(Bee value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public Node(String forest, int rate,int sound){
        value = new Bee(forest, rate, sound);
        left = null;
        right = null;
        
    }

    public Bee getValue() {
        return value;
    }

    public void setValue(Bee value) {
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
