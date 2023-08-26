/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyListsrc {

    Node head, tail;

    MyListsrc() {
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
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
        int x = 5;
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

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

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

// ||____ADD______//add last
// ||	||______//add first
// ||     ||______//add many
// ||     ||______//add if age > 4
// ||     ||______//add element have max age
// ||
// ||___INSERT____//insert position k
// ||       ||____//insert after position k
// ||
// ||___SEARCH____//search node
// ||       ||____//search node with string
// ||       ||____//search node with integer/double
// ||
// ||___REMOVE____//remove node
// ||       ||____//remove all
// ||       ||____//remove at position k
// ||       ||____//remove first no age < 6
// ||       ||____//remove a node after position k
// ||       ||____//remove node after 2 node have age < 9
// ||       ||____//remove node thirdth have age < 6
// ||       ||____//remove node first after node have position k
// ||       ||____//remove node after node have price > xPrice
// ||       ||____//remove 2 node last have age > 5
// ||       ||____//remove second biggest
// ||
// ||___SORT______//sort by string
// ||     ||______//sort by integer/ double
// ||     ||______//sort by for
// ||     ||______//sort 3 first element 
//  ||     ||______//sortByWeight
// ||
// ||___SWAP______//swap min max
// ||     ||______//swap node max second with node min first
// ||
// ||___GET_______//get node at index k
// ||    ||_______//get node max
// ||
// ||___ORTHER____//traverse
// ||       ||____//replace a node
// ||       ||____//count number of node
// ||       ||____//reverse list
// ||       ||____//append another list
// ||       ||____//change name first
//addLast if charAt(0) = 'A', price > 100 then do nothing
    void addLast(String xOwner, int xPrice) {
        //You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        addLast(new Car(xOwner, xPrice));

    }

    void addLast(Car x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    //addFirst
    void addFirst(Car x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }

//add many
    public void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Car(a[i], b[i]));
        }
    }

//add if age > 4
    public void addLastCondition() {
        Node p = head;
        while (p != null) {
            if (p.info.price > 4) {
                addLast(p.info);
            }
            p = p.next;
        }
    }

//add element have max age
//    public void addMaxAgeInH(){
//		Car k = getMaxColor();
//		Node p = head;
//		while(p != null){
//			if(p.info.age == k.age) h.addLast(p.info);
//			p = p.next;
//		}
//	}
//insert after position k
    public void addAfterPositionK(int k, Car c) {
        Node p = new Node(c);
        if (k == -1) {
            addFirst(c);
            return;
        }
        int count = 0;
        Node p1 = head;
        while (p1 != null && count < k) {
            p1 = p1.next;
            count++;
        }
        if (p1.next == null && count == k) {
            addLast(c);
            return;
        }
        p.next = p1.next;
        p1.next = p;
    }
//Q1-f2=======add vao vi tri cu the=======

    void insertPositionK(Car x, int position) {
        if (isEmpty()) {
            head = tail = new Node(x);
        }
        if (position == 0) {
            addFirst(x);
            return;
        }
        int count = 1;
        Node p = head;
        while (p != null && count < position) {
            p = p.next;
            count++;
        }
        Node temp = p.next;
        p.next = new Node(x, temp);
    }

  

//search node by key integer/double
    public Node search(int x) {
        Node p = head;
        while (p != null && p.info.price != x) {
            p = p.next;
        }
        return p;
    }

//search node with string
    public Node search(String colorName) {
        Node p = head;
        while (p != null) {
            if (p.info.owner.equalsIgnoreCase(colorName)) {
                break;
            }
            p = p.next;
        }
        return p;
    }

    Node searchByWeight(int xWeight) {
        Node p = head;
        while (p != null) {
            if (p.info.price == xWeight) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
//search node nang thu 2 sau cai xWeight

    Node searchByWeight2nd(int xWeight) {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.info.price < xWeight) {
                count++;
            }
            if (count == 2) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

//ham remove
    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void remove(Node q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;//q ko co trong danh sach
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }
// Get the node at a specific position

    Node getNode(int position) {
        if (position < 0 || position >= size()) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }
// Remove all nodes with a given age

    public void removeAll(int xAge) {
        Node q;
        while (true) {
            q = searchByWeight(xAge);
            if (q == null) {
                break;
            }
            remove(q);
        }
    }

//remove at position k
    public void removeAt(int k) {
        if (isEmpty()) {
            return;
        }
        if (k == 0) {//check if node is head
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = getNode(k);//get node position k
            if (p == null) {
                return;
            }
            Node q = getNode(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

//remove first no age < 6
    public void deleteFirstCondition() {
        Node p = head;
        while (p != null) {
            if (p.info.price < 6) {
                remove(p);
            }
            p = p.next;
        }
    }

//remove a node after position k
    public void deleteAfterPosK(int k) {
        if (isEmpty()) {
            return;
        }
        //remove head
        if (k == -1) {
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = getNode(k + 1);
            if (p == null) {
                return;
            }
            Node q = getNode(k);
            //remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

    Node getNodet(int position) {
        if (position < 0 || position >= size()) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

// remove the node after two nodes with price < 9
    public void deleteAfterTwoNodeAgeSmallerNine() {
        Node p = head;
        while (p != null && p.info.price >= 9) {
            p = p.next;
        }
        if (p == null || p.next == null) {
            return;
        }
        remove(p.next.next);
    }

// remove the third node with age < 6
    public void removeThirdAgeSmallerSix() {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.info.price < 6 && count != 3) {
                count++;
            } else if (p.info.price < 6 && count == 3) {
                break;
            }
            p = p.next;
        }
        remove(p);
    }

// remove the first node after the node at position k
    public void deleteFirstAfterPosition(int k) {
        Node p = getNode(k);
        if (p == null || p.next == null) {
            return;
        }
        Node q = p.next;
        if (q.next == null) {
            tail = p;
            p.next = null;
        } else {
            p.next = q.next;
            q.next = null;
        }
    }

// remove the node after the node with price > xPrice
    public void deleteAfterCondition(double xPrice) {
        Node p = head;
        while (p != null && p.info.price < xPrice) {
            p = p.next;
        }
        if (p == null || p.next == null) {
            return;
        }
        Node q = p.next;
        if (q == tail) {
            tail = p;
        }
        p.next = q.next;
        q.next = null;
    }

// remove the last two nodes with age > 5
    public void removeTwoLastNodeCondition() {
        int c = 0;
        int sz = size();
        for (int i = sz - 1; i >= 0; i--) {
            Node p = getNode(i);
            if (p.info.price > 5) {
                c++;
                remove(p);
                if (c >= 2) {
                    break;
                }
            }
        }
    }
// Get first min Car

    public Car getFirstMin() {
        if (isEmpty()) {
            return null;
        }
        Car min = head.info;
        Node p = head;
        while (p != null) {
            if (p.info.price < min.price) {
                min = p.info;
            }
            p = p.next;
        }
        return min;
    }

// Get first max Car 
    public Car getFirstMax() {
        if (isEmpty()) {
            return null;
        }
        Car max = head.info;
        Node p = head;
        while (p != null) {
            if (p.info.price > max.price) {
                max = p.info;
            }
            p = p.next;
        }
        return max;
    }

// Remove the second largest node
    public void removeSecond() {
        Car firstMax = getFirstMax();
        if (firstMax == null) {
            return;
        }
        int n = size();
        if (n <= 1) {
            return;
        }
        int imax = 0;
        Node p = head;
        while (p != null && p.info.price == firstMax.price) {
            imax++;
            p = p.next;
        }
// Find the second max starting from imax
        Car secondMax = (p != null) ? p.info : null;
        for (int i = imax + 1; i < n; i++) {
            Node pi = getNode(i);
            if (pi.info.price > secondMax.price && pi.info.price != firstMax.price) {
                imax = i;
                secondMax = pi.info;
            }
        }
        if (imax < n) {
            removeAt(imax);
//            remove(imax);
        }
    }
    //remove second node having max type
//    int max = maxType();
//        int count=0;
//        Node p=head;
//        while(p!=null){
//            if(p.info.type==max){
//                count++;
//                if(count==2) remove(p);
//            }
//            p=p.next;
//         }
    //remove the node after the first min hoof (if first min hoof is tail then do nothing
    public void removeNodeAfterFirstMin() {
        Car firstMin = getFirstMin();
        if (firstMin == null) {
            return;
        }
        if (firstMin == tail.info) {
            return;
        }
        int imax = 0;
        Node p = head;
        while (p != null && p.info.price != firstMin.price) {
            imax++;
            p = p.next;
            if (p.info.price == firstMin.price) {
                break;
            }
        }
        int n = size();
        imax = imax + 1;

        if (imax < n) {
            removeAt(imax);
        }
    }

    int maxType() {
        Node p = head;
        int max = p.info.price;
        while (p != null) {
            if (p.info.price > max) {
                max = p.info.price;
            }
            p = p.next;
        }
        return max;
    }

//Q1-f4======sort theo yeu cau de bai======
//ham sort tu vi tri k den vi tri h
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return p;
            }
            i++;
            p = p.next;
        }
        return null;
    }

    void sortByWeight(int k, int h) {
        if (k > h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        int n = size();
        if (h > n - 1) {
            h = n - 1;
        }
        Node u = pos(k);
        Node v = pos(h + 1);
        Node pi, pj;
        Car x;
        pi = u;
        while (pi != v) {
            pj = pi.next;
            while (pj != v) {
                if (pj.info.price < pi.info.price) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
//tim max

    int findMaxWeight() {
        int x;
        Node p, q;
        p = q = head;
        x = head.info.price;
        p = p.next;
        while (p != null) {
            if (p.info.price > x) {
                x = p.info.price;
                q = p;
            }
            p = p.next;
        }
        return x;
    }
// tim position

    int getIndex(int rate) {
        int indexRes = 0;
        Node p = head;
        while (p != null) {
            if (p.info.price == rate) {
                break;
            }
            indexRes++;
            p = p.next;
        }

        return indexRes;
    }

//sort by string
    public void sortByString() {
        Node pi, pj;
        Car x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.owner.compareTo(pi.info.owner) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

//sort by integer/ double
    public void sortByInt() {
        Node pi, pj;
        Car x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.price < pi.info.price) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

//sort by for
    public void sortByFor() {
        int n = (size() > 3) ? 3 : size();
        //int n = size();         
        // for(int i = n-3; i < n; i++) //last 3 element
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) { //first 3 element
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.owner.compareToIgnoreCase(pj.info.owner) > 0) {
                    Car temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }

//sort 3 first element 
    public void sortThird() {
        Node pi, pj;
        pi = head;
        int count = 0;
        while (pi != null) {
            count++;
            pj = pi.next;
            int count1 = 0;
            while (pj != null) {
                count1++;
                if (pi.info.owner.compareToIgnoreCase(pj.info.owner) < 0) {
                    Car t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
                pj = pj.next;
                if (count1 == 3 - count) {
                    break;
                }
            }
            pi = pi.next;
            if (count == 2) {
                break;
            }
        }
    }

//Get first min node
    public Node getMinFirst() {
        if (isEmpty()) {
            return null;
        }
        Node min = head;
        Node p = head;
        while (p != null) {
            if (p.info.price < min.info.price) {
                min = p;
            }
            p = p.next;
        }
        return min;
    }

//Get first max node
    public Node getMaxFirst() {
        if (isEmpty()) {
            return null;
        }
        Node max = head;
        Node p = head;
        while (p != null) {
            if (p.info.price > max.info.price) {
                max = p;
            }
            p = p.next;
        }
        return max;
    }

//swap min max
    public void swapMinMax() {
        Node min = getMinFirst();
        Node max = getMaxFirst();
        Car t = min.info;
        min.info = max.info;
        max.info = t;
    }

//swap node max second with node min first
    public void swapMax2Min1() {
        Node max = getMaxFirst();
        Node min = getMinFirst();
        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.info.price == max.info.price) {
                count++;
            }
            if (count == 2) {
                break;
            }
            p = p.next;
        }
        Car temp;
        temp = p.info;
        p.info = min.info;
        min.info = temp;

    }

//traverse
    public void traverse() {
        MyListsrc h = new MyListsrc();
        Node p = head;
        Car x;
        while (p != null) {
            x = p.info;
            h.addFirst(x);
            p = p.next;
        }
        head = h.head;
        tail = h.tail;
    }

//replace a node
    public void replace() {
        Node p = head;
        while (p != null) {
            if (p.info.owner.equals("xName")) {// xName was given
                break;
            }
            p = p.next;
        }
        if (p != null) {
            p.info.owner = "yName";// yName was given
        }
    }

//reverse list
    public void reverse() {
        int n = size(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i);// create a node = getnode index i
            Node pj = getNode(j);// create a node = getnode index j
            Car temp = pi.info;// Note: change value of node, not change node
            pi.info = pj.info;
            pj.info = temp;
        }
    }

//append another list
    void appendAnotherList(MyListsrc h) {
        Node p = h.head;
        while (p != null) {
            addLast(p.info);
            p = p.next;
        }
    }

//change name first
    void changeNameFirst() {
        Node p = head;
        while (p != null) {
            if (p.info.owner.equals("C6")) {
                p.info.owner = "CX";
                break;
            }
            p = p.next;
        }
    }
}
