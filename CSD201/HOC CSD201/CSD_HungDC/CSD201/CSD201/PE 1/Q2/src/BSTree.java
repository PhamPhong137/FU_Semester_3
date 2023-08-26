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
  void insert(Ball x) {
    if (isEmpty()) {
      root = new Node(x);
      return;
    }
    Node f, p;
    f = null;
    p = root;
    while (p != null) {
      if (p.info.type == x.type) {
        System.out.println(
          "The key " + x.type + " already exists, no insertion"
        );
        return;
      }
      f = p;
      if (x.type < p.info.type) p = p.left; else p = p.right;
    }
    if (x.type < f.info.type) f.left = new Node(x); else f.right = new Node(x);
  }

  void insert(String xMaker, int xType, int xRadius) {
    //You should insert here statements to complete this function
    if (xMaker.charAt(0) == 'B') return;
    insert(new Ball(xMaker, xType, xRadius));
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
    if (p.info.radius < 5) fvisit(p, f);
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
  Node q123 = null;
  int count = 0;

  void inOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    inOrder2(p.left, f);
    if (p.left != null && p.right != null && count == 0) {
      q123 = p;
      count++;
      return;
    }
    inOrder2(p.right, f);
    return;
  }

    void deleteByCopy(Node x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.type == x.info.type) break;
            f = p;
            if (x.info.type < p.info.type) p = p.left; else p = p.right;
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
    q123 = null;
    inOrder2(root, f);
    deleteByCopy(q123);
    //------------------------------------------------------------------------------------
    breadth(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  Node father2(int xType) { // return the father of the node q, where q.info.price = xPrice
    Node f, p;
    f = null;
    p = root;
    while (p != null) {
      if (p.info.type == xType) break;
      f = p;
      if (xType < p.info.type) p = p.left; else p = p.right;
    }
    return (f);
  }

  Node rotateLeft(Node p) {
    if (p == null || p.right == null) return (p);
    Node q = p.right;
    p.right = q.left;
    q.left = p;
    return (q);
  }

  /* Tac vu rotateLeft: xoay trai cay nhi phan tim kiem co nut goc
     la root, yeu cau root phai co nut con ben phai (goi la nut p)
     Sau khi xoay trai thi nut con ben phai p tro thanh nut goc, nut goc
     cu tro thanh nut con ben trai cua nut goc moi
     Tac vu nay tra ve con tro chi nut goc moi 
     */

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
    q123 = null;
    inOrder2(root, f);
    Node r = rotateLeft(q123);

    Node fa = father2(q123.info.type);
    if (fa == null) root = r; else {
      if (fa.left == q123) fa.left = r; else fa.right = r;
    }
    //------------------------------------------------------------------------------------
    breadth(root, f);

    f.writeBytes("\r\n");
    f.close();
  }
}
