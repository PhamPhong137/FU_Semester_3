/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

//import Queue.SingleEndedQueue.*;

/**
 *
 * @author Hp
 */
public class MyFileQueue {

    Node head, tail;

    public MyFileQueue() {
        head = tail = null;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void enqueue(String x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
//            tail.next = null;
        } else {
            tail.next = n;
            tail = n;
        }
    }

//    void enqueueWithPriority(String s) {
//        Node p = head;
//        Node x= new Node(s);
//        boolean check = false;
//        if (isEmpty()) {
//            head = tail = x;
//        } else if (x.info > head.info) { //add first
//            x.next = head;
//            head = x;
//            check = true;
//        } else if (x.info < tail.info) { //ad first
//            tail.next = x;
//            tail = x;
////            x.next = null;
//        } else { //add in-between
//            while (p.next != null && p.next.info > x.info) {
//                p = p.next;
//            }
//            x.next = p.next;
//            p.next = x;
//        }
//    }
    Node dequeue() {
        try {
            Node p = head;
            head = head.next;
            return p;
        } catch (Exception e) {
            System.out.println("No element in the queue.");
        }
        return null;
    }

    Node front() {
        return head;
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
    }

}
