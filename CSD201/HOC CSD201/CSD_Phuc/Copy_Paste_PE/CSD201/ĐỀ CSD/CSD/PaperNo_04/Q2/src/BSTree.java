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
  void insert(Bat x) {
    if (isEmpty()) {
      root = new Node(x);
      return;
    }
    Node f, p;
    f = null;
    p = root;
    while (p != null) {
      if (p.info.color == x.color) {
        System.out.println(
          "The key " + x.color + " already exists, no insertion"
        );
        return;
      }
      f = p;
      if (x.color < p.info.color) p = p.left; else p = p.right;
    }
    if (x.color < f.info.color) f.left = new Node(x); else f.right =
      new Node(x);
  }

  void insert(String xOwner, int xPrice, int xColor) {
    //You should insert here statements to complete this function
    if (xOwner.charAt(0) == 'A') return;
    insert(new Bat(xOwner, xPrice, xColor));
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
  void inOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    inOrder2(p.left, f);
    if (p.info.price < 7) fvisit(p, f);
    inOrder2(p.right, f);
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
    inOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    inOrder2(root, f);
    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  int max;

  void breadth2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    max = root.info.color;
    while (!q.isEmpty()) {
      r = q.dequeue();
      if (r.info.color > max) max = r.info.color;
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }
  }

  void deleByCopy(int x) {
    Node f, p;
    f = null;
    p = root;
    while (p != null) {
      if (p.info.color == x) break;
      f = p;
      if (x < p.info.color) p = p.left; else p = p.right;
    }
    if (p == null) return; // not found
    // p is a leaf node
    if (p.left == null && p.right == null) {
      if (f == null) { // p==root
        root = null;
        return;
      }
      if (p == f.left) f.left = null; else f.right = null;
    }
    // p has left son only
    if (p.left != null && p.right == null) {
      if (f == null) { // p==root
        root = p.left;
        return;
      }
      if (p == f.left) f.left = p.left; else f.right = p.left;
    }
    // p has right son only
    if (p.left == null && p.right != null) {
      if (f == null) { // p==root
        root = p.right;
        return;
      }
      if (p == f.left) f.left = p.right; else f.right = p.right;
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
      p.info = rp.info;
      if (frp == null) { // rp==q
        p.left = q.left;
      } else {
        frp.right = rp.left;
      }
    }
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
    max = 0;
    breadth2(root, f);

    Queue q = new Queue();
    q.enqueue(root);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      if (r.info.color == max) deleByCopy(r.info.color);
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }

    //------------------------------------------------------------------------------------
    breadth(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  Node findNode(Node p, RandomAccessFile f) throws Exception {
    Node c = null;
    if (p == null) {
      return null;
    }
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    max = root.info.color;
    while (!q.isEmpty()) {
      r = q.dequeue();
      if (r.info.color > max) {
        max = r.info.color;
        c = r;
      }
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }
    return c;
  }
  
  Node getParent(Node p) {
    if (p == root) return null;
    Node father = null, cu = root;
    while (cu != null && cu.info.color != p.info.color) {
      father = cu;
      if (cu.info.color < p.info.color) cu = cu.right; else cu = cu.left;
    }
    if (cu == null) return null;
    return father;
  }
  
  void rotateLeft(Node p) {
    if (p == null || p.right == null) return;
    Node c = p.right;
    p.right = c.left;
    c.left = p;
    Node father = getParent(p);
    if (father == null) root = c;
    else {
      if (father.info.color > p.info.color) father.left = c;
      else father.right = c;
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
    rotateLeft(getParent(findNode(root, f)));
    //------------------------------------------------------------------------------------
    breadth(root, f);

    f.writeBytes("\r\n");
    f.close();
  }
}
