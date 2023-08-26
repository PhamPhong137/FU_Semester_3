/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assign2_1;

import jdk.nashorn.internal.ir.ContinueNode;

/**
 *
 * @author Admin
 */
public class MyTree {

    Node root;

    public MyTree() {
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(String xType, int xRate, int xWing) {
        if ((xType.charAt(0) == 'B')) {
            return;
        } else {
            Bird value = new Bird(xType, xRate, xWing);
            Node node = new Node(value);
            if (isEmpty()) {
                root = node;
                return;
            }
            Node cu = root;
            Node father = null;
            while (cu != null) {
                if (cu.value.rate == value.rate) {
                    System.out.println("Khong the add " + value + " vao trong tree");
                    return;
                }
                father = cu;
                if (cu.value.rate < value.rate) {
                    cu = cu.right;
                } else {
                    cu = cu.left;
                }
            }
            if (father.value.rate < value.rate) {
                father.right = node;
            } else {
                father.left = node;
            }
        }
    }

    void add(Bird value) {
        Node node = new Node(value);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cu = root;
        Node father = null;
        while (cu != null) {
            if (cu.value.rate == value.rate) {
                System.out.println("Khong the add " + value + " vao trong tree");
                return;
            }
            father = cu;
            if (cu.value.rate < value.rate) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (father.value.rate < value.rate) {
            father.right = node;
        } else {
            father.left = node;
        }
    }

    void visit(Node p) {
     
        System.out.print(p.value);
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);

    }

    void preOrder() {
        preOrder(root);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    int count = 0;
    Node node = new Node();
    boolean check = true;
    void postOrderIndex(Node p) {
        if (p == null) {
            return;
        }
        if (count!=4&&check==true) {
            postOrderIndex(p.left);
            postOrderIndex(p.right);
            count++;
        }
        if(count==4){
            node = p;
            check = false;
        }
    }

    void postOrderIndex() {
        postOrderIndex(root);
    }

    void postOrder() {
        postOrder(root);
    }

    void InOrder(Node p) {
        if (p == null) {
            return;
        }
        InOrder(p.left);
        visit(p);
        InOrder(p.right);
    }

    void InOrder() {
        InOrder(root);
    }

    void breadth2() {
        breadth2(root);
    }

    void breadth2(Node p) {
        MyQueue queue = new MyQueue();
        if (isEmpty()) {
            return;
        }
        queue.Enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            if (node.value.getWing() > 4) {
                visit(node);
            }
        }
    }
    int heightTree(Node node){
        if(node == null){
            return 0;
        }
        else if(node.left==null&&node.right==null){
            return 1;
        }
        else{
            int leftHeight = heightTree(node.left);
            int rightHeight = heightTree(node.right);
            return 1+Math.max(leftHeight, rightHeight);
        }
    }
    int heightTree(){
        return heightTree(node);
    }
    void BreadthFirstOrder() {
        BreadthFirstOrder(root);
    }

    void BreadthFirstOrder(Node p) {
        MyQueue queue = new MyQueue();
        if (isEmpty()) {
            return;
        }
        queue.Enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            visit(node);
        }
    }

    void deleteByCopyL(Node p) {
        if (p == null) {
            return;
        }
        if (p.left == null) {
            return;
        }
        if (p.left.right == null) {
            p.value = p.left.value;
            p.left = p.left.left;
            return;
        } else {
            Node father = p.left;
            Node cu = p.left.right;
            while (father.right.right != null) {
                father = father.right;
            }
            p.value = father.right.value;

            if (father.right.left == null) {
                father.right = null;
                return;
            }
            father.right = father.right.left;
        }
    }

    void deleteByCopyR(Node p) {
        if (p == null) {
            return;
        }
        if (p.right == null) {
            return;
        }
        if (p.right.left == null) {
            p.value = p.right.value;
            p.right = p.right.right;
            return;
        } else {
            Node father = p.right;
            Node cu = p.right.left;
            while (father.left.left != null) {
                father = father.left;
            }
            p.value = father.left.value;

            if (father.left.right == null) {
                father.left = null;
                return;
            }
            father.left = father.left.right;
        }
    }

    Node getParent(Node p) {
        if (p == root) {
            return null;
        }
        Node father = null, cu = root;
        while (cu != null && cu.value.rate != p.value.rate) {
            father = cu;
            if (cu.value.rate < p.value.rate) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (cu == null) {
            return null;
        }
        return father;
    }

    Node findNode(int key) {
        Node cu = root;
        while (cu != null) {
            if (cu.value.rate == key) {
                return cu;
            }
            cu = cu.value.rate < key ? cu.right : cu.left;
        }
        return null;
    }

    void deleteMerging(Node p) {
        Node father = getParent(p);
        if (father == null) {
            if (p.value.rate != root.value.rate) {
                System.out.println("Khong ton tai node p");
                return;
            }
            if (root.left == null) {
                root = root.right;
                return;
            }
            if (root.left.right == null) {
                root.left.right = root.right;
                root = root.left;
                return;
            }
            Node q = root.left;
            while (q.right != null) {
                q = q.right;
            }
            q.right = p.right;
            root = p.left;
            return;
        }
        Bird c = p.value;
        if (p.left == null) {
            if (c.rate < father.value.rate) {
                father.left = p.right;
            } else {
                father.right = p.right;
            }
            return;
        }
        Node q = p.left;
        while (q.right != null) {
            q = q.right;
        }
        q.right = p.right;
        if (c.rate < father.value.rate) {
            father.left = p.left;
        } else {
            father.right = p.left;
        }
    }

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return null;
        }
        Node c = p.left;
        p.left = c.right;
        c.right = p;
        return c;
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return null;
        }
        Node child = p.right;
        p.right = child.left;
        child.left = p;
        return child;
    }
}
