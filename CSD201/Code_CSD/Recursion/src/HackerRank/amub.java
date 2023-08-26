/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class amub {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<BigInteger> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String x = sc.next();
            String y = sc.next();
            String z = sc.next();
            BigInteger base = new BigInteger(x);
            BigInteger p = new BigInteger(y);
            BigInteger k = new BigInteger(z);
            BigInteger mod = new BigInteger("1000000007");

            BigInteger m = p.pow(k.intValue());
            BigInteger result = base.modPow(m, mod);

            list.add(result);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i));
        }
    }
}
