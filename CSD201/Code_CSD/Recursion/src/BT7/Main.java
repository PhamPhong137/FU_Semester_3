/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BT7;

public class Main {
    
    // 1 2 4 12 60 480
    public static int multiplyRecursive(int x) {
        if (x <= 2) {
            return x;
        }
        return multiplyRecursive(x-1) * fibo(x);
    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.print(multiplyRecursive(i)+" ");
        }

    }

}
