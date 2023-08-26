/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {
    
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
    
    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }
    
    void fvisitBal(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes("(" + p.info.name + "," + p.info.age + "," + p.bal + ") ");
        }
    }
    
    void fvisitLevel(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes("(" + p.info.name + "," + p.info.age + "," + p.level + ") ");
        }
    }
    
    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }
    
    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }
    
    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }
    
    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    
    void breadthBal(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitBal(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    
    void breadthLevel(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitLevel(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    
    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//===========================================================================
    void insert(Person x) {
        if(isEmpty()) {
            root=new Node(x);
            return;
        }
        Node f,p;
        f=null;p=root;
        while(p!=null) {
            if(p.info.name.compareTo(x.name)==0) {
                return;
            }
            f=p;
            if(x.name.compareTo(p.info.name)<0)
                p=p.left;
            else
                p=p.right;
        }
        if(x.name.compareTo(f.info.name)<0) 
            f.left = new Node(x);
        else
            f.right=new Node(x);
    }
    
    void insert(String xName, int xAge) {
        if (xName.charAt(0)!='B') {
            insert(new Person(xName, xAge));
        }
    }
    
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        inOrder(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    void insert3(String xName, int xAge) {
        if (xAge>4) {
            insert(new Person(xName, xAge));
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
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        BSTree h = new BSTree();
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        MyQueue q = new MyQueue();
        q.enqueue(root);Node r;
        while(!q.isEmpty())
        {r = q.dequeue();
        if(r.info.age>4) h.insert(r.info.name, r.info.age);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
        }

        //-------------------------------------------------------------------------------------
        h.preOrder(h.root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    int height(Node p) {
        if (p == null) {
            return 0;
        }
        int leftHeight, rightHeight, height;
        leftHeight = height(p.left);
        rightHeight = height(p.right);
        height = leftHeight > rightHeight ? leftHeight : rightHeight;
        return height + 1;
    }
    
    void f3() throws Exception {
        clear();
        loadData(5);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        int k = 0;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        k = height(root);

        //-------------------------------------------------------------------------------------
        f123.writeBytes(" k = " + k + "\r\n");
        f123.close();
    }

//===============================================================
    int count(Node p) {
       MyQueue q = new MyQueue();
       int count=0;
       q.enqueue(p); Node r;
       while(!q.isEmpty()) {
         r=q.dequeue();
         count++;
         if(r.left!=null) q.enqueue(r.left);
         if(r.right!=null) q.enqueue(r.right);
       }
       return count;
    }
    
    void f4() throws Exception {
        clear();
        loadData(5);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        int k = 0;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        k=count(root);
        //-------------------------------------------------------------------------------------
        f123.writeBytes(" k = " + k + "\r\n");
        f123.close();
    }

//===============================================================
    void deleByCopy(String x) {
        if (isEmpty()) {
            return;
        }

        //b1 : tìm node cần xóa
        Node f, p;//f là cha của p
        f = null;
        p = root;
        while (p != null) {
            if (p.info.name.compareTo(x)==0) {//tìm thấy node có giá trị bằng x
                break;
            }
            f = p;
            if (x.compareTo(p.info.name) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;//không tìm thấy giá trị x
        }
        //p là không có con
        if (p.left == null && p.right == null) {
            if (f == null) {//p là root
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }
        //p có 1 con(trái hoặc phải)
        //có 2TH:
        //th1: p có con trái
        if (p.left != null && p.right == null) {
            if (f == null) { //p là root
                root = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        //th2: p có con phải
        if (p.right != null && p.left == null) {
            if (f == null) { //p là root
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        //p có cả hai con
        if (p.left != null && p.right != null) {
            Node q = p.left;
            //tìm node bên phải nhất của nửa bên trái tính từ node q
            Node frp, rp; //frp là cha của rp, rp là node phải nhất
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }

            p.info = rp.info;

            //xóa số 40 đi
//            deleByCopy(rp.info);
            if (frp == null) {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }

        }
    }
    
    void f5() throws Exception {
        clear();
        loadData(5);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        String xName = root.info.name;
        deleByCopy(xName);
        //-------------------------------------------------------------------------------------
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    Node rotateRight(Node p) {
     if(p==null || p.left==null) return(p);
     Node q=p.left;
     p.left=q.right;
     q.right=p;
     return(q);
   }
    
    
    
    void f6() throws Exception {
        clear();
        loadData(5);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        if(root.left!=null){
            root = rotateRight(root);
        }
        //-------------------------------------------------------------------------------------
        breadth(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    void f7() throws Exception {
        clear();
        loadData(5);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        MyQueue q = new MyQueue();
        q.enqueue(root); Node r;
        int mark = 1;
        while(!q.isEmpty()) {
         r=q.dequeue();
         r.bal = height(r.right)-height(r.left);
         if(height(r.right)-height(r.left)>=2 || height(r.right)-height(r.left)<=-2) mark = 0;
         if(r.left!=null) q.enqueue(r.left);
         if(r.right!=null) q.enqueue(r.right);
        }
        
        breadthBal(root, f123);
        if(mark == 1){
            f123.writeBytes("\r\nThe tree is an AVL tree\r\n");
        }else {
            f123.writeBytes("\r\nThe tree is not an AVL tree\r\n");

        }
        
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    void f8() throws Exception {
        clear();
        loadData(5);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        MyQueue q = new MyQueue();
        root.level=1;
        q.enqueue(root); Node r;
        while(!q.isEmpty()) {
         r=q.dequeue();
         if(r.left!=null) r.left.level=r.level+1;
         if(r.right!=null) r.right.level=r.level+1;
         if(r.left!=null) q.enqueue(r.left);
         if(r.right!=null) q.enqueue(r.right);
        }
        
        breadthLevel(root, f123);
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    void inOrder(ArrayList<Person> t, Node p) {
     if(p==null) return;
     inOrder(t,p.left);
     t.add(p.info);
     inOrder(t,p.right);
   }
   void balance(ArrayList<Person> t, int i, int j) {
       if(i>j) return;
       int k = (i+j)/2;
       Person x = t.get(k);
       insert(x);
       balance(t,i,k-1);
       balance(t,k+1,j);
   }
   void bal() {
    ArrayList<Person> t = new ArrayList<>();
    inOrder(t,root);
    clear();
    int n=t.size();
    balance(t,0,n-1);
   }
    
    void f9() throws Exception {
        clear();
        loadData(5);
        String fname = "f9.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        bal();
        breadth(root, f123);
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }
    
}
