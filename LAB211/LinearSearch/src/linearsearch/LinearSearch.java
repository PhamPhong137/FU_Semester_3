/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class LinearSearch {

    static Scanner sc = new Scanner(System.in);

    public static int inputNumberofarray() {

        while (true) {
            System.out.println("Enter number of array:");
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    return n;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }
    }

    public static int[] randomValueofArray(int n) {
        int[] a = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n) + 1;
        }
        return a;
    }

    public static int inputValue() {
        while (true) {
            try {
                System.out.println("Enter search value: ");
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Try Again:");
            }
        }
    }

    public static void display(int[] a) {

        System.out.print("[");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[a.length - 1]);
        System.out.print("]");
    }

    public static int returnIndex(int[] a, int n) {
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == n) {
//                return i;
//            }
//        }
//        return -1;
        int i = 0;
        while (i < a.length) {
            if (a[i] == n) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void displayIndex(int a[], int n) {
        int c = returnIndex(a, n);
        if (c == -1) {
            System.out.printf("Not found %d of array ", n);
        } else {
            System.out.printf("Found %d at index: %d ", n, c);
        }
    }

    public static void main(String[] args) {
        int n = inputNumberofarray();
        int[] a = randomValueofArray(n);
        display(a);
        System.out.println("");

        int m = inputValue();
        displayIndex(a, m);
    }

}
