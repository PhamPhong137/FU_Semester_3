
package Tree;

import Queue.MyQueue;

public final class MyTree {
    Node root;
    
    public MyTree() {
        root = null;
    }
    
    public MyTree(int[] a) {
        for (int x: a) {
            add(x);
        }
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    public void add(int x) {
        Node node = new Node(x);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cu = root;
        Node father = null;
        while (cu != null) {
            if (cu.value == x) {
                return;
            }
            father = cu;
            if (cu.value < x) cu = cu.right;
            else if (cu.value > x) cu = cu.left;
        }
        assert(father != null);
        if (father.value > x) father.left = node;
        else father.right = node;
    }
    
    void visit(Node p) {
        System.out.printf("%-3d", p.value);
    }
    
    void preOrder(Node p) {
        if (p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void preOrder() {
        preOrder(root);
        System.out.println();
    }
    
    void postOrder(Node p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    void postOrder() {
        postOrder(root);
        System.out.println();
    }
    
    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    
    void inOrder() {
        inOrder(root);
        System.out.println();
    }
    
    void BreathFirstOrder(Node p) throws Exception {
        MyQueue queue = new MyQueue();
        if (isEmpty()) return;
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node node = (Node)queue.deQueue();
            if (node.left != null) queue.enQueue((node.left));
            if (node.right != null) queue.enQueue((node.right));
            visit(node);
        }
    }
    
    void BreathFirstOrder() throws Exception {
        BreathFirstOrder(root);
    }
    
    Node getParent(Node p) {
        if (p == root) return null;
        Node father = null, cu = root;
        while (cu != null && cu.value != p.value) {
            father = cu;
            if (cu.value < p.value) cu = cu.right;
            else cu = cu.left;
        }
        if (cu == null) return null;
        return father;
    }
    
    Node findNode(int key) {
        Node cu = root;
        while (cu != null) {
            if (cu.value == key) return cu;
            cu = cu.value < key ? cu.right : cu.left;
        }
        return null;
    }
    
    void deleteByCopyL(Node p) {
        if (p == null) return;
        if (p.left == null) return;
        if (p.left.right == null) {
            p.value = p.left.value;
            p.left = p.left.left;
        }
        else {
            Node father = p.left;
            while (father.right.right != null) father = father.right;
            p.value = father.right.value;
            
            if (father.right.left == null) {
                father.right = null;
            }
            else father.right = father.right.left;
        }
    }
    
    void deleteByCopy(Node x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.value == x.value) break;
            f = p;
            if (x.value < p.value) p = p.left; else p = p.right;
            // x.value can be replaced to x.info.value. The same to p.value
        }
        if (p == null) return; // not found
        // p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { // p==root
              root = null;
              return;
            }
            if (p == f.left) f.left = null;
            else f.right = null;
        }
        // p has left son only
        if (p.left != null && p.right == null) {
            if (f == null) { // p==root
              root = p.left;
              return;
            }
            if (p == f.left) f.left = p.left;
            else f.right = p.left;
        }
        // p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { // p==root
              root = p.right;
              return;
            }
            if (p == f.left) f.left = p.right;
            else f.right = p.right;
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            // find the right-most node in the left sub-tree
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
              frp = rp;
              rp = rp.right;
            }
            p.value = rp.value;
            // Can be replaced to p.info = rp.info
            if (frp == null) p.left = q.left;
            else frp.right = rp.left;
        }
    }
 
    void deleteByMerging(Node p) {
        Node father = getParent(p);
        if (father == null) {
            if (p.value != root.value) {
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
        if (p.left == null) {
            if (p.value < father.value) father.left = p.right;
            else father.right = p.right;
            return;
        }
        Node q = p.left;
        while (q.right != null) q = q.right;
        q.right = p.right;
        if (p.value < father.value) father.left = p.left;
        else father.right = p.left;
    }
    
    void rotateRight(Node p) {
        if (p == null || p.left == null) return;
        Node c = p.left;
        p.left = c.right;
        c.right = p;
        Node father = getParent(p);
        if (father == null) root = c;
        else {
            if (father.value > p.value) father.left = c;
            else father.right = c;
        }
    }
    
    void rotateLeft(Node p) {
        if (p == null || p.right == null) return;
        Node c = p.right;
        p.right = c.left;
        c.left = p;
        Node father = getParent(p);
        if (father == null) root = c;
        else {
            if (father.value > p.value) father.left = c;
            else father.right = c;
        }
    }
    
    void getHeap(int[] a) {
        int k, tmp;
        for (int i = 0; i < a.length; i++) {
            if (i != 0) {
                k = i;
                while ((k-1)/2 >= 0) {
                    if (a[k] >= a[(k-1)/2]) {
                        tmp = a[k];
                        a[k] = a[(k-1)/2];
                        a[(k-1)/2] = tmp;
                        k = (k-1)/2;
                        if (k == 0) break;
                    }
                    else break;
                }
            }
        }
        // Print heap
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    
    int max(int a, int b) {
        if (a > b) return a;
        else return b;
    }
    
    public int getMaxSum(Node p) {
        if (p == null) return 0;
        if (p.left == null && p.right == null) return p.value;
        return p.value + max(getMaxSum(p.left), getMaxSum(p.right));
    }
    
    public int getMaxSum() {
        return getMaxSum(root);
    }
}
