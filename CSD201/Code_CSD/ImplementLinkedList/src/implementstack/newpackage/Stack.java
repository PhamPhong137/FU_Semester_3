/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementstack.newpackage;

public class Stack {
    private Node top;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // Return a default value or throw an exception for empty stack
        }
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot peek element.");
            return -1; // Return a default value or throw an exception for empty stack
        }
        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Peeked element: " + stack.peek());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

