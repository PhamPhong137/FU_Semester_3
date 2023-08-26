/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exdoublelinkedlist;

/**
 *
 * @author PC-Phong
 */
public class Main {
    
    public static void main(String[] args) {
        MyDoubleList dl = new MyDoubleList();
        dl.addFirst(new Student("S001", "Duc", 9, 8, 9));
        dl.addFirst(new Student("S002", "Phong", 10, 8, 7));
        dl.addFirst(new Student("S003", "Hieu", 9, 8, 7));
        dl.addLast(new Student("S007", "Duong", 7, 8, 9));
        dl.addLast(new Student("S007", "Tung", 7, 8, 9));
        dl.addPos(new Student("S008", "Minh", 10, 2, 5), 5);
        //Remove student
        //  dl.removeByID("S004");

        dl.displayAll();

        // Get student by index
        //  System.out.println(dl.get(0));
        // Search student byIDStudent
        dl.search("S007");
        // Find student have max average
        //   System.out.println(dl.max());
        
        
        //Test Stack
        
        MyStack ms = new MyStack();
        ms.push(new Student("S009", "PHONG", 5, 6, 9));
        
        
        ms.display();
        
    }
    
}
