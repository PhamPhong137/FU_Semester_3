/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class Binary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Display numbers of array
        System.out.println("Enter number of array:");
        int length = scanner.nextInt();

        //Display search value
        System.out.println("Enter search value:");
        int search = scanner.nextInt();

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }

        bubbleSort(array);

        System.out.print("Sorted array: ");
        displayArray(array);

        List<Integer> foundIndex = binarySearchAll(array, search, 0, length - 1);
        if (!foundIndex.isEmpty()) {
            System.out.println("Value " + search + " found at: " + foundIndex);
        } else {
            System.out.println("Value " + search + " not found.");
        }
    }

    public static void displayArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public static List<Integer> binarySearchAll(int[] arr, int target, int low, int high) {
        List<Integer> indices = new ArrayList<>();

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                indices.add(mid);

                // Tìm tất cả các vị trí khác của giá trị target bên trái và bên phải
                int left = mid - 1;
                while (left >= 0 && arr[left] == target) {
                    indices.add(left);
                    left--;
                }

                int right = mid + 1;
                while (right < arr.length && arr[right] == target) {
                    indices.add(right);
                    right++;
                }

                return indices;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;

            }
        }

        return indices;
    }

}
