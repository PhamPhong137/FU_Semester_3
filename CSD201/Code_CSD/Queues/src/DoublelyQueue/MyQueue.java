/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublelyQueue;

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

    public void enqueue(Object info) {
        Node p = new Node(info);

        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            p.prev = tail;
            tail = p;
        }
        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }

        Object p = head.info;
        if (head == tail) {
            head = tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }
        size--;
        return p;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return head.info;
    }

    public Object front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");

        }
        return head.info;
    }

    void display() {
        Node p = head;
        while (p != null) {
            if (p == tail) {
                System.out.print(p.info + " ");
            } else {
                System.out.print(p.info + " ");
            }
            p = p.next;
        }
    }

}
