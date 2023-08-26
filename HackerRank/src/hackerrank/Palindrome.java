/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int check = 1;
        char[] a = x.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != a[a.length - i - 1]) {
                check = 0;
            }
        }
        if(check==1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

}
