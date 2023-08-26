/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2_csd_collection;

/**
 *
 * @author VICTUS
 */
public class Q2_CSD_Collection {

    //================ f1() ===================//
    //=========================================//
    //insert charAt(0), preice > 100 do nothing
    void insert(String xOwner, int xPrice) {//You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        insert(new Car(xOwner, xPrice));

    }

    void insert(Car x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.price == x.price) {

                return;
            }
            f = p;
            if (x.price < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.price < f.info.price) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    //================ f2() ===================//
    //=========================================//
    //postOrder display radius < 5 only
//    postOrder2(root, f);
    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        if (p.info.radius < 5) {
            fvisit(p, f);
        }
    }

    //inOrder display color < 5 only
//    inOrder2(root, f);
    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if (p.info.color < 5) {
            fvisit(p, f);
        }
        inOrder2(p.right, f);
    }

    //preOrder display only price int[3,5]
//    preOrder2(root, f);
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

    //create obj h in BSTree insert to h all element having age> 4
//    BSTree h = new BSTree();
    int xAge = 4;
    MyQueue q = new MyQueue();

    q.enqueue (root);
    Node r;

    while (!q.isEmpty () 
        ) {
        r = q.dequeue();
        if (r.info.age > xAge) {
            h.insert(new Person(r.info.name, r.info.age));
        }
        if (r.left != null) {
            q.enqueue(r.left);
        }
        if (r.right != null) {
            q.enqueue(r.right);
        }
    }

    //breadth-first dispay only wing > 4  
//    breadth2(root, f);
    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.wing > 4) {
                fvisit(r, f);
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    /*
        Suppose p is the 5th node when performing the post-order traversal of the
        tree. Calculate number of nodes in the sub-tree with root p and suppose
        this number is k, then p,info.color = k
     */
//        postOrder(root);
//        int k = countNode(node3);
//        node3.info.color = k;
    int count = 0;
    Node node3 = null;

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        if (count == 4 && node3 == null) {
            node3 = p;
        }
        count++;
    }

    int countNode(Node pNode) {
        if (pNode == null) {
            return 0;
        }
        int k, h, rNode;
        k = countNode(pNode.left);
        h = countNode(pNode.right);
        rNode = k + h + 1;
        return rNode;
    }

    /*
        Perform pre-order travesal from the root but display to file f2.txt nodes
    with rate < 6 only
     */
    //    preOrder2(root, f);
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.rate < 6) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }

    //================ f3() ===================//
    //=========================================//
    //in-order find the first node p having both 2 sons, then delete node p by copying.
//    inOrder2(root, f);
//        deleByCopy(q123.info.type);
    int count = 0;

    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if (p.left != null && p.right != null && count == 0) {
            q123 = p;
            count++;
            return;
        }
        inOrder2(p.right, f);
        return;
    }

    void deleByCopy(int x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.type == x) {
                break;
            }
            f = p;
            if (x < p.info.type) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // not found
        }      // p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { // p==root
                root = null;
                return;
            }
            if (p == f.left) {
                f.left = null;
            } else {
                f.right = null;
            }
        }
        // p has left son only
        if (p.left != null && p.right == null) {
            if (f == null) { // p==root
                root = p.left;
                return;
            }
            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
        // p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { // p==root
                root = p.right;
                return;
            }
            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            // find the right-most node in the left sub-tree
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == null) { // rp==q
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }

    }

    //Search the node having price=6 in the tree. If the node found is p then calculate
    //the number of nodes in the sub-tree with root p. If this number of nodes is k then change
    //p.info.color to 100+k.
    Node p = root;
    if (p == null) {
            return;
    }
    Queue q = new Queue();

    q.enqueue (p);
    Node r = null;

    while (!q.isEmpty()) {
            r = q.dequeue();
//        fvisit(r,f);
        if (r.info.price == 6) {
            break;
        }
        if (r.left != null) {
            q.enqueue(r.left);
        }
        if (r.right != null) {
            q.enqueue(r.right);
        }
    }

    p  = r;
    if (p

    
        != null) {
            q = new Queue();
        q.enqueue(p);
        Node a;
        int k = 0;
        while (!q.isEmpty()) {
            a = q.dequeue();
            k++;
            if (a.left != null) {
                q.enqueue(a.left);
            }
            if (a.right != null) {
                q.enqueue(a.right);
            }
        }
        p.info.color = 100 + k;
    }

    //Perform pre-order traversal and find the first node p having type < 10, then delete
    //p by copying
//    preOrderAndDelete(root);
    void deleByCopy(int x) {
        if (isEmpty()) {
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.type == x) {
                break;
            }
            f = p;
            if (x < p.info.type) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // not found
        }      // p is a leaf-node
        if (p.left == null && p.right == null) {
            if (f == null) { // p is the root
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

        // p has left son
        if (p.left != null && p.right == null) {
            if (f == null) { // p is the root
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
        // p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { // p is the root
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
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            // Start finding the right-most node on the left subtree
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp now is the right-most node
            p.info = rp.info;
            // Delete rp;
            if (frp == null) {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }

    }

    void preOrderAndDelete(Node p) {
        if (p == null) {
            return;
        }
        if (p.info.type < 10) {
            deleByCopy(p.info.type);
            return;
        }
        preOrderAndDelete(p.left);
        preOrderAndDelete(p.right);
    }

    //Perform breadth-first traversal from the root and delete by copying the first node
    //having both 2 sons and price < 7. Output in the file f3.txt must be the following:
    Node breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return null;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && r.right != null && r.info.price < 7) {
                return r;
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

    void deleByCopy(int x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.price == x) {
                break;
            }
            f = p;
            if (x < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // not found
        }      // p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { // p==root
                root = null;
                return;
            }
            if (p == f.left) {
                f.left = null;
            } else {
                f.right = null;
            }
        }
        // p has left son only
        if (p.left != null && p.right == null) {
            if (f == null) { // p==root
                root = p.left;
                return;
            }
            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
        // p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { // p==root
                root = p.right;
                return;
            }
            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            // find the right-most node in the left sub-tree
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == null) { // rp==q
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }

        //Suppose the tree is not empty. Find the node p having largest price in the tree
        //(i.e. p is the right-most node), then delete p.
//     max = 0;
//        breadth2(root, f);
//        Queue q = new Queue();
//        q.enqueue(root);
//        Node r;
//        while (!q.isEmpty()) {
//            r = q.dequeue();
//            if (r.info.color == max) {
//                deleByCopy(r.info.color);
//            }
//            if (r.left != null) {
//                q.enqueue(r.left);
//            }
//            if (r.right != null) {
//                q.enqueue(r.right);
//            }
//        }
        int max;

        void breadth2
        (Node p, RandomAccessFile f) throws Exception {
            if (p == null) {
                return;
            }
            Queue q = new Queue();
            q.enqueue(p);
            Node r;
            max = root.info.color;
            while (!q.isEmpty()) {
                r = q.dequeue();
                if (r.info.color > max) {
                    max = r.info.color;
                }
                if (r.left != null) {
                    q.enqueue(r.left);
                }
                if (r.right != null) {
                    q.enqueue(r.right);
                }
            }
        }

        void deleByCopy(int x) {
            Node f, p;
            f = null;
            p = root;
            while (p != null) {
                if (p.info.color == x) {
                    break;
                }
                f = p;
                if (x < p.info.color) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            if (p == null) {
                return; // not found
            }      // p is a leaf node
            if (p.left == null && p.right == null) {
                if (f == null) { // p==root
                    root = null;
                    return;
                }
                if (p == f.left) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            // p has left son only
            if (p.left != null && p.right == null) {
                if (f == null) { // p==root
                    root = p.left;
                    return;
                }
                if (p == f.left) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            // p has right son only
            if (p.left == null && p.right != null) {
                if (f == null) { // p==root
                    root = p.right;
                    return;
                }
                if (p == f.left) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            // p has both 2 sons
            if (p.left != null && p.right != null) {
                Node q = p.left;
                // find the right-most node in the left sub-tree
                Node frp, rp;
                frp = null;
                rp = q;
                while (rp.right != null) {
                    frp = rp;
                    rp = rp.right;
                }
                p.info = rp.info;
                if (frp == null) { // rp==q
                    p.left = q.left;
                } else {
                    frp.right = rp.left;
                }
            }
        }

        //Perform pre-order traversal and find the first node p having left son only, then
        //rotate p to right about it’s left son.
//     breadth3(root, f);
        Node father2(Node node) {
        Node f, p;
            f = null;
            p = root;
            while (p != null) {
                if (p == node) {
                    break;
                }
                f = p;

                if (p.info.area > node.info.area) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            return (f);
        }

        Node rotateRight(Node node) {
            if (node == null || node.left == null) {
                return node;
            }
            Node pl = node.left;
            node.left = pl.right;
            pl.right = node;
            return pl;
        }

        void myRotateRight(Node node) {
            Node tmp = rotateRight(node);
            Node parent = father2(node);
            if (parent == null) {
                root = tmp;
            } else {
                if (parent.left == node) {
                    parent.left = tmp;
                } else {
                    parent.right = tmp;
                }
            }
        }

        void breadth3(Node p, RandomAccessFile f) throws Exception {
            if (p == null) {
                return;
            }
            Queue q = new Queue();
            q.enqueue(p);
            Node r;
            while (!q.isEmpty()) {
                r = q.dequeue();

                if (r.left != null && r.right == null) {
                    myRotateRight(r);
                    break;
                }

                if (r.left != null) {
                    q.enqueue(r.left);
                }
                if (r.right != null) {
                    q.enqueue(r.right);
                }
            }
        }

        //Perform breadth-first traversal from the root and delete by copying the first node
        //having both 2 sons and price < 7.
//    inOrderF3(root, f);
        void inOrderF3
        (Node p, RandomAccessFile f) throws Exception {
            if (p == null) {
                return;
            }
            inOrderF3(p.left, f);
            if (p.left != null && p.right != null && p != root) {
                deleteByCopying(p);
                return;
            }
            inOrderF3(p.right, f);
        }

        void deleteByCopying(Node p) { // copy left
        if (p == null || p.left == null) {
                return;
            }
            if (p.left.right == null) {
                p.info = p.left.info;
                p.left = p.left.left;
            } else {
                Node father = p.left;
                Node cur = p.left.right;
                while (cur.right != null) {
                    father = cur;
                    cur = cur.right;
                }
                p.info = cur.info;
                father.right = cur.left;
            }
        }

        //calculate the height of the tree. You should use the given statement
        //f123.writeBytes(“k = “ + k + “\r\n”);  to write this value to the file f3.txt. 
        //With the given data, the content of  the file  f3.txt  must be the following:
        //k = 5
//    k = height(root);
        int height
        (Node p) {
            if (p == null) {
                return (0);
            }
            int k, h, r;
            k = height(p.left);
            h = height(p.right);
            r = k > h ? k : h;
            return (r + 1);
        }

        //p is 4th node when post-order, f is father of p. delete f by copying
//    ArrayList<Node> a = new ArrayList<>();
//        postOrder3(root, f, a);
//        Node p = a.get(3);
//        Node ff = searchParent(p);
//        delete(ff);
        void postOrder3(Node p, RandomAccessFile f, ArrayList<Node> a) throws Exception {
            if (p == null) {
                return;
            }
            postOrder3(p.left, f, a);
            postOrder3(p.right, f, a);
            a.add(p);
        }

        Node searchParent(Node a) {
            if (a == null) {
                return null;
            }
            Node p = root, f = null;
            while (p != null && p != a) {
                f = p;
                if (p.info.rate > a.info.rate) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            return f;
        }

        void delete(Node x) {
            if (isEmpty()) {
                return;
            }
            Node p = root, f = null;
            while (p != null) {
                if (p.info == x.info) {
                    break;
                }
                f = p;
                if (p.info.rate > x.info.rate) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            if (p == null) {
                return;
            }

            // No child
            if (p.left == null && p.right == null) {
                if (f == null) {
                    root = null;
                    return;
                }
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }

            // 1 child
            if (p.left != null && p.right == null) {
                if (f == null) {
                    root = p.left;
                    return;
                }
                if (f.left == p) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            } else if (p.left == null && p.right != null) {
                if (f == null) {
                    root = p.right;
                    return;
                }
                if (f.left == p) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }

            // 2 children
            if (p.left != null && p.right != null) {
                deleteByCopying(p);
            }
        }

        void deleteByCopying(Node p) {
            Node rightMost = p.left, f = null;
            while (rightMost.right != null) {
                f = rightMost;
                rightMost = rightMost.right;
            }
            p.info = rightMost.info;
            if (f == null) {
                p.left = rightMost.left;
            } else {
                f.right = rightMost.left;
            }
        }

  
    /*
        Suppose p is the 4-th node when performing the pre-order traversal of the
    tree. Delete the node p by copying
    */
    
//      ArrayList<Boo> t = new ArrayList<>();
//      preOrder(t, root);
//      Boo p = t.get(3);
//      deleByCopy(p);
    
    void preOrder(ArrayList<Boo> t, Node p) {
        if (p == null) {
            return;
        }
        t.add(p.info);
        preOrder(t, p.left);
        preOrder(t, p.right);
    }
    
    public void deleByCopy(Boo x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x.sound < p.info.sound) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;  //not found
        }
        //p is leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { //p is root
                root = null;
                return;
            }
            if (p == f.left) {
                f.left = null;
            } else {
                f.right = null;
            }
        }
        //p has left son only
        if (p.left != null && p.right == null) {
            if (f == null) { //p is root
                root = p.left;
                return;
            }
            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
        //p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { //p is root
                root = p.right;
                return;
            }
            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == null) { //rp == q
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }

        //================ f4() ===================//
        //=========================================//
        //Perform in-order traversal and find the node p having both 2 sons, then rotate
        //p to left. 
//        q123 = null;
//        inOrder2(root, f);
//
//        Node r = rotateLeft(q123);
//        Node fa = father2(q123.info.type);
//        if (fa == null) {
//            root = r;
//        } else {
//            if (fa.left == q123) {
//                fa.left = r;
//            } else {
//                fa.right = r;
//            }
//        }
        Node father2(int xType) { 
            Node f, p;
            f = null;
            p = root;
            while (p != null) {
                if (p.info.type == xType) {
                    break;
                }
                f = p;
                if (xType < p.info.type) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            return (f);
        }

        Node rotateLeft(Node p) {
            if (p == null || p.right == null) {
                return (p);
            }
            Node q = p.right;
            p.right = q.left;
            q.left = p;
            return (q);
        }

        //Search the node having price = 6 and if the node found is p then delete p by
        //copying.
//       deleteByCopy(6);
        void deleteFunc (Node p, Node f) {
        //p do not have child
        if (p.left == null && p.right == null) {
                if (f == null) {
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
            //p have one-left child
            if (p.left != null && p.right == null) {
                if (f == null) {
                    root = p.left;
                } else {
                    if (f.left == p) {
                        f.left = p.left;
                    } else {
                        f.right = p.left;
                    }
                }
                return;
            }
            //p have one-right child
            if (p.left == null && p.right != null) {
                if (f == null) {
                    root = p.right;
                } else {
                    if (f.left == p) {
                        f.left = p.right;
                    } else {
                        f.right = p.right;
                    }
                }
                return;
            }
            Node p1 = p.left;
            Node f1 = p;
            while (p1.right != null) {
                f1 = p1;
                p1 = p1.right;
            }
            p.info = p1.info;
            if (f1.right == p1) {
                f1.right = p1.left;
            } else {
                f1.left = p1.left;
            }
        }

        void deleteByCopy(int price) {
        Node f, p;
            f = null;
            p = root;
            while (p != null) {
                if (p.info.price == 6) {
                    break;
                }
                f = p;
                if (p.info.price > price) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            if (p == null) {
                return;
            }
            deleteFunc(p, f);
        }

        //Perform breadth-first traversal from the root and find the first node p having left son
        //and price < 7. Rotate p to right about its’ left son.
//    Node q123 = breadth3(root);
//        Node r = rotateRight(q123);
//        Node fa = father2(q123.info.price);
//        if (fa == null) {
//            root = r;
//        } else {
//            if (fa.left == q123) {
//                fa.left = r;
//            } else {
//                fa.right = r;
//            }
//        }
        Node breadth3(Node p) throws Exception {
            if (p == null) {
                return null;
            }
            Queue q = new Queue();
            q.enqueue(p);
            Node r;
            while (!q.isEmpty()) {
                r = q.dequeue();
                if (r.left != null && r.info.price < 7) {
                    return r;
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

        Node rotateRight(Node p) {
            if (p == null || p.left == null) {
                return (p);
            }
            Node q = p.left;
            p.left = q.right;
            q.right = p;
            return (q);
        }

        Node father2(int xPrice) {
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

        //Suppose the tree is not empty. Find the node p having largest price in the tree
        //(i.e p is the right-most node). If p has father f then rotate f to left about p.
//        max = 0;
//        breadth2(root, f);
//        Node q123 = null;
//        Queue q = new Queue();
//        q.enqueue(root);
//        Node r;
//        while (!q.isEmpty()) {
//            r = q.dequeue();
//            if (r.info.color == max) {
//                q123 = r;
//            }
//            if (r.left != null) {
//                q.enqueue(r.left);
//            }
//            if (r.right != null) {
//                q.enqueue(r.right);
//            }
//        }
//        Node fa1 = father2(q123.info.color);
//        Node r12 = rotateLeft(fa1);
//        Node fa2 = father2(fa1.info.color);
//        if (fa2 == null) {
//            root = r12;
//        } else {
//            if (fa2.left == fa1) {
//                fa2.left = r12;
//            } else {
//                fa2.right = r12;
//            }
//        }
        Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
                return (p);
            }
            Node q = p.right;
            p.right = q.left;
            q.left = p;
            return (q);
        }

        Node father2(int xColor) {
        Node f, p;
            f = null;
            p = root;
            while (p != null) {
                if (p.info.color == xColor) {
                    break;
                }
                f = p;
                if (xColor < p.info.color) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            return (f);
        }
        //Perform pre-order traversal and find the first node p having left son q only, then
        //delete q by copying.
        //    breadth2(root, f);
    public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            return;
        }
        Node q = root;
        Node f = null;
        while (q != p) {

            if (q.info.area > p.info.area) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else if (f.right == p) {
                f.right = null;
            }
        } else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.right == p) {
                f.right = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            }
        } else if (p.right != null && p.left == null) {
            if (f == null) {
                root = p.right;
            } else if (f.right == p) {
                f.right = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            }
        }
        if (p.left != null && p.right != null) {
            f = null;
            Node rp = p.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (f == null) {
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }
        }
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

            if (r.left != null && r.right == null) {
                deleteByCopy(r.left);
                break;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    //Perform breadth-first traversal from the root and find the first node p having left
    //son and price < 7. Rotate p to right about its’ left son.
//    inOrderF4(root, f);
    private Node getParent(Node n) {
        if (n == root) {
            return null;
        }
        Node father = null;
        Node cur = root;
        while (cur != null && cur.info.type != n.info.type) {
            father = cur;
            if (cur.info.type < n.info.type) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return father;
    }

    void leftRotate(Node p) {
        Node grandpa = getParent(p);
        Node child;
        if (p == null || p.right == null) {
            return;
        } else {
            child = p.right;
            p.right = child.left;
            child.left = p;
        }
        if (grandpa != null) {
            if (grandpa.info.type < p.info.type) {
                grandpa.right = child;
            } else {
                grandpa.left = child;
            }
        } else {
            root = child;
        }
    }

    void inOrderF4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF4(p.left, f);
        if (p.left != null && p.right != null && p != root) {
            leftRotate(p);
        }
        inOrderF4(p.right, f);
    }

    //calculate the number of nodes of the tree. You should use the given statement
    //f123.writeBytes(" k = " + k + "\r\n"); to write this value to the file f4.txt.
    //With the given data, the content of  the file  f4.txt  must be the following:
    //k = 9
//    k = count(root);
    int count(Node p) {
        if (p == null) {
            return (0);
        }
        int k, h, r;
        k = count(p.left);
        h = count(p.right);
        r = k + h + 1;
        return (r);
    }

    //Check if the root having non-empty left-son then rotate it to right about its
    //left-son
//      root = rotateToRight(root);
    Node rotateToRight(Node p) {
        if (p == null || p.left == null) {
            return (p);
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return (q);
    }

    //Calculate balance factor of all nodes. Display all node with balance factor
    //by breadth-first traverse. Display also the information about whether a given binary
    //search tree is height balanced (AVL tree) or not.
//     boolean isAVL = true;
//        MyQueue q = new MyQueue();
//        q.enqueue(root);
//        Node r;
//        while (!q.isEmpty()) {
//            r = q.dequeue();
//            r.bal = height(r.right) - height(r.left);
//            if (r.bal >= 2 || r.bal <= -2) {
//                isAVL = false;
//            }
//            if (r.left != null) {
//                q.enqueue(r.left);
//            }
//            if (r.right != null) {
//                q.enqueue(r.right);
//            }
//        }
//
//        breadthBal(root, f123);
//        if (!isAVL) {
//            f123.writeBytes("\r\nThe tree is not an AVL tree\r\n");
//        } else {
//            f123.writeBytes("\r\nThe tree is an AVL tree\r\n");
//        }
    //Calculate level of all nodes. Display all node with level by breadth-first traverse.
    MyQueue q = new MyQueue();

    if (isEmpty() 
        ) {
        return;
    }
    root.level  = 1;

    q.enqueue (root);
    Node r;

    while (!q.isEmpty () 
        ) {
        r = q.dequeue();
        if (r.left != null) {
            r.left.level = r.level + 1;
        }
        if (r.right != null) {
            r.right.level = r.level + 1;
        }
        if (r.left != null) {
            q.enqueue(r.left);
        }
        if (r.right != null) {
            q.enqueue(r.right);
        }
    }

    breadthLevel(root, f123);

    //Balance a binary search tree by simple balancing algorithm. Display all node 
    //by breadth-first traverse.  
//        balance();
//        breadth(root, f123);
    void inOrder(ArrayList<Person> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }

    void balance(ArrayList<Person> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        insert(t.get(k));
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    void balance() {
        ArrayList<Person> t;
        t = new ArrayList<Person>();
        inOrder(t, root);
        int n = t.size();
        clear();
        balance(t, 0, n - 1);
    }

    //Find the node p having type = 5, then calculate number of nodes in the sub-tree
    //with root p. Suppose this number is k, then set p.info.price = k. 
//    Node p = root;
//        while (p != null) {
//            if (p.info.type == 5) {
//                break;
//            }
//            if (p.info.type > 5) {
//                p = p.left;
//            } else {
//                p = p.right;
//            }
//        }
//        int k = count(p);
//        p.info.price = k;
    int count(Node p) {
        if (p == null) {
            return (0);
        }
        int k, h, r;
        k = count(p.left);
        h = count(p.right);
        r = k + h + 1;
        return (r);
    }
}

 /*
         Suppose p is the 4-th node when performing the pre-order traversal of the
    tree. Check if p has right son then rotate it to left about its' right son
    */
    
//      ArrayList<Boo> t = new ArrayList<>();
//      preOrder(t, root);
//      Boo p = t.get(3);
//      deleByCopy(p);


    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return (p);
        }
        
        Node f, s;
        f = null;
        s = root;
        while (s != null) {
            if (s == p) {
                break;
            }
            f = s;
            if (p.info.sound < s.info.sound) {
                s = s.left;
            } else {
                s = s.right;
            }
        }
        
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        if (f == null) root = q;
        if (f.left == p) f.left = q;
        if (f.right == p) f.right = q;
        return (q);
    }
    
    public Node search(Node p, Boo x) {
        if (p == null) {
            return null;
        }
        if (p.info.sound == x.sound) {
            return p;
        } else if (x.sound < p.info.sound) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

 /*
        Perform the post-order traversal of the tree and find the 2nd node having
    left son. If the node found is p, then rotate p to right
    */
    
    
//        postOrder2(root);
//        Node father = findFather(nodef4);
//        boolean isLeft = (father.left == nodef4);
//        nodef4 = rotateRight(nodef4);
//        if (isLeft) {
//            father.left = nodef4;
//        } else {
//            father.right = nodef4;
//        }
    
    Node nodef4 = null;
    int count4 = 0;

    void postOrder2(Node p) {
        if (p == null) {
            return;
        }
        postOrder2(p.left);
        postOrder2(p.right);
        //logic
        if (nodef4 == null && p.left != null) {
            count4++;
            if (count4 == 2) {
                nodef4 = p;
            }
        }
    }

    public Node findFather(Node x) {
        Queue q = new Queue();
        q.enqueue(root);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left == x || r.right == x) {
                return r;
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

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return (p);
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return (q);
    }

