/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author PC-Phong
 */
public class Duplicate {

    public static int removeDuplicates(int[] nums) {
        Set<Integer> rm = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            rm.add(nums[i]);
        }
        return rm.size();
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(removeDuplicates(a));
    }
}
