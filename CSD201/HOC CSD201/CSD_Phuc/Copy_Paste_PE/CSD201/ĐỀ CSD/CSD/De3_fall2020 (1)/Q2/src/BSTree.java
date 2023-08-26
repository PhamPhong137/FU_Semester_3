/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

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

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
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
        Queue q = new Queue();
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

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(Ball x) {
        Node q = new Node(x);
        if (root == null) {
            root = q;
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info.type == x.type) {
                return;
            }
            if (x.type < p.info.type) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (x.type < f.info.type) {
            f.left = q;
        } else {
            f.right = q;
        }
    }

    void insert(String xMaker, int xType, int xRadius) {
        if (xMaker.charAt(0) == 'B') {
            return;
        }
        Ball x = new Ball(xMaker, xType, xRadius);
        insert(x);
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    /*void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        if(p.info.radius<5) fvisit(p, f);
    }
     */
    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        //edit here
        if (p.info.radius < 5) {
            fvisit(p, f);
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
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        postOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    /* Node q123=null;
    int count=0;
    
    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
         if (p.left != null && p.right != null && count == 0) {
            q123=p;
            count++;
            return;
         }
        inOrder2(p.right, f);
        return;
    }
    
    void deleByCopy(int x) {
      Node f,p;
      f=null; p=root;
      while(p!=null) {
        if(p.info.type==x) break;
        f=p;
        if(x<p.info.type)
            p=p.left;
          else
            p=p.right;
      }
      if(p==null) return; // not found
      // p is a leaf node
      if(p.left==null && p.right==null) {
         if(f==null) { // p==root
           root=null;
           return;
         }
        if(p==f.left)
            f.left=null;
           else
            f.right=null;
      }
      // p has left son only
      if(p.left!=null && p.right==null) {
         if(f==null) { // p==root
           root=p.left;
           return;
         }
        if(p==f.left)
            f.left=p.left;
           else
            f.right=p.left;
      }
      // p has right son only
      if(p.left==null && p.right!=null) {
         if(f==null) { // p==root
           root=p.right;
           return;
         }
        if(p==f.left)
            f.left=p.right;
           else
            f.right=p.right;
      }
      // p has both 2 sons
      if(p.left!=null && p.right!=null) {
         Node q=p.left;
         // find the right-most node in the left sub-tree
         Node frp,rp;
         frp=null;rp=q;
         while(rp.right!=null) {
           frp=rp;
           rp=rp.right;
         }
         p.info=rp.info;
         if(frp==null) { // rp==q
            p.left=q.left;             
         }
         else {
           frp.right=rp.left;
         }
      }
      
   }*/
    int count = 0;

    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if (p.left != null && p.right != null && count == 0) {
            count++;
            deleByCopy(p.info.type);

        }
        inOrder2(p.right, f);
    }

    void deleByCopy(int xPrice) {
        if (root == null) {
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        Node f, p; // f will be the father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info.type == xPrice) {
                break;//Found key x
            }
            if (xPrice < p.info.type) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + xPrice + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null) // p is a leaf node
        {
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }

        if (p.left != null && p.right == null) // p has only left child
        {
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        if (p.left == null && p.right != null) // p has only right child
        {
            if (f == null) // p is a root
            {
                root = p.right;
            } else {
                if (f.left == p) // p is aleft child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        if (p.left != null && p.right != null) // p has both left and right children
        {
            Node q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            q = p.left;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right; // Find the right most node on the left sub-tree
            }
            p.info = rp.info;
            if (fr == null) // rp is just a left son of p 
            {
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
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
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        // q123=null;
        // inOrder2(root, f);
        // deleByCopy(q123.info.type);
        //------------------------------------------------------------------------------------

        inOrder2(root, f);
       
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    int count1 = 0;
    void inOrder3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder3(p.left, f);
       if (p.left != null && p.right != null && count1 == 0) {
            count1++;
           rotateLeft(p);
         
            
       }
        inOrder3(p.right, f);
    }
    
     Node parent(Node ch) {
        if (ch == root || ch == null) {
            return null;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.type == ch.info.type) {
                break;
            }
            parent = p;
            if (p.info.type > ch.info.type) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return parent;
    }
     void rotateLeft(Node par) {
        if (par == null || par.right == null) {
            return;
        }
        Node ch = par.right;
        par.right = ch.left;
        ch.left = par;
        if (parent(par) == null) {
            root = ch;
            return;
        }
        if (parent(par).left == par) {
            parent(par).left = ch;
        } else {
            parent(par).right = ch;
        }
    }

    
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        //q123=null;
        //inOrder2(root, f);

        //Node r = rotateLeft(q123);
        //Node fa = father2(q123.info.type);
        //if(fa==null) root = r;
        //else {
        //   if(fa.left==q123) fa.left=r;
        // else fa.right=r;
        //}
        //------------------------------------------------------------------------------------
        inOrder3(root, f);
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
