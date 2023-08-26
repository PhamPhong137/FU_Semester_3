/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Scanner;

/**
 *
 * @author Admin MSI
 */
public class Graph {

    private boolean adjacencyMatrix[][];
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true;
        }
    }

//    public void removeEdge(int i, int j) {
//        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
//            adjacencyMatrix[i][j] = false;
//            adjacencyMatrix[j][i] = false;
//        }
//    }
    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            return adjacencyMatrix[i][j] || adjacencyMatrix[j][i];
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        Validate v = new Validate();
     
        int start = v.inputInt("Enter the start point: ");

        int end = v.inputInt("Enter the end point: ");

        System.out.println("This is " + (graph.isEdge(start, end) ? "" : "not ") + "an edge");
    }
}
