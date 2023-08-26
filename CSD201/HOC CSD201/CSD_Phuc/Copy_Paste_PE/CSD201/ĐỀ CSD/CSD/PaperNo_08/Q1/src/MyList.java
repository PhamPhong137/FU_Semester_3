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
    /* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
   void addLast(Castor x)
   {//You should write here appropriate statements to complete this function.
    Node q = new Node(x);
    if(isEmpty())
     head=tail=q;
     else
     {tail.next=q;
      tail=q;
     }
   }

    void addLast(String xPlace, int xDepth, int xType) {
       if(xPlace.charAt(0)=='A' ) return;
    Castor x = new Castor(xPlace, xDepth, xType);
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
  void addFirst(Castor x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    void addAfter(Node p, Castor x) {
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

    void insert(Castor x, int index) {
        int count = 0;
        Node p = head;
        while (p.next != null) {
            if (index == 0) {
                this.addFirst(x);
                break;
            }
            if (count == index - 1) {
                this.addAfter(p, x);
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
        Castor x, y;
        x = new Castor("X", 1, 2);
        y = new Castor("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        insert(x, 2);
        insert(y, 0);
        
        ftraverse(f);
        f.close();
    }

    //==================================================================
int MaxAgeN(int n) {
        Node p = head;
        int max = -1;
        if (n == 1) {
            max = p.info.type;
            while (p.next != null) {
                if (p.next.info.type > max) {
                    max = p.next.info.type;
                }
                p = p.next;
            }
        }
        else {
            p = head;
            int maxN = MaxAgeN(n-1);
            while(p!=null) {
                if (p.info.type<maxN) {
                    max = p.info.type;
                }
                p=p.next;
            }
            p=head;
            while (p.next != null) {
                if (p.next.info.type > max && p.next.info.type<maxN) {
                    max = p.next.info.type;
                }
                p = p.next;
            }
        }
        return max;
    }
    void max1(){
        int max = MaxAgeN(1);//edit here // lon thu may thi sua o day
        Node p = head;
        while(p!= null){
            if(max == p.info.type){
                p.info.place ="YY"; //edit here
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
         max1();
        ftraverse(f);
        f.close();
    }
void sort(int startIndex, int endIndex) {       
        int count = 0,m=0;
        Castor tmp;
        Node p = head,i;
        while (p.next != null) {
            if (count == startIndex) {
                for (; p != null; p = p.next) {
                    int n=0;
                    for (i = p.next; i != null; i = i.next) {
                        if (p.info.depth < i.info.depth) {
                            tmp = p.info;
                            p.info = i.info;
                            i.info = tmp;
                        }
                        n++;
                        if (m+n==endIndex-startIndex) {
                            break;
                        }
                    }
                    if (m+1==endIndex-startIndex) {
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
    //==================================================================
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

        //------------------------------------------------------------------------------------
        sort(2, 5);
        ftraverse(f);
        f.close();
    }
}
