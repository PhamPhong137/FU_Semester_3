/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_1_3;

/**
 *
 * @author Admin
 */
public class Main {
    public static MyList my = new MyList();
    
    public static void generate(){
        my.addLast("A", 1);
        my.addLast("B", 5);
        my.addLast("C", 10);
        my.addLast("G", 80);
        my.addLast("H", 91);
        my.addLast("I", 100);
        my.addLast("D", 20);
        my.addLast("E", 25);
        my.addLast("F", 2);
        my.display();
    }
    
    public static void main(String[] args) {
//        //F1: make a list
//        generate();
        
//        //F2: sort increasingly
//        generate();
//        my.sort();
//        my.display();

        //F3: add Index from the beginning if student have mark<50
        //    add Index from the beginning if student have mark>50
        generate();
        my.sort();
        my.addIndex("D", 40);
        my.addIndex("Z", 83);
        my.display();
        
//        //F4: delete student having mark <=3
//        generate();
//        my.delete();
//        my.display();^
        
//        //F5: print average mark
//        generate();
//        my.averageMark();
    }
}
