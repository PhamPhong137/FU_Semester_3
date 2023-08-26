/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

/**
 *
 * @author PC-Phong
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    void addFirst(int value) {
        Node p = new Node(value);

        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head.prev = p;
            head = p;
        }
        size++;
    }

    void addLast(int value) {
        Node p = new Node(value);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            p.prev = tail;
            tail = p;
        }
        size++;
    }

    void delFirst() {
        if (isEmpty()) {
            return;
        }
        head.next.prev = null;
        head = head.next;
        size--;
    }

    void delLast() {
        if (isEmpty()) {
            return;
        }
        tail.prev.next = null;
        tail = tail.prev;
        size--;
    }

    void addIndex(int value, int index) {
        Node node = new Node(value);
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addFirst(value);
        } else if (index == size - 1) {
            addLast(value);
        } else {
            if (index < size / 2) {
                // đặt p ở trước vị trí cần add
                int count = 0;
                Node p = head;
                while (count != index - 1) {
                    count++;
                    p = p.next;
                }
                node.next = p.next;
                p.next.prev = node;
                node.prev = p;
                p.next = node;
            } else {
                // đặt p ở sau vị trí cần add
                int count = size - 1;
                Node p = tail;
                while (count != index) {
                    count--;
                    p = p.prev;
                }
                node.prev = p.prev;
                p.prev.next = node;
                node.next = p;
                p.prev = node;
            }
            size++;
        }
    }

    void display() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info + " ");
            p = p.next;
        }
    }
}
