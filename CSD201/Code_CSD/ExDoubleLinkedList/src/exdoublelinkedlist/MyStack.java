/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exdoublelinkedlist;

public class MyStack {

    MyDoubleList mylist = new MyDoubleList();
    int maxsize;
    int top = -1;

    public MyStack() {

        maxsize = 50;
    }

    public MyStack(int max1) {
        maxsize = max1;
        top = -1;
    }

    void clear() {
        mylist.clear();
        top = -1;
    }

    boolean isEmpty() {
        return (mylist.isEmpty());
    }

    void push(Student x) {
        mylist.addFirst(x);
        top++;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack empty");
        }
        mylist.removeFirst();
        top--;
    }

    Student peek() {
        if (isEmpty()) {
            return null;
        }
        return mylist.get(0);
    }

    int size() {
        return top + 1;
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(mylist.get(i));
        }
    }
}
