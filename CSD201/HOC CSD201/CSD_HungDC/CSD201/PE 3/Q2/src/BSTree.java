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
    if (p != null) System.out.println(p.info + " ");
  }

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if (p != null) f.writeBytes(p.info + " ");
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

  void loadData(int k) { //do not edit this function
    String[] a = Lib.readLineToStrArray("data.txt", k);
    int[] b = Lib.readLineToIntArray("data.txt", k + 1);
    int[] c = Lib.readLineToIntArray("data.txt", k + 2);
    int n = a.length;
    for (int i = 0; i < n; i++) insert(a[i], b[i], c[i]);
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
  void insert(String xForest, int xRate, int xSound) {
    //You should insert here statements to complete this function
    if (xForest.charAt(0) == 'A') return;
    Node node = new Node(new Bee(xForest, xRate, xSound));
    if (isEmpty()) {
        root = node;
        return;
    }
    Node cu = root;
    Node father = null;
    while (cu != null) {
        if (cu.info.sound == xSound) return;
        father = cu;
        if (cu.info.sound < xSound) cu = cu.right;
        else if (cu.info.sound > xSound) cu = cu.left;
    }
    assert(father != null);
    if (father.info.sound > xSound) father.left = node;
    else father.right = node;
  }

  //Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    inOrder(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  void preOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) return;
    if (p.info.rate < 6) fvisit(p, f);
    preOrder2(p.left, f);
    preOrder2(p.right, f);
  }
  
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    preOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    preOrder2(root, f);
    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  int count = 0;
  Node q123;
  void preOrder3(Node p, RandomAccessFile f) throws Exception {
    if (p == null) return;
    ++count;
    if (count == 4) q123 = p;
    preOrder3(p.left, f);
    preOrder3(p.right, f);
  }
  
  void deleteByCopy(Node x) {
    Node f, p;
    f = null;
    p = root;
    while (p != null) {
      if (p.info.sound == x.info.sound) break;
      f = p;
      if (x.info.sound < p.info.sound) p = p.left; else p = p.right;
    }
    if (p == null) return; // not found    
    if (p.left == null && p.right == null) { // p is a leaf node
      if (f == null) { // p is root
        root = null;
        return;
      }
      if (p == f.left) f.left = null; else f.right = null;
    }    
    if (p.left != null && p.right == null) { // p has left son only
      if (f == null) { // p is root
        root = p.left;
        return;
      }
      if (p == f.left) f.left = p.left; else f.right = p.left;
    }   
    if (p.left == null && p.right != null) { // p has right son only
      if (f == null) { // p is root
        root = p.right;
        return;
      }
      if (p == f.left) f.left = p.right; else f.right = p.right;
    }   
    if (p.left != null && p.right != null) { // p has both 2 sons
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
      if (frp == null) p.left = q.left; else frp.right = rp.left;
    }
  }
  
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    preOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    q123 = null;
    preOrder3(root,f);
    deleteByCopy(q123);
    //------------------------------------------------------------------------------------
    preOrder(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  Node getParent(Node p) {
    if (p == root) return null;
    Node father = null, cu = root;
    while (cu != null && cu.info.sound != p.info.sound) {
      father = cu;
      if (cu.info.sound < p.info.sound) cu = cu.right; else cu = cu.left;
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
      if (father.info.sound > p.info.sound) father.left = c;
      else father.right = c;
    }
  }
  
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    preOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    q123 = null;
    preOrder3(root,f);
    rotateLeft(q123);
    //------------------------------------------------------------------------------------
    preOrder(root, f);
    f.writeBytes("\r\n");
    f.close();
  }
}
