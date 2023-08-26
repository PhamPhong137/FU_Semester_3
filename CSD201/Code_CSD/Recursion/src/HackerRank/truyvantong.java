/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class truyvantong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] truyhoi = new long[n + 1];

        long[] arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
            truyhoi[i] = truyhoi[i - 1] + arr[i];
        }      

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(truyhoi[b] - truyhoi[a - 1]);
        }
    }

}
