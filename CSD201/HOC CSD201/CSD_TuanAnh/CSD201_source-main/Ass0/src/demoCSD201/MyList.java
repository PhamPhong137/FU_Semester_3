/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoCSD201;


/**
 *
 * @author Admin MSI
 */
public class MyList {
    Node head, tail;
    int size;
    
    public MyList(){
    head  = tail = null;
    size  = 0;
    }
    boolean isEmpty() {
        return head == null;
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("");
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
            // if list empty create first block;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    int findIndex() {
        int indext = 0;
        Node cu = head;
        int count = 0;
        while (cu != null) {
            if (check(cu.value)) {
                count++;
            }
            if (count == 3) {
                return indext + 1;
            }
            cu = cu.next;
            indext++;
        }
        return -999;
    }

    boolean check(int n) {
        int count = 0;
        if (n == 1) {
            count++;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    void addIndext(int value, int indext) {
        if (indext == 0) {
            addFirst(value);
            return;
        }
        if (indext == size) {
            addLast(value);
            return;
        }
        int count = 0;
        Node cu = head;
        while (cu != null && count != indext - 1) {
            count++;
            cu = cu.next;
        }
        if (cu == null) {
            return;
        } else {
            Node node = new Node(value);
            node.next = cu.next;
            cu.next = node;
            size++;
        }
    }

    int deleteFirst() {
        if (isEmpty()) {
            return -999;
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    void delFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;
    }

    int deletaLast() {
        if (isEmpty()) {
            return -999;
        }
        if (head.next == null) {
            int value = head.value;
            head = null;
            size--;
            return value;
        }
        Node cu = head;

        while (cu.next.next != null) {
            cu = cu.next;
        }
        int value = cu.next.value;
        cu.next = null;
        size--;
        tail = cu;
        return value;
    }

    void delLast() {
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node cu = head;
        while (cu.next.next != null) {
            cu = cu.next;
        }
        cu.next = null;
        tail = cu;
        size--;
    }

    void deleteIndext(int indext) {
        if (indext < 0 || indext > size) {
            return;
        }
        if (indext == 0) {
            delFirst();
            return;
        }
        int count = 0;
        Node cu = head;
        while (count != indext - 1) {
            count++;
            cu = cu.next;
        }
        cu.next = cu.next.next;
        size--;
    }
}
