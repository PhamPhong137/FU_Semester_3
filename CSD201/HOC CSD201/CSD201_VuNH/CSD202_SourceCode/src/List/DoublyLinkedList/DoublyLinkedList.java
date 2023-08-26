/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.DoublyLinkedList;

/**
 *
 * @author Hp
 */
public class DoublyLinkedList {

    Node head, tail;

    void addHead(Node x) {
        if (head == null) {
            head = tail = x;
        } else {
            head.prev = x;
            x.next = head;
            head = x;
        }
    }

    void addTail(Node x) {
        if (head == null) {
            head = tail = x;
        } else {
            tail.next = x;
            x.prev = tail;
            tail = x;
        }
    }

    void display() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
    }

    /*
    This method return info of index-th node 
    If no result is found, return -1
    Suppose all node info are positive
     */
    int get(int index) {
        if (head == null) {
            return -1;
        }
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == index) {
                return p.info;
            } else {
                p = p.next;
                i++;
            }
        }
        return -1;
    }

    /*
    This method updates value of the index-th node
     */
    void set(int index, int val) {
        int i = 0;
        Node p = head;
        if (head == null) {
            return;
        }
        while (i < index && p.next != null) {
            p = p.next;
            i++;
        }
        if (i == index) {
            p.info = val;
        }
    }

    /* 
    This method delete the index-th node
    Steps: find the index-th node. If it exists, delete it.
    0: if empty
    1: if head
    2: if tail
    3: in-list node
     */
    void delete(int index) {
        int i = 0;
        Node p = head;
        if (head == null) {
            return;
        }
        while (i < index && p.next != null) {
            p = p.next;
            i++;
        }

        if (i == index) {
            if (p == head) {
                p.next.prev = null;
                head = p.next;

            } else if (p == tail) {
                p.prev.next = null;
                tail = p.prev;
            } else {
                p.prev.next = p.next;
                p.next.prev = p.prev;
            }
        }
    }

}
