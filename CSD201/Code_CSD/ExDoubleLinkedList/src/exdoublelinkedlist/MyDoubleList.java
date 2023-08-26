/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exdoublelinkedlist;

/**
 *
 * @author PC-Phong
 */
public class MyDoubleList {
    
    Node head;
    Node tail;
    int size;

    boolean isEmpty() {
        return head == null;
    }

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

    public void addLast(Student s) {
        Node p = new Node(s);

        if (tail == null) {
            head = tail = p;

        } else {
            p.prev = tail;
            tail.next = p;
            tail = p;
        }
        size++;
    }

    public void addPos(Student s, int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addFirst(s);
        } else if (index == size) {
            addLast(s);
        } else {
            Node newNode = new Node(s);
            Node p = head;
            int count = 0;

            while (p != null && count < index) {
                p = p.next;
                count++;
            }
            if (p != null) {
                newNode.next = p;
                newNode.prev = p.prev;
                p.prev.next = newNode;
                p.prev = newNode;
            }
        }
        size++;
    }

    public void search(String key) {
        Node p = head;
        boolean check = false;
        while (p != null) {
            if (p.data.studentID.equals(key)) {
                System.out.println(p.data);
                check = true;
            }

            p = p.next;
        }
        if (check == false) {
            System.out.println("Not Found");
        }

    }

    public void removeByID(String key) {
        Node p = head;

        while (p != null) {
            if (p.data.studentID.equals(key)) {
                if (p == head) {
                    head = p.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (p == tail) {
                    tail = p.prev;
                    tail.next = null;
                } else {
                    p.prev.next = p.next;
                    p.next.prev = p.prev;
                }
                break;
            }
            p = p.next;
        }
        size--;
    }

    public Student get(int k) {
        if (k < 0 || k >= size) {
            return null;
        }

        Node p = head;
        int count = 0;

        while (p != null) {
            if (count == k) {
                return p.data;
            }
            p = p.next;
            count++;
        }

        return null;
    }

    public Student max() {
        if (head == null) {
            return null; // No students in the list
        }

        Node p = head;
        Student maxStudent = head.data;
        double maxAverage = head.data.getAverage();

        while (p != null) {
            if (p.data.getAverage() > maxAverage) {
                maxStudent = p.data;
                maxAverage = p.data.getAverage();
            }

            p = p.next;
        }

        return maxStudent;
    }

    public void clear() {
        head = tail = null;
    }

    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void displayAll() {
        Node p = head;

        while (p != null) {
            System.out.print("Student ID: " + p.data.studentID + " | ");
            System.out.printf("Name: %-6s | ", p.data.name);
            System.out.printf("Mark 1: %-5.2f | ", p.data.mark1);
            System.out.printf("Mark 2: %-5.2f | ", p.data.mark2);
            System.out.printf("Mark 3: %-5.2f | ", p.data.mark3);
            System.out.printf("Average: %.2f ", p.data.getAverage());
            System.out.println("");
            p = p.next;
        }
    }

}
