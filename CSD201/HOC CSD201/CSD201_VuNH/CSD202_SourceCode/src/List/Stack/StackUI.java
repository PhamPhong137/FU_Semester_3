/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.Stack;

/**
 *
 * @author Hp
 */
public class StackUI {

    public static void main(String[] args) {
        MyStack hoenStack1 = new MyStack();
        hoenStack1.push(new Node(5));
        hoenStack1.push(new Node(3));
        hoenStack1.push(new Node(1));
        MyStack hoenStack2 = new MyStack();
       
         hoenStack1.transfer(hoenStack1, hoenStack2);
//        Node toFind = new Node(5);
        hoenStack1.display();
        System.out.println();
        hoenStack2.display();
//        System.out.println();
//        System.out.println("The node is at index " + hoenStack.search(toFind));

    }
}
