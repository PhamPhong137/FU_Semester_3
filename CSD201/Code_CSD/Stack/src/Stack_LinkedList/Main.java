/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack_LinkedList;

/**
 *
 * @author PC-Phong
 */
public class Main {

    public static void main(String[] args) {
        MyStack_LinkedList ms = new MyStack_LinkedList();

        ms.push("1");
        ms.push("3");
        ms.push("9");
        ms.push("10");
        ms.push("11");
        ms.push("18");
        ms.push("16");
        ms.push("13");
        ms.pop();
        
        ms.display();
        
    }
}
