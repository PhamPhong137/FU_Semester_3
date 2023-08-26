/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

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
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xOwner, int xPrice) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'A' || xPrice > 100) {

        } else {
            Car newCar = new Car(xOwner, xPrice);
            Node p = new Node(newCar);
            if (isEmpty()) {
                head = tail = p;
            } else {
                tail.next = p;
                tail = p;
            }
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
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
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Car x = new Car("X", 1);
        Car y = new Car("Y", 2);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addFirst(y);
//------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void addFirst(Car x) {
        Node xNode = new Node(x);
        Node p = head;
        if (isEmpty()) {
            head = tail = xNode;
        } else {
            xNode.next = head;
            head = xNode;
        }
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(7);
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
        int count = 0;
        Node p = head, parent = p;
        while (p.next != null) {
            parent = p;
            if (p.next.info.price == 5) {
                count++;
                if (count == 2) {
                    break;
                }
            }
            p = p.next;
        }
//        System.out.println("Parent: " + parent.info.owner + parent.info.price);
        if (count == 2) {
            parent.next = parent.next.next;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(10);
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
        Node currentNode = head, nextNode = null;
        if (head == null) {
        } else {
            while (currentNode != null) {
                nextNode = currentNode.next;
                while (nextNode != null) {
                    if (currentNode.info.price < nextNode.info.price) {
                        Car temp;
                        temp = currentNode.info;
                        currentNode.info = nextNode.info;
                        nextNode.info = temp;
                    }
                    nextNode = nextNode.next;
                }
                currentNode = currentNode.next;
            }
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void sortAsc() {
        Node currentNode = head, nextNode = null;
        if (head == null) {
        } else {
            while (currentNode != null) {
                nextNode = currentNode.next;
                while (nextNode != null) {
                    if (currentNode.info.price > nextNode.info.price) {
                        int temp;
                        temp = currentNode.info.price;
                        currentNode.info.price = nextNode.info.price;
                        nextNode.info.price = temp;
                    }
                    nextNode = nextNode.next;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public void sortInRange(Node from, Node to) {
        if (from != null) {
            Node current = from;
            while (current != to) {
                Node pNext = current.next;
                while (pNext != to.next) {
                    //change the condition if necessary
                    if (current.info.price > pNext.info.price) {
                        Car temp = current.info;
                        current.info = pNext.info;
                        pNext.info = temp;
                    }
                    pNext = pNext.next;
                }
                current = current.next;
            }
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Node findByIndex(int k) {
        int idx = 0;
        if (isEmpty()) {
            return null;
        }
        Node p = head;
        while (p != null) {
            if (idx == k) {
                return p;
            }
            p = p.next;
            idx++;
        }
        return null;
    }
}
