/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass0;

import java.util.LinkedList;


/**
 *
 * @author Admin MSI
 */
public class MyFeature {
  
    boolean isEmpty(){
        return head == null;
    }
    
    public LinkNode head, tail;
    
    public void display(){
        LinkNode current = head;
        if(head==null){
            System.out.println("List is empty! You need to create new list");
            return;
        }
        while(current!=null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    
    public void addLast(int value){
        LinkNode newNode = new LinkNode(value);
        
        if(head==null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    void addFirst(int value) {
        LinkNode node = new LinkNode(value);
        if (isEmpty()) {
            head = tail = node;
            // if list empty create first block;
        } else {
            node.next = head;
            head = node;
        }
    }
    
        void addIndext(int value, int indext) {
        if (indext == 0) {
            addFirst(value);
            return;
        }
        int count = 0;
        LinkNode cu = head;
        while (cu != null && count != indext - 1) {
            count++;
            cu = cu.next;
        }
        if (cu == null) {
            return;
        } else {
            LinkNode node = new LinkNode(value);
            node.next = cu.next;
            cu.next = node;
        }
    }
    
    public void delFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
    }

    public void deleteIndex(int indext) {
        if (indext < 0) {
            return;
        }
        if (indext == 0) {
            delFirst();
            return;
        }
        int count = 0;
        LinkNode cu = head;
        while (count != indext - 1) {
            count++;
            cu = cu.next;
        }
        cu.next = cu.next.next;
    }
    
    public boolean checkPrime(int value) {
        if (value == 1) {
            return false;
        } else {
            for (int i = 2; i <= value / 2; i++) {
                // Check whether value is prime or not
                if (value % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public void delelePrimeNode() {
        if (this.head == null) {
            System.out.println("Empty linked List");
        } else {
            int remove = 0;
            // Auxiliary variables
            LinkNode temp = this.head;
            LinkNode hold = null;
            LinkNode prev = null;
            // Iterating and find prime nodes
            while (temp != null) {
                if (this.checkPrime(temp.value)) {
                    // Is prime node
                    hold = temp;
                } else {
                    prev = temp;
                }
                // Visit to next node
                temp = temp.next;
                if (hold != null) {
                    if (hold == this.head) {
                        // When delete head node
                        this.head = temp;
                        hold = null;
                    } else {
                        if (prev != null) {
                            prev.next = temp;
                        }
                        hold = null;
                    }
                }
            }
        }
    }

}
