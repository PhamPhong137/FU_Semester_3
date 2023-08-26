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
public class JSdichoi {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[6];
        int totalScore = 0;
        for (int i = 0; i < 6; i++) {
            scores[i] = scanner.nextInt();
            totalScore += scores[i];
        }

        if (totalScore % 2 != 0) {
            System.out.println("NO");
            return;
        }

        int halfScore = totalScore / 2;
        boolean[] dp = new boolean[halfScore + 1];
        dp[0] = true;

        for (int i = 0; i < 6; i++) {
            for (int j = halfScore; j >= scores[i]; j--) {
                dp[j] = dp[j - scores[i]];
                System.out.print(dp[j]);
                System.out.println(j);
            }
            System.out.println("");

        }

        System.out.println(dp[halfScore] ? "YES" : "NO");
    }
}
