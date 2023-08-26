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

    void loadData(int k) //do not edit this function
    {
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
//==================================================================
    void addLast(Corn x)
     {Node q = new Node(x);
       if(isEmpty()) {head=tail=q;return;}
       tail.next = q;
       tail = q;
     }
    
    void addLast(String xCode, int xType, int xPrice) {//You should write here appropriate statements to complete this function.
       if(xCode.charAt(0)=='B') return;
        addLast(new Corn(xCode, xType, xPrice));
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(2);
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
    
    
    void insertAfter(Node q, Corn x){
       if(isEmpty() || q==null) return;
       Node q1=q.next;
       Node p=new Node(x,q1);
       q.next=p;
       if(tail==q) tail=p;
     }
    
    Node pos(int k)
     {int i=0;
      Node p=head;
      while(p!=null) {
        if(i==k) return(p);
        i++;
        p=p.next;
      }
      return(null);
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
        ftraverse(f);
        Corn x, y;
        x = new Corn("X", 1, 2);
        y = new Corn("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insertAfter(pos(1), y);
        insertAfter(pos(1), x);
        

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public Node getNode(int i) {
        int count = 0;
        Node p = head;
        while (count < i) {
            count++;
            p = p.next;
        }
        return p;
    }

//==================================================================
    int findMax()
     {Node p=head;
     int max = p.info.type;
       while(p!=null){
           if(p.info.type>max) max = p.info.type;
           p=p.next;
         }
      System.out.println();
      return max;
     }
    
    Node searchByType(int xType)
     {Node p=head;
       while(p!=null)
        {if(p.info.type==xType) return(p);
          p=p.next;
        }
       return(null);
     }
    
    void removeFirst() {
      if(isEmpty()) return;
      head=head.next;
      if(head==null) tail=null;
   }
    
    void remove(Node q)
     {if(isEmpty() || q==null) return;
      if(q==head) {
         removeFirst();
         return;
      }
       Node f=head;
       while(f!=null && f.next!=q) f=f.next;
       if(f==null) return; // q is not in the list
       Node q1=q.next;
       f.next=q1;
       if(f.next==null) tail=f;
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
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        int max = findMax();
        Node q = searchByType(max);        
        remove(q.next);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    int size()
     {int i=0;
      Node p=head;
      while(p!=null) {
         i++;
         p=p.next;
      }
      return(i);
     }
    
    void sortByType(int  k, int h)
     {if(k>h) return;
      if(k<0) k=0;
      int n=size();
      if(h>n-1) h=n-1;
      Node u=pos(k);
      Node v=pos(h+1);
      Node pi,pj; Corn x;
      for(pi=u;pi!=v;pi=pi.next) 
        for(pj=pi.next;pj!=v;pj=pj.next)
          if(pj.info.type>pi.info.type) {
            x=pi.info;pi.info=pj.info;pj.info=x;
          }
    
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
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sortByType(0, 3);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
