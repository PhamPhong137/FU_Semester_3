/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedStack;

/**
 *
 * @author PC-Phong
 */
public class Main {

    public static void main(String[] args) {
        LinkedStack ls = new LinkedStack();

        ls.push("1");
        ls.push("2");
        ls.push("5");
        ls.push("6");
        ls.push("8");
        ls.push("9");
        ls.push("10");
        ls.push("18");
        ls.pop();
        ls.display();

    }

}
