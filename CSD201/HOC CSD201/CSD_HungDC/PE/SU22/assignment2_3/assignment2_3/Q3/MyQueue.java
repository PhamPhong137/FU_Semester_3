/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_3.Q3;

/**
 *
 * @author TLC
 */
class MyQueue {

    Node head, tail;

    public MyQueue() {

    }

    boolean isEmpty() {
        return head == null;
    }

    void Enqueue(int value) {
        Node n = new Node(value);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    int Dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int value = head.value;
        head = head.next;
        return value;
    }
}
