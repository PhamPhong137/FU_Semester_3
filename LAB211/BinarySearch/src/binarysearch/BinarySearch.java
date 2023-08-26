/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class BinarySearch {

    Scanner sc = new Scanner(System.in);

    public int inputInt(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(msg);
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    return n;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Try again");
            }
        }
    }

    public int[] randomValueofArray(int n) {
        int[] a = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n) + 1;
        }
        return a;
    }

    public void sortArraybyBubbleSort(int[] a) {
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

    public int searchbyBinarySearch(int a[], int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int k = (left + right) / 2;
        if (value == a[k]) {
            return k;
        }
        if (value > a[k]) {
            return searchbyBinarySearch(a, k + 1, right, value);
        }
        return searchbyBinarySearch(a, left, k - 1, value);
    }

    public void display(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
