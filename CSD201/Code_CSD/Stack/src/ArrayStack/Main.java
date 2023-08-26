/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayStack;

/**
 *
 * @author PC-Phong
 */
public class Main {

    public static void main(String[] args) {
        MyStack ms = new MyStack(7);

        ms.push("9");
        ms.push("5");
        ms.push("5");
        ms.push("4");
        ms.push("2");
        ms.push("7");
        ms.push("9");
        ms.push("-2");
        ms.push("6");
        ms.push("1");
        ms.pop();

        ms.display();

    }
}
