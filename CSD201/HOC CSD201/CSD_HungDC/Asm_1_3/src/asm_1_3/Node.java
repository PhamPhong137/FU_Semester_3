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
public class Node {

    Student infor;
    Node next, pre;

    public Node(Student infor) {
        this.infor = infor;
        next = pre = null;
    }
    
}
