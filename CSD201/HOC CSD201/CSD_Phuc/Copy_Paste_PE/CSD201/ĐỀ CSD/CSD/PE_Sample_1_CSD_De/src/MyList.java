/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception
   {if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception
   {Node p = head;
    while(p!=null)
      {fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadDataToLast(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i]);
   }

  void loadDataToFirst(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addFirst(a[i],b[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addLast(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
       if(xName.charAt(0)!='B'){
       Person x = new Person(xName, xAge);
       Node q = new Node(x);
        if(isEmpty()) {head=tail=q;return;}
        tail.next = q;
        tail = q;
       }
   }

  void addFirst(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
       if(xName.charAt(0)!='B'){
           Person x = new Person(xName, xAge);
           head = new Node(x,head);
           if(tail==null) tail=head;
       }
   }

//=================================================================
  
  
  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadDataToLast(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void f2() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addFirst  function
        above only.
     */
     clear();
     loadDataToFirst(1);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  
  void f3() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);

    MyList  h = new MyList();
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       Node p = head;
       while (p!=null) {           
           if(p.info.age>4) {
               h.addLast(p.info.name, p.info.age);
           }
        p=p.next;
       }

    //-------------------------------------------------------------------------------------
    h.ftraverse(f123);
    f123.close();
   }

//=================================================================
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
  
  void f4() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node f = head;
    while(f!=null){
        if(f.info.age<6){
            remove(f);
            break;
        }
        f=f.next;
    }

    //-------------------------------------------------------------------------------------
     ftraverse(f123);
     f123.close();
   }

//=================================================================
  void sortByName()
     {Node pi,pj; Person x;
      for(pi=head;pi!=null;pi=pi.next) 
        for(pj=pi.next;pj!=null;pj=pj.next)
          if(pj.info.name.compareTo(pi.info.name)<0){
            x=pi.info;pi.info=pj.info;pj.info=x;
          }  
     }
  
  void f5() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    sortByName();

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }


//=================================================================
  void reverse()
     {MyList t=new MyList();
      Node p=head;
      while(p!=null) {
        t.addFirst(p.info.name,p.info.age);
        p=p.next;
      }
      head=t.head;
      tail=t.tail;
     }
  
  void f6() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    reverse();

    //--------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f7() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f7.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    MyList h = new MyList();
    h.loadDataToLast(7);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node f= h.head;
       while (f!=null) {           
           addLast(f.info.name, f.info.age);
           f=f.next;
       }

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
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

   // (11)
   void removePos(int k)
     {Node q=pos(k);
      remove(q);
     }
  
  void f8() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f8.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    int k = 3;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       removePos(3);

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void setData(Node p, String xName)
     {if(p!=null) p.info.name=xName;
     }
  
  void f9() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f9.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    String xName = "C6";
    String yName = "CX";
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node p = head;
    while(p!=null){
        if(p.info.name.equals(xName)){
            setData(p, yName);
            break;
        }
        p=p.next;
    }

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

 }
