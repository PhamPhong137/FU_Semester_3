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
public class Node {

    Student student;
    Node next;

    public Node(Student student) {
        this.student = student;
    }

    public Node(Student student, Node next) {
        this.student = student;
        this.next = next;
    }

}
