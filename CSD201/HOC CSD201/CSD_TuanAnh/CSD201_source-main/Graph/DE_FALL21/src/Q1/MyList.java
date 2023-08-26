/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public MyList() {
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
            addFirst(value.getForest(),value.getRate(), value.getSound());
        } else if (index >= size) {
            addLast(value.getForest(),value.getRate(), value.getSound());
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

    void deleteSec_Thr() {
        Node cur = head;
        int idx=-1,i=0;
        while (cur != null) {
            idx++;
            if (idx==1&&i<2) {
                delete(idx);
                i++;
                idx--;
            }
            cur = cur.next;
        }
    }
    
    ArrayList<Bee> arr2 = new ArrayList<>();
    void addElement(){
        ArrayList<Bee> arr1 = new ArrayList<>();
        Node cur = head;
        while(cur!=null){
            arr1.add(cur.value);
            cur = cur.next;
        }
        int i = 0;
        while(i<5){
            arr2.add(arr1.get(0));
            arr1.remove(0);
            i++;
        }
        Collections.sort(arr2, new Comparator<Bee>(){
            @Override
            public int compare(Bee o1, Bee o2) {
                return o1.getSound()-o2.getSound();
            }
            
        });
        arr2.addAll(arr1);
    }
}
