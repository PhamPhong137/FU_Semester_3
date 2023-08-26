/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Admin MSI
 */

    class Node1 implements Comparable <Node> {
    String data; double freq;
    Node   left, right;
    
        Node1(String d, double f) {
        data = d;
        freq = f;
    }
    
    @Override public int compareTo(Node o) {
        if(freq < o.freq) return -1;
        if(freq > o.freq) return +1;
        return 0;
    }
    @Override public String toString() { 
        return "<" + data + ", " + freq + ">"; 
    }
    Node1(String d, int f) {
        data = d; freq = f; 
        left = right = null;
    }
    Node1(Node lNode, Node rNode) { 
        data = lNode.data + rNode.data; 
        freq = lNode.freq + rNode.freq;
        this.left  = lNode;
        this.right = rNode;
    }
}
class Huffman3 {
    ArrayList<Node> A; 
    HashMap<String,String> CodeTable;
    void dispList() { 
        for (Node node : A) 
            System.out.print(" " + node);
    }
    
    Huffman3(String fname) throws FileNotFoundException {
        // Thống kê tần suất xuất hiện của các ký tự trong file text
        Scanner fThongKe = new Scanner(new File(fname)); 
        HashMap<String,Integer> Freq = new HashMap<>();
        while(fThongKe.hasNextLine()) {
           String line = fThongKe.nextLine(); 
           for (int i = 0; i < line.length(); i++) {
               Integer numOccur = 0;
               if(Freq.containsKey(String.valueOf(line.charAt(i))))
                   numOccur = Freq.get(String.valueOf(line.charAt(i)));
               Freq.put(String.valueOf(line.charAt(i)), numOccur + 1);
            }
        }
        Set<Map.Entry<String,Integer>> entryset = Freq.entrySet(); 
        //System.out.println(""+entryset);
        A = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : entryset) {
            A.add(new Node(entry.getKey(),entry.getValue()));
            System.out.print(", "+entry);
        }
    }
    void CreateCodeTable () {
        Collections.sort(A);
        int i = 1;
        while(A.size() > 1) {
            System.out.println("\n---Step---"+i);
            dispList(); 
            A.add(new Node(A.get(1),A.get(0))); 
            A.remove(1); A.remove(0); // remove(0),remove(0)
            i++;
        }
        dispList(); // Chỉ còn một nút gốc.
        CodeTable = new HashMap<>(); 
        preOrder(A.get(0), "");
        System.out.println("\nBang ma:");
        Set<Map.Entry<String,String>> entryset = CodeTable.entrySet(); 
        System.out.println(""+entryset);
    }
    void preOrder(Node goc, String acc) {
        if(goc.left == null && goc.right==null) { 
            // System.out.println(goc.data + ": " + acc);
            CodeTable.put(goc.data, acc); 
            return; 
        }
        preOrder(goc.left, acc+"1");
        preOrder(goc.right, acc+"0");
    }
    String CodeOneLine(String line) {
        String res="";
        for (int i = 0; i < line.length(); i++)
            if(! CodeTable.containsKey((String.valueOf(line.charAt(i)))))
                res += line.charAt(i);
            else 
                res += CodeTable.get((String.valueOf(line.charAt(i))));
        return res;
    }
}
//====================================
//        Huffman H = new Huffman(); // tan suat cho san

public class Test_HMC {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("...Dang doc file de thong ke tan suat...");
        Huffman3 H = new Huffman3("D:\\Workspace\\Java\\CSD201\\TextProcessing\\algorithm\\huff-in.txt"); // thong ke tan suat 
        System.out.println("\n...Dang tao bang ma...");
        H.CreateCodeTable();
        Scanner f = new Scanner(new File("D:\\Workspace\\Java\\CSD201\\TextProcessing\\algorithm\\huff-in.txt"));
        FileWriter fw = new FileWriter("huff-out.txt");
        System.out.println("...Coding by Huffman...");
        while (f.hasNextLine()) {
            String line = f.nextLine();
            System.out.println("> " + line);
            String codingLine = H.CodeOneLine(line);
            System.out.println("=> " + codingLine);
            fw.write(codingLine + "\n");
        }
        fw.close();
        System.out.println("___Success___");
    }
}
