/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bubblesort {

    public static int inputNumberofarray() {
        Scanner sc = new Scanner(System.in);
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

    public static void sortArraybyBubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    }

    public static void display(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int n = inputNumberofarray();
        int[] a = randomValueofArray(n);

        System.out.print("Unsorted array: ");
        display(a);
        System.out.println("");
        sortArraybyBubbleSort(a);
        System.out.print("Sorted array: ");
        display(a);
    }

}
