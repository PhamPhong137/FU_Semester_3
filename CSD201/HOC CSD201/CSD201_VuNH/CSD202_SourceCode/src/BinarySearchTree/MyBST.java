/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import sun.misc.Queue;

/**
 *
 * @author Hp
 */
public class MyBST {

    Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public void visit(Node p) {
        System.out.print(p.inf + " ");
    }

    public void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
        } else {
            Node p = root;
            Node parent = p;
            while (p != null) {
                if (x < p.inf) {
                    parent = p;
                    p = p.left;
                } else if (x > p.inf) {
                    parent = p;
                    p = p.right;
                } else {
                    return;
                }
            }
            if (x < parent.inf) {
                parent.left = new Node(x);
            } else {
                parent.right = new Node(x);
            }
        }
    }

    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    public void breadFirstSearch(Node p) throws Exception {
        if (p == null) {
            return;
        }
        Queue<Node> myQueue = new Queue<>();
        myQueue.enqueue(p);
        Node currentNode;
        while (!myQueue.isEmpty()) {
            currentNode = (Node) myQueue.dequeue();
            if (currentNode.left != null) {
                myQueue.enqueue(currentNode.left);
            }
            if (currentNode.right != null) {
                myQueue.enqueue(currentNode.right);
            }
            visit(currentNode);
        }

    }

    public void breadth(Node p) throws InterruptedException {
        if (p == null) {
            return;
        }
        Queue myQueue = new Queue();
        myQueue.enqueue(p);
        Node q = null;
        while (!myQueue.isEmpty()) {
            q = (Node) myQueue.dequeue();
            System.out.print(q.inf + " ");
            if (q.left != null) {
                myQueue.enqueue(q.left);
            }
            if (q.right != null) {
                myQueue.enqueue(q.right);
            }
        }
    }

    //find the Node whose inf equals x
    public void remove(int x) {
        Node p = root, par = p;
        while (p != null && p.inf != x) {
            if (x > p.inf) {
                par = p;
                p = p.right;
            } else if (p.inf > x) {
                par = p;
                p = p.left;
            }
        }
        if (p == null) { //there is no x in the tree
            return;
        }
        //found Node p whose inf= x and its par_K (par)

        //when x is in the tree, 3 cases are possible:
        //Case 1: x is a leave: par.child= null;
        if (p.left == null && p.right == null) {
            if (par.left == p) {
                par.left = null;
            } else {
                par.right = null;
            }
        } else if (p.left != null && p.right == null) { //Case 2: p only has a left child
            if (par.left == p) {
                par.left = p.left;
            } else {
                par.right = p.left;
            }
        } else if (p.left == null && p.right != null) { //Case 3: p only has a right child
            if (par.left == p) {
                par.left = p.right;
            } else {
                par.right = p.right;
            }
        } else { //Case 4: it has both children
            //Sol 1: copy a node
            //Sol 1.1: finding max of the left tree
//            Node k = p.left, par_K = p;
//            while (k.right != null) {
//                par_K = k;
//                k = k.right;
//            }
//            if (par_K == p) {
//                p.inf = k.inf;
//                p.left = k.left;
//            }
//            p.inf = k.inf;
//            par_K.right = k.left;
            //Sol 1.2: finding min of the right tree
//            Node k = p.right, par_K = p;
//            while (k.left != null) {
//                par_K = k;
//                k = k.left;
//            }
//            if (par_K == p) {
//                p.inf = k.inf;
//                p.right = k.right;
//            }
//            p.inf = k.inf;
//            par_K.left = k.right;
            //Sol 2: merging
            Node mostRight = p.left;
            while (mostRight.right != null) {
                mostRight = mostRight.right;
            }
            if (root == p) {
                root = root.left;
            } else {
                par.left = p.left;
            }
            mostRight.right = p.right;
        }

    }

    public void removebyCopyL(int x) {
        Node p = root, par = root;
        while (p != null && p.inf != x) {
            if (p.inf < x) {
                par = p;
                p = p.right;
            } else if (p.inf > x) {
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
            Node rightmost = p.left;
            Node par_rightmost = p;
            while (rightmost.right != null) {
                par_rightmost = rightmost;
                rightmost = rightmost.right;
            }
            p.inf = rightmost.inf;
            if (par_rightmost == p) {
                par_rightmost.left = rightmost.left;
            } else {
                par_rightmost.right = rightmost.left;
            }
        }

    }

    public void removebyCopyR(int x) {
        Node p = root, par = root;
        while (p != null && p.inf != x) {
            if (p.inf < x) {
                par = p;
                p = p.right;
            } else if (p.inf > x) {
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
            p.inf = lefttmost.inf;
            if (par_lefttmost == p) {
                par_lefttmost.right = lefttmost.right;
            } else {
                par_lefttmost.left = lefttmost.right;
            }
        }

    }

    public void removeNodebyMergL(int key) {
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node par = null;
        while (p != null && p.inf != key) {
            if (p.inf < key) {
                par = p;
                p = p.right;
            } else if (p.inf > key) {
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

    public void removeNodebyMergR(int key) {
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node par = null;
        while (p != null && p.inf != key) {
            if (p.inf < key) {
                par = p;
                p = p.right;
            } else if (p.inf > key) {
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

    public int height(int x) {
        Node p = root, par = p;
        if (root == null) {
            return 0;
        }
        while (p != null && p.inf != x) {
            if (x > p.inf) {
                par = p;
                p = p.right;
            } else if (p.inf > x) {
                par = p;
                p = p.left;
            }
        }
        if (p.left == null && p.right == null) {
            return 1;
        } else if (p.left != null && p.right == null) {
            return (1 + height(p.left.inf));
        } else if (p.left == null && p.right != null) {
            return (1 + height(p.right.inf));
        } else {
            return Integer.max(1 + height(p.left.inf), 1 + height(p.right.inf));
        }

    }

    public void readDataFromFile(String fname) throws FileNotFoundException, IOException {
        File f = new File(fname);
        if (!f.isFile()) {
            return;
        }
        RandomAccessFile fr = new RandomAccessFile(fname, "r");
        String s;
        while ((s = fr.readLine()) != null) {
            String[] arr = s.split("[ ]+");
            for (int i = 0; i < arr.length; i++) {
                insert(Integer.parseInt(arr[i]));
            }
        }
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
}
