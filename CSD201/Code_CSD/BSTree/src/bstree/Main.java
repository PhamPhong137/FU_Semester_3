/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

/**
 *
 * @author PC-Phong
 */
public class Main {

    public static void main(String[] args) {
        MyBSTree bt = new MyBSTree();
        bt.insert(5);
        bt.insert(2);
        bt.insert(6);
        bt.insert(1);
        bt.insert(4);
        bt.insert(8);
        // bt.insert(55);
        bt.insert(3);
        bt.insert(7);
        //  bt.insert(bt.root, 26);
        bt.BFS(bt.root);
        System.out.println("");
        bt.deleteByMerging(5);
        bt.BFS(bt.root);

//        System.out.println("PreOrder:");
//        bt.preOrder(bt.root);
//
//        System.out.println("");
//        System.out.println("InOrder:");
//        bt.inOrder(bt.root);
//
//        System.out.println("");
//        System.out.println("PostOrder:");
//        bt.postOrder(bt.root);
//
//        System.out.println("");
//        System.out.println("BFS");
//        bt.BFS(bt.root);

//        System.out.println("");
//        System.out.println("Search");

//        Node c = bt.search(bt.root, 30);
//        if (c != null) {
//            System.out.println("Have " + c.value);
//        } else {
//            System.out.println("Can not found");
//        }

       






    

    }

}
