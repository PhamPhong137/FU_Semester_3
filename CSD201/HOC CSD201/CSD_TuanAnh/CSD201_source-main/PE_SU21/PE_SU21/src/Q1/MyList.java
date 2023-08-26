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
            if (cur.next != null) {
                System.out.print(cur.value);
            } else {
                System.out.print(cur.value);
            }
            cur = cur.next;
        }
        System.out.println("");
    }

    void addLast(String xPlace, int xDepth, int xType) {
        if (xPlace.charAt(0) == 'A') {
            return;
        }
        Node node = new Node(new Castor(xPlace, xDepth, xType));
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void addFirst(String xPlace, int xDepth, int xType) {
        Node node = new Node(new Castor(xPlace, xDepth, xType));
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    void clear() {
        head = tail = null;
    }

    void addIndex(String xPlace, int xDepth, int xType, int index) {
        Node node = new Node(new Castor(xPlace, xDepth, xType));
        if (index <= 0) {
            addFirst(xPlace, xDepth, xType);
        } else if (index >= size) {
            addLast(xPlace, xDepth, xType);
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
        } else if (index == size - 1) {
            deleteLast();
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

    Node findNodeMax() {
        Node cur = head;
        Node max = head;
        while (cur != null) {
            if (cur.value.type > max.value.type) {
                max = cur;
            }
            cur = cur.next;
        }
        return max;
    }

    void changeMax() {
        Node cur = head;
        Node max = findNodeMax();
        int i = 0;
        while (cur != null && i < 1) {
            if (cur.value.type == max.value.type) {
                cur.value.setPlace("YY");
                i++;
            }
            cur = cur.next;
        }
    }
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<Castor> arr1 = new ArrayList<>();

    void addElement() {
        Node cur = head;
        int idx = -1, i = 0;
        while (cur != null && i < 4) {
            idx++;
            if (idx == 2) {
                i++;
                arr.add(idx);
                arr1.add(cur.value);
            }
            if (idx == 3) {
                i++;
                arr.add(idx);
                arr1.add(cur.value);
            }
            if (idx == 4) {
                i++;
                arr.add(idx);
                arr1.add(cur.value);
            }
            if (idx == 5) {
                i++;
                arr.add(idx);
                arr1.add(cur.value);
            }

            cur = cur.next;
        }
    }

    void deleteElement() {
        Node cur = head;
        int i = 0, idx = -1;
        while (cur != null && i < 4) {
            idx++;
            if (idx == 2 || idx == 3 | idx == 4 || idx == 5) {
                i++;
                delete(idx);
                idx--;
            }
            cur = cur.next;
        }
    }

    void sort() {
        Collections.sort(arr1, new Comparator<Castor>() {
            @Override
            public int compare(Castor o1, Castor o2) {
                return o1.getType() - o2.getType();
            }
        });
    }
}
