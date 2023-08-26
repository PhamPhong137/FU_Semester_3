/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

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

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    int size;

    void addLast(String xForest, int xRate, int xSound) {
        //You should write here appropriate statements to complete this function.
        Node node = new Node(new Bird(xForest, xRate, xSound));
        if (node.info.forest.charAt(0) == 'B') {
            return;
        }
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
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

//==================================================================
    public void addLast(Bird value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    // Add first node
    public void addFirst(Bird value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void addAfterIndex(Bird value, int index) {
        if (index < 0) {
            addFirst(value);
            return;
        }
        if (index >= size) {
            addLast(value);
            return;
        }
        int count = 0;
        Node cur = head;
        while (cur != null && count != index) {
            count++;
            cur = cur.next;
        }
        if (cur == null) {
        } else {
            Node node = new Node(value);
            node.next = cur.next;
            cur.next = node;
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
        Bird x, y;
        x = new Bird("X", 1, 2);
        y = new Bird("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addAfterIndex(x, 0);
        addAfterIndex(y, 1);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    // Delete last node
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        if (head.next == null) {
            head = null;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        tail = cur;
    }

    // Delete first node
    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        if (head.next == null) {
            head = null;
        }
        Node cur = head;
        head = cur.next;
    }

    // Delete specific node
    public void deleteIndex(int index) {
        if (index <= 1) {
            deleteFirst();
            return;
        }
        if (index >= size) {
            deleteLast();
            return;
        }
        int pos = 1;
        Node cur = head;
        while (pos < index - 1) {
            cur = cur.next;
            ++pos;
        }
        cur.next = cur.next.next;
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        deleteIndex(0);
        deleteIndex(2);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    public void addFirst(String xType, int xRate, int xWing) {
        Bird b = new Bird(xType, xRate, xWing);
        Node newNode = new Node(b);
        if (xType.charAt(0) == 'B') {
            return;
        }
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public void sort() {
        ArrayList<Node> list = new ArrayList<>();
        Node p = head;
        for (int i = 0; i < 4; i++) {
            list.add(p);
            p = p.next;
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node t, Node t1) {
                return t.info.rate < t1.info.rate ? 1 : -1;
            }
        });

        for (int i = 0; i < 4; i++) {
            deleteFirst();
//           addIndex(list.get(i).bird.getType(), list.get(i).bird.getRate(), list.get(i).bird.getWing(), i);
        }
        for (int i = 0; i < 4; i++) {
            addFirst(list.get(i).info.forest, list.get(i).info.rate, list.get(i).info.sound);
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sort();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
