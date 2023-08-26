/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylist;

public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void addIndex(int value, int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(value);
        } else {
            Node cur = head;
            int pos = 0;
            while (cur != null) {
                if (index - 1 == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur == null) {
                return;
            } else {
                Node node = new Node(value);
                if (cur.next == null) {
                    addLast(value);
                } else {
                    node.next = cur.next;
                    cur.next = node;
                }
            }
        }
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        System.out.println("");
    }

    void deleteFirst() {

    }

    int delFirst() {
        return -1;
    }

    void deleteLast() {

    }

    int delLast() {
        return -1;
    }

    void deleteIndex(int index) {

    }

    int delIndext(int index) {
        return -1;
    }

    public static void main(String[] args) {
        MyList my = new MyList();
        my.addFirst(1);
        my.addFirst(2);
        my.addFirst(3);
        my.addFirst(4);
        my.addFirst(5);
        my.addFirst(6);
        my.addLast(90);
        my.addIndex(100, 2);
        my.display();
    }
}
