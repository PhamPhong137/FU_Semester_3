/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_2_2;

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
        Bird value = new Bird(xType, xRate, xWing);
        Node node = new Node(value);
        if (isEmpty()) {
            root = node;
            return;
        }
        if (xType.charAt(0) == 'B') {
            return;
        }
        Node cu = root;
        Node father = null;
        while (cu != null) {
            if (cu.value.getType().equals(value.getType())) {
                System.out.println("Khong the add " + value + " vao trong tree");
                return;
            }
            father = cu;
            if (cu.value.getRate() < value.getRate()) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (father.value.getRate() < value.getRate()) {
            father.right = node;
        } else {
            father.left = node;
        }
    }

    void visit(Node p) {
        System.out.print(p.value);
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

    void postOrder() {
        postOrder(root);
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

    void BreadthFirstOrder2() {
        BreadthFirstOrder2(root);
    }

    void BreadthFirstOrder2(Node p) {
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
        while (cu != null && cu.value.getRate() != p.value.getRate()) {
            father = cu;
            if (cu.value.getRate() < p.value.getRate()) {
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
    
    //f3:
    int countF3 = 0;
    Node node4F3 = new Node();
    boolean checkF3 = true;
    
    void findNodef3(Node p) {
        if (p == null) {
            return;
        }
        if (countF3 < 4 && checkF3) {
            findNodef3(p.left);
            findNodef3(p.right);
            countF3++;
        }
        if (countF3 == 4 && checkF3) {
            checkF3 = false;
            node4F3 = p;
            return;
        }
    }
    
    void f3(MyTree my) {
        my.insert("C", 8, 2);
        my.insert("D", 6, 1);
        my.insert("E", 9, 4);
        my.insert("F", 2, 3);
        my.insert("G", 7, 8);
        my.insert("H", 1, 7);
        my.insert("I", 3, 9);
        my.insert("J", 5, 5);
        my.insert("K", 4, 6);

        my.postOrder();
        System.out.println();
        findNodef3(root);
        Node node = getParent(node4F3);
        if (node.value.getRate() < getParent(node).value.getRate()) {
            deleteByCopyL(node);
        } else {
            deleteByCopyR(node);
        }
        my.postOrder();
    }

}
