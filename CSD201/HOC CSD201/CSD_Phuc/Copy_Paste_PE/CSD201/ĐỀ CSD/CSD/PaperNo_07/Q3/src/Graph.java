/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;

//-------------------------------------------------------------------------------
class Graph {

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

  void loadData(int k) { //do not edit this function
    RandomAccessFile f;
    int i, j, x;
    String s;
    StringTokenizer t;
    a = new int[20][20];
    try {
      f = new RandomAccessFile("data.txt", "r");
      for (i = 0; i < k; i++) f.readLine();
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
    } catch (Exception e) {}
  }

  void dispAdj() {
    int i, j;
    for (i = 0; i < n; i++) {
      System.out.println();
      for (j = 0; j < n; j++) System.out.printf("%4d", a[i][j]);
    }
  }

  void fvisit(int i, RandomAccessFile f) throws Exception {
    f.writeBytes(" " + v[i]);
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
    for (i = 0; i < n; i++) en[i] = false;
    breadth(en, k, f);
    for (i = 0; i < n; i++) if (!en[i]) breadth(en, i, f);
  }

  void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
    fvisit(k, f);
    visited[k] = true;
    for (int i = 0; i < n; i++) {
      if (!visited[i] && a[k][i] > 0) depth(visited, i, f);
    }
  }

  void depth(int k, RandomAccessFile f) throws Exception {
    boolean[] visited = new boolean[20];
    int i;
    for (i = 0; i < n; i++) visited[i] = false;
    depth(visited, k, f);
    for (i = 0; i < n; i++) if (!visited[i]) depth(visited, i, f);
  }

  int deg(int i) {
    int s, j;
    s = 0;
    for (j = 0; j < n; j++) s += a[i][j];
    s += a[i][i];
    return (s);
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
  void fvisit2(int i, RandomAccessFile f) throws Exception {
    f.writeBytes(" " + v[i] + "(" + deg(i) + ")");
  }

  void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
    fvisit2(k, f);
    visited[k] = true;
    for (int i = 0; i < n; i++) {
      if (!visited[i] && a[k][i] > 0) depth2(visited, i, f);
    }
  }

  void depth2(int k, RandomAccessFile f) throws Exception {
    boolean[] visited = new boolean[20];
    int i;
    for (i = 0; i < n; i++) visited[i] = false;
    depth2(visited, k, f);
    for (i = 0; i < n; i++) if (!visited[i]) depth2(visited, i, f);
  }

  void f1() throws Exception {
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    depth(1, f);
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    depth2(1, f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
  }

  //===========================================================================
  void dijkstra(int fro, int to, RandomAccessFile f) throws Exception {
    int i, j, k, t, INF;
    INF = 999;
    boolean[] S = new boolean[n];
    int[] d = new int[n];
    int[] p = new int[n];
    for (i = 0; i < n; i++) {
      S[i] = false;
      d[i] = a[fro][i];
      p[i] = fro;
    }

    int[] ss = new int[n]; // ss[0], ss[1], ss[2],... are vertices sequentially selected to S
    int[] pp = new int[n]; // ss[0] -> ss[1] -> ss[2],... is the shortest path
    int m, r; // m is number of vertices in S,
    // r is the number of vertices in shortest path
    j = 0;

    // select fro into the set S
    S[fro] = true;
    ss[0] = fro;
    while (true) { // find min d[i] in the set of those vertices not selected into S
      k = -1;
      t = INF;
      for (i = 0; i < n; i++) {
        if (S[i] == true) continue;
        if (d[i] < t) {
          k = i;
          t = d[i];
        }
      }
      if (k == -1) return; // no solution
      // select k into the set S
      S[k] = true;
      j++;
      ss[j] = k;
      if (k == to) break;
      // Recalculate d[i]
      for (i = 0; i < n; i++) {
        if (S[i] == true) continue;
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
      if (i == fro) break;
      i = p[i];
    }
    j = 0;
    while (!s.isEmpty()) {
      i = s.pop();
      pp[j++] = i;
    }
    r = j;
    f.writeBytes("" + v[pp[0]]);
    for (i = 1; i < r; i++) f.writeBytes("   " + v[pp[i]]);
    f.writeBytes("\r\n");
    f.writeBytes("" + d[pp[0]]);
    for (i = 1; i < r; i++) f.writeBytes("   " + d[pp[i]]);
    f.writeBytes("\r\n");
  }

  void f2() throws Exception {
    loadData(12);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    //-------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    dijkstra(0, 4, f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
  }

  //===========================================================================
  /*
Algorithm for finding an Euler cycle from the vertex X using stack 
//Input: Connected graph G with all vertices having even degrees
//Output: Euler cycle
declare a stack S of characters
declare empty array E (which will contain Euler cycle)
push the vertex X to S
while(S is not empty)
 {r = top element of the stack S 
  if r is isolated then remove it from the stack and put it to E
   else
   select the first vertex Y (by alphabet order), which is adjacent
   to r, push  Y  to  S and remove the edge (r,Y) from the graph   
 }
 the last array E obtained is an Euler cycle of the graph
*/
 boolean hasIsolated() {
        for (int i = 0; i < n; i++) {
            if (deg(i) == 0) {
                return (true);
            }
        }
        return (false);
    }
    
    boolean isConnected() {
        boolean[] p = new boolean[n];
        int i, j, r;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        Stack s = new Stack();
        s.push(0);
        p[0] = true;
        while (!s.isEmpty()) {
            r = s.pop();
            for (i = 0; i < n; i++) {
                if (!p[i] && a[r][i] > 0) {
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!p[i]) {
                return (false);
            }
        }
        return (true);
    }
    
    boolean isUnDirected() {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    return (false);
                }
            }
        }
        return (true);
    }
    
    boolean allDegEven() {
        for (int i = 0; i < n; i++) {
            if (deg(i) % 2 == 1) {
                return (false);
            }
        }
        return (true);
    }
    
    boolean hasEulerCycle() {
        if (!hasIsolated() && isUnDirected() && isConnected() && allDegEven()) {
            return (true);
        } else {
            return (false);
        }
    }
    
    void eulerCycle(int fro, RandomAccessFile f) throws IOException {
        if (!hasEulerCycle()) {
            return;
        }
        int[] eu = new int[100];
        int m, i, j, r;
        Stack s = new Stack();
        s.push(fro);
        j = 0;
        while (!s.isEmpty()) {
            r = s.top();
            for (i = 0; i < n; i++) {
                if (a[r][i] > 0) {
                    break;
                }
            }
            if (i == n) {
                s.pop();
                eu[j++] = r;
                
            } else {
                s.push(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        m = j;
        for (i = 0; i < m; i++) {
            f.writeBytes(v[eu[i]] + " ");
        }
    }


  void f3() throws Exception {
    loadData(20);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f5.txt
    //  and statement f.writeBytes(" " + k); to write  variable k to the file f5.txt
      eulerCycle(1, f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
  }
}
//=================================================================
