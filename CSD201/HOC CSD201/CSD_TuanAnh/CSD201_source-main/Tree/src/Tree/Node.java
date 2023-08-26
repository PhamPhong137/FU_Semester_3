/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author ADMIN
 */
public class Node {
    Car value;
    Node left,right;

    public Node() {
    }

    public Node(Car value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public Node(String name, int price){
        value = new Car(name, price);
        left = null;
        right = null;
        
    }

    public Car getValue() {
        return value;
    }

    public void setValue(Car value) {
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
