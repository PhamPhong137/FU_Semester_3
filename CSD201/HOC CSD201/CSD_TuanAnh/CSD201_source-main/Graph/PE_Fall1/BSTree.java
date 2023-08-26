/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PE_Fall1;

/**
 *
 * @author ADMIN
 */
public class BSTree {

    Node root;

    public BSTree() {
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(String xForest, int xRate, int xSound) {
        if ((xForest.charAt(0) == 'A')) {
            return;
        } else {
            Bee value = new Bee(xForest, xRate, xSound);
            Node node = new Node(value);
            if (isEmpty()) {
                root = node;
                return;
            }
            Node cu = root;
            Node father = null;
            while (cu != null) {
                if (cu.value.getSound() == value.getSound()) {
                    System.out.println("Khong the add " + value + " vao trong tree");
                    return;
                }
                father = cu;
                if (cu.value.getSound() < value.getSound()) {
                    cu = cu.right;
                } else {
                    cu = cu.left;
                }
            }
            if (father.value.getSound() < value.getSound()) {
                father.right = node;
            } else {
                father.left = node;
            }
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
    int count = 0, i = 0;
    Node node = new Node();

    void preOrder3(Node p) {
        if (p == null) {
            return;
        }

        if (count < 4) {
            count++;
            if (count == 4) {
                node = p;
            }
            preOrder3(p.left);
            preOrder3(p.right);
        }

    }

    void preOrder3() {
        preOrder3(root);
    }

    void preOrder4(Node p) {
        if (p == null) {
            return;
        }

        if (count < 4) {
            count++;
            if (count == 4) {
                node = p;
                if (node.right != null) {
                    Node father = getParent(node);
                    Node after = rotateLeft(node);//quay trai
                    if (father.value.Sound > node.value.Sound) {
                        father.left = after;
                    } else {
                        father.right = after;
                    }
                }
            }
            preOrder4(p.left);
            preOrder4(p.right);
        }

    }

    void preOrder4() {
        preOrder4(root);
    }

    void preOrder2(Node p) {
        if (p == null) {
            return;
        }
        if (p.value.Rate < 6) {
            visit(p);
        }

        preOrder2(p.left);
        preOrder2(p.right);

    }

    void preOrder2() {
        preOrder2(root);
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
        while (cu != null && cu.value.Sound != p.value.Sound) {
            father = cu;
            if (cu.value.Sound < p.value.Sound) {
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
            if (cu.value.Sound == key) {
                return cu;
            }
            cu = cu.value.Sound < key ? cu.right : cu.left;
        }
        return null;
    }

    void deleteMerging(Node p) {
        Node father = getParent(p);
        if (father == null) {
            if (p.value.Sound != root.value.Sound) {
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
        Bee c = p.value;
        if (p.left == null) {
            if (c.Sound < father.value.Sound) {
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
        if (c.Sound < father.value.Sound) {
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
