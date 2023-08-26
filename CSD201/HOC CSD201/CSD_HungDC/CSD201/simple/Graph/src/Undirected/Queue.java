/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Undirected;

/**
 *
 * @author Ratty
 */
class Queue {
    Node head, tail;
    
    public Queue() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    void enqueue(int value) {
        Node n = new Node(value);
        if (isEmpty()) {
            head = tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
    }
    
    int dequeue() {
        if (isEmpty()) return -1;
        int value = head.value;
        head = head.next;
        return value;
    }
}
