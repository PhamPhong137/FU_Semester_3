/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigintegernumber;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author PC-Phong
 */
public class BigIngeterNumber {

    public static String inputNumber(String mess) {
        Scanner sc = new Scanner(System.in);
        String number = "";
        while (true) {
            System.out.print(mess);
            number = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]+$");
            if (p.matcher(number).matches()) {
                break;
            } else {
                System.err.println("Invalid number, input again");
            }
        }
        return number;
    }

    public static void main(String[] args) {
        String a = inputNumber("Input nummber A:");
        BigInteger number1 = new BigInteger(a);
        String b = inputNumber("Input nummber B:");
        BigInteger number2 = new BigInteger(b);
        System.out.println(number1.multiply(number2));
    }
}
