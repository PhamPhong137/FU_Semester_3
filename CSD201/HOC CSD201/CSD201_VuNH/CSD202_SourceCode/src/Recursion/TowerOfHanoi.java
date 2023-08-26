/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class TowerOfHanoi {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number of disks: ");
        int noOfDisks = sc.nextInt();
        moveDisks(noOfDisks, 1, 2, 3);
    }

    static long steps(int n) {
        return 0;
    }

    static void moveDisks(int n, int fromCol, int toCol, int auxCol) {
        if (n == 1) {
            System.out.println("Move from " + fromCol + " to " + toCol);
        } else {
            moveDisks(n - 1, fromCol, auxCol, toCol);
            moveDisks(1, fromCol, toCol, auxCol);
            moveDisks(n - 1, auxCol, toCol, fromCol);
        }
    }
}
