/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.LinkedList;

/**
 *
 * @author Hp
 */
public class MyLinkedList {

    Node head, tail;

    MyLinkedList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }

    /*
    This method return the first node whose info equals to x
     */
    Node search(int x) {
        if (head == null) {
            return null;
        } else {
            Node p = head;
            while (p.info != x && p.next != null) {
                p = p.next;
                if (p.info == x) {
                    return p;
                }
            }
        }
        return null;
    }

    void addLast(int x) {
        Node p = new Node(x);
        Node current = head;
        if (head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    void addFirst(int x) {
        Node p = head;
        if (head == null) {
            head.info = x;
            head.next = null;
        } else {
            Node newNode = null;
            newNode.info = x;
            newNode.next = p;
            head = newNode;
        }
    }

    void insert(int x) {

    }

    void delete(int x) {

    }

    void sortAsc() {
        Node currentNode = head, nextNode = null;
        if (head == null) {
        } else {
            while (currentNode != null) {
                nextNode = currentNode.next;
                while (nextNode != null) {
                    if (currentNode.info > nextNode.info) {
                        int temp;
                        temp = currentNode.info;
                        currentNode.info = nextNode.info;
                        nextNode.info = temp;
                    }
                    nextNode = nextNode.next;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public void sortInRange(Node from, Node to) {
        if (from != null) {
            Node current = from;
            while (current != to) {
                Node pNext = current.next;
                while (pNext != to.next) {
                    //change the condition if necessary
                    if (current.info > pNext.info) {
                        int temp = current.info;
                        current.info = pNext.info;
                        pNext.info = temp;
                    }
                    pNext = pNext.next;
                }
                current = current.next;
            }
        }
    }

    public Node findByIndex(int k) {
        int idx = 0;
        if (isEmpty()) {
            return null;
        }
        Node p = head;
        while (p != null) {
            if (idx == k) {
                return p;
            }
            p = p.next;
            idx++;
        }
        return null;
    }
}
