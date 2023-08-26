/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_1_3;

/**
 *
 * @author Admin
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print("(" + cur.infor.getName() + "," + cur.infor.getMark() + ")");
            cur = cur.next;
        }
        System.out.println("");
    }

    //F1: add to the end of the list to create a new list
    public void addLast(String name, int mark) {
        if (mark < 0 || mark > 100) {
            return;
        }
        Node p = new Node(new Student(name, mark));
        if (isEmpty()) {
            head = tail = p;
        } else {
            this.tail.next = p;
            p.pre = this.tail;
            this.tail = p;
        }
        size++;
    }

    //F2: sort
    public void sort() {
        Node cur = head;
        Student s = new Student();
        for (int i = 0; i < size; i++) {
            Node cur2 = cur.next;
            for (int j = 1; j < size - i; j++) {
                if (cur2.infor.getMark() < cur.infor.getMark()) {
                    s = cur.infor;
                    cur.infor = cur2.infor;
                    cur2.infor = s;
                }
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
    }

    //F3: add Index from the beginning if student have mark<50
    //    add Index from the beginning if student have mark>50
    public void addIndex(String name, int mark) {
        Node n = new Node(new Student(name, mark));
        if (mark < 50) {
            if (isEmpty()) {
                return;
            }
            Node cur = head;
            int count = 0;
            while (cur.infor.getMark() < mark) {
                cur = cur.next;
                count++;
            }
            if (cur == null && count == size) {
                tail.next = n;
                n.pre = this.tail;
                tail = n;
                size++;
            } else {
                n.next = cur;
                cur.pre.next = n;
                n.pre = cur.pre;
                cur.pre = n;
                size++;
            }
        } else {
            if (isEmpty()) {
                return;
            }
            Node cur = tail;
            int count = size - 1;
            while (cur.infor.getMark() > mark) {
                cur = cur.pre;
                count--;
            }
            if (cur == null && count == 0) {
                head.pre = n;
                n.next = this.head;
                head = n;
                size++;
            } else {
                n.pre = cur;
                n.next = cur.next;
                cur.next.pre = n;
                cur.next = n;
//                Node p = new Node(new Student(n.infor.getName(), n.infor.getMark()));
//                n.infor.getName() = n.pre.infor.getName();
            }
        }
    }

    //F4: delete the student having mark <= 3
    public void delete() {
        if (isEmpty()) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.infor.getMark() <= 3) {
                if (cur == head) {
                    this.head = this.head.next;
                    this.head.pre = null;
                } else {
                    cur.pre.next = cur.next;
                    if (cur.next != null) {
                        cur.next.pre = cur.pre;
                    } else {
                        this.tail = cur.pre;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //F5: print out average mark
    public void averageMark() {
        Double avr;
        Node cur = head;
        int sum = 0, count = 0;
        while (cur != null) {
            sum += cur.infor.getMark();
            count++;
            cur = cur.next;
        }
        avr = (double) (sum) / (double) (count);
        System.out.println("Average mark of the student list: " + avr);
    }
}
