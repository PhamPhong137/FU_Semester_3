
package Directed;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

// For directed graph
public class DGraph {
    int[][] a;
    int size;
    
    char Convert(int x) {
        return (char)(x+65);
    }
    
    public DGraph(int n) {
        size = n;
        a = new int[size][size];
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("inputGraph.txt", "r");
            String s;
            int i = 0;
            while ((s = raf.readLine()) != null) {
                String[] s1 = s.split("[\\s]+");
                for (int j = 0; j < size; j++) {
                    a[i][j] = Integer.parseInt(s1[j]);
                }
                i++;
            }
            if (i >= size) {
            }
        }
        catch (IOException | NumberFormatException e) {}
    }
    
    public DGraph() {
        this(9);
    }
    
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public void breadthFirst(int x) {
        if (x >= size) return;
        boolean[] b = new boolean[size]; int p;
        Arrays.fill(b, true);
        MyQueue my = new MyQueue();
        my.enQueue(x);
        b[x] = false;
        while (!my.isEmpty()) {
            p = my.deQueue();
            for (int i = 0; i < size; i++) {
                if (a[i][p] != 0 && b[i]) {
                    b[i] = false;
                    my.enQueue(i);
                }
            }
            if (my.isEmpty()) System.out.print(Convert(p));
            else System.out.print(Convert(p) + " --> ");
        }
        System.out.println("");
    }
    
    public void breadthFirst(char x) {
        breadthFirst((int)(x-65));
    }
    
    public void depthFirst(boolean[] b, int x) {
        if (x >= size) return;
        System.out.print(Convert(x) + "-->");
        b[x] = false;
        for (int i = 0; i < size; i++) {
            if (a[i][x] != 0 && b[i]) {
                depthFirst(b, i);
            }
        }
    }
    
    public void depthFirst(int x) {
        if (x >= size) return;
        boolean[] b = new boolean[size];
        Arrays.fill(b, true);
        depthFirst(b, x);
        for (int i = 0; i < size; i++) {
            if (b[i]) depthFirst(b, i);
        }
    }
    
    public void depthFirst(char x) {
        depthFirst((int)(x-65));
    }

}

class Node {
    int value;
    Node next;
    
    public Node() {
        
    }
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class MyQueue {
    Node head, tail;
    
    public MyQueue() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    void enQueue(int value) {
        Node n = new Node(value);
        if (isEmpty()) {
            head = tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
    }
    
    int deQueue() {
        if (isEmpty()) return -1;
        int value = head.value;
        head = head.next;
        return value;
    }
}
