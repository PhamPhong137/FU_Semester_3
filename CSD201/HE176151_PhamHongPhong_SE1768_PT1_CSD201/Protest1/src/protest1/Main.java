/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protest1;

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

        mq.enQueue(new Student("HE176151", "Phong", 9, 8));
        mq.enQueue(new Student("HE176152", "Lan", 5, 8));
        mq.enQueue(new Student("HE176153", "Tung", 6, 8));
        mq.enQueue(new Student("HE176154", "Duc", 9, 10));
        mq.enQueue(new Student("HE176155", "Duong", 9, 5));
        mq.enQueue(new Student("HE176156", "Huy", 9, 10));
        mq.enQueue(new Student("HE176157", "Dat", 5, 5));
        mq.enQueue(new Student("HE176158", "Bach", 2, 3));

        mq.deQueue();

        mq.display();

        System.out.println("Size of the list: " + mq.size());
        
        System.out.println("Search Student:");
        mq.searchByID("HE176155");
        
        System.out.println("Student have max AVG: ");
        mq.max();
        
        System.out.println("After remove student have AVG < 5.0");
        mq.remove();
        mq.display();
                

    }

}
