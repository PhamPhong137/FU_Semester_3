/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_2_1;

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

    void insert(String xOwener, int xPrice) {
        Car value = new Car(xOwener, xPrice);
        Node node = new Node(value);
        if (isEmpty()) {
            root = node;
            return;
        }
        if (xOwener.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        Node cu = root;
        Node father = null;
        while (cu != null) {
            if (cu.value.price == value.price) {
                System.out.println("Khong the add " + value + " vao trong tree");
                return;
            }
            father = cu;
            if (cu.value.price < value.price) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (father.value.price < value.price) {
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

    void preOrder2(Node p) {
        if (p == null) {
            return;
        }
        if (p.value.price >= 3 && p.value.price <= 5) {
            visit(p);
        }
        preOrder2(p.left);
        preOrder2(p.right);

    }

    void preOrder2() {
        preOrder2(root);
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

    Node findNode(int key) {
        Node cu = root;
        while (cu != null) {
            if (cu.value.price < key) {
                return cu;
            }
            cu = cu.value.price < key ? cu.right : cu.left;
        }
        return null;
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

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return null;
        }
        Node c = p.left;
        p.left = c.right;
        c.right = p;
        return c;
    }
    
    public void f4(int price) {
        if (root.value.getPrice() < price && root.left != null) {
            Node node = root.left;
            root.left = node.right;
            node.right = root;
            root = node;
        } else {
            Node cu = root.left;
            while (cu.left != null) {
                if (cu.left != null && cu.value.getPrice() < price) {
                    Node temp = cu.left;
                    Node temp2 = cu.left.right;
                    cu.left.right = cu;
                    cu.left = temp2;
                    getParent(cu).left = temp;
                    break;
                }
                cu = cu.value.price > price ? cu.left : cu.right;
            }
        }
    }
    
    Node getParent(Node p) {
        if (p == root) {
            return null;
        }
        Node father = null, cu = root;
        while (cu != null && cu.value.price != p.value.price) {
            father = cu;
            if (cu.value.price < p.value.price) {
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
}
