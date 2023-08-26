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
public class Find_last_word {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s = s1.trim();
        char a[] = s.toCharArray();
        int count = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != ' ') {
                count++;
            }
            if (a[i] == ' ') {
                break;
            }
        }
        System.out.println(count);
    }
}
