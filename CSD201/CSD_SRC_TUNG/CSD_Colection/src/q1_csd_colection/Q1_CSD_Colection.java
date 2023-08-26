/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1_csd_colection;

/**
 *
 * @author VICTUS
 */
public class Q1_CSD_Colection {

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

    //================ f1() ===================//
    //=========================================//
    //addLast if charAt(0) = 'A', price > 100 then do noting
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

    //================ f2() ===================//
    //=========================================//
    //suppose the list have x element, insert so x and y is 4th 3rd element of the list
    /*
    insertAfter(pos(2), y);
    insertAfter(pos(3), x);
     */
    void insertAfter(Node q, Ball x) {
        if (isEmpty() || q == null) {
            return;
        }
        Node q1 = q.next;
        Node p = new Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }

    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    void insertBefore(Node q, Dog x) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; //q is not in the list
        }
        insertAfter(f, x);// before q
    }

    //insert before the last element
//    Node n = getNode(3);
//
//    addBefore(n, y);
//    Node new_node = new Node(x, head);
//    head  = new_node;
    void addBefore(Node q, Box p) {
        Node node = this.head;

        while (node != null) {
            if (node.equals(q)) {
                Node new_node = new Node(p, node.next);
                node.next = new_node;
                break;
            }
            node = node.next;
        }
    }

    public Node getNode(int k) {
        if (k < 0) {
            return null;
        }
        Node node = head;
        int t = 0;
        // loop until not come to the k-index or end of list
        while (t < k && node != null) {
            t++;
            node = node.next;
        }
        // even if k > n-1 ==> node = null ==> return null is exactly suitable
        return node;
    }

    /*
    Suppose the list contains at least 5 elements. Write statements to insert
    x and y to the list so that y will be 3-rd, x will be the last node. 
     */
    // insertAfter(pos(1), y);
    // Node n = getNode(size() - 1);
    // insertBefore(n, x);
    void insertAfter(Node q, Bike x) {
        if (isEmpty() || q == null) {
            return;
        }
        Node q1 = q.next;
        Node p = new Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }

    void addFirst(Bike x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }

    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    void insertBefore(Node q, Bike x) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        insertAfter(f, x);
    }

    public Node getNode(int k) {
        if (k < 0) {
            return null;
        }
        Node node = head;
        int t = 0;
        while (t < k && node != null) {
            t++;
            node = node.next;
        }
        return node;
    }


    /*
        Suppose the list contains at least 3 elements. Write statements to insert
    x and y to the list so that x will be the 2nd, y will be the 3rd elements in the list
     */
//        insertAfter(pos(0), x);
//        insertAfter(pos(1), y);
    void insertAfter(Node q, Bird x) {
        if (isEmpty() || q == null) {
            return;
        }
        Node q1 = q.next;
        Node p = new Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }

    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    void insertBefore(Node q, Bird x) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; //q is not in the list
        }
        insertAfter(f, x);// before q
    }

    void addFirst(Bird x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }

    //================ f3() ===================//
    //=========================================//
    //Remove the first node having price < 6
//    Node p = head;
//    while (p!= null) {
//            if (p.info.price < 6) {
//            remove(p);
//        }
//        p = p.next;
//    }
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
            return;
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    /*
    Remove the second node having weight < 6
     */
//     Node p = head;
//        int count = 0;
//        while (p != null) {
//            if (p.info.weight < 6) {
//                count++;
//                if (count == 2) {
//                    remove(p);
//                }
//            }
//            p = p.next;
//        }
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
            return;
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
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
            return; // q is not in the list
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    int maxType() {
        Node p = head;
        int max = p.info.type;
        while (p != null) {
            if (p.info.type > max) {
                max = p.info.type;
            }
            p = p.next;
        }
        return max;
    }

//    swap element at 2 and 4 (start at 0)
//    swap(getNode(2), getNode(4));
    void swap(Node i, Node j) {
        Box p = i.info;
        i.info = j.info;
        j.info = p;
    }

    //find second node havnf rate < 6 hen change its wing to 99
//    Node p = head;
//        int count = 0;
//        while (p != null) {
//            if (p.info.rate < 6) {
//                count++;
//                if (count == 2) break;
//            }
//            p = p.next;
//        }
//        p.info.wing = 99;

    /*
        Suppose the list contains at least 3 elements. Delete first and the third
    elements of the original list.
     */
//        remove(pos(0));
//        remove(pos(1));
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
            return;
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    //================ f4() ===================//
    //=========================================//
    //sort from element to element descending
//    sortByType(0, 3);
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    void sortByPrice(int k, int h) {
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
        Bat x;
        for (pi = u; pi != v; pi = pi.next) {
            for (pj = pi.next; pj != v; pj = pj.next) {
                if (pj.info.price > pi.info.price) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }

    }

    //sort the whole list
//    Node cur = head;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4 - i - 1; j++) {
//                Node lhs = get(j);
//                Node rhs = get(j + 1);
//                if (lhs.info.type < rhs.info.type) {
//                    Ball temp = lhs.info;
//                    lhs.info = rhs.info;
//                    rhs.info = temp;
//                }
//            }
//        }
    int size() {
        Node node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    Node get(int index) {
        if (index == 0) {
            return head;
        }
        if (index == size() - 1) {
            return tail;
        }
        if (index > 0 && index < size() - 1) {
            int i = 0;
            Node cur = head;
            while (i != index) {
                cur = cur.next;
                i++;
            }
            return cur;
        } else {
            return null;
        }
    }

    //reverse the first 4 element
    swap(getNode

    (0), getNode(3));
    swap(getNode

    (1), getNode(2));
    
    void swap(Node i, Node j) {
        Box p = i.info;
        i.info = j.info;
        j.info = p;
    }

    //sort from begin to first max rate
//    Node p = head;
//        int max = head.info.rate;
//        while (p != null) {
//            if (p.info.rate > max) {
//                max = p.info.rate;
//            }
//            p = p.next;
//        }
//        int i = getIndex(max);
//        sortFirstKElements(i);
    int getIndex(int rate) {
        int indexRes = 0;
        Node p = head;
        while (p != null) {
            if (p.info.rate == rate) {
                break;
            }
            indexRes++;
            p = p.next;
        }

        return indexRes;
    }

    void sortFirstKElements(int k) {
        for (int i = 0; i < k - 1; i++) {
            int count = 0;
            for (Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if (pj.info.rate > pj.next.info.rate) {
                    Bird temp = pj.info;
                    pj.info = pj.next.info;
                    pj.next.info = temp;
                }
            }
        }
    }


    /*
    Sort from (first) min weight to the end ascendingly by weight  
     */
//    Node p = head;
//        int min = head.info.weight;
//        while (p != null) {
//            if (p.info.weight < min) {
//                min = p.info.weight;
//            }
//            p = p.next;
//        }
//        int i = getIndex(min);
//        sortByWeight(i, size());
    int getIndex(int rate) {
        int indexRes = 0;
        Node p = head;
        while (p != null) {
            if (p.info.weight == rate) {
                break;
            }
            indexRes++;
            p = p.next;
        }

        return indexRes;
    }

    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
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
        Bike x;
        for (pi = u; pi != v; pi = pi.next) {
            for (pj = pi.next; pj != v; pj = pj.next) {
                if (pj.info.weight < pi.info.weight) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }
}


/*
         Suppose the list contains at least 4 elements. Sort the first 4 elements
    ascendingly by rate. 
 */
//  sortByRate(0, 3);
int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    void sortByRate(int k, int h) {
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
        Bird x;
        for (pi = u; pi != v; pi = pi.next) {
            for (pj = pi.next; pj != v; pj = pj.next) {
                if (pj.info.rate < pi.info.rate) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }
