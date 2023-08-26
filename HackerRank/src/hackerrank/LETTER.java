/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author PC-Phong
 */
public class LETTER {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int a[] = new int[n];
        String a1[] = new String[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.nextLine());
            a1[i] = sc.nextLine();
        }

        Set sm = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i] - 1; j++) {
                sm.add(a1[i].substring(0, j) + a1[i].substring(j + 2, a[i]));

            }
            System.out.println(sm.size());
            sm.clear();
        }
    }
}
