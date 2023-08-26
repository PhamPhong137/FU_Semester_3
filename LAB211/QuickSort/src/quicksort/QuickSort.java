/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class QuickSort {

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

    public static void sortArraybyQuickSort(int[] a, int L, int R) {

        if (L >= R) {
            return;
        }
        int key = a[(L + R) / 2];
        int k = partition(a, L, R, key);
        
        sortArraybyQuickSort(a, L, k - 1);
        
        sortArraybyQuickSort(a, k, R);
    }

    public static int partition(int[] a, int L, int R, int key) {
        int iL = L;
        int iR = R;
        while (iL <= iR) {
            while (a[iL] < key) {
                iL++;
            }
            while (a[iR] > key) {
                iR--;
            }
            if (iL <= iR) {
                int temp = a[iL];
                a[iL] = a[iR];
                a[iR] = temp;
                iL++;
                iR--;
            }
        }
        
        return iL;
    }

    public static void display(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int n = inputNumberofarray();
        int[] a = randomValueofArray(n);

        System.out.print("Unsorted array: ");
        display(a);
        sortArraybyQuickSort(a, 0, n - 1);
        System.out.print("Sorted array: ");
        display(a);
    }

}
