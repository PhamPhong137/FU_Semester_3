/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

  Node root;

  BSTree() {
    root = null;
  }

  boolean isEmpty() {
    return (root == null);
  }

  void clear() {
    root = null;
  }

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if (p != null) f.writeBytes(p.info + " ");
  }

  void preOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) return;
    fvisit(p, f);
    preOrder(p.left, f);
    preOrder(p.right, f);
  }

  void inOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) return;
    inOrder(p.left, f);
    fvisit(p, f);
    inOrder(p.right, f);
  }

  void postOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) return;
    postOrder(p.left, f);
    postOrder(p.right, f);
    fvisit(p, f);
  }

  void breadth(Node p, RandomAccessFile f) throws Exception {
    if (p == null) return;
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      fvisit(r, f);
      if (r.left != null) q.enqueue(r.left);
      if (r.right != null) q.enqueue(r.right);
    }
  }

  void loadData(int k) { // do not edit this function
    String[] a = Lib.readLineToStrArray("data.txt", k);
    int[] b = Lib.readLineToIntArray("data.txt", k + 1);
    int n = a.length;
    for (int i = 0; i < n; i++) insert(a[i], b[i]);
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
    void insert(String xOwner, int xPrice) { //You should insert here statements to complete this function
        if (xOwner.startsWith("B") || xPrice > 100) return;
        Node x = new Node(new Car(xOwner, xPrice));
        if (root == null) root = x; else {
          Node cur = root, father = root;
          while (cur != null) {
            father = cur;
            if (cur.info.price == x.info.price) return;
            if (cur.info.price < x.info.price) cur = cur.right;
            else cur = cur.left;
          }
          if (father.info.price < x.info.price) father.right = x;
          else father.left = x;
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert function above only. */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

  //=============================================================  
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) return;
        if (p.info.price >= 3 && p.info.price <= 5) fvisit(p, f);
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
  
    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*  You must keep statements pre-given in this function.
                Your task is to insert statements here, just after this comment,
                to complete the question in the exam paper. */
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

  // f.writeBytes(" k = " + k + "\r\n");
  //=============================================================
    
    Node findNodeWithTwoChildren(Node p) throws Exception {
        Queue queue = new Queue();
        if (isEmpty()) return null;
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            if (node.left != null && node.right != null && node.info.price < 7) return node;
            else {
                if (node.left != null) queue.enqueue((node.left));
                if (node.right != null) queue.enqueue((node.right));
            }
        }
        return null;
    }
    
    void deleteByCopyL(Node p) {
        if (p == null) return;
        if (p.left == null) return;
        if (p.left.right == null) {
            p.info = p.left.info;
            p.left = p.left.left;
        }
        else {
            Node father = p.left;
            while (father.right.right != null) father = father.right;
            p.info = father.right.info;
            if (father.right.left == null) {
                father.right = null;
            }
            else father.right = father.right.left;
        }
    }
  
    void f3() throws Exception {
        clear();
        loadData(7);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
            Your task is to insert statements here, just after this comment,
            to complete the question in the exam paper.*/
        deleteByCopyL(findNodeWithTwoChildren(root));
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

  //=============================================================
    Node findNodeWithLeftChild(Node p) throws Exception {
        Queue queue = new Queue();
        if (isEmpty()) return null;
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            if (node.left != null) {
                if (node.info.price < 7) return node;
                else queue.enqueue((node.left));
            }
            if (node.right != null) queue.enqueue((node.right));
        }
        return null;
    }
    
    Node getParent(Node p) {
        if (p == root) return null;
        Node father = null, cu = root;
        while (cu != null && cu.info.price != p.info.price) {
            father = cu;
            if (cu.info.price < p.info.price) cu = cu.right;
            else cu = cu.left;
        }
        if (cu == null) return null;
        return father;
    }
    
    void rotateRight(Node p) {
        if (p == null || p.left == null) return;
        Node c = p.left;
        p.left = c.right;
        c.right = p;
        Node father = getParent(p);
        if (father == null) root = c;
        else {
            if (father.info.price > p.info.price) father.left = c;
            else father.right = c;
        }
    }
    
    void f4() throws Exception {
        clear();
        loadData(10);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
              Your task is to insert statements here, just after this comment,
              to complete the question in the exam paper.*/
        rotateRight(findNodeWithLeftChild(root));
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
}
