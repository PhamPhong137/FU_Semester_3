/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayStack;

import java.util.EmptyStackException;

/**
 *
 * @author PC-Phong
 */
public class MyStack {

    private Object[] a;
    private int top; //index của phần tử cuối cùng 
    private int max;//size của mảng 

    public MyStack() {
        a = new Object[50];
        max = 50;
    }

    public MyStack(int max1) {
        max = max1;
        a = new Object[max];
        top = -1;
    }

    public boolean grow() {
        int max1 = max + max / 2;
        Object[] a1 = new Object[max1];
        if (a1 == null) {
            return (false);
        }
        for (int i = 0; i <= top; i++) {
            a1[i] = a[i];
        }
        a = a1;
        max = max1;
        return (true);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max - 1);
    }

    public void clear() {
        top = -1;
    }

    public void push(Object x) {
        if (isFull() && !grow()) {
            return;
        }
        a[++top] = x;
    }

    Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (a[top]);
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = a[top];
        top--;
        return (x);
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(a[i]+" ");
        }
    }

}
