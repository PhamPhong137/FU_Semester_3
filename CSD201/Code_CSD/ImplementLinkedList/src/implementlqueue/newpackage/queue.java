/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementlqueue.newpackage;

public class queue {
    private Node front;
    private Node rear;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1; // Return a default value or throw an exception for empty queue
        }
        int dequeuedValue = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedValue;
    }

    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1; // Return a default value or throw an exception for empty queue
        }
        return front.data;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public static void main(String[] args) {
        queue queue = new queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Peeked element: " + queue.peek());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}

