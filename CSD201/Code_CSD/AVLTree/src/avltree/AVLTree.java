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
public class AVLTree {

    private int size;
    private Node root;

    public AVLTree() {
        this.size = 0;
        this.root = null;
    }

    public int size() {
        return this.size;
    }

    public int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    public void insert(int key) {
        this.root = insert(this.root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            this.size++;
            return new Node(key);
        }

        if (node.equal(key)) {
            return node;
        }

        if (node.lessThan(key)) {
            node.right = insert(node.right, key);
        } else {
            node.left = insert(node.left, key);
        }

        node.height = max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1) {
            // => right
            if (node.left.lessThan(key)) {
                // left rotation
                node.left = leftRotation(node.left);
            }
            // right rotation
            return rightRotation(node);
        } else if (balance < -1) {
            // => left
            if (node.right.greaterThan(key)) {
                // right rotation
                node.right = rightRotation(node.right);
            }
            // left rotation
            return leftRotation(node);
        }

        return node;
    }

    private int max(int key1, int key2) {
        if (key1 <= key2) {
            return key2;
        }
        return key1;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    private Node leftRotation(Node node) {
        if (node == null) {
            return null;
        }

        Node returnNode = node.right;
        node.right = returnNode.left;
        returnNode.left = node;

        node.height = max(height(node.left), height(node.right)) + 1;
        returnNode.height = max(height(returnNode.left), height(returnNode.right)) + 1;

        return returnNode;
    }

    private Node rightRotation(Node node) {
        if (node == null) {
            return null;
        }

        Node returnNode = node.left;
        node.left = returnNode.right;
        returnNode.right = node;

        node.height = max(height(node.left), height(node.right)) + 1;
        returnNode.height = max(height(returnNode.left), height(returnNode.right)) + 1;

        return returnNode;
    }

    public void printPreOrder() {
        System.out.print("\n");
        System.out.print("printPreOrder, size = " + this.size);
        System.out.print("\n");
        printPreOrder(this.root);
    }

    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }

        node.printInfo();
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printInOrder() {
        System.out.print("\n");
        System.out.print("printInOrder, size = " + this.size);
        System.out.print("\n");
        printInOrder(this.root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        node.printInfo();
        printInOrder(node.right);
    }
}
