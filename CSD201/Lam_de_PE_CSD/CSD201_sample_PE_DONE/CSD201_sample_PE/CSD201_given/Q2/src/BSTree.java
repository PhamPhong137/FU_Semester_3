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

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xOwner, int xPrice) {//You should insert here statements to complete this function
        Node q = new Node(new Car(xOwner, xPrice));
        if (isEmpty()) {
            root = q;
            return;
        }
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.price == xPrice) {
                return;
            }
            f = p;
            if (xPrice < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (xPrice < f.info.price) {
            f.left = q;
        } else {
            f.right = q;
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
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.price >= 3 && p.info.price <= 5) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);

    }

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    void f3() throws Exception {
        clear();
        loadData(7);
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
        breadth2(root, f);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();

            if (r.left != null && r.right != null && r.info.price < 7) {
                deleteNode(r);
                return;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void deleteNode(Node p) {
        if (root == null) {
            System.out.println("The tree is empty, no deletion");
            return;
        }
        Node f; // f will be the father of p
        f = null;
        Node temp = root;
        while (temp != null) {
            if (temp == p) {
                break; // Found Node p
            }
            if (p.info.price < temp.info.price) {
                f = temp;
                temp = temp.left;
            } else {
                f = temp;
                temp = temp.right;
            }
        }
        if (temp == null) {
            System.out.println("The node does not exist, no deletion");
            return;
        }
        if (temp.left == null && temp.right == null) // p is a leaf node
        {
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == temp) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }

        if (temp.left != null && temp.right == null) // p has only left child
        {
            if (f == null) // p is a root
            {
                root = temp.left;
            } else {
                if (f.left == temp) // p is a left child
                {
                    f.left = temp.left;
                } else {
                    f.right = temp.left;
                }
            }
            return;
        }

        if (temp.left == null && temp.right != null) // p has only right child
        {
            if (f == null) // p is a root
            {
                root = temp.right;
            } else {
                if (f.left == temp) // p is a left child
                {
                    f.left = temp.right;
                } else {
                    f.right = temp.right;
                }
            }
            return;
        }

        if (temp.left != null && temp.right != null) // p has both left and right children
        {
            Node rp; // p's key will be replaced by rp's one
            f = null;
            rp = temp.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            // Find the rightmost node on the left sub-tree

            temp.info = rp.info;
            if (f == null) // rp is just a left son of p 
            {
                temp.left = rp.left;
            } else {
                f.right = rp.left;
            }
        }
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(10);
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
        breadth3(root, f);

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    public void rotateModifier(Node node) {
        Node nodeRotate = rotateToRight(node);
        Node nodeFather = father(node.info.price);
        if (nodeFather == null) {
            root = nodeRotate;
        } else {
            if (nodeFather.left == node) {
                nodeFather.left = nodeRotate;
            } else {
                nodeFather.right = node;
            }
        }
    }
    Node father(int xPrice) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.price == xPrice) {
                break;
            }
            f = p;
            if (xPrice < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (f);
    }

    Node breadth3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return null;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && r.info.price < 7) {
                rotateModifier(r);
                break;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
        return null;
    }

    Node rotateToRight(Node p)//root = rotateToRight(root)
    {
        if (p == null || p.left == null) {
            return (p);
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return (q);
    }
}
