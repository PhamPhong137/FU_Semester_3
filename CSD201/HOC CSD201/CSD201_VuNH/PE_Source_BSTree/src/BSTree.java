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

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.price >= 4 && p.info.price <= 7) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
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

    void breadthF3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
//            fvisit(r, f);
            if (r.left != null && r.right != null && r.info.price < 7) {
                temp = r;
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

    void breadthF4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && r.info.price < 7) {
                temp = r;
                return;
            }
//            fvisit(r, f);
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
    Node temp;
    int count;

    void insert(String xOwner, int xPrice) {//You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'A' || xPrice > 100) {

        } else {
            Car newCar = new Car(xOwner, xPrice);
            Node x = new Node(newCar);
            if (isEmpty()) {
                root = x;
            } else {
                Node p = root;
                Node parent = p;
                while (p != null) {
                    if (x.info.price < p.info.price) {
                        parent = p;
                        p = p.left;
                    } else if (x.info.price > p.info.price) {
                        parent = p;
                        p = p.right;
                    } else {
                        return;
                    }
                }
                if (x.info.price < parent.info.price) {
                    parent.left = x;
                } else if (x.info.price > parent.info.price) {
                    parent.right = x;
                }
            }
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
        temp = root;
        breadthF3(root, f);
        removebyCopyL(temp);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
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
        temp = root;
        breadthF4(root, f);
//        System.out.println("Temp: " + temp.info.owner + temp.info.price);
        Node p = root, parent = p;
        while (p.left != temp && p.right != temp) {
            parent = p;
            if (p.info.price < temp.info.price) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (parent.left == temp) {
            parent.left = rightRotate(temp);
        } else {
            parent.right = rightRotate(temp);
        }

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    public Node rightRotate(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        Node newRoot = p.left;
        p.left = newRoot.right;
        newRoot.right = p;
        return newRoot;
    }

    public Node leftRotate(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        Node newRoot = p.right;
        p.right = newRoot.left;
        newRoot.left = p;
        return newRoot;
    }

    public Node leftRightRotate(Node p) {
        p.left = leftRotate(p.left);
        p = rightRotate(p);
        return p;
    }

    public Node rightLeftRotate(Node p) {
        p.right = rightRotate(p.right);
        p = leftRotate(p);
        return p;
    }

    public int height(Node x) {
        Node p = root, par = p;
        if (root == null) {
            return 0;
        }
        while (p != null && p.info != x.info) {
            if (x.info.price > p.info.price) {
                par = p;
                p = p.right;
            } else if (p.info.price > x.info.price) {
                par = p;
                p = p.left;
            }
        }
        if (p.left == null && p.right == null) {
            return 1;
        } else if (p.left != null && p.right == null) {
            return (1 + height(p.left));
        } else if (p.left == null && p.right != null) {
            return (1 + height(p.right));
        } else {
            return Integer.max(1 + height(p.left), 1 + height(p.right));
        }

    }

    public void removeNodebyMergL(Node x) {
        int key = x.info.price;
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node par = null;
        while (p != null && p.info.price != key) {
            if (p.info.price < key) {
                par = p;
                p = p.right;
            } else if (p.info.price > key) {
                par = p;
                p = p.left;
            }
        }
        if (p == null) {
            return;//ko co node can xoa
        }        //p  la node can xoa, par la node cha cua p
        if (p.left == null && p.right == null) {
            if (par.left == p) {
                par.left = null;
            } else {
                par.right = null;
            }
        } else if (p.left != null && p.right == null) {
            if (par.left == p) {
                par.left = p.left;
            } else {
                par.right = p.left;
            }
        } else if (p.left == null && p.right != null) {

            if (par.left == p) {
                par.left = p.right;
            } else {
                par.right = p.right;
            }
        } else { //if (p.left!=null && p.right!=null)
            //đã có node cần xóa là  P và node cha của nó là par
            //đi tìm node phải cùng của cây con trái (node có 
            //giá trị lớn nhất của cây con trái)

            Node rightMost = p.left;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            if (p == root) {
                root = root.left;
            } else {
                if (par.left == p) {
                    par.left = p.left;
                } else {
                    par.right = p.left;
                }
            }
            rightMost.right = p.right;
        }

    }

    public void removeNodebyMergR(Node x) {
        int key = x.info.price;
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node par = null;
        while (p != null && p.info.price != key) {
            if (p.info.price < key) {
                par = p;
                p = p.right;
            } else if (p.info.price > key) {
                par = p;
                p = p.left;
            }
        }
        if (p == null) {
            return;//ko co node can xoa
        }        //p  la node can xoa, par la node cha cua p
        if (p.left == null && p.right == null) {
            if (par.left == p) {
                par.left = null;
            } else {
                par.right = null;
            }
        } else if (p.left != null && p.right == null) {
            if (par.left == p) {
                par.left = p.left;
            } else {
                par.right = p.left;
            }
        } else if (p.left == null && p.right != null) {
            if (par.left == p) {
                par.left = p.right;
            } else {
                par.right = p.right;
            }
        } else { //if (p.left!=null && p.right!=null)
            //cách 2 cho con phải lên thay
            //tìm node trái cùng của của cây con phải
            //gắn node trái của node cần xóa 
            //vào node trái cùng đã tìm ở trên
            Node leftMost = p.right;
            while (leftMost.left != null) {
                leftMost = leftMost.left;
            }
            if (p == root) {
                root = root.right;
            } else {
                if (par.left == p) {
                    par.left = p.right;
                } else {
                    par.right = p.right;
                }
            }
            leftMost.left = p.left;
        }
    }

    public void removebyCopyL(Node x) {
        Node p = root, par = root;

        while (p != null && p != x) {
            if (p.info.price < x.info.price) {
                par = p;
                p = p.right;
            } else if (p.info.price > x.info.price) {
                par = p;
                p = p.left;
            }
        }
        if (p == null) {
//            return;
        } else {
            //da tim dc node p co gia tri = x va node cha cua p
            if (p.left == null && p.right == null) {//xoa node la
                if (par.left == p) {
                    par.left = null;
                } else {
                    par.right = null;
                }
            } else if (p.left != null && p.right == null) {
                //xoa node chi co 1 con trai
                if (par.left == p) {
                    par.left = p.left;
                } else {
                    par.right = p.right;
                }
            } else if (p.left == null && p.right != null) {
                //xoa node chi co 1 con phai
                if (par.left == p) {
                    par.left = p.right;
                } else {
                    par.right = p.right;
                }
            } else {//xoa node co 2 con
                Node rightmost = p.left;
                Node par_rightmost = p;
                while (rightmost.right != null) {
                    par_rightmost = rightmost;
                    rightmost = rightmost.right;
                }
                p.info = rightmost.info;
                if (par_rightmost == p) {
                    par_rightmost.left = rightmost.left;
                } else {
                    par_rightmost.right = rightmost.left;
                }
            }
        }
    }

    public void removebyCopyR(Node xNode) {
        int x = xNode.info.price;
        Node p = root, par = root;
        while (p != null && p.info.price != x) {
            if (p.info.price < x) {
                par = p;
                p = p.right;
            } else if (p.info.price > x) {
                par = p;
                p = p.left;
            }
        }
        if (p == null) {
            return;
        }
        //da tim dc node p co gia tri = x va node cha cua p
        if (p.left == null && p.right == null) {//xoa node la
            if (par.left == p) {
                par.left = null;
            } else {
                par.right = null;
            }
        } else if (p.left != null && p.right == null) {
            //xoa node chi co 1 con trai
            if (par.left == p) {
                par.left = p.left;
            } else {
                par.right = p.right;
            }
        } else if (p.left == null && p.right != null) {
            //xoa node chi co 1 con phai
            if (par.left == p) {
                par.left = p.right;
            } else {
                par.right = p.right;
            }
        } else {//xoa node co 2 con
            Node lefttmost = p.right;
            Node par_lefttmost = p;
            while (lefttmost.left != null) {
                par_lefttmost = lefttmost;
                lefttmost = lefttmost.left;
            }
            p.info.price = lefttmost.info.price;
            if (par_lefttmost == p) {
                par_lefttmost.right = lefttmost.right;
            } else {
                par_lefttmost.left = lefttmost.right;
            }
        }

    }

}
