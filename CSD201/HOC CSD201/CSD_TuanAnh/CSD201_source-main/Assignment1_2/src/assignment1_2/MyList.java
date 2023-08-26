/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyList {

    Bird head, tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Bird cur = head;
        while (cur != null) {
            if (cur.next != null) {
                System.out.print(cur.toString());
            } else {
                System.out.print(cur.toString());
                System.out.println("");
            }
            cur = cur.next;
        }
    }

    void addFirst(String Type, int xRate, int xWing) {
        Bird x = new Bird(Type, xRate, xWing);
        if (isEmpty()) {
            head = tail = x;
        } else {
            x.next = head;
            head = x;
        }
        size++;
    }

    public void addLast(String xType, int xRate, int xWing) {
        if (xType.charAt(0) == 'B') {
            return;
        }
        Bird x = new Bird(xType, xRate, xWing);
        if (isEmpty()) {
            head = tail = x;
        } else {
            tail.next = x;
            tail = x;
        }
        size++;
    }

    public void addIndex(String xType, int xRate, int xWing, int idx) {
        if (idx <= 0) {
            addFirst(xType, xRate, xWing);
        } else if (idx >= (size)) {
            addLast(xType, xRate, xWing);
        } else {
            Bird x = new Bird(xType, xRate, xWing);
            Bird cur = head;
            int count = 0;
            while (cur != null && count != (idx - 1)) {
                cur = cur.next;
                count++;
            }
            x.next = cur.next;
            cur.next = x;
            size++;
        }
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head.next = head;
        size--;
    }

    void deleteLast() {
        if (isEmpty()) {
            return;
        }
        Bird cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }
        cur.next = null;
        tail = cur;
        size--;
    }

    void deleteIndex(int idx) {
        if (idx < 0 || idx > (size - 1)) {
            return;
        } else if (idx == 0) {
            deleteFirst();
            return;
        } else if (idx == size - 1) {
            deleteLast();
            return;
        }
        int count = 0;
        Bird cur = head;
        while (cur != null && count != (idx - 1)) {
            cur = cur.next;
            count++;
        }
        cur.next = cur.next.next;
        size--;
    }

    int countLess() {
        Bird cur = head;
        int count = 0;
        while (cur != null) {
            if (cur.rate < 6) {
                count++;
            }
            cur = cur.next;
        }
        if (count < 2) {
            System.out.println("Dont have the second node having rate < 6.");
            return -1;
        } else {
            return count;
        }
    }
// 8 5 2 1

    int findNode() {
        int idx = -1, i = 0;
        Bird fx = head;
        while (fx != null && i < 2) {
            idx++;
            if (fx.rate < 6) {
                i++;
            }
            fx = fx.next;
        }
        return idx;
    }

    int findRateMax() {
        Bird cur = head;
        int rateMax = cur.rate;
        while (cur != null) {
            if (rateMax < cur.rate) {
                rateMax = cur.rate;
            }
            cur = cur.next;
        }
        return rateMax;
    }

    int findIndexFirstRate() {
        Bird cur = head;
        int valueMax = findRateMax();
        int i = 0;
        int idx = -1;
        while (cur != null && i < 1) {
            idx++;
            if (cur.rate == valueMax) {
                i++;
            }
            cur = cur.next;
        }
        return idx;
    }

    void f1() {
        addLast("A", 9, 8);
        addLast("C", 6, 5);
        addLast("D", 2, 4);
        addLast("E", 7, 9);
        addLast("F", 4, -7);
        addLast("G", -3, 2);
        display();
    }

    void f2() {
        addLast("A", 9, 8);
        addLast("D", 6, 3);
        addLast("E", 8, 5);
        addLast("F", 5, 4);
        addLast("I", 4, 9);
        display();
        addIndex("X", 1, 2, 3);
        addIndex("Y", 3, 4, 5);
        display();
    }

    void f3() {
        addLast("C", 8, 6);
        addLast("D", 3, 5);
        addLast("E", 9, 2);
        addLast("F", 5, 8);
        addLast("G", 9, 7);
        addLast("H", 6, 8);
        addLast("I", 7, 3);
        display();
        int n = countLess();
        if (n < 0) {
            return;
        }
        int idxNode = findNode();
        deleteIndex(idxNode);
        addIndex("F", 5, 99, idxNode);
        display();
    }

    void f4() {
        addLast("C", 1, 2);
        addLast("D", 10, 3);
        addLast("E", 2, 15);
        addLast("F", 11, 6);
        addLast("I", 6, 14);
        addLast("J", 11, 15);
        addLast("K", 7, 9);

        ArrayList<Bird> listArr = new ArrayList<>();
        ArrayList<Bird> listArr1 = new ArrayList<>();
        listArr.add(new Bird("C", 1, 2));
        listArr.add(new Bird("D", 10, 3));
        listArr.add(new Bird("E", 2, 15));
        listArr.add(new Bird("F", 11, 6));
        listArr.add(new Bird("I", 6, 14));
        listArr.add(new Bird("J", 11, 15));
        listArr.add(new Bird("K", 7, 9));
         for (Bird o : listArr) {
            System.out.print(o);
        }
        int i = 0;
        while(i<=findIndexFirstRate()){
              i++;
             listArr1.add(listArr.get(0));
             listArr.remove(0);
        }
       
        System.out.println("");
        Collections.sort(listArr1, new Comparator<Bird>(){
            @Override
            public int compare(Bird o1, Bird o2) {
                return o1.getRate()-o2.getRate();
            }
            
        });
        listArr1.addAll(listArr);
        for (Bird b : listArr1) {
            System.out.print(b);
        }
        System.out.println("");
    }

}
