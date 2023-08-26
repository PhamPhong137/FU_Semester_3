/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_1_2;

/**
 *
 * @author Admin
 */
public class Main {
    public static MyList my = new MyList();
    
    public static void generatef1(){
        my.addLast("A", 9, 8);
        my.addLast("C", 6, 5);
        my.addLast("D", 2, 4);
        my.addLast("E", 7, 9);
        my.addLast("F", 4, -7);
        my.addLast("G", -3, 2);
        my.display();
    }
    
    public static void generatef2(){
        my.addLast("C", 9, 8);
        my.addLast("D", 6, 3);
        my.addLast("E", 8, 5);
        my.addLast("F", 5, 4);
        my.addLast("I", 4, 9);
        my.display();
    }
    
    public static void generatef3(){
        my.addLast("C", 8, 6);
        my.addLast("D", 3, 5);
        my.addLast("E", 9, 2);
        my.addLast("F", 5, 8);
        my.addLast("G", 9, 7);
        my.addLast("H", 6, 8);
        my.addLast("I", 7, 3);
        my.display();
    }
    
    public static void generatef4(){
        my.addLast("C", 1, 2);
        my.addLast("D", 10, 3);
        my.addLast("E", 2, 15);
        my.addLast("F", 11, 6);
        my.addLast("I", 6, 14);
        my.addLast("J", 11, 15);
        my.addLast("K", 7, 9);
        my.display();
    }
    
    public static void main(String[] args) {
//        //cau 1: add last
//        generatef1();
        
//        //cau 2: add index
//        generatef2();
//        my.addIndex("X", 1, 2, 3);
//        my.addIndex("Y", 3, 4, 5);
//        my.display();
       
//        //cau 3: find the second node having rate < 6 and change it's wing to 99
//        generatef3();
//        my.f3();
//        my.display();
        
        //cau 4: sort from beginning to first max rate ascendingly
        generatef4();
        my.f4();
        my.display();
    }
}
