/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

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

  void visit(Node p) {
    System.out.print("p.info: ");
    if (p != null) {
      System.out.println(p.info + " ");
    }
  }

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if (p != null) {
      f.writeBytes(p.info + " ");
    }
  }

  void preOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    fvisit(p, f);
    preOrder(p.left, f);
    preOrder(p.right, f);
  }

  void inOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    inOrder(p.left, f);
    fvisit(p, f);
    inOrder(p.right, f);
  }

  void postOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    postOrder(p.left, f);
    postOrder(p.right, f);
    fvisit(p, f);
  }

  void breadth(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      fvisit(r, f);
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }
  }

  void loadData(int k) { //do not edit this function
    String[] a = Lib.readLineToStrArray("data.txt", k);
    int[] b = Lib.readLineToIntArray("data.txt", k + 1);
    int[] c = Lib.readLineToIntArray("data.txt", k + 2);
    int n = a.length;
    for (int i = 0; i < n; i++) {
      insert(a[i], b[i], c[i]);
    }
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
  void insert(Castor x) {
    if (isEmpty()) {
      root = new Node(x);
      return;
    }
    Node f, p;
    f = null;
    p = root;
    while (p != null) {
      if (p.info.weight == x.weight) {
        return;
      }
      f = p;
      if (x.weight < p.info.weight) p = p.left; else p = p.right;
    }
    if (x.weight < f.info.weight) f.left = new Node(x); else f.right =
      new Node(x);
  }

  void insert(String xMaker, int xType, int xRadius) {
    //You should insert here statements to complete this function
    if (xMaker.charAt(0) == 'A') return;
    insert(new Castor(xMaker, xType, xRadius));
  }

  //Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    inOrder(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  void postOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    postOrder2(p.left, f);
    postOrder2(p.right, f);
    if (p.info.depth < 7) fvisit(p, f);
  }

  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    postOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    postOrder2(root, f);
    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  Node findNode(Node p) throws Exception {
    Queue queue = new Queue();
    if (isEmpty()) return null;
    queue.enqueue(root);
    int k = 0;
    while (!queue.isEmpty()) {
      Node node = queue.dequeue();
      if (node.left != null) {
        queue.enqueue((node.left));
      }
      if (node.right != null) {
        ++k;
        if (k == 2) return node;
        queue.enqueue((node.right));
      }
    }
    return null;
  }

  Node findMin(Node p) {
    Queue queue = new Queue();
    if (isEmpty()) return null;
    Node res = p;
    int weight = p.info.weight;
    queue.enqueue(p);
    while (!queue.isEmpty()) {
      Node node = queue.dequeue();
      if (node.info.weight < res.info.weight) res = node;
      if (node.left != null) {
        queue.enqueue((node.left));
      }
      if (node.right != null) {
        queue.enqueue((node.right));
      }
    }
    return res;
  }

  Node getParent(Node p) {
    if (p == root) return null;
    Node father = null, cu = root;
    while (cu != null && cu.info.weight != p.info.weight) {
      father = cu;
      if (cu.info.weight < p.info.weight) cu = cu.right; else cu = cu.left;
    }
    if (cu == null) return null;
    return father;
  }

  void delete(Node p) {
    Node father = getParent(p);
    if (father == null) {
      if (p.info.weight != root.info.weight) {
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
      if (p.info.weight < father.info.weight) father.left =
        p.right; else father.right = p.right;
      return;
    }
    Node q = p.left;
    while (q.right != null) q = q.right;
    q.right = p.right;
    if (p.info.weight < father.info.weight) father.left =
      p.left; else father.right = p.left;
  }

  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    delete(findMin(findNode(root)));
    //------------------------------------------------------------------------------------
    breadth(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================

  void rotateLeft(Node p) {
    if (p == null || p.right == null) return;
    Node c = p.right;
    p.right = c.left;
    c.left = p;
    Node father = getParent(p);
    if (father == null) root = c; else {
      if (father.info.weight > p.info.weight) father.left =
        c; else father.right = c;
    }
  }

  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    rotateLeft(findNode(root));
    //------------------------------------------------------------------------------------
    breadth(root, f);

    f.writeBytes("\r\n");
    f.close();
  }
}
