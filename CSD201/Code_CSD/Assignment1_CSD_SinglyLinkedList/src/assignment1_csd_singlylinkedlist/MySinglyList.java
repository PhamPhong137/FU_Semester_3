/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_csd_singlylinkedlist;

import java.util.NoSuchElementException;

/**
 *
 * @author PC-Phong
 * @param <T>
 */
public class MySinglyList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MySinglyList() {
        head = tail = null;
        size = 0;
    }

    public void setFirst(Node<T> head) {
        this.head = head;
    }

    public void setLast(Node<T> tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return (head == null && size == 0);
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getInfo();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.getInfo();
    }

    public T set(int index, T x) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }

        T oldElement = p.getInfo();
        p.setInfo(x);
        return oldElement;
    }

    public int size() {
        return size;
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

    public void addLast(T x) { // default addlast
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            tail.setNext(new Node(x, null));
            tail = tail.getNext();
        }
        size++;
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p = head;
        for (int i = 0; i < idx; i++) {
            p = p.getNext();
        }
        return p.getInfo();
    }

    public void addFirst(T x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node<T> p = new Node(x, head);
            head = p;
        }
        size++;
    }

    public void add(int k, T x) {
        if (k < 0 || k >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (k == 0) {
            addFirst(x);
            size++;
        } else {
            Node<T> p = head;
            int i = 0;
            while (i < k - 1) {
                p = p.getNext();
                i++;
            }
            Node<T> t = new Node(x, p.getNext());
            p.setNext(t);
            if (t.getNext() == null) {
                tail = t;
            }
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
            size--;
        }
    }

    public void removeLast() {
        Node<T> p = head;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            clear();
        }

        for (int i = 0; i < size - 2; i++) {
            p = p.getNext();
        }
        p.setNext(null);
        tail = p;
        size--;
    }

    public void remove(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (k < 0 || k >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p = head;
        if (k == 0) {
            removeFirst();
        } else if (k == size - 1) {
            removeLast();
        } else {
            for (int i = 0; i < k - 1; i++) {
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
            size--;
        }
    }

    public void removeByElement(T x) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < size; i++) {
            if (get(i).equals(x)) {
                remove(i);
                break;
            }
        }
    }

    public int indexOf(T x) {

        int i = 0;
        Node<T> p = head;
        while (p != null) {
            if (p.getInfo().equals(x)) {
                return i;
            } else {
                p = p.getNext();
            }
            i++;
        }
        return -1;
    }

    public int lastIndexOf(T x) {

        for (int i = size - 1; i >= 0; i++) {
            if (get(i).equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public Node<T> findNodeByValue(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p = head;
        while (p != null) {
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    return p;
                }
                p = p.getNext();
            }

        }
        return null;
    }

    void swapNode(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index1 == index2) {
            return;
        }
        Node<T> node1 = findNodeByValue(index1);
        Node<T> node2 = findNodeByValue(index2);

        if (node1 == null || node2 == null) {
            return;
        }
        T temp = node1.getInfo();
        node1.setInfo(node2.getInfo());
        node2.setInfo(temp);
    }

    @Override
    public MySinglyList<T> clone() {
        MySinglyList<T> cloneList = new MySinglyList<>();

        Node<T> p = head;
        while (p != null) {
            cloneList.addLast(p.getInfo());
            p = p.getNext();
        }

        return cloneList;
    }

    public void display() {
        Node<T> p = head;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getNext();
        }
    }

}
