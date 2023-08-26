/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

import java.util.LinkedList;
import java.util.Queue;

public class MyBSTree {

    Node root;

    public MyBSTree() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int x) {
        if (root == null) {
            root = new Node(x);
        } else {
            Node p = root;
            Node parent = p;
            while (p != null) {
                if (x < p.value) {
                    parent = p;
                    p = p.left;
                } else if (x > p.value) {
                    parent = p;
                    p = p.right;
                } else {
                    return;
                }
            }
            if (x >= parent.value) {
                parent.right = new Node(x);
            } else {
                parent.left = new Node(x);
            }
        }
    }
    // Insert dùng đệ quy

//    public Node insert(Node rootNode, int value) {
//        if (rootNode == null) {
//            return new Node(value);
//        }
//        if (value < rootNode.value) {
//            if (rootNode.left == null) {
//                root.left = new Node(value);
//            } else {
//                insert(rootNode.left, value);
//            }
//        } else {
//            if (rootNode.right == null) {
//                root.right = new Node(value);
//            } else {
//                insert(rootNode.right, value);
//            }
//        }
//        return rootNode;
//    }
    public void remove(int x) {
        Node p = root, par = p;
        while (p != null && p.value != x) {
            if (x > p.value) {
                par = p;
                p = p.right;
            } else if (p.value > x) {
                par = p;
                p = p.left;
            }
        }
        if (p == null) { //there is no x in the tree
            return;
        }
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

    public void visit(Node p) {
        System.out.print(p.value + " ");
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

    public void BFS(Node p) {

        if (p == null) {
            return;
        }
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(p);
        Node q = null;
        while (!myQueue.isEmpty()) {
            q = (Node) myQueue.remove();
            System.out.print(q.value + " ");
            if (q.left != null) {
                myQueue.add(q.left);
            }
            if (q.right != null) {
                myQueue.add(q.right);
            }
        }

    }

    Node search(Node p, int x) {
        if (p == null) {
            return (null);
        }
        if (p.value == x) {
            return (p);
        }
        if (x < p.value) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    public int height(int x) {
        Node p = root, par = p;
        if (root == null) {
            return 0;
        }
        while (p != null && p.value != x) {
            if (x > p.value) {
                par = p;
                p = p.right;
            } else if (p.value > x) {
                par = p;
                p = p.left;
            }
        }
        if (p.left == null && p.right == null) {
            return 1;
        } else if (p.left != null && p.right == null) {
            return (1 + height(p.left.value));
        } else if (p.left == null && p.right != null) {
            return (1 + height(p.right.value));
        } else {
            return Integer.max(1 + height(p.left.value), 1 + height(p.right.value));
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

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.value > p.value) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
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
