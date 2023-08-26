/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack_LinkedList;

import java.util.LinkedList;

/**
 *
 * @author PC-Phong
 */
public class MyStack_LinkedList {

    LinkedList h;

    MyStack_LinkedList() {
        h = new LinkedList();
    }

    boolean isEmpty() {
        return (h.isEmpty());
    }

    void push(Object x) {
        h.add(x);
    }

    Object pop() {
        if (isEmpty()) {
            return (null);
        }
        return (h.removeLast());
    }

    Object peek() {
        if (isEmpty()) {
            return null;
        }
        return h.getLast();
    }

    boolean search(Object x) {
        return h.contains(x);
    }

    void clean() {
        h.clear();
    }

    void display() {
        for (Object o : h) {
            System.out.print(o + " ");
        }
    }
}
