/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt1;

/**
 *
 * @author PC-Phong
 */
public class MyQueue {

    Node head, tail;
    int size;

    public MyQueue() {
        head = tail = null;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    public void enqueue(Student student) {
        Node p = new Node(student);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = tail.next;
        }
        size++;
    }

    public void dequeue() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void search(String key) {
        Node p = head;
        boolean check = false;
        while (p != null) {
            if (p.student.getStudentID().equals(key)) {
                System.out.println(p.student);
                check = true;
            }

            p = p.next;
        }
        if (check == false) {
            System.out.println("Not Found");
        }

    }

    public void studentMax() {
        Node p = head;
        Node maxNode = tail;

        while (p != null) {
            if (p.student.getAVG() > maxNode.student.getAVG()) {
                maxNode = p;

            }
            p = p.next;
        }

        p = head;
        while (p != null) {
            if (p.student.getAVG() == maxNode.student.getAVG()) {
                System.out.println(p.student);
            }
            p = p.next;
        }
    }

    public void remove() {
        while (head != null && head.student.getAVG() < 5.0) {
            head = head.next;
            size--;
        }

        if (head == null) {
            tail = null;
            return;
        }

        Node p = head;
        while (p.next != null) {
            if (p.next.student.getAVG() < 5.0) {
                if (p.next == tail) {
                    tail = p;
                }
                p.next = p.next.next;
                size--;
            } else {
                p = p.next;
            }
        }
    }

    public void displayAll() {
        Node p = head;

        while (p != null) {
            System.out.println(p.student);
            p = p.next;
        }

    }

}
