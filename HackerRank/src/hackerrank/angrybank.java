/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class angrybank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] a = new String[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextLine();
        }

        HashMap<String, Integer> s = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (s.containsKey(a[i])) {
                int count = s.get(a[i]);
                s.put(a[i], count + 1);
                System.out.println(a[i] + count);
            } else {
                s.put(a[i], 1);
                System.out.println("OK");
            }
        }
    }
}
