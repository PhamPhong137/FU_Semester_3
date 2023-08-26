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
    int[] c = Lib.readLineToIntArray("data.txt", k + 2);
    int n = a.length;
    for (int i = 0; i < n; i++) addLast(a[i], b[i], c[i]);
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
  void addLast(String xCode, int xType, int xPrice) { //You should write here appropriate statements to complete this function.
    if (xCode.startsWith("B") || xPrice > 100) return;
    Node x = new Node(new Corn(xCode, xType, xPrice));
    if (head == null) head = tail = x;
    else {
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
    
    // Add first node
    public void addFirst(String code, int type, int price) {
	Node node = new Node(new Corn(code, type, price));
	if (isEmpty()) {
            head = tail = node;
	}
	else {
            node.next = head;
            head = node;
	}
    }

    // Add node after a specific node
    public void addIndex(String code, int type, int price, int index) {
	if (index <= 0) {
            addFirst(code, type, price);
            return;
	}
	int count = 0;
	Node cur = head;
	while (cur != null && count != index-1) {
            count++;
            cur = cur.next;
	}
	if (cur == null) {}
        else {
            Node node = new Node(new Corn(code, type, price));
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
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
          Your task is to insert statements here, just after this comment,
          to complete the question in the exam paper.*/
    addIndex("Y", 3, 4, 2);
    addIndex("X", 1, 2, 2);
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
    void maxType() {
        Node cur = head;
        Node res = null;
        int max = -1;
        while (cur != null) {
            if (cur.info.type > max) {
                res = cur;
                max = cur.info.type;
            }
            cur = cur.next;
        }
        if (res.next != null) res.next = res.next.next;
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
    maxType();
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
    public Node get(int index) {
        Node cur = head;
        for (int i = 2; i <= index; i++) {
            cur = cur.next;
        }
        return cur;
    }
  
    void sort(int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = i+1; j <= end; j++) {
                if (get(i).info.type < get(j).info.type) {
                    Corn tmp = get(i).info;
                    get(i).info = get(j).info;
                    get(j).info = tmp;
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
    sort(1, 4);
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }
}
