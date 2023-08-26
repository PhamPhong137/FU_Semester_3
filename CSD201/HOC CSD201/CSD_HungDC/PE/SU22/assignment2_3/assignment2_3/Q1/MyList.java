/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_3.Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author TLC
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value.toString());
            cur = cur.next;
        }
        System.out.println("");
    }

    void addLast(String xForest, int xRate, int xSound) {
        if (xForest.charAt(0) == 'A') {
            return;
        }
        Bee value = new Bee(xForest, xRate, xSound);
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void addFirst(String xForest, int xRate, int xSound) {
        Bee value = new Bee(xForest, xRate, xSound);
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    void addIndex(Bee value, int index) {
        //Bee value = new Bee(xForest, xRate, xSound);
        Node node = new Node(value);
        if (index <= 0) {
            addFirst(value.getForest(), value.getRate(), value.getSound());
        } else if (index >= size) {
            addLast(value.getForest(), value.getRate(), value.getSound());
        } else {
            int count = 0;
            Node cur = head;
            while (cur != null && count != index - 1) {
                cur = cur.next;
                count++;
            }

            node.next = cur.next;
            cur.next = node;
            size++;
        }
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;
    }

    void deleteLast() {
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

    void delete(int index) {
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
        // 8 5 9 2 1
        Node cur = head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        cur.next = cur.next.next;
        size--;
    }

    void f04() {
        List<Bee> beeList = new ArrayList<>();
        Node cur = head;
        int count = 0;
        while (cur != null) {
            if (count <= 4) {
                beeList.add(cur.value);
            }
            cur = cur.next;
            count++;
        }
        Collections.sort(beeList, new Comparator<Bee>() {
            @Override
            public int compare(Bee o1, Bee o2) {
                return o1.getSound() - o2.getSound();
            }
        });
        for (int i = 0; i < 5; i++) {
            deleteFirst();
        }
        
        int beeSize =beeList.size();
        for (int i = beeSize-1; i >= 0; i--) {
            String forest =beeList.get(i).getForest();
            int rate =beeList.get(i).getRate();
            int sound = beeList.get(i).getSound();
            addFirst(forest, rate, sound);
        }
        display();
    }
}
