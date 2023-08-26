/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floyd_algorithm;

public class Floyd_Algorithm {

    final static int INF = 99999, V = 7;

    public static void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int P[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
            System.out.println("k =" + k);
            printSolution(dist);

        }

        printSolution(dist);
    }

    public static void printSolution(int dist[][]) {
        System.out.println("Following matrix shows the shortest "
                + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int graph[][] = {{0, 3, 4, INF,INF, INF, INF}
, {6, 0, INF, 3, 2,INF, INF},
 {INF,INF,0, 2, 6, INF, 2},
 {2,3, INF, 0, 3, 4, INF},
 {INF, INF, INF, 2, 0, INF,INF}, 
{INF, INF, INF, 1, INF, 0,2},
{INF, INF, INF, 1, INF, INF,0}};

        floydWarshall(graph);
    }
}
