/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menububblesort;

import java.util.Arrays;

/**
 *
 * @author PC-Phong
 */
public class SortArray {

    Validate v = new Validate();

    public void printMenu() {
        System.out.println("1. Input items of the array");
        System.out.println("2. Sort the array in ascending order");
        System.out.println("3. Sort the array in descending order");
        System.out.println("4. Exit");
        System.out.println("Please choice one option:");

    }

    public int[] inputItemsofArray() {
        int n = v.checkInputnumberofArray();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter number " + (i + 1)+": ");
            a[i] = v.checkInputitemsofArray();
        }
        return a;
    }

   

    public void sortArray(int a[], boolean tf) {
        int length = a.length;
        if (length == 0) {
            System.out.println("List empty");
        } else {
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = 0; j < a.length - i - 1; j++) {
                    if ((a[j] > a[j + 1] && tf) || (a[j] < a[j + 1] && !tf)) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
            }
            System.out.println(tf ? "====Ascending====" : "====Decending====");
            System.out.println(Arrays.toString(a));

        }
    }
}
