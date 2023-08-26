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
public class Bowling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a1[] = new int[n];
        int a2[] = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a2[i] = sc.nextInt();
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (a1[i] == 10) {
                sum1 += 20;
            } else {
                sum1 += a1[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (a2[i] == 10) {
                sum2 += 20;
            } else {
                sum2 += a2[i];
            }
        }
        if (sum1 > sum2) {
            System.out.println("1");
        } else if (sum1 < sum2) {
            System.out.println("2");
        }else{
            System.out.println("0");
        }
        

        
    }

}
