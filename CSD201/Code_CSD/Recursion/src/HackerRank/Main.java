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
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int s = sc.nextInt();
        int k = sc.nextInt();

        float x = (60.0f * v * s) / (60.0f * s - k * v);

        System.out.printf("%.3f", x);
    }
}
