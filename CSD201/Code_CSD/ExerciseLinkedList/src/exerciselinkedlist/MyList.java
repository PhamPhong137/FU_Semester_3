/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciselinkedlist;

/**
 *
 * @author PC-Phong
 */
public class MyList {

    Node head, tail;
    int size;
     public void addFirst(Student s) {
        Node p = new Node(s);

        if (head == null) {
            head = tail = p;

        } else {
            p.next = head;
            head.prev = p;
            head = p;
        }
        size++;
    }
    
    
    
    
    
    
    
//    public void displayAll() {
//        Node p = head;
//
//        while (p != null) {
//            System.out.print("Student ID: " + p.data.studentID + " | ");
//            System.out.printf("Name: %-6s | ", p.data.name);
//            System.out.printf("Mark 1: %-5.2f | ", p.data.mark1);
//            System.out.printf("Mark 2: %-5.2f | ", p.data.mark2);
//            System.out.printf("Mark 3: %-5.2f | ", p.data.mark3);
//            System.out.printf("Average: %.2f ", p.data.getAverage());
//            System.out.println("");
//            p = p.next;
//        }
//    }
}
