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
public class binary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            long n;
            System.out.print("Input: ");
            n = Long.parseLong(sc.nextLine());
            
            System.out.println("Output: "+Long.toBinaryString(n));
        } catch (Exception e) {
            System.out.println("Invalid");
        }

    }
}
