/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class MyList {

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
    int n = a.length;
    for (int i = 0; i < n; i++) addLast(a[i], b[i]);
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
  void addLast(Car x) {
    Node q = new Node(x);
    if (isEmpty()) {
      head = tail = q;
      return;
    }
    tail.next = q;
    tail = q;
  }

  void addLast(String xOwner, int xPrice) { //You should write here appropriate statements to complete this function.
    if (xOwner.charAt(0) == 'B' || xPrice > 100) return;
    addLast(new Car(xOwner, xPrice));
  }

  void f1()
    throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
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
  void addFirst(Car x) {
    Node q = new Node(x);
    if (isEmpty()) {
      head = tail = q;
      return;
    }
    q.next = head;
    head = q;
  }

  void f2() throws Exception {
    clear();
    loadData(4);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    Car x = new Car("X", 1);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    addFirst(x);

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
  Node searchByPrice(int xPrice) {
    Node p = head;
    while (p != null) {
      if (p.info.price == xPrice) return (p);
      p = p.next;
    }
    return (null);
  }

  void removeFirst() {
    if (isEmpty()) {
      return;
    }
    head = head.next;
    if (head == null) {
      tail = null;
    }
  }

  void remove(Node q) { //tim node đứng trước rồi nối nó với node đứng sau
    if (q == null) {
      return;
    }
    if (q == head) {
      removeFirst();
      return;
    }
    Node f = head;
    while (f != null && f.next != q) {
      f = f.next;
    }
    if (f == null) return; else {
      f.next = q.next;
    }
    if (f.next == null) { //neu f la node cuoi cung sau khi xoa
      tail = f;
    }
  }

  void removeByPrice(int xPrice) {
    Node p = searchByPrice(xPrice);
    remove(p);
  }

  void f3() throws Exception {
    clear();
    loadData(7);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    removeByPrice(5);

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
  void sortByPrice() {
    Node pi, pj;
    pi = head;
    while (pi != null) {
      pj = pi.next;
      while (pj != null) {
        if (pi.info.price > pj.info.price) {
          Car temp = pi.info;
          pi.info = pj.info;
          pj.info = temp;
        }
        pj = pj.next;
      }
      pi = pi.next;
    }
  }

  void f4() throws Exception {
    clear();
    loadData(10);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    sortByPrice();

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }
}
