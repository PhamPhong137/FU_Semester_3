/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class DesignedLinkedList {

    public static void main(String[] args) {
        MyLinkedList hoenLinkedList = new MyLinkedList();
        hoenLinkedList.addAtHead(2);
        hoenLinkedList.deleteAtIndex(1);
        hoenLinkedList.addAtHead(2);
        hoenLinkedList.addAtHead(7);
        hoenLinkedList.addAtHead(3);
        hoenLinkedList.addAtHead(2);
        hoenLinkedList.addAtHead(5);
        hoenLinkedList.addAtTail(5);
        hoenLinkedList.traverse();
        System.out.print("\nThe 6th element: " + hoenLinkedList.get(5));

    }
}

class MyLinkedList {

    ListNode head, tail;

    public MyLinkedList() {
        head = tail = null;
    }

    public int get(int index) {
        if (index >= 0) {
            int idx = 0;
            ListNode p = head;
            while (p != null) {
                if (idx == index) {
                    return p.val;
                }
                p = p.next;
                idx++;
            }
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode x = new ListNode(val);
        if (isEmpty()) {
            head = x;
            x.next = tail;
        } else {
            x.next = head;
            head = x;
        }
    }

    public void addAtTail(int val) {
        ListNode x = new ListNode(val), p = head;
        if (isEmpty()) {
            head = x;
        } else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = x;
            x.next = tail;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index >= 0) {
            ListNode x = new ListNode(val), p = head, prev = p;
            if (index == 0) {
                x.next = head;
                head = x;
            } else {
                int idx = 0;
                while (idx < index && p != null) {
                    prev = p;
                    p = p.next;
                    idx++;
                }
                if (idx == index) {
                    x.next = p;
                    prev.next = x;
                }
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0) { //check if index is valid
            if (index == 0) {
                head = head.next;
            } else {
                ListNode p = head, prev = p;
                int idx = 0;
                while (p.next != null && idx < index) {
                    prev = p;
                    p = p.next;
                    idx++;
                }
                if (idx == index) {
                    p = p.next;
                    prev.next = p;
                }
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void traverse() {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val + " ");
            p = p.next;
        }
    }
}
