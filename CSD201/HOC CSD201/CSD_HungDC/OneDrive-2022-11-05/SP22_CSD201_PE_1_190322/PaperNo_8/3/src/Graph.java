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
    int count = 0;
    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (count >= 1 && count<=5){
            fvisit(k, f);
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

//=================================================================
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
                if (S[i] == true) continue;
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) return; // no solution            
            S[k] = true; // select k into the set ss
            ss.add(k);
            if (k == to) break;
            // Recalculate d[i]
            for (int i = 0; i < n; i++) {
                if (S[i] == true) continue;
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
            if (x == fro) break;
            x = p[x]; // truy nguoc ve dinh lien truoc no
        }
        
        ArrayList<Integer> pp = new ArrayList<>();  
        while (!s.isEmpty()) { // loi tu stack s sang pp
            x = s.pop();
            pp.add(x);
        }
        
        
        // In ra cac dinh thoa man
        f.writeBytes("" + v[pp.get(0)]);
        for (int i = 1; i < pp.size(); i++) f.writeBytes("   " + v[pp.get(i)]);
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
                if (S[i] == true) continue;
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) return; // no solution            
            S[k] = true; // select k into the set ss
            ss.add(k);
            if (k == to) break;
            // Recalculate d[i]
            for (int i = 0; i < n; i++) {
                if (S[i] == true) continue;
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
            if (x == fro) break;
            x = p[x]; // truy nguoc ve dinh lien truoc no
        }
        
        ArrayList<Integer> pp = new ArrayList<>();  
        while (!s.isEmpty()) { // loi tu stack s sang pp
            x = s.pop();
            pp.add(x);
        }
        
        // In ra cac dinh duoc chon lan luot theo thuat toan
       f.writeBytes("" + v[ss.get(ss.size() - 4)]);
        for (int i = ss.size() - 3; i < ss.size(); i++) f.writeBytes("   " + v[ss.get(i)]);
        f.writeBytes("\r\n");
//        // In ra cac dinh thoa man
//        f.writeBytes("" + v[pp.get(0)]);
//        for (int i = 1; i < pp.size(); i++) f.writeBytes("   " + v[pp.get(i)]);
//        f.writeBytes("\r\n");
//        // In ra min quan duong tai cac dinh do
//        f.writeBytes("" + d[pp.get(0)]);
//        for (int i = 1; i < pp.size(); i++) f.writeBytes("   " + d[pp.get(i)]);
//        f.writeBytes("\r\n");
    }
    
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
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
        dijkstra(0, 6, f);
        dijkstra2(0, 6, f);
        dijkstra(2, 5, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

}
