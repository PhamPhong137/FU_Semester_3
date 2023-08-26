/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt1;

/**
 *
 * @author PC-Phong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.enqueue(new Student("HE176151", "Phong", 8, 9));
        mq.enqueue(new Student("HE176152", "Tung", 7, 9));
        mq.enqueue(new Student("HE176152", "Lan", 10, 10));
        mq.enqueue(new Student("HE176154", "Mai", 5, 7));
        mq.enqueue(new Student("HE176155", "Duc", 3, 4));
        mq.enqueue(new Student("HE176156", "Minh", 1, 2));
        mq.enqueue(new Student("HE176157", "Bach", 10, 10));

        mq.dequeue();
        mq.displayAll();
        System.out.println("Size of List: " + mq.size());

//        System.out.println("Search student:");
//        mq.search("HE17615");

//        System.out.println("Student max");
//        mq.studentMax();
        
        mq.remove();
        mq.displayAll();
        System.out.println("Size of List: " + mq.size());
    }

}
