/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_csd_singlylinkedlist;

import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        MySinglyList<Student> ml = new MySinglyList();

        ml.addLast(new Student("HE176151", "Phong", 8, 9, 9, 10, 9, 10, 0));
        ml.addLast(new Student("HE176152", "Duc", 8, 9, 7, 9, 9, 8, 0));
        ml.addLast(new Student("HE176153", "Nam", 8, 7, 4, 6, 5, 2, 0));
        ml.addLast(new Student("HE176154", "Lan", 8, 1, 5, 4, 9, 10, 0));
        ml.addLast(new Student("HE176155", "Hung", 6, 9, 9, 7, 3, 2, 0));
        ml.addLast(new Student("HE176156", "Long", 9, 9, 6, 9, 7, 5, 0));
        ml.addLast(new Student("HE176157", "Bach", 7, 9, 5, 6, 3, 8, 0));
        ml.addFirst(new Student("HE176158", "Tung", 7, 9, 5, 6, 8, 8, 0));
        
        //Add at index 
        try {
            ml.add(100, new Student("HE176159", "Tien", 7, 8, 6, 7, 9, 8, 0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBound, can not add student");
        }

        //Remove first
        try {
            ml.removeFirst();
        } catch (NoSuchElementException e) {
            System.out.println("List empty");
        }
        //Remove last
        try {
            ml.removeLast();
        } catch (NoSuchElementException e) {
            System.out.println("List empty");
        }

        //Remove at index
        ml.remove(2);

        ml.removeByElement(new Student("HE176151", "Phong", 8, 9, 9, 10, 9, 10, 0));

        ml.display();

        System.out.printf("\nSize of list: ");
        System.out.println(ml.size());

        System.out.printf("\nTake the first student in list:\n");
        System.out.println(ml.getFirst());

        System.out.printf("\nTake the last student in list:\n");
        System.out.println(ml.getLast());

        System.out.println("Check student in list: ");
        Student student1 = new Student("HE176157", "Bach", 7, 9, 5, 6, 3, 8, 6.0);
        System.out.println(ml.contains(student1));

        System.out.println("Get student: ");
        try {
            System.out.println(ml.get(1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBound");
        }

        //Trả về chỉ mục xuất hiện đầu tiên
        System.out.print("Indexof: ");
        System.out.println(ml.indexOf(new Student("HE176156", "Long", 9, 9, 6, 9, 7, 5, 0)));
        //Trả về chỉ mục xuất hiện cuối cùng
        System.out.print("LastIndexOf: ");
        System.out.println(ml.indexOf(new Student("HE176156", "Long", 9, 9, 6, 9, 7, 5, 0)));

        //Đổi chỗ vị trí hai Node
        System.out.println("Swap");
        try {
            ml.swapNode(0, 4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBound");
        }

        ml.display();

        //Sao chép 
        MySinglyList<Student> clonedList = ml.clone();

        System.out.println("Original List:");
        ml.display();

        System.out.println("Cloned List:");
        clonedList.display();
    }

}
