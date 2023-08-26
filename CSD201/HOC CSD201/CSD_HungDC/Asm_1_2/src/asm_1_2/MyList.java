/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
    }

    // check if the list is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    //output list
    public void display() {
        Node cur = head;
        while (cur != null) {
            if (cur == tail) {
                System.out.println(cur.bird.toString());
            } else {
                System.out.print(cur.bird.toString());
            }
            cur = cur.next;
        }
    }

    // f1: add a new node to the end of the list
    public void addLast(String xType, int xrate, int xWing) {
        Bird b = new Bird(xType, xrate, xWing);
        Node newNode = new Node(b);
        if (xType.charAt(0) == 'B') {
            return;
        }
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // add a new node to the beginning of the list
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

    // f2: add after a node
    public void addIndex(String xType, int xRate, int xWing, int index) {
        if (index == 0) {
            addFirst(xType, xRate, xWing);
        }
        if (index == size) {
            addLast(xType, xRate, xWing);
        }
        int count = 0;
        Bird b = new Bird(xType, xRate, xWing);
        Node newNode = new Node(b);
        Node cur = head;
        while (count != index - 1 && cur != null) {
            count++;
            cur = cur.next;
        }
        if (cur == null) {
            return;
        } else {
            newNode.next = cur.next;
            cur.next = newNode;
        }
        size++;
    }

    // f3: find the second node having rate < 6 and change it's wing to 99
    public void f3() {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            if (cur.bird.getRate() < 6) {
                count++;
            }
            if (count == 2) {
                break;
            }
            cur = cur.next;
        }
        cur.bird.setWing(99);
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        Node cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }

        cur.next = null;
        tail = cur;
        size--;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        } else if (index == size - 1) {
            deleteLast();
            return;
        }

        Node cur = head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        cur.next = cur.next.next;
        size--;
    }

    // f4: sort from beginning to first max rate ascendingly
    public void f4() {
        Node max = head, cur = head.next;
        int count = 0, pos = -1;
        while (cur != null) {
            if (cur.bird.getRate() > max.bird.getRate()) {
                max = cur;
                pos = count;
            }
            cur = cur.next;
            count++;
        }
        ArrayList<Node> list = new ArrayList<>();
        Node p = head;
        for (int i = 0; i < pos + 1; i++) {
            list.add(p);
            p = p.next;
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node t, Node t1) {
                return t.bird.getRate() < t1.bird.getRate() ? 1 : -1;
            }
        });
        
        for(int i=0; i<pos+1; i++){
            deleteFirst();
//           addIndex(list.get(i).bird.getType(), list.get(i).bird.getRate(), list.get(i).bird.getWing(), i);
        }
        for(int i=0; i<pos+1; i++){
            addFirst(list.get(i).bird.getType(), list.get(i).bird.getRate(), list.get(i).bird.getWing());
        }
    }

}
