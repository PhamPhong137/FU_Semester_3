/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class MergeSort {

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

    public static void sortArraybyMergeSort(int arr[], int L, int R) {
        if (L >= R) {
            return; // Returns recursively
        }

        int k = (L + R) / 2;
        sortArraybyMergeSort(arr, L, k);
        sortArraybyMergeSort(arr, k + 1, R);
        merge(arr, L, k, R);
    }

    public static void merge(int arr[], int l, int k, int r) {

        // Tìm kích thước của 2 mảng con để merged
        int n1 = k - l + 1;
        int n2 = r - k;
     
        // Tạo mảng tạm
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[k + 1 + j];
        }

        // Merge các mảng tạm lại
        // Chỉ mục ban đầu của 2 mảng con
        int i = 0, j = 0;

        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int m = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[m] = L[i];
                i++;
            } else {
                arr[m] = R[j];
                j++;
            }
            m++;
        }

        // Sao chép các phần tử còn lại của L[] nếu có
        while (i < n1) {
            arr[m] = L[i];
            i++;
            m++;
        }

        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[m] = R[j];
            j++;
            m++;
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
        sortArraybyMergeSort(a, 0, n - 1);
        System.out.print("Sorted array: ");
        display(a);
    }
}
