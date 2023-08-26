/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Node implements Comparable<Node> { // Tao node voi 2 gia tri la data va freq
    String data; 
    double freq;
    Node left, right;

    Node(String d, double f) {
        data = d;
        freq = f;
    }

    @Override
    public int compareTo(Node o) { // ham de sap xep lai cac node truoc khi thuc hien Huffman Coding
        if (freq < o.freq) {
            return -1;
        }
        if (freq > o.freq) {
            return +1;
        }
        return 0;
    }

    @Override
    public String toString(){
        return "<" + data + ", " + freq + ">";
    }
//    Node(String d, double f) {data=d; freg = f;}

    Node(Node lNode, Node rNode) { // Thuc hien qua trinh cong cay 
        data = lNode.data + rNode.data; // lay data cua node left + data node right = data
        freq = lNode.freq + rNode.freq; // lay freq cua node left + data node right = freq
        this.left = lNode;
        this.right = rNode;
    }
}

class Huffman1 {

    ArrayList<Node> A; // Tao ArrayList de luu cac node 
    HashMap<String, String> CodeTable; // Tao hashmap de luu gia tri cac node sau khi coding
         
    void displayList() { // Ham de display cac node
        for (Node node : A) {
            System.out.println("" + node);
        }
    }

    public Huffman1() { // Add cac node vao ArrayList
        A = new ArrayList<>();
        A.add(new Node("A", 0.2));
        A.add(new Node("B", 0.09));
        A.add(new Node("C", 0.15));
        A.add(new Node("D", 0.11));
        A.add(new Node("E", 0.4));
        A.add(new Node("F", 0.05));
    }

    void CreateCodeTable() { // Ham nay de luu qua trinh thuc hien Huffman Coding
        while (A.size() > 1) { // Hàm này để check array list nếu > 1 thì thực hiện Huffman Coding
            Collections.sort(A);// Sort lại ArrayList mỗi lần trước khi thực hiện cộng node
            displayList();// Display ra kết quả sau khi sort
            A.add(new Node(A.get(1), A.get(0))); // thực hiện add 2 node lại với nhau
            A.remove(1); // Sau khi thực hiện cộng thì phải xoá node đó đi 
            A.remove(0);
            System.out.println("Step!");
        }
        displayList();// Display hết quả sau khi thực hiện sort
        CodeTable = new HashMap<String, String>(); // Tạo HashMap
        preOrder(A.get(0), ""); // Preorder cây 
        Set<Map.Entry<String,String>> entryset = CodeTable.entrySet();// Lưu các kết quả vào HashMap
        System.out.println(""+entryset);// In HashMap ra
    }
    
    void preOrder(Node root, String acc){ // hàm để preorder cây
        if(root.left == null && root.right==null){//check các nhánh của cây, nếu 2 nhánh k null thì ném data vào HashMap
            //System.out.println(root.data + ": " + acc);
            CodeTable.put(root.data, acc);// Đẩy kết quả vào HashMap với data và acc
            // acc là biến để lưu giá trị mã hoá 0 or 1
            return;
        }
        //Theo lý thuyết của Huffman Coding thì nhánh trái của cây sẽ đc mã hoá thành 0 còn nhánh phải là 1 
        preOrder(root.right, acc+"1");
        preOrder(root.left, acc+"0");
    }
}

public class Huffman_Encoding {

    public static void main(String[] args) {
        Huffman1 H = new Huffman1();
        H.CreateCodeTable();
    }
}
