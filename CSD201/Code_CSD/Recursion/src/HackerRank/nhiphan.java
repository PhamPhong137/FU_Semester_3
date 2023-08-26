/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class nhiphan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();

        BigInteger decimalNumber = new BigInteger(x, 2);
        System.out.println(decimalNumber);
    }

}
