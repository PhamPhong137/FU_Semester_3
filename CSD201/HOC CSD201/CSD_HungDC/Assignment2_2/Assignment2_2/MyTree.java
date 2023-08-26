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
public class MyTree {

    Node root;

    public MyTree() {
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(String type, int rate, int wing) {
        if (type.charAt(0) == 'B') {
            return;
        }
        Node node = new Node(type, rate, wing);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cu = root;
        Node father = null;
        while (cu != null) {
            father = cu;
            if (cu.value.rate < rate) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (father.value.rate < rate) {
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

    // f1
    void f1(MyTree my) {
        my.insert("A", 7, 9);
        my.insert("C", 4, 3);
        my.insert("D", 8, 6);
        my.insert("E", 2, 5);
        my.insert("Y", 6, -7);
        my.insert("F", -6, 7);

        // add a type start with 'B'
        my.insert("B", 11, 0);
        my.BreadthFirstOrder();
        System.out.println();
        my.InOrder();
    }

    //f2
    void BreadthFirstOrder2() {
        BreadthFirstOrder2(root);
    }

    void BreadthFirstOrder2(Node p) {
        MyQueue queue = new MyQueue();
        if (isEmpty()) {
            return;
        }
        queue.Enqueue(p);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            if (node.value.wing > 4) {
                visit(node);
            }
        }
    }

    void f2(MyTree my) {
        my.insert("C", 8, 2);
        my.insert("D", 6, 1);
        my.insert("E", 9, 4);
        my.insert("F", 2, 3);
        my.insert("G", 7, 8);
        my.insert("H", 1, 7);
        my.insert("I", 3, 9);
        my.insert("J", 5, 5);
        my.insert("K", 4, 6);

        my.BreadthFirstOrder();
        System.out.println();
        my.BreadthFirstOrder2();
    }

    //f3
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
        if (node.value.rate < getParent(node).value.rate) {
            deleteByCopyL(node);
        } else {
            deleteByCopyR(node);
        }
        my.postOrder();
    }
    
    //f4
    
    int countF4 = 0;
    boolean checkF4 = true;
    Node node4F4 = new Node();
    
    int findHigh(Node p) {
        MyQueue queue = new MyQueue();
        int count = 0;
        queue.Enqueue(p);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            count++;
        }
        
        return count;
    }
    
    void findNodef4(Node p) {
        if (p == null) {
            return;
        }
        if (countF4 < 4 && checkF4) {
            findNodef4(p.left);
            findNodef4(p.right);
            countF4++;
        }
        if (countF4 == 4 && checkF4) {
            checkF4 = false;
            node4F4 = p;
            return;
        }
    }
    
    void setNode4(Node node) {
        node.value.setWing(findHigh(node));
    }
    
    void f4(MyTree my) {
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
        findNodef4(root);
        setNode4(node4F4);
        my.postOrder();
    }
}
