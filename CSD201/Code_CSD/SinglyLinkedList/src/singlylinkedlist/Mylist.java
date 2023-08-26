/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 *
 * @author PC-Phong
 */
public class Mylist {

    Node head, tail;
    int size;

    public Mylist() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int value) {
        Node p = new Node(value);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
        size++;
    }

    void addIndex(int value, int index) {
        if (index <= 0) {
            addFirst(value);
            return;
        }
        if (index >= size) {
            addLast(value);
            return;
        }

        int count = 0;
        Node p = head;
        while (p != null && count != index - 1) {
            count++;
            p = p.next;
        }

        if (p == null) {
            return;
        } else {
            Node node = new Node(value);
            node.next = p.next;
            p.next = node;
            size++;
        }
    }

    void addLast(int value) {
        Node p = new Node(value);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
        size++;
    }

    void display() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
    }

    // có trả về 
    int delFirst() {
        if (isEmpty()) {
            return -1;
        }
        int value = head.info;
        head = head.next;
        return value;
    }

    //ko trả vờ
    void deleFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;
    }

    void deleLast() {
        if (isEmpty()) {
            return;
        }
        Node p = head;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        tail = p;
        size--;
    }

    void deleteIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            delFirst();
            return;
        }
        if (index == size - 1) {
            deleLast();
            return;

        }
        int count = 0;
        Node p = head;
        while (count != index - 1) {
            p = p.next;
            count++;
        }
        p.next = p.next.next;
        size--;
    }

    int getFirst() {
        Node p = head;
        return p.info;

    }

    int getLast() {
        Node p = tail;
        return p.info;
    }

    void searchIndexOfValue(int value) {
        Node p = head;
        int count = 0;
        int c = 0;
        while (p != null) {
            if (p.info == value) {
                System.out.print(count + " ");
                c = 1;
            }
            p = p.next;
            count++;
        }
        if (c == 0) {
            System.out.println("Not found");
        }

    }

    Node findNodeByValue(int index) {
        Node p = head;
        while (p != null) {
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    return p;
                }
                p = p.next;
            }

        }
        return null;
    }

    void swapNode(int index1, int index2) {
        if (index1 == index2) {
            return;
        }

        Node node1 = findNodeByValue(index1);
        Node node2 = findNodeByValue(index2);

        if (node1 == null || node2 == null) {
            return;
        }

        int temp = node1.info;
        node1.info = node2.info;
        node2.info = temp;
    }

    void sortIndex() {
        if (size <= 1) {
            return;
        }

        boolean swapped = true;
        Node lastSorted = null;

        while (swapped) {
            swapped = false;
            Node p = head;

            while (p != lastSorted && p.next != null) {
                if (p.info > p.next.info) {
                    // Swap the nodes
                    int temp = p.info;
                    p.info = p.next.info;
                    p.next.info = temp;
                    swapped = true;
                }
                p = p.next;
            }

            lastSorted = p;
        }

    }

}
