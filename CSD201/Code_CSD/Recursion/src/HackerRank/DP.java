/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author PC-Phong
 */
public class DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] p = new int[n];
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            p[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j] && p[i] < p[j] + 1) {
                    p[i] = p[j] + 1;
                    System.out.println(p[i]+"ip");
                }
            }
            if (p[i] > maxLength) {
                maxLength = p[i];
            }
            System.out.println(maxLength+" tr ");
        }
        System.out.println(maxLength);
        
     
    }

}
