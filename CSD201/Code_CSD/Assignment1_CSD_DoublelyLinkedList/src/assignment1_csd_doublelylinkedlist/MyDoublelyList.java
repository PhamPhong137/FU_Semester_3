/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_csd_doublelylinkedlist;

import java.util.NoSuchElementException;

/**
 *
 * @author PC-Phong
 */
public class MyDoublelyList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public T getFirst() {
        return head.getInfo();
    }

    public void setFirst(Node<T> first) {
        this.head = head;
    }

    public T getLast() {
        return tail.getInfo();
    }

    public void setLast(Node<T> last) {
        this.tail = tail;
    }

    public int size() {
        return size;
    }

    public MyDoublelyList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (tail == null && size == 0);
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean contains(T x) {
        Node<T> p = head;
        while (p != null) {
            if (p.getInfo().equals(x)) {
                return true;
            }
            p = p.getNext();
        }
        return false;
    }

    public void addLast(T x) {
        if (isEmpty()) {
            head = tail = new Node(x, null, null);
        } else {
            Node<T> newNode = new Node(x, null, tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        return p.getInfo();
    }

    public void addFirst(T x) {
        if (isEmpty()) {
            head = tail = new Node(x, null, null);
        } else {
            Node<T> newNode = new Node(x, head, null);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void add(int index, T x) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(x);
        } else if (index == size) {
            addLast(x);
        } else {
            Node<T> p = getNode(index);
            Node<T> newNode = new Node(x, p, p.getPrev());
            p.getPrev().setNext(newNode);
            p.setPrev(newNode);
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            clear();
        } else {
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            clear();
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        }
    }

    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> p = getNode(index);
            p.getPrev().setNext(p.getNext());
            p.getNext().setPrev(p.getPrev());
            size--;
        }
    }

    public void removeByElement(T x) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(x)) {
                remove(i);
                break;
            }
        }
    }

    public int indexOf(T x) {
        int index = 0;
        Node<T> p = head;
        while (p != null) {
            if (p.getInfo().equals(x)) {
                return index;
            }
            p = p.getNext();
            index++;
        }
        return -1;
    }

    public int lastIndexOf(T x) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p;
        if (index < size / 2) {
            p = head;
            for (int i = 0; i < index; i++) {
                p = p.getNext();
            }
        } else {
            p = tail;
            for (int i = size - 1; i > index; i--) {
                p = p.getPrev();
            }
        }
        return p;
    }

    void swapNode(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index1 == index2) {
            return;
        }
        Node<T> node1 = getNode(index1);
        Node<T> node2 = getNode(index2);

        T temp = node1.getInfo();
        node1.setInfo(node2.getInfo());
        node2.setInfo(temp);
    }

    public void display() {
        Node<T> p = head;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getNext();
        }
    }

}
