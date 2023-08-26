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
  void addLast(String xOwner, int xPrice) { //You should write here appropriate statements to complete this function.
    if (xOwner.startsWith("B") || xPrice > 100) return;
    Node x = new Node(new Car(xOwner, xPrice));
    if (head == null) head = tail = x; else {
      tail.next = x;
      tail = x;
    }
  }

  void f1()
    throws Exception {/* You do not need to edit this function. Your task is to complete the addLast function above only. */
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
    Node p = new Node(x);
    if (head == null) head = tail = p; else {
      p.next = head;
      head = p;
    }
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
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
    Node p = head;
    while (p != null) {
      if (p.next.info.price == 5) {
        p.next = p.next.next;
        break;
      }
      p = p.next;
    }
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
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
    Node i = head, j;
    String tmp_s;
    int tmp_i;
    while (i != null) {
      j = head;
      while (j.next != null) {
        if (j.info.price > j.next.info.price) {
          tmp_s = j.info.owner;
          tmp_i = j.info.price;
          j.info.owner = j.next.info.owner;
          j.info.price = j.next.info.price;
          j.next.info.owner = tmp_s;
          j.next.info.price = tmp_i;
        }
        j = j.next;
      }
      i = i.next;
    }
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }
}
