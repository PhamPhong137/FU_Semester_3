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
public class kinhtethatthuong {

    public static int kinhte(int n) {
        if (n % 2 == 0) {
            return -n / 2;
        } else {
            return (n / 2) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(kinhte(n));
    }
}
