/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class aotoaonho {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a[] = new String[n];
        String b[] = new String[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
            b[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            int a_val = calculateSize(a[i]);
            int b_val = calculateSize(b[i]);

            if (a_val < b_val) {
                System.out.println("<");
            } else if (a_val > b_val) {
                System.out.println(">");
            } else {
                System.out.println("=");
            }
        }

    }

    public static int calculateSize(String size) {
        char lastChar = size.charAt(size.length() - 1);
        int baseSize = 0;

        switch (lastChar) {
            case 'S':
                baseSize = 0;
                break;
            case 'M':
                baseSize = 100;
                break;
            case 'L':
                baseSize = 200;
                break;
        }

        int extraSize = size.length() - 1; // subtract one because of 'S'/'M'/'L'
        return lastChar == 'S' ? baseSize - extraSize : baseSize + extraSize;
    }
}
