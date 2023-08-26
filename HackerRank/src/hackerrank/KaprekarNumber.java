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
public class KaprekarNumber {

    public static boolean isKaprekarNumber(BigInteger number) {
        BigInteger square = number.multiply(number);
        String squareString = square.toString();

        for (int i = 1; i < squareString.length(); i++) {
            BigInteger leftPart = new BigInteger(squareString.substring(0, i));
            BigInteger rightPart = new BigInteger(squareString.substring(i));

            if (rightPart.compareTo(BigInteger.ZERO) != 0 && leftPart.add(rightPart).equals(number)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger number = sc.nextBigInteger();

        
        if (isKaprekarNumber(number)||number.equals(BigInteger.ONE)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
