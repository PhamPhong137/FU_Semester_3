
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    // Default constructor
    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.getInfo() + " "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    /**
     * Do NOT modify this method Load 3 lines of data from file: line k (for
     * owner), line k+1 (for price), and line k+2 (for color)
     *
     * @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;

        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);// insert the new Node(a[i], b[i], c[i]) into the list
        }
    }

    /**
     * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error
     * khi run chuong trinh. 2. Neu khong tuan thu se nhan diem 0 (khong).
     * Question 1.1: implement the 'addLast' method that inserts a new Node into
     * the list's tail if the attribute 'Owner'of a House does NOT start with
     * 'B'. The output of this method will be written into the file 'f1.txt'.
     * Therefore you should open this file to see/test your code output.
     * Example: with the content given in the file 'data.txt', the content of
     * 'f1.txt' after insertion should be (A,9,8) (C,6,5) (D,2,4) (E,7,9)
     * (F,4,-7) (G,-3,2)
     *
     * @param xOwner the owner of the input House
     * @param xPrice the price of the input House
     * @param xColor the color of the input House
     */
    void addLast(String xOwner, int xPrice, int xColor) {
        if (xOwner.charAt(0) != 'B') {
            Node newNode = new Node(new House(xOwner, xPrice, xColor));
            if (isEmpty()) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        }
    }

    /**
     * Do NOT modify this method This is a helper method for writing data
     * (node's info) stored in the linked list to file
     *
     * @throws Exception
     */
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

    void addFirst(House x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    void addAfter(Node p, House x) {
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

    // This method is used for Question 1.2
    void insert(House x, int index) {
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

        // Declare two House Objects which will be used for the Question 1.2
        House x;
        House y;
        x = new House("X", 1, 2);
        y = new House("Y", 3, 4);

        /**
         * Question 1.2: use House x and House y declared above, write your code
         * to: (1) insert the node with info = x into the second position of the
         * list, and (2) insert the node with info = y into the third position
         * of the list The output of this method will be written into the file
         * 'f2.txt'. Therefore you should open this file to see/test your code
         * output. Example: if the linked list before insertion is (C,9,8)
         * (D,6,3) (E,8,5) (F,5,4) (I,4,9) then the content of 'f2.txt' after
         * insertion is (C,9,8) (X,1,2) (Y,3,4) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        insert(x, 1);//index
        insert(y, 2);
        ftraverse(f); // write list's data to file
        f.close();
    }

   

    // This method is used for Question 1.3
    
     void Replace() {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.getInfo().price < 6) {
                count++;
                if (count == 1) {
                    p.getInfo().color = 88;
                }
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
        /**
         * Question 1.3: Find the first node in the linked list that has House's
         * price less than 6, if such a node is found, then set the color
         * of.//change = replace House in this node to 88. The output of this
         * method will be written into the file 'f3.txt'. Therefore you should
         * open this file to see/test your code output. Example: if the linked
         * list before change is (C,8,6) (D,3,5) (E,9,2) (F,5,8) (G,9,7) (H,6,8)
         * (I,7,3) then the content of 'f3.txt' after change is (C,8,6) (D,3,88)
         * (E,9,2) (F,5,8) (G,9,7) (H,6,8) (I,7,3)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
       
        Replace();
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------

        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.4
    
    
    void sortByPrice() {
        Node pi, pj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.getInfo().price > pj.getInfo().price) {
                    House temp = pi.getInfo();
                    pi.setInfo(pj.getInfo()) ;
                    pj.setInfo(temp);
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
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
        /**
         * Question 1.4: Sort the linked list in an ascending order according to start index 2 , end index 
         * House's price. Hint: create a new method to sort the linked list,
         * then call the created method in f4() The output of this method will
         * be written into the file 'f4.txt'. Therefore you should open this
         * file to see/test your code output. Example: if the linked list before
         * sorting is (C,1,2) (D,10,3) (E,2,15) (F,12,6) (I,6,14) (J,11,15)
         * (K,7,9) then the content of 'f4.txt' after sorting is (C,1,2)
         * (E,2,15) (I,6,14) (K,7,9) (D,10,3) (J,11,15) (F,12,6)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        // Hint: create a new method to sort the linked list, then call the created method here
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
       sortByPrice();
        ftraverse(f);
        f.close();
    }
}
