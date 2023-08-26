/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
 *
 * @author Hp
 */
public class BSTMain {

    public static void main(String[] args) {

        MyBST hoenTree = new MyBST();
        hoenTree.insert(30);
        hoenTree.insert(10);
        hoenTree.insert(35);
        hoenTree.insert(20);
        hoenTree.insert(25);
        hoenTree.insert(5);
        hoenTree.insert(15);
        System.out.println("BST before rotation: ");
        try {
            hoenTree.breadth(hoenTree.root);
        } catch (Exception e){
            System.out.println("Something went wrong");
        }
        hoenTree.root= hoenTree.leftRightRotate(hoenTree.root);
        System.out.println("\nBST after rotation: ");
        try {
            hoenTree.breadth(hoenTree.root);
        } catch (Exception e){
            System.out.println("Something went wrong");
        }        
    }

//    public static void main(String[] args) throws Exception {
//        MyBST hoenTree = new MyBST();
//        hoenTree.readDataFromFile("src\\BinarySearchTree\\data.txt");
////        hoenTree.insert(9);
////        hoenTree.insert(5);
////        hoenTree.insert(15);
////        hoenTree.insert(2);
////        hoenTree.insert(7);
////        hoenTree.insert(14);
////        hoenTree.insert(16);
////        hoenTree.insert(6);
////        hoenTree.insert(10);
////        System.out.print("Pre-order: ");
////        hoenTree.preOrder(hoenTree.root);
////        System.out.println();
////        System.out.print("In-order: ");
////        hoenTree.inOrder(hoenTree.root);
////        System.out.println();
////        System.out.print("Post-order: ");
////        hoenTree.postOrder(hoenTree.root);
////        System.out.println();
////        System.out.print("Bread-first search: ");
////        hoenTree.breadFirstSearch(hoenTree.root);
////        System.out.println();
////        System.out.print("Bread-first search: ");
////        hoenTree.breadth(hoenTree.root);
////        hoenTree.remove(44);
////        System.out.println();
////        System.out.print("Bread-first search: ");
////        hoenTree.breadth(hoenTree.root);
//        System.out.println("Height of 47 is " + hoenTree.height(47));
//    }
}
