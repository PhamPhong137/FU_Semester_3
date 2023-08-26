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
    if (p != null) f.writeBytes(p.info + " ");
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
    for (int i = 0; i < n; i++) addLast(a[i], b[i], c[i]);
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
  /* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xForest, int xRate, int xSound) {
    //You should write here appropriate statements to complete this function.
    if (xForest.charAt(0) == 'A');
    else {
      Node p = new Node(new Bee(xForest, xRate, xSound));
      if (head == null) head = tail = p;
      else {
        tail.next = p;
        tail = p;
      }
    }
  }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    f.close();
  }

  //==================================================================
  int size() {
    Node cur = head;
    int k = 0;
    while (cur != null) {
      k++;
      cur = cur.next;
    }
    return k;
  }
  
  void addFirst(String xForest, int xRate, int xSound) {
    Node node = new Node(new Bee(xForest, xRate, xSound));
    if (isEmpty()) {
      head = tail = node;
    } else {
      node.next = head;
      head = node;
    }
  }
  
  void addAfterIndex(String xForest, int xRate, int xSound, int index) {
    if (index < 0) {
      addFirst(xForest, xRate, xSound);
      return;
    }
    if (index >= size()) {
      addLast(xForest, xRate, xSound);
      return;
    }
    int count = 1;
    Node cur = head;
    while (cur != null && count != index) {
      count++;
      cur = cur.next;
    }
    if (cur != null) {
      Node node = new Node(new Bee(xForest, xRate, xSound));
      node.next = cur.next;
      cur.next = node;
    }
  }
  
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    Bee x, y;
    x = new Bee("X", 1, 2);
    y = new Bee("Y", 3, 4);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    addAfterIndex(x.forest, x.rate, x.sound, 1);
    addAfterIndex(y.forest, y.rate, y.sound, 1);
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
  void delete() {
    if (head == null || head.next == null) return;
    head.next = head.next.next;
  }
  
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    delete();
    delete();
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
  Node pos(int k) {
    int i = 1;
    Node p = head;
    while (p != null) {
      if (i == k) return (p);
      i++;
      p = p.next;
    }
    return (null);
  }
  
  void sort(int k, int h) {
    if (k > h) return;
    if (k < 1) k = 1;
    int n = size();
    if (h > n) h = n;
    Node u = pos(k);
    Node v = pos(h + 1);
    Node pi, pj;
    Bee x;
    for (pi = u; pi != v; pi = pi.next) {
      for (pj = pi.next; pj != v; pj = pj.next) {
        if (pj.info.sound < pi.info.sound) {
          x = pi.info;
          pi.info = pj.info;
          pj.info = x;
        }
      }        
    }
  }
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    sort(1, 5);
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }
}
