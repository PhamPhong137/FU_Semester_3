/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

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
    void addLast(Ball x) {//You should write here appropriate statements to complete this function.
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    void addLast(String xMaker, int xType, int xRadius) {
        //You should write here appropriate statements to complete this function.
        if (xMaker.charAt(0) == 'B') {
            return;
        }
        Ball x = new Ball(xMaker, xType, xRadius);
        addLast(x);
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
    void addAfterP(Node p, Ball x) {
        Node p1 = new Node(x);
        if (isEmpty()) {
            return;
        }
        p1.next = p.next;
        p.next = p1;
        if (p == tail) {
            tail = p1;
        }
    }

    void insert(Ball x, int position) {
        int count = 0;
        Node p = head;
        while (p.next != null) {
            if (count == position - 1) {
                this.addAfterP(p, x);
                break;
            }
            count++;
            p = p.next;
        }
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
        Ball x, y;
        x = new Ball("X", 1, 2);
        y = new Ball("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insert(x, 2);
        insert(y, 3);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    /* void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void delete(Node q) {
        if (isEmpty() || q == null) {
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
        if (f == null) {
            return;
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    int maxType() {
        Node p = head;
        int max = p.info.type;
        while (p != null) {
            if (p.info.type > max) {
                max = p.info.type;
            }
            p = p.next;
        }
        return max;
    }*/
    void max() {
        Node p = head;
        int max = p.info.type;
        while (p.next != null) {
            if (p.next.info.type > max) {
                max = p.next.info.type;
            }
            p = p.next;
        }
        dele(max);
    }

    Node beforeNode(Node q) {
        Node f = head;
        while (f.next != q) {
            f = f.next;
        }
        return f;
    }

    void remove(Node q) {
        if (isEmpty()) {
            return;
        }
        if (q == head) {//a b 
            head = q.next;
            return;
        }
        if (q == null) {
            return;
        }
        beforeNode(q).next = q.next;
    }

    void dele(int max) {
        Node p = head;
        if (isEmpty()) {
            return;
        }
        int count = 0;
        while (p.next != null) {
            if (p.info.type == max) {
                count++;
            }
            if (count == 2) { // edit here
                remove(p);
                break;
            }
            p = p.next;

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
        ftraverse(f);
        max();
        ftraverse(f);
        f.close();
    }

//==================================================================
    void sort(int startIndex, int endIndex) {
        int count = 0, m = 0;
        Ball tmp;
        Node p = head, i;
        while (p.next != null) {
            if (count == startIndex) {
                for (; p != null; p = p.next) {
                    int n = 0;
                    for (i = p.next; i != null; i = i.next) {
                        if (p.info.type < i.info.type) {
                            tmp = p.info;
                            p.info = i.info;
                            i.info = tmp;
                        }
                        n++;
                        if (m + n == endIndex - startIndex) {
                            break;
                        }
                    }
                    if (m + 1 == endIndex - startIndex) {
                        break;
                    }
                    m++;
                }
                break;
            }
            count++;
            p = p.next;
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
        ftraverse(f);

        sort(0, 3); //edit here
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
