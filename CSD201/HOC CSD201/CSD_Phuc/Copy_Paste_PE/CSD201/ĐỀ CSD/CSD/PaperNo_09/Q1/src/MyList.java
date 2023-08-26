/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class MyList {

  Node head, tail;

  MyList() {
    head = tail = null;
  }

  boolean isEmpty() {
    return (head == null);
  }

  void clear() {
    head = tail = null;
  }

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if (p != null) {
      f.writeBytes(p.info + " ");
    }
  }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while (p != null) {
      fvisit(p, f); // You will use this statement to write information of the node p to the file
      p = p.next;
    }
    f.writeBytes("\r\n");
  }

  void loadData(int k) { //do not edit this function
    String[] a = Lib.readLineToStrArray("data.txt", k);
    int[] b = Lib.readLineToIntArray("data.txt", k + 1);
    int[] c = Lib.readLineToIntArray("data.txt", k + 2);
    int n = a.length;
    for (int i = 0; i < n; i++) {
      addLast(a[i], b[i], c[i]);
    }
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
  /* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
 

  void addLast(String xMaker, int xType, int xRadius) {
    //You should write here appropriate statements to complete this function.
    
  }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    f.close();
  }

  //==================================================================
  void insertFirst(Castor x) {
    Node p = new Node(x);
    if (isEmpty()) head = tail = p; else {
      p.next = head;
      head = p;
    }
  }

  void insertAfter(Node q, Castor x) {
    if (isEmpty() || q == null) {
      insertFirst(x);
      return;
    }
    Node q1 = q.next;
    Node p = new Node(x, q1);
    q.next = p;
    if (tail == q) tail = p;
  }

  Node pos(int k) {
    int i = 0;
    Node p = head;
    while (p != null) {
      if (i == k) return (p);
      i++;
      p = p.next;
    }
    return (null);
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
    ftraverse(f);
    Castor x, y;
    x = new Castor("X", 1, 2);
    y = new Castor("Y", 3, 4);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    insertAfter(pos(1), y);
    insertAfter(pos(-1), x);
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
  Node maxDepth() {
    int maxDepth = -9999999;
    int maxPos = -1;
    int k = 0;
    Node cur = head;
    while (cur != null) {
      if (cur.info.radius > maxDepth) {
        maxPos = k;
        maxDepth = cur.info.radius;
      }
      cur = cur.next;
      ++k;
    }
    return pos(maxPos - 1);
  }

  void change(Node p) {
    p.info.maker = "XX";
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
    ftraverse(f);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    change(maxDepth());

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
  void sortByType(int k, int h) {
    if (k > h) return;
    if (k < 0) k = 0;
    int n = size();
    if (h > n - 1) h = n - 1;
    Node u = pos(k);
    Node v = pos(h + 1);
    Node pi, pj;
    Castor x;
    for (pi = u; pi != v; pi = pi.next) for (
      pj = pi.next;
      pj != v;
      pj = pj.next
    ) if (pj.info.type < pi.info.type) {
      x = pi.info;
      pi.info = pj.info;
      pj.info = x;
    }
  }

  int size() {
    int i = 0;
    Node p = head;
    while (p != null) {
      i++;
      p = p.next;
    }
    return (i);
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
    ftraverse(f);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    sortByType(2, 5);
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }
}
