/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_graph;

/**
 *
 * @author Admin MSI
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    int[][] a;
    int size;

    char Covert(int x) {
        return (char) (x + 65);
    }

    public Graph() {
        size = 8;
        a = new int[size][size];
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("inputGraph.txt", "r"); //LAy du lieu dau vao
            String s = "";
            int i = 0;
            while ((s = raf.readLine()) != null) {
                String[] s1 = s.split("\\s");
                for (int j = 0; j < size; j++) {
                    a[i][j] = Integer.parseInt(s1[j]);
                }
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    void Break_first(int x) {
        boolean[] b = new boolean[size];
        Arrays.fill(b, true);
        MyQueue my = new MyQueue();
        my.Enqueue(x);
        b[x] = false;
        while (!my.isEmpty()) {
            int p = my.Dequeue();
            for (int i = 0; i < size; i++) {
                if (a[i][p] != 0 && b[i]) {
                    b[i] = false;
                    my.Enqueue(i);
                }
            }
            System.out.println(Covert(p) + "->");
        }
        System.out.println("");
    }

    void depth_first(int x) {
        boolean[] b = new boolean[size];
        Arrays.fill(b, true);
        depthFirst(b, x);
        for (int i = 0; i < size; i++) { // xet toan bo do thi co hoac dinh co lap
            if (b[i]) {
                depthFirst(b, i);
            }
        }
    }

    void depthFirst(boolean[] b, int x) {
        System.out.println(Covert(x) + " ");
        b[x] = false;
        for (int i = 0; i < size; i++) {
            if (a[i][x] != 0 && b[i]) {
                depthFirst(b, i);
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Graph my = new Graph();
        my.display();
        //my.Break_first(0); // duyet theo chieu ngang
        //neu muon duyet tu cac diem khac, ta thay 0 thanh 1, 2, 3
        my.depth_first(0); // duyet theo chieu sau
    }

}

class MyQueue {

    Node head, tail;

    public MyQueue() {

    }

    boolean isEmpty() {
        return head == null;
    }

    void Enqueue(int value) {
        Node n = new Node(value);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    int Dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int value = head.value;
        head = head.next;
        return value;
    }
}

class Node {

    int value;
    Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
        this.next = next;
    }

}
