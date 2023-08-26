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
public class Longestnotrepeat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        if (!s.matches("[a-zA-Z]+")) {
            System.out.println("Invalid");
        } else {
            String s1 = "";
            HashMap<Character, Integer> charCount = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (c != ' ') {
                    if (charCount.containsKey(c)) {
                        break;
                    } else {
                        charCount.put(c, 1);
                        s1 += c;
                    }
                }
            }
            System.out.println(s1);
        }

    }

}
