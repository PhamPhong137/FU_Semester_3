/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class StringtoInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String currentNumber = "";
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber += c;
            } else {
                if (!currentNumber.isEmpty()) {
                    BigInteger number = new BigInteger(currentNumber);
                    sum = sum.add(number);
                    currentNumber = "";
                }
            }
        }

        if (!currentNumber.isEmpty()) {
            BigInteger number = new BigInteger(currentNumber);
            sum = sum.add(number);
        }
        System.out.println(sum);

    }

}
