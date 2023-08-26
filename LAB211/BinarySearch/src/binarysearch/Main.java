/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 *
 * @author PC-Phong
 */
public class Main {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int n = bs.inputInt("Enter number of array: ");
        int value = bs.inputInt("Enter search value: ");
        int[] a = bs.randomValueofArray(n);
        bs.sortArraybyBubbleSort(a);
        System.out.print("Sorted array: ");
        bs.display(a);
        int v = bs.searchbyBinarySearch(a, 0, n - 1, value);
        if (v == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at index " + v);
        }
    }
}
