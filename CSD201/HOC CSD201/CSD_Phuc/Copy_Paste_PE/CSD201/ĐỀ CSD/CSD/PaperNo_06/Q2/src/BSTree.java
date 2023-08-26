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
  void insert(Corn x) {
    if (isEmpty()) {
      root = new Node(x);
      return;
    }
    Node f, p;
    f = null;
    p = root;
    while (p != null) {
      if (p.info.type == x.type) {
        return;
      }
      f = p;
      if (x.type < p.info.type) p = p.left; else p = p.right;
    }
    if (x.type < f.info.type) f.left = new Node(x); else f.right = new Node(x);
  }

  void insert(String xCode, int xType, int xPrice) {
    //You should insert here statements to complete this function
    if (xCode.charAt(0) == 'B') {
      return;
    }
    insert(new Corn(xCode, xType, xPrice));
  }

  //Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(2);
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
    if (p.info.price < 5) {
      fvisit(p, f);
    }
    inOrder2(p.right, f);
  }

  void f2() throws Exception {
    clear();
    loadData(6);
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

  Node q123 = null;

  void preOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    if (p.info.type < 10) {
      q123 = p;
      return;
    }
    preOrder2(p.left, f);
    preOrder2(p.right, f);
  }

    void deleteByCopy(Node p) {
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
    loadData(10);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    preOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    q123 = null;
    preOrder2(root, f);

    if (q123 != null) {
        deleteByCopy(q123);
    }
    //------------------------------------------------------------------------------------
    preOrder(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================

  Node search(Node p, int x) {
    if (p == null) return (null);
    if (p.info.type == x) return (p);
    if (x < p.info.type) return (search(p.left, x)); else return (
      search(p.right, x)
    );
  }

  int count(Node p, RandomAccessFile f) throws Exception {
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    int count = 0;
    while (!q.isEmpty()) {
      r = q.dequeue();
      count++;
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }
    return count;
  }

  void f4() throws Exception {
    clear();
    loadData(14);
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
    Node p = search(root, 5);
    int k = count(p, f);
    p.info.price = k;
    //------------------------------------------------------------------------------------
    breadth(root, f);

    f.writeBytes("\r\n");
    f.close();
  }
}
