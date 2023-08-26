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

    void loadData(int k) //do not edit this function
    {
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

    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        s += a[i][i];
        return (s);
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

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//===========================================================================

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
        dijkstraExtended(1, 4, f);
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
        findEulerCycle(0, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    public void findEulerCycle(int v1, RandomAccessFile f) throws IOException {
        ArrayList t = new ArrayList();
        Stack s = new Stack();
        int sel = v1;
        s.push(sel);
        while (!s.isEmpty()) {
            int tmp = s.top();
            sel = isolated(tmp);
            if (sel == -1) {//=> tmp la dinh co lap
                tmp = (int) s.pop();
                t.add(tmp);
            } else {
                //s ko la dinh co lap, check la dinh lien ke dau tien
                //dua check vao stack va remoe canh tmp,check
                s.push(sel);
                a[tmp][sel]--;
                a[sel][tmp]--;
            }
        }
        for (int i = 0; i < t.size(); i++) {
            f.writeBytes(" " + v[(int) t.get(i)]);
        }

    }

    int isolated(int v) {
        for (int i = 0; i < n; i++) {
            if (a[v][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public void dijkstra(int from, int to, RandomAccessFile f) throws Exception {
        int distance[] = new int[n];
        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            path[i] = from;
            visited[i] = false;
        }

//        System.out.println("");
        distance[from] = 0;
        int sel = from;
        visited[sel] = true;
//        path[0] = from;
        for (int t = 0; t < n; t++) {

            for (int i = 0; i < n; i++) {
                //cac dinh lien ke cua from
                if (!visited[i] && (a[sel][i] + distance[sel] < distance[i])) {
                    distance[i] = a[sel][i] + distance[sel];
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
        String a = "", b = "";
        while (!stack.isEmpty()) {
            x = (int) stack.pop();
            a += v[x] + " ";
            b += distance[x] + " ";
//            f.writeBytes(v[x] + " ");
        }
//        f.writeBytes(a + "\n" + b);
        f.writeBytes(a + "\n" + b);
//        System.out.println();
//        System.out.println("distance = " + distance[to]);

    }

    public void dijkstraExtended(int from, int to, RandomAccessFile f) throws Exception {
        int distance[] = new int[n];
        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            path[i] = from;
            visited[i] = false;
        }

//        System.out.println("");
        distance[from] = 0;
        int sel = from;
        visited[sel] = true;
//        path[0] = from;
        ArrayList<Integer> selectedSet = new ArrayList<>();
        ArrayList<Integer> labelSet = new ArrayList<>();
        selectedSet.add(from);
        labelSet.add(0);
        for (int t = 0; t < n; t++) {

            for (int i = 0; i < n; i++) {
                //cac dinh lien ke cua from
                if (!visited[i] && (a[sel][i] + distance[sel] < distance[i])) {
                    distance[i] = a[sel][i] + distance[sel];
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
            if (t < n - 1) {
                selectedSet.add(sel);
                labelSet.add(min);
            } else {
                labelSet.add(min);
            }
        }
        String selectedVertices = "";
        String labels = "";
        String verticesAndLabels = "";
        for (int i = selectedSet.size()-3; i < selectedSet.size(); i++) {
            selectedVertices += v[selectedSet.get(i)] + " ";
            labels += labelSet.get(i) + " ";
            verticesAndLabels += v[selectedSet.get(i)] + "-" + labelSet.get(i) + " ";
            if (selectedSet.get(i) == to) {
                break;
            }
        }

        int x = to;
        Stack stack = new Stack();
        while (x != from) {
            stack.push(x);
            x = path[x];
        }
        stack.push(from);
        String a = "", b = "";
        while (!stack.isEmpty()) {
            x = (int) stack.pop();
            a += v[x] + " ";
            b += distance[x] + " ";
//            f.writeBytes(v[x] + " ");
        }
//        f.writeBytes(a + "\n" + b);
        f.writeBytes(a + "\n" + b);
        f.writeBytes("\n" + verticesAndLabels);
//        System.out.println();
//        System.out.println("distance = " + distance[to]);

    }

    boolean isEvenDegree() {
        int bac;
        for (int i = 0; i < n; i++) {
            bac = 0;
            for (int j = 0; j < n; j++) {
                bac += a[i][j];
            }
            if (bac % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    boolean isConnected() {
        boolean[] pushed = new boolean[20];

        for (int i = 0; i < n; i++) {
            pushed[i] = false;
        }
        Stack s = new Stack();
        s.push(0);
        pushed[0] = true;

        int r;
        while (!s.isEmpty()) {
            r = s.pop();
            for (int i = 0; i < n; i++) {
                if (i == r) {
                    continue;
                }
                if (!pushed[i] && a[r][i] > 0) {
                    s.push(i);
                    pushed[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!pushed[i]) {
                return false;
            }
        }
        return true;
    }

    void checkEulerCycle(RandomAccessFile f) throws Exception {
        // Check directed
        if (isUndirected()) {
            f.writeBytes(
                    "The graph is undirected.\r\n"
            );
        } else {
            f.writeBytes("The graph is directed.\r\n");
        }
        // Check connected
        if (isConnected()) {
            f.writeBytes(
                    "The graph is connected.\r\n"
            );
        } else {
            f.writeBytes("The graph is not connected.\r\n");
        }
        // Check even degree
        if (isEvenDegree()) {
            f.writeBytes(
                    "All vertices have even degree.\r\n"
            );
        } else {
            f.writeBytes("The graph has a vertex with odd degree\r\n");
        }
        // Check Euler's cycle
        if (isUndirected() && isConnected() && isEvenDegree()) {
            f.writeBytes(
                    "Conditions for Euler's cycle are satisfied.\r\n"
            );
        } else {
            f.writeBytes("Conditions for Euler's cycle are not satisfied.\r\n");
        }
    }

    boolean isUndirected() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean hasEulerCycle() {
        boolean ok = true;
        if (!isUndirected()) {
//            System.out.println("The graph is directed.\r\n");
            ok = false;
        }
        if (!isConnected()) {
//            System.out.println("The graph is not connected.\r\n");
            ok = false;
        }
        if (!isEvenDegree()) {
//            System.out.println("The graph has a vertex with odd degree\r\n");
            ok = false;
        }
        if (!ok) {
//            System.out.println("Conditions for Euler's cycle are not satisfied.\r\n");
            return false;
        }
        return true;
    }
}
//=================================================================
