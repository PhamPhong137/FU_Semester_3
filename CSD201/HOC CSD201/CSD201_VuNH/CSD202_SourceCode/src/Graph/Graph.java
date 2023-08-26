package Graph;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thangnv
 */
public class Graph {

    int n;
    char Vertex[];
    int[][] adj;//adj[v][i] i se la dinh lien ke cua v,

    public Graph(int n) {
        this.n = n;
        Vertex = new char[n];
        adj = new int[n][n];
    }

    int isolated(int v) {
        for (int i = 0; i < n; i++) {
            if (adj[v][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public void visit(int i) {
        System.out.print(Vertex[i] + " ");
    }

    public void depth(boolean visited[], int i) {
        visit(i);
        visited[i] = true;
        for (int k = 0; k < n; k++) {
            if (adj[i][k] > 0 && adj[i][k] < 999 && !visited[k]) {
                depth(visited, k);
            }
        }
    }

    public void depthFirst(int k) {
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i);
            }
//            System.out.println("");
        }
    }

    public void breadth(boolean visited[], int v) throws Exception {
        Queue q = new Queue();
        q.enqueue(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int r = q.dequeue();
            visit(r);
            for (int i = 0; i < n; i++) {
                if (adj[r][i] > 0 && !visited[i]) {
                    q.enqueue(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void breadth_full(int v) throws Exception {
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

//       breadth (visited,v);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                breadth(visited, i);
            }
        }
        System.out.println("");
    }
//    

    public static void main(String[] args) throws InterruptedException, Exception {
        // TODO code application logic here
        int n = 6;
        Graph grap = new Graph(n);
        String s, s1 = null;
        Scanner scan;

        grap.Vertex = "ABCDEFGHIJKLMNOP".toCharArray();
        //A     B       C        D   E       F    G       H        I
        s1 = "0    999     999     999     8       2   15     999     14 "//A
                + "999   0      999     999     999    999   10     999     999 "//B
                + "999  999      0       999    999    999   999     2     999 "//C
                + "999  999     999      0      999     999   999     11     999 "//D
                + "8    999     999     999      0      3   999     999     5 "//E
                + "2   999      999     999     3       0   999     999     999 "//F
                + "15   10      999     999   999      999   0      999     999 "//G
                + "999  999     2       11      999     999   999     0       999 "//H
                + "14    999     999     999     5      999   999     999     0 ";//I

        //   A   B   C  D E  F  G  H  I
        String s2 = "0  0  0  0  1  1  1  0  1 "
                +//A
                "0  0  0  0  0  0  1  0  0 "
                +//B
                "0  0  0  0  0  0  0  1  0 "
                +//C adj[2][8] ==1
                "0  0  0  0  0  0  0  1  0 "
                +//D
                "1  0  0  0  0  1  0  0  1 "
                +//E
                "1  0  0  0  1  0  0  0  1 "
                +//F
                "1  1  0  0  0  0  0  0  0 "
                +//G
                "0  0  1  1  0  0  0  0  0 "
                +//H
                "1  0  0  0  1  1  0  0  0 ";  //I

//    grap.Vertex="123456".toCharArray();
        String s3 = "0 2 4 999 999 999 "
                + "2 0 1 7 999 999 "
                + "4 1 0 999 3 999 "
                + "999 7 999 0 2 1 "
                + "999 999 3 2 0 5 "
                + "999 999 999 1 5 0 ";
        // 0 1 2 3 4 5 6 7 
        String s4 = "0 1 1 1 0 0 0 0 "
                +//0
                "1 0 0 1 0 1 1 0 "
                +//1
                "1 0 0 0 1 0 1 0 "
                +//2
                "1 1 0 0 0 0 0 0 "
                +//3
                "0 0 1 0 0 0 0 1 "
                +//4
                "0 1 0 0 0 0 1 0 "
                +//5
                "0 1 1 0 0 1 0 0 "
                +//6
                "0 0 0 0 0 0 0 0 ";//7
        String s5 = "0 2 999 999 999 4 "
                + "2 0 7 999 999 1 "
                + "999 7 0 1 2 999 "
                + " 999 999 1 0 5 999  "
                + " 999 999 2 5 0 3 "
                + "4 1 999 999 3 0 ";
        String s6 = "0 5 999 7 3 1 "
                + "5 0 4 999 999 1 "
                + "999 4 0 2 999 1 "
                + "7 999 2 0 3 50 "
                + "3 999 999 3 0 999 "
                + "1 1 1 50 999 0 ";
        scan = new Scanner(s5);
//        System.out.println("s ="+s);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grap.adj[i][j] = scan.nextInt();// Integer.parseInt( scan.next());
            }
        }
        System.out.println("adjacency matrix");
        grap.display();
        System.out.println("");
        int from = 0, to = 6;
        System.out.println("test breadth- first travels");
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        grap.breadth(visited, from);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                grap.breadth(visited, i);
            }
        }
//        System.out.println("test depth-first");
//        grap.depthFirst(from);
        System.out.println("");
        System.out.println("shortest path from Vertex " + grap.Vertex[from] + " to Vertex " + grap.Vertex[to]);
        grap.dijkstra(from);
        System.out.println("");
    }

    public void dijkstra(int from) {
        int distance[] = new int[n];
        boolean[] ok = new boolean[n];

        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            path[i] = from;
            ok[i] = false;
        }

        System.out.println("");
        distance[from] = 0;
        int sel = from;
        ok[sel] = true;
        path[sel] = from;

        for (int t = 0; t < n; t++) {
            for (int i = 0; i < n; i++) {
                //cac dinh lien ke cua from
                if (!ok[i] && (adj[sel][i] + distance[sel] < distance[i])) {
                    distance[i] = adj[sel][i] + distance[sel];
                    path[i] = sel;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!ok[i] && distance[i] < min) {
                    sel = i;
                    min = distance[i];
                }
            }
//            sel = path[t];
            ok[sel] = true;
//         System.out.println("from = "+path[0]+"ver 0 ="+Vertex[0]);
            System.out.println("from vertex " + Vertex[from] + " to " + Vertex[path[t]] + " dis = " + distance[path[t]]);

            //tinh khoang cach tu dinh from toi cac dinh lien ke
        }
        System.out.println("");
        for (int i = 0; i < n; i++) {
            System.out.println(" from  = " + i + " to " + path[i] + " ");
        }
        System.out.println("");
        for (int t = 0; t < n; t++) {
            System.out.print(Vertex[path[t]] + " ");
        }
    }

    public void dijkstra(int from, int to) {
        int distance[] = new int[n];
        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            path[i] = from;
            visited[i] = false;
        }

        System.out.println("");
        distance[from] = 0;
        int sel = from;
        visited[sel] = true;
//        path[0] = from;
        for (int t = 0; t < n; t++) {

            for (int i = 0; i < n; i++) {
                //cac dinh lien ke cua from
                if (!visited[i] && (adj[sel][i] + distance[sel] < distance[i])) {
                    distance[i] = adj[sel][i] + distance[sel];
                    path[i] = sel;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (distance[i] < min)) {
                    sel = i;
                    min = distance[i];
                }
            }
            visited[sel] = true;
        }

        int x = to;
        Stack stack = new Stack();
        while (x != from) {
            stack.push(x);
            x = path[x];
        }
        stack.push(from);
        while (!stack.isEmpty()) {
            x = (int) stack.pop();
            System.out.print(Vertex[x] + " ");
        }
        System.out.println("distance = " + distance[to]);

    }

    public void findEulerCycle(String graph, int from){
        Stack<Integer> s = new Stack();
        int e[][];
    }
    
    public void findEulerCycle(int v1, RandomAccessFile f) throws IOException {
//        ArrayList t = new ArrayList();
//        Stack s = new Stack();
//        int sel = v1;
//        s.push(sel);
//        while (!s.isEmpty()) {
//            int tmp = s.top();
//            sel = isolated(tmp);
//            if (sel == -1) {//=> tmp la dinh co lap
//                tmp = (int) s.pop();
//                t.add(tmp);
//            } else {
//                //s ko la dinh co lap, check la dinh lien ke dau tien
//                //dua check vao stack va remoe canh tmp,check
//                s.push(sel);
//                a[tmp][sel]--;
//                a[sel][tmp]--;
//            }
//        }
//        for (int i = 0; i < t.size(); i++) {
//            f.writeBytes(" " + v[(int) t.get(i)]);
//        }

    }    
    
    public void input(int n) {
        this.n = n;
        Scanner scan;//= new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("ten dinh thu " + i + ": ");
            scan = new Scanner(System.in);
            String s = scan.nextLine();
            Vertex[i] = s.charAt(0);
        }
        System.out.println("Ma tran lien thuoc");
        for (int i = 0; i < n; i++) {
            System.out.print("Vertex " + Vertex[i] + " ");
            scan = new Scanner(System.in);
            String s = scan.nextLine();//.split("[ ]+");
            scan = new Scanner(s);
            for (int j = 0; j < n; j++) {
                adj[i][j] = scan.nextInt();// Integer.parseInt(s[j]);
            }
        }
    }

    public void display() {
        System.out.println("");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println("");
        }
    }

}

class Queue {

    Node head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int t) {
        if (head == null) {
            head = tail = new Node(t);
        } else {
            tail.next = new Node(t);
            tail = tail.next;
        }
    }

    public int dequeue() throws Exception {
        int x = 0;
        if (head != null) {
            x = head.val;
            head = head.next;
        } else {
            throw new Exception("Nothing to dequeue");
        }
        return x;
    }
}

class Node {

    int val;
    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

}
