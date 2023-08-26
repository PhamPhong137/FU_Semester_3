/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class xepgach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a, Collections.reverseOrder());
        int idx = Math.min(n - 1, a[0]);
        int i = 1;

        while (i < idx) {
            idx = Math.min(idx, i + a[i]);
            i++;
        }
        System.out.println(idx + 1);

    }
}
