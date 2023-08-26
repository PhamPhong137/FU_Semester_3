/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank;

import java.util.Scanner;
import java.util.Stack;

public class Stack1 {

    public static boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                myStack.push(c);
            } else {
                if (myStack.isEmpty()) {
                    return false;
                }
                char openPeek = myStack.peek();
                if ((c == ')' && openPeek == '(') || (c == ']' && openPeek == '[') || (c == '}' && openPeek == '{')) {
                    myStack.pop();
                } else {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String s =sc.next();
        if(isValid(s)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        
    }
}
