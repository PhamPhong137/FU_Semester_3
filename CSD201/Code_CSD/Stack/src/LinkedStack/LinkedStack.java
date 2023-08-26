/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedStack;

import java.util.EmptyStackException;
// CODE này add thì đẩy lên đầu, top lấy phần từ đầu ???
class LinkedStack {

    Node top;
    int size;

    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(Object x) {
        top = new Node(x, top);
        size++;
    }

    Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (top.info);
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = top.info;
        top = top.next;
        size--;
        return (x);

    }

    void display() {
        if (isEmpty()) {
            System.out.println("No element in stack");
        } else {
            Node p = top;
            while (p != null) {
                System.out.print(p.info + " ");
                p = p.next;
            }
        }
    }

}
