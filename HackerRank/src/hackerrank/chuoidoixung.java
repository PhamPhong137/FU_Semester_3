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
public class chuoidoixung {

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s[] = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
            int c = 0;
            if (isPalindrome(s[i])) {
                for (int j = 0; j <= s[i].length() / 2 - 2; j++) {
                    if (!(s[i].substring(j, j + 1).equals(s[i].substring(j + 1, j + 2)))) {
                        System.out.println("YES");
                        c = 1;
                        break;
                    }
                }
                if (c == 0) {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }

        }
    }
}
