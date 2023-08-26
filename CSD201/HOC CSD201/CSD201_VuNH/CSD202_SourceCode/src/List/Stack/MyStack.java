/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.Stack;

/**
 *
 * @author Hp
 */
public class MyStack {

    Node top; //store the index of the top element in the stack
//    Node head, tail;

    MyStack() {
        top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    Node peek() {
        if (isEmpty()) {
            return null;
        } else {
            return top;
        }
    }

    Node pop() {

        if (isEmpty()) {
            return null;
        } else {
            Node p = top;
            top = top.next;
            return p;
        }
    }

    /*
    x el
     */
    void push(Node el) throws StackOverflowError {
        if (isEmpty()) {
            top = el;
        } else {
            el.next = top;
            top = el;
        }
//        return el;
    }

    int search(Node el) {
        int idx = 0;
        Node p = top;
        if (isEmpty()) {
            return -1;
        } else {
            while (p.next != null && p.info != el.info) {
                idx++;
                p = p.next;
            }
        }
        return idx;
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

    void transfer(MyStack st1, MyStack st2) {
        Node myTop = st1.top;
        while (myTop != null) {
            st2.push(myTop);
            myTop = myTop.next;
        }
//        MyStack stemp = st1;
//        while (stemp.top!=null) {
//            st2.push(stemp.peek());
//            stemp.top = stemp.top.next;
//            System.out.println(stemp.top.info);
//        }
    }

}
