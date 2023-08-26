/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass0;

/**
 *
 * @author Admin MSI
 */
class solution {

// Node of the singly linked list
    static class Node {

        int value;
        Node next;
    }

// Function to insert a node at the beginning
// of the singly Linked List
    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.value = new_data;
        new_node.next = (head_ref);
        (head_ref) = new_node;
        return head_ref;
    }

// Function to check if a number is prime
    static boolean isPrime(int n) {
        // Corner cases
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

// Function to find count of prime
// nodes in a linked list
    static int countPrime(Node head_ref) {
        int count = 0;
        Node ptr = head_ref;

        while (ptr != null) {
            // If current node is prime
            if (isPrime(ptr.value)) {
                // Update count
                count++;
            }
            ptr = ptr.next;
        }

        return count;
    }
    
    public static void main(String args[]) {
            // start with the empty list
            Node head = null;
            // create the linked list
            // 15 . 5 . 6 . 10 . 17
            head = push(head, 2);
            head = push(head, 8);
            head = push(head, 7);
            head = push(head, 5);
            head = push(head, 3);

            // Function call to print require answer
            System.out.println("Count of prime nodes = " + countPrime(head));

        }
}
