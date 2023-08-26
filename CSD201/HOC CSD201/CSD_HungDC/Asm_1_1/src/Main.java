/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {
    public static MyList myList = new MyList();
    
    public static void Generate(){
        myList.addLast("A", 20);
        myList.addLast("C", 13);
        myList.addLast("D", 15);
        myList.addLast("E", 25);
        myList.addLast("E", 23);
        myList.addLast("E", 17);
        myList.addLast("E", 28);
        myList.display();
    }
    
    public static void main(String[] args) {
//        //cau 1: addLast
//        Generate();
//        
//        //cau 2: add new car after a node that has smaller value
//        Generate();
//        myList.addIndex("F", 30, 16);
//        myList.display();
        
//        //cau 3.1: delete the first Prime
//        Generate();
//        myList.deleteFisrtPrime();
//        myList.display();
        
        //cau 3.2: delete the last Prime
        
    }
}
