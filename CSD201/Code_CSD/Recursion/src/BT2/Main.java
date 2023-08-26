/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BT2;

public class Main {

    // 1 3 1/9 27 1/81 .........
    public static double recursion(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        if (n % 2 != 0) {
            return recursion(n - 2) * 1 / 3 * 1 / 3;
        } else {
            return recursion(n - 2) * 3 * 3;
        }

    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.print(recursion(i) + " ");
        }
    }
}
