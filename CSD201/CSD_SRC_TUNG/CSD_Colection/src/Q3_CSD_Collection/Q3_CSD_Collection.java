/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3_CSD_Collection;

/**
 *
 * @author VICTUS
 */
public class Q3_CSD_Collection {

    /*
     void f1() - Perform depth-first traversal (to the file f1 .txt) from the vertex i = 2 (the vertex
    D) but display 6 vertices from the 2nd vertex to the 7th vertex only. Hint: copy depth(...)
    to depth2(...) and modify the latter one. Content of the output file f1.tx( must be:
    C A B E H I D G F
    A B E H I D
     */
    //    depthFirst2(2, 1, 6, f);
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

    /*
    void f1() - Perform depth-first traversal (to the file f1 .txt) from the vertex i = 3 (the vertex
    D) but display 5 vertices from the 2nd vertex to the 6th vertex only. Hint: copy depth(...)
    to depth2(...) and modify the latter one. Content of the output file f1.tx( must be:
    D A B E H I C G F
    A B E H I
     */
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(3, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        depth2(3, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    int count = 0;

    void fvisit2(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (count >= 1 && count <= 5) {
            fvisit2(k, f);
        }
        count++;
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

//=================================================================
    /*
    void f2) - Apply the DiJkstra`s shortest path algorrthm to find (1) the shortest path from
    vertext 2 (C) to vertex 5 (F), then (2) from vertex 0 (A) to vertex 6 (G). Write 3 lines to
    the file f2 txt: line l contains vertices in shortest path (l), line 2 contains the last 3
    vertices selected into the set ŠS with their labels in (2), line 3 contains vertices im shortest
    path (2). (Note that in the weiphted matrix, the value 99 ¡s considered as infinity). Output
    in the file f2.txt must be the following:
    C E D F
    D,I9 F,24 G,29
    A B C E D G
     */
    void f2() throws Exception {
        loadData(12);
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
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
        dijkstra(2, 5, f);
        dijkstra2(0, 6, f);
        dijkstra(0, 6, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");

        f.close();
    }

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
        f.writeBytes("" + v[pp[0]]);
        for (i = 1; i < r; i++) {
            f.writeBytes("  " + v[pp[i]]);
        }
        f.writeBytes("\r\n");

    }

    void dijkstra2(int fro, int to, RandomAccessFile f) throws IOException {
        List<Integer> listSelected = new ArrayList<>();
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int i, j, k, min;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        S[fro] = true;
        listSelected.add(fro);
        while (true) {
            min = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < min) {
                    min = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("No solution");
                return;
            }
            S[k] = true;
            listSelected.add(k);
            if (k == to) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
//        System.out.println("The shortest distance is " + d[to]);
//        System.out.println("The path is:");
        i = to;
        Stack s = new Stack();
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro) {
                break;
            }
        }
        i = s.pop();
        int mm = listSelected.size() - 3;
        f.writeBytes("" + v[listSelected.get(mm)] + "," + d[listSelected.get(mm)]);
        for (int m = listSelected.size() - 2; m < listSelected.size(); m++) {
            int index = listSelected.get(m);
            f.writeBytes(" " + v[index] + "," + d[index]);
        }
        f.writeBytes("\r\n");
    }

    /*void f1Q — Perform depth first traversal (to the file f1.xt) from the vertex i=0 (the vertex A)
    but display only vertices having degree > 1. Hint: copy depth(...) to depth2(...) and modify
    the latter one. Content of the output file fl.txt must be:
    A E F I G B C H D
    A E F I G H
     */
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(0, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth2(0, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (deg(k) > 1) {
            fvisit(k, f);
        }
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

//=================================================================
    /*
    void f2() — Supposed the given graph has Euler's cycle. Apply the pseudocode in the
    Graph.java file to write statements to find the Euler's cycle from the vertex 2 (C). Write 2
    lines to the file f2.txt: the first line contains the Euler's cycle and the second line contains 3
    first vertices pushed into the stack (displayed by their pushing order). Output in the file
    f2.txt must be the following:
    C D E D B E G F A B C
    C B A
     */
    void f2() throws Exception {
        loadData(12);
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
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f6.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f6.txt  
        eulerCycle(2, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void eulerCycle(int k, RandomAccessFile f) throws IOException {
        int[] eu = new int[100];
        int m, i, r;
        m = 0;
        Stack s = new Stack();
        Queue display = new Queue();
        s.push(k);
        display.enqueue(k);
        while (!s.isEmpty()) {
            r = s.top();
            for (i = 0; i < n; i++) {
                if (a[r][i] > 0) {
                    break;
                }
            }
            if (i == n) { // r is isolated
                s.pop();
                eu[m++] = r;
            } else {
                s.push(i);
                display.enqueue(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        f.writeBytes(v[eu[0]] + "");
        for (i = 1; i < m; i++) {
            f.writeBytes("  " + v[eu[i]]);
        }
        f.writeBytes("\r\n");
        f.writeBytes(v[display.dequeue()] + "");
        f.writeBytes("  " + v[display.dequeue()]);
        f.writeBytes("  " + v[display.dequeue()]);
    }

    /*
    void f1() - Perfom depth-first traversal (to the file f1.xt) from the vertex i=1 (the vertex B) but
    display vertices with their deegrees in bracket. Hint: copy depth(...) to depth2(...) and modify the
    latter one. Content of the output file f1.txt must be:
    B G A E F I C H D
    B(1) G(2) A(4) E(3) F(3) I(3) C(1) H(2) D(1)
     */
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

        depth2(1, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void fvisit2(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i] + "(" + deg(i) + ")");
    }

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit2(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

//===========================================================================

    /*
    void f2() - Apply the Dijkstra’s shortest path algorithm to find the shortest path from the vertex 0
    (A) to the vertex 4 (E). (Note that in the weighted matrix, the value 999 is considered as infinity).
    Write 2 lines into the file f6.txt. The first line contains the list of vertices in the shortest path. The
    second lines contains shortest distances to the vertices in the first line. Content of the output file
    f2.txt must be:
    A C F E
    0 9 11 20
     */
    void f2() throws Exception {
        loadData(12);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
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
        while (true) {// find min d[i] in the set of those vertices not selected into S
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
        f.writeBytes("" + v[pp[0]]);
        for (i = 1; i < r; i++) {
            f.writeBytes("   " + v[pp[i]]);
        }
        f.writeBytes("\r\n");
        f.writeBytes("" + d[pp[0]]);
        for (i = 1; i < r; i++) {
            f.writeBytes("   " + d[pp[i]]);
        }
        f.writeBytes("\r\n");
    }

//===========================================================================
    /*
    Algorithm for finding an Euler cycle from the vertex X using stack 
    Input: Connected graph G with all vertices having even degrees
    Output: Euler cycle

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
 /*
    void f3() — Supposed the given graph has Euler's cycle. Apply the pseudocode in the Graph.java
    file to write statements to find the Euler's cycle from the vertex 1 (B). Output in the file f3.0ct must
    be the following:
    B D E D C B E G F A B
     */
    void f3() throws Exception {
        loadData(20);
        String fname = "f3.txt";
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
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f5.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f5.txt  

        EulerCycle(1, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    boolean isUndirected() // The adjacency matrix should be symmetric
    {
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

    boolean isEvenDegree() {
        int i, j, deg;
        for (i = 0; i < n; i++) {
            deg = 0;
            for (j = 0; j < n; j++) {
                deg += a[i][j];
            }
            if (deg % 2 == 1) {
                return (false);
            }
        }
        return (true);
    }

    boolean isConnected() {
        boolean[] pushed = new boolean[20];
        boolean cont = false;
        int i, j, k, r;
        for (i = 0; i < n; i++) {
            pushed[i] = false;
        }
        Stack s = new Stack();
        s.push(0);
        pushed[0] = true;
        while (!s.isEmpty()) {
            r = s.pop();
            for (i = 0; i < n; i++) {
                if (i == r) {
                    continue;
                }
                if (!pushed[i] && a[r][i] > 0) {
                    s.push(i);
                    pushed[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!pushed[i]) {
                return (false);
            }
        }
        return (true);
    }

    void checkEulerCycle(RandomAccessFile f) throws Exception {
        if (isUndirected()) {
            f.writeBytes("The graph is undirected.\r\n");
        } else {
            f.writeBytes("The graph is directed.\r\n");
        }
        if (isConnected()) {
            f.writeBytes("The graph is connected.\r\n");
        } else {
            f.writeBytes("The graph is not connected.\r\n");
        }

        if (isEvenDegree()) {
            f.writeBytes("All vertices have even degree.\r\n");
        } else {
            f.writeBytes("The graph has a vertex with odd degree\r\n");
        }
        if (isUndirected() && isConnected() && isEvenDegree()) {
            f.writeBytes("Conditions for Euler's cycle are satisfied.\r\n");
        } else {
            f.writeBytes("Conditions for Euler's cycle are not satisfied.\r\n");
        }

    }

    boolean hasEulerCycle() {
        boolean ok = true;
        if (!isUndirected()) {
            System.out.println("The graph is directed.\r\n");
            ok = false;
        }
        if (!isConnected()) {
            System.out.println("The graph is not connected.\r\n");
            ok = false;
        }

        if (!isEvenDegree()) {
            System.out.println("The graph has a vertex with odd degree\r\n");
            ok = false;
        }
        if (!ok) {
            System.out.println("Conditions for Euler's cycle are not satisfied.\r\n");
            return (false);
        }
        return (true);
    }

    void EulerCycle(int k, RandomAccessFile f) throws Exception {
        if (!hasEulerCycle()) {
            return;
        }
        Stack s = new Stack();
        int[][] b = new int[20][20];
        int[] eu = new int[20];
        int m;
        int i, j, r, t;
        int[] x = new int[50];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                b[i][j] = a[i][j];
            }
        }
        s.push(k);//Dua dinh k vao Stack
        m = 0;//Ban dau chu trinh chua co phan tu nao
        t = 0;
        x[0] = k;
        while (!s.isEmpty()) {
            r = s.top();
            i = 0;
            while (i < n && b[r][i] == 0) {
                i++;//Tim i dau tien de b[r][i]#0
            }
            if (i == n) //r da la dinh co lap, dua  r  vao chu trinh Euler
            {
                eu[m++] = r;
                s.pop();
            }//Lay dinh co lap ra khoi Stack
            else {
                x[++t] = i;
                s.push(i);
                b[r][i]--;
                b[i][r]--;
            }//Loai canh (i,r) khoi do thi
        }
        for (i = 0; i < m; i++) {
            f.writeBytes(v[eu[i]] + "  ");
        }
        f.writeBytes("\r\n");
    }

    /*
    void f1() - Perfom depth-first traversal (to the file fl.xt) from the vertex i=1 (the vertex B)
    but display vertices with their deegrees in bracket. Hint: copy depth(...) to depth2(...) and
    modify the latter one. Content of the output file fl.txt must be:
    B G A E F I C H D
    B(1) G(2) A(4) E(3) F(3) I(3) C(1) H(2) D(1)
     */
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(3, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        depth2(3, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    int count = 1;

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (count >= 2 && count <= 6) {
            fvisit(k, f);
        }
        visited[k] = true;
        count++;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

//=================================================================
    /*
    void f2() — Apply the Dijkstra’s shortest path algorithm to find the shortest path from the
    vertex 0 (A) to the vertex 4 (E). (Note that in the weighted matrix, the value 999 is
    considered as infinity). Write 2 lines into the file f6.txt. The first line contains the list of
    vertices in the shortest path. The second lines contains shortest distances to the vertices in
    the first line. Content of the output file f2.txt must be:
    A C F E
    0 9 11 20
     */
    void f2() throws Exception {
        loadData(12);
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
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  

        dijkstra(2, 5, f);
        f.writeBytes("\r\n");
        dijkstra(0, 6, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void dijkstra(int u, int z, RandomAccessFile f) throws IOException, Exception {

        boolean[] c = new boolean[n];
        int[] t = new int[n];
        int INF = 99;
        for (int i = 0; i < n; i++) {
            deg[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        while (curr != z) {
            int min = INF;
            int k = -1;
            for (int i = 0; i < n; i++) {
                if (!c[i] && deg[i] < min) {
                    min = deg[i];
                    k = i;
                }
            }
            if (min == INF) {
                System.out.println("Sortest path does not exists");
                return;
            }
            c[k] = true;
            curr = k;
            for (int i = 0; i < n; i++) {
                if (deg[i] > deg[k] + a[k][i] && !c[i]) {
                    deg[i] = deg[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        int[] h = new int[n];
        int hn = 0;
        h[hn] = z;
        int x, y = z;
        while (u != z) {
            z = t[z];
            h[++hn] = z;
        }
        int[] w = new int[n];
        int wn = -1;
        for (int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
        int k = 0;
        for (int i = hn; i >= 0; i--) {
            f.writeBytes(v[h[i]] + " ");
        }
        f.writeBytes("\n");
    }

    /*
    void f1()— Perform depth first traversal (to the file f1.txt) from the vertex i = 2 (the vertex C)
    but display first 6 vertices only. Hint: copy đepth(...) to depth2(...) and modify the latter
    one. Content of the output file f1.txt must be:
    C H D A E F I G B
    C H D A E F
     */
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(2, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        depth2(2, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    int count = 0;

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (count < 6) {
            fvisit(k, f);
            count++;
        }
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

//=================================================================
    /*
    void f2() - Apply the Dijkstra's shortest path algorithm to find the shortest path ffom the
    vertex 0 (A) to the vertex 6 (G). Write 2 lines to the file f2.txt: the line 1 contains vertices in
    shortest path, the line 2 contains the last 3 vertices selected into the set S with their labels
    (sec output format below). (Note that in the weighted matrix, the value 99 is considered as
    infinity). Output ín the file f2.txt must be the following:
    A  B  C  E  D  G
    D-19 F-24 G-29
     */
    void f2() throws Exception {
        loadData(12);
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
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  

        dijkstra(0, 6);
        f.writeBytes(s1 + "\r\n");
        f.writeBytes(s2);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    String s1 = "";
    String s2 = "";

    void dijkstra(int fro, int to) {
        List<Integer> listSelected = new ArrayList<>();
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int i, j, k, min;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        S[fro] = true;
        listSelected.add(fro);
        while (true) {
            min = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < min) {
                    min = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("No solution");
                return;
            }
            S[k] = true;
            listSelected.add(k);
            if (k == to) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
//        System.out.println("The shortest distance is " + d[to]);
//        System.out.println("The path is:");
        i = to;
        Stack s = new Stack();
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro) {
                break;
            }
        }
        i = s.pop();
//        System.out.print(v[i] + "(" + d[i] + ")");
        s1 += v[i];
        while (!s.isEmpty()) {
            i = s.pop();
//            System.out.print(" -> " + v[i] + "(" + d[i] + ")");
            s1 += " " + v[i];
        }
        for (int m = listSelected.size() - 3; m < listSelected.size(); m++) {
            int index = listSelected.get(m);
            s2 = s2 + v[index] + "-" + d[index] + " ";
        }
        s2 = s2.trim();
    }
}

    /*
        Apply the Dijkstra's shortest path algorithm to find (1) the shortest path
    from vertext 2 (C) to vertex 5 (F), then (2) from vertex 0 (a) to vertex 6 (G).
    Write 3 lines to the file f2.txt: lime 1 contains vertices in shortest path (2),
    line 2 contrains the last 4 vertices selected into the set S, line 3 contains 
    vertices in shortest path (1). (Note theat in the weighted matrix, the value 
    99 is considered as infinity).
    */
    Content of the file f2.txt:
  
    A  B  C  E  D  G
    E  D  F  G
    C  E  D  F

//      ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> setS1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        ArrayList<Integer> setS2 = new ArrayList<>();
        dijkstra(path1, setS1, 2, 5, f);
        dijkstra(path2, setS2, 0, 6, f);
        for (int i = 0; i < path2.size(); i++) {
            fvisit(path2.get(i), f);
        }
        
        f.writeBytes("\r\n");
        for (int i = setS2.size() - 4; i < setS2.size(); i++) {
            fvisit(setS2.get(i), f);
        }

        f.writeBytes("\r\n");
        for (int i = 0; i < path1.size(); i++) {
            fvisit(path1.get(i), f);
        }
//
    
    void dijkstra(ArrayList<Integer> path, ArrayList<Integer> setS, int fro, int to, RandomAccessFile f) throws Exception {
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int i, j, k, t;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }

        S[fro] = true;

        while (true) {
            t = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < t) {
                    t = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                return;
            }
            S[k] = true;
            setS.add(k);
            if (k == to) {
                break;
            }
            // update data
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        Stack s = new Stack();
        i = to;
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        i = s.pop();
        path.add(i);
        while (!s.isEmpty()) {
            i = s.pop();
            path.add(i);
        }
    }

/*
        Apply the Dijkstra's shortest path algorithm to find (1) the shortest path
    from vertext 2 (C) to vertex 5 (F), then (2) from vertex 0 (A) to vertex 6 (G).
    Write 2 lines to the file f2.txt: line 1 contains the first and the last vertices
    and shortest distance in (1), line 2 contains the ..................
    OUTPUT:
          C->F:12
 	  E-15 D-19 F-24 G-29
    */
    
//        dijkstra(2, 5, f);
//        dijkstra2(0, 6, f);

    void dijkstra(int fro, int to, RandomAccessFile f) throws Exception {
        int INF = 999; // infinity value
        boolean[] S = new boolean[n]; // kiem tra xem da duyet dinh chua
        int[] d = new int[n]; // luu gia tri duong di ngan nhat tai dinh do
        int[] p = new int[n]; // luu gia tri dinh gan no nhat

        for (int i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }

        ArrayList<Integer> ss = new ArrayList<>(); // cac dinh duoc lay     
        // them fro vao ss
        S[fro] = true;
        ss.add(fro);

        // Duyet cac dinh, tim min quang duong, them vao tap ss
        int k, t;
        while (true) {
            k = -1;
            t = INF;
            for (int i = 0; i < n; i++) {
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
            }
            S[k] = true; // select k into the set ss
            ss.add(k);
            if (k == to) {
                break;
            }
            // Recalculate d[i]
            for (int i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }

        // truy nguoc lai cac dinh tu to ve fro
        Stack s = new Stack();
        int x = to;
        while (true) {
            s.push(x);
            if (x == fro) {
                break;
            }
            x = p[x]; // truy nguoc ve dinh lien truoc no
        }

        ArrayList<Integer> pp = new ArrayList<>();
        while (!s.isEmpty()) { // loi tu stack s sang pp
            x = s.pop();
            pp.add(x);
        }

        // In ra cac dinh thoa man
//        f.writeBytes(v[ss.get(fro)]+"->" +v[ss.get(to)]+ d[ss.get(ss.size()-1)]);
        f.writeBytes("" + v[pp.get(0)]);
        f.writeBytes("->" + v[pp.get(pp.size() - 1)] + ":" + d[ss.get(ss.size() - 1)]);
        f.writeBytes("\r\n");
    }

    void dijkstra2(int fro, int to, RandomAccessFile f) throws Exception {
        int INF = 999; // infinity value
        boolean[] S = new boolean[n]; // kiem tra xem da duyet dinh chua
        int[] d = new int[n]; // luu gia tri duong di ngan nhat tai dinh do
        int[] p = new int[n]; // luu gia tri dinh gan no nhat

        for (int i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }

        ArrayList<Integer> ss = new ArrayList<>(); // cac dinh duoc lay     
        // them fro vao ss
        S[fro] = true;
        ss.add(fro);

        // Duyet cac dinh, tim min quang duong, them vao tap ss
        int k, t;
        while (true) {
            k = -1;
            t = INF;
            for (int i = 0; i < n; i++) {
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
            }
            S[k] = true; // select k into the set ss
            ss.add(k);
            if (k == to) {
                break;
            }
            // Recalculate d[i]
            for (int i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }

        // truy nguoc lai cac dinh tu to ve fro
        Stack s = new Stack();
        int x = to;
        while (true) {
            s.push(x);
            if (x == fro) {
                break;
            }
            x = p[x]; // truy nguoc ve dinh lien truoc no
        }

        ArrayList<Integer> pp = new ArrayList<>();
        while (!s.isEmpty()) { // loi tu stack s sang pp
            x = s.pop();
            pp.add(x);
        }

        // In ra cac dinh duoc chon lan luot theo thuat toan
        f.writeBytes("" + v[ss.get(ss.size() - 4)] + "-" + d[ss.get(ss.size() - 4)]);
        for (int i = ss.size() - 3; i < ss.size(); i++) {
            f.writeBytes(" " + v[ss.get(i)] + "-" + d[ss.get(i)]);
        }
        f.writeBytes("\r\n");
    }
