/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) {  //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(1, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depthFirst2(1, 0, 5, f);
        
        depth3(1, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    int depthFirst2(boolean visited[], int i, int count, int min, int max, RandomAccessFile f) throws Exception {
        if (count >= min && count <= max) {
            fvisit(i, f);
        }
        visited[i] = true;
        int j;
        for (j = 0; j < n; j++) {
            if (a[i][j] > 0 && (!visited[j])) {
                count = depthFirst2(visited, j, (count + 1), min, max, f);
            }
        }
        return count;
    }

    void depthFirst2(int k, int min, int max, RandomAccessFile f) throws Exception {
        int i;
        boolean[] visited = new boolean[20];
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        int count = depthFirst2(visited, k, 0, min, max, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirst2(visited, i, (count + 1), min, max, f);
            }
        }
        System.out.println();
    }

    int count = 0;

    void depth3(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        count++;
        if (count <= 6) {
            fvisit(k, f);
        }
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth3(visited, i, f);
            }
        }
    }

    void depth3(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        count = 0;
        depth3(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {

                depth3(visited, i, f);
            }
        }
    }

//=================================================================
    void f2() throws Exception {
        loadData(13);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f2.txt 
        dijkstra(0, 6, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void dijkstra(int fro, int to, RandomAccessFile f) throws Exception {
        int i, j, k, t, INF;
        INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }

        int[] ss = new int[n];
        int[] pp = new int[n];
        int m, r;
        j = 0;
        S[fro] = true;
        ss[0] = fro;
        while (true) {
            k = -1;
            t = INF;
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) {
                return; // no solution
            }           // select k into the set S
            S[k] = true;
            j++;
            ss[j] = k;
            if (k == to) {
                break;
            }
            // Recalculate d[i]
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        m = j;
        Stack s = new Stack();
        i = to;
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        j = 0;
        while (!s.isEmpty()) {
            i = s.pop();
            pp[j++] = i;
        }
        r = j;
//        for (i = 0; i < r; i++) {
//            fvisit(pp[i], f);
//        }
        f.writeBytes(" " + d[pp[r - 1]]);
        for (i = r - 4; i < r; i++) {
            f.writeBytes(v[pp[i]] + "(" + d[pp[i]] + ") ");
        }
        f.writeBytes("\r\n");

    }

}
