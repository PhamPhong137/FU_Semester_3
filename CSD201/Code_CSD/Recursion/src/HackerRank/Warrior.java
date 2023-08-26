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
public class Warrior {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }

        long minSum = Integer.MAX_VALUE;
        long currentSum = 0;

        for (long num : array) {
            if (currentSum > 0) {
                currentSum = num;
            } else {
                currentSum += num;
            }

            if (currentSum < minSum) {
                minSum = currentSum;
            }
        }
        System.out.println(minSum);
    }
}
