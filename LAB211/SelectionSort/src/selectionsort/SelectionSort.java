/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class SelectionSort {

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

    public static void sortArraybySelectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int jMin = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[jMin]) {
                    jMin = j;
                }
            }
            if (jMin != i) {
                int temp = a[i];
                a[i] = a[jMin];
                a[jMin] = temp;
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

    public static void main(String[] args) {
        int n = inputNumberofarray();
        int[] a = randomValueofArray(n);

        System.out.print("Unsorted array: ");
        display(a);
        System.out.println("");
        sortArraybySelectionSort(a);
        System.out.print("Sorted array: ");
        display(a);
    }

}
