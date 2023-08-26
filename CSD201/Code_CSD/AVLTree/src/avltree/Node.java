/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author PC-Phong
 */
public class Node {

    public int key;
    public int height;
    public Node left;
    public Node right;

    public Node(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public void printInfo() {
        System.out.print("key: " + this.key + "; height: " + this.height + "\n");
    }

    public boolean greaterThan(int key) {
        return this.key > key;
    }

    public boolean lessThan(int key) {
        return this.key < key;
    }

    public boolean equal(int key) {
        return this.key == key;
    }
}
