/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack_ArrayList;

import java.util.ArrayList;

/**
 *
 * @author PC-Phong
 */
public class MyStack_ArrayList {

    ArrayList h;
    int size;

    MyStack_ArrayList() {
        h = new ArrayList();
    }

    boolean isEmpty() {
        return (h.isEmpty());
    }

    void push(Object x) {
        h.add(x);
        size++;
    }

    Object pop() {
        if (isEmpty()) {
            return (null);
        }
        size--;
        return (h.remove(h.size() - 1));
    }
    Object peek() {
        if (isEmpty())
            return null;
        return h.get(h.size() - 1);
    }

    int search(Object x) {
        for (int i = h.size() - 1; i >= 0; i--) {
            if (h.get(i).equals(x)) {
                return h.size() - i;
            }
        }
        return -1;
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
