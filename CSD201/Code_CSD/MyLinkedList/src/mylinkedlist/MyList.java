/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinkedlist;

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

    void addFirst(String value) {
        Node p = new Node(value);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
        size++;
    }

    void addLast(String value) {
        Node p = new Node(value);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }

    }

    String delFirst() {
        if (isEmpty()) {
            return "";
        }
        String value = head.info;
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

    void addIndex(String value, int index) {
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

    String getFirst() {
        Node p = head;
        return p.info;

    }

    String getLast() {
        Node p = tail;
        return p.info;
    }

    

    void display() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info + " ");
            p = p.next;
        }
    }

}
